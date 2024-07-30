package sc.senai.topcare.exceptions;

public class EnderecoNaoEncontradoException extends Exception{
    public EnderecoNaoEncontradoException(){
        super("O Endereço não foi encontrado!");
    }
}
