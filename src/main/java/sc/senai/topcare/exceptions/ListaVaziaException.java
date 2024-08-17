package sc.senai.topcare.exceptions;

public class ListaVaziaException extends Exception {
    public ListaVaziaException(){
        super("A lista está vazia");
    }
}
