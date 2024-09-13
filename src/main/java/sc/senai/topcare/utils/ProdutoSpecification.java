package sc.senai.topcare.utils;

import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;
import sc.senai.topcare.entity.Especie;
import sc.senai.topcare.entity.Produto;

public class ProdutoSpecification {

    public static Specification<Produto> especieIgual(String nomeEspecie) {
        return (root, query, criteriaBuilder) -> {
            // Fazendo o join com a lista de especies
            Join<Produto, Especie> especieJoin = root.join("especies");
            return criteriaBuilder.equal(especieJoin.get("nome"), nomeEspecie);
        };
    }

    public static Specification<Produto> marcaIgual(String marca) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("marca"), marca);
    }

    public static Specification<Produto> categoriaIgual(String categoria) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("categoria").get("nome"), categoria);
    }

}