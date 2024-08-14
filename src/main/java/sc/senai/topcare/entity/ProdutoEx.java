package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.service.interfaces.CarrinhoComponent;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoEx implements CarrinhoComponent{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double preco;
    @Override
    public double getPreco(){
        return this.preco;
    }
}
