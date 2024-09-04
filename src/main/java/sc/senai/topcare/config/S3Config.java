package sc.senai.topcare.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:aws.properties")
@Getter
public class S3Config {
    @Value("${aws.access.key}")
    private String accessKey;

    @Value("${aws.secret.access.key}")
    private String secretKey;

    @Value("${aws.bucket.name}")
    private String bucket;
}