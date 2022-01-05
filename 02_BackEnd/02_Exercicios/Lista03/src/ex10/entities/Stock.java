package ex10.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import ex10.exceptions.NoSuchProductException;
import ex10.exceptions.ProductAlreadyInStockException;

public class Stock {
    private Map<String, Product> products;

    public Stock(){
        this.products = new HashMap<String, Product>();
    }

    public Map<String, Product> getProducts(){
        return this.products;
    }

    public boolean hasProduct(String code){
        return this.getProducts().containsKey(code);
    }

    public Product getProduct(String code) throws NoSuchProductException{
        Product product = this.getProducts().get(code);
        if(product == null){
            throw new NoSuchProductException("There is no product with such code in the stock.");
        }
        return product;
    }

    public void addProduct(Product product) throws ProductAlreadyInStockException{
        if(this.hasProduct(product.getCode())){
            throw new ProductAlreadyInStockException("There is already a product with the same code in the stock.");
        }
        this.getProducts().put(product.getCode(), product);
    }

    public void removeProduct(String code) throws NoSuchProductException{
        Product product = this.getProducts().remove(code);
        if(product == null){
            throw new NoSuchProductException("There is no product with such code in the stock.");
        }
    }

    @Override
    public String toString(){
        String productsStr = "";
        for(Entry<String, Product> entry: this.getProducts().entrySet()){
            productsStr += String.format("%s%n", entry.getValue().toString());
        }
        return productsStr.equals("") ? String.format("The products stock is empty!%n") : productsStr;
    }
}
