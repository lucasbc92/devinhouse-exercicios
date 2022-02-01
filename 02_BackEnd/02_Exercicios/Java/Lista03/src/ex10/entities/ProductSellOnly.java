package ex10.entities;

import ex10.exceptions.CannotBeExchangedException;
import ex10.exceptions.NegativeStockQuantityException;

public class ProductSellOnly extends Product {
    public ProductSellOnly(String code, String name, String description, double salePrice, int qtStock) throws NegativeStockQuantityException {
        super(code, name, description, salePrice, -1, qtStock);        
    }

    public void exchange(Product product) throws CannotBeExchangedException{
        throw new CannotBeExchangedException("This product is only marketed by sale.");
    }
}
