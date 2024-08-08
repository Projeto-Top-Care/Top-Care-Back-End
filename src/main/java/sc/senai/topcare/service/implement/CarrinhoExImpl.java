package sc.senai.topcare.service.implement;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.entity.CarrinhoEx;
import sc.senai.topcare.entity.ProdutoEx;
import sc.senai.topcare.repository.CarrinhoExRepository;
import sc.senai.topcare.service.interfaces.CarrinhoComponent;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class CarrinhoExImpl implements CarrinhoComponent {

    private CarrinhoExRepository carrinhoExRepository;

    public CarrinhoEx salvarCarrinhoEx(CarrinhoEx carrinhoEx){
        return carrinhoExRepository.save(carrinhoEx);
    }
    @Override
    public double getPreco(Long id) throws Exception {
        double precoTotal = 0;
        CarrinhoEx carrinhoEx = buscarCarrinhoExPorId(id);
        for (ProdutoEx item : carrinhoEx.getProdutos()) {
            precoTotal += item.getPreco();
        }
        return precoTotal;
    }
    public CarrinhoEx buscarCarrinhoExPorId(Long id) throws Exception {
        Optional<CarrinhoEx> optional =  carrinhoExRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            throw new Exception("Carrinho não encontrado!");
        }
    }
    public List<CarrinhoEx> buscarTodosCarrinhosEx(){
        return carrinhoExRepository.findAll();
    }
}
