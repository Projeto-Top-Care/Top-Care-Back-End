package sc.senai.topcare.utils;

import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;
import sc.senai.topcare.entity.Especie;
import sc.senai.topcare.entity.Produto;

import java.util.List;

public class ProdutoSpecification {

    // Filtro para marcas
    public static Specification<Produto> marcasIn(List<String> marcas) {
        return (root, query, criteriaBuilder) ->
                root.get("marca").in(marcas);
    }

    // Filtro para categorias
    public static Specification<Produto> categoriasIn(List<String> categorias) {
        return (root, query, criteriaBuilder) ->
                root.get("categoria").get("nome").in(categorias);
    }

    // Filtro para espécies
    public static Specification<Produto> especiesIn(List<String> especies) {
        return (root, query, criteriaBuilder) -> {
            // Join com a lista de especies
            Join<Produto, Especie> especieJoin = root.join("especies");
            return especieJoin.get("nome").in(especies);
        };
    }

}