package sc.senai.topcare.service.imagem;

import com.amazonaws.HttpMethod;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sc.senai.topcare.config.S3Config;
import sc.senai.topcare.entity.Imagem;
import sc.senai.topcare.repository.ImagemRepository;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ImagemServiceImp implements ImagemService{

    private final S3Config s3Config;
    private final ImagemRepository repository;

    private AmazonS3 getClient(){
        String awsKeyId = s3Config.getAccessKey();
        String awsKeySecret = s3Config.getSecretKey();
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(awsKeyId, awsKeySecret);
        return AmazonS3ClientBuilder
                .standard()
                .withRegion(Regions.US_EAST_2)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }

    private String getBucket(){
        return s3Config.getBucket();
    }

    private boolean doesNotExist(){
        return !getClient().doesBucketExistV2(getBucket());
    }


    @Override
    public Imagem salvarImagem(MultipartFile multipartFile) {
        try{

            String chave = UUID.randomUUID().toString();

            if(doesNotExist()){
                throw new RuntimeException("O bucket não existe");
            }

            File file = File.createTempFile("tmp", multipartFile.getOriginalFilename());
            multipartFile.transferTo(file);

            getClient().putObject(new PutObjectRequest(getBucket(), chave, file)
                    .withCannedAcl(CannedAccessControlList.PublicRead));

            Imagem imagem =
                    new Imagem(null, chave, multipartFile.getOriginalFilename(), getCaminho(chave));

            repository.save(imagem);
            return imagem;

        }catch (AmazonS3Exception e){
            System.out.println("Amazon Erro" + e.getMessage());
            return null;
        }catch (Exception e){
            System.out.println( "Server Erro " + e.getMessage());
            return null;
        }
    }

    private String getCaminho(String ref){
        return "https://" + getBucket() + ".s3.us-east-2.amazonaws.com/" + ref;
    }

    @Override
    public Imagem getImagem(Long id) {
        return null;
    }

    @Override
    public void deletarImagem(Long id){
        if(doesNotExist()){
            throw new RuntimeException("O bucket não existe");
        }

        Imagem file = repository.findById(id).orElseThrow(NoSuchElementException::new);
        String ref = file.getReferencia();

        getClient().deleteObject(getBucket(), ref);
        repository.delete(file);
    }

    public void deletarImagem(String caminho){
        Imagem imagem = repository.findByCaminho(caminho).orElseThrow(NoSuchElementException::new);
        deletarImagem(imagem.getId());
    }
}
