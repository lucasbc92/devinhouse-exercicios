package ex10.exceptions;

public class ProductAlreadyInStockException extends Exception {
    public ProductAlreadyInStockException(String message){
        super(message);
    }
}
