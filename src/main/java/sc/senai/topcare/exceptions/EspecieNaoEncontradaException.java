package sc.senai.topcare.exceptions;

public class EspecieNaoEncontradaException extends Exception{
    public EspecieNaoEncontradaException(){
        super("A espécie não foi encontrada!");
    }
}
