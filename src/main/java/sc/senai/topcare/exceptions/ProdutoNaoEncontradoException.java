package sc.senai.topcare.exceptions;

public class ProdutoNaoEncontradoException extends Exception{
    public ProdutoNaoEncontradoException(){
            super("O produto não foi encontrado!");
        }
}
