package ex10.entities;

import ex10.exceptions.CannotBeSoldException;
import ex10.exceptions.NegativeStockQuantityException;

public class ProductExchangeOnly extends Product {
    public ProductExchangeOnly(String code, String name, String description, double exchangePrice, int qtStock) throws NegativeStockQuantityException {
        super(code, name, description, -1, exchangePrice, qtStock);        
    }

    public void sell() throws CannotBeSoldException{
        throw new CannotBeSoldException("This product is only marketed by exchange.");
    }
}
