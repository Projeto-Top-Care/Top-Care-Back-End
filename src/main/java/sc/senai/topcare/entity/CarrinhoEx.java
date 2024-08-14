package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.service.interfaces.CarrinhoComponent;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarrinhoEx implements CarrinhoComponent{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<ProdutoEx> produtos = new ArrayList<>();
    @Override
    public double getPreco() {
        double precoTotal = 0;
        for (ProdutoEx produto : this.produtos) {
            precoTotal += produto.getPreco();
        }
        return precoTotal;
    }
}
