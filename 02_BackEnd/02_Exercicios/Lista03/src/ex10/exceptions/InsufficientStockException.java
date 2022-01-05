package ex10.exceptions;

public class InsufficientStockException extends Exception{
    public InsufficientStockException(String message){
        super(message);
    }
}
