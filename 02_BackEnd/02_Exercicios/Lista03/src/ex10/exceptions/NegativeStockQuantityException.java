package ex10.exceptions;

public class NegativeStockQuantityException extends Exception{
    public NegativeStockQuantityException(String message){
        super(message);
    }
}
