package sc.senai.topcare.exceptions;

public class FiliarNaoEncontradaException extends Exception{
    public FiliarNaoEncontradaException(){
        super("A filial não foi encontrada");
    }
}
