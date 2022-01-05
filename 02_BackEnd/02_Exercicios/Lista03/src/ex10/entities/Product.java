package ex10.entities;

import ex10.exceptions.CannotBeExchangedException;
import ex10.exceptions.CannotBeSoldException;
import ex10.exceptions.ExchangeDeniedException;
import ex10.exceptions.InsufficientStockException;
import ex10.exceptions.NegativeStockQuantityException;
import ex10.interfaces.Exchangeable;
import ex10.interfaces.Sellable;

public class Product implements Sellable, Exchangeable{
    private String code;
    private String name;
    private String description;
    private double salePrice;
    private double exchangePrice;
    private int qtStock;

    public Product(String code, String name, String description, double salePrice, double exchangePrice, int qtStock) throws NegativeStockQuantityException{
        if(qtStock < 0){
            throw new NegativeStockQuantityException("You can't create a product with negative stock quantity.");
        }
        this.code = code;
        this.name = name;
        this.description = description;
        this.salePrice = salePrice;
        this.exchangePrice = exchangePrice;        
        this.qtStock = qtStock;
    }

    public String getCode(){
        return this.code;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public double getSalePrice(){
        return this.salePrice;
    }

    public double getExchangePrice(){
        return this.exchangePrice;
    }

    public int getQtStock(){
        return this.qtStock;
    }

    public boolean isStockEmpty(){
        return this.getQtStock() == 0;
    }

    public void increaseStock(){
        this.qtStock++;
    }

    public void decreaseStock(){
        this.qtStock--;
    }

    public void sell() throws InsufficientStockException, CannotBeSoldException{
        if(this.getQtStock() == 0){
            throw new InsufficientStockException("There is no product in stock for selling.");
        }
        this.decreaseStock();
    }

    protected double calculatePercentualPriceDifference(Product product){
        try{
            return Math.abs( (this.getExchangePrice() - product.getExchangePrice()) / Math.max(this.getExchangePrice(), product.getExchangePrice()) );
        } catch (ArithmeticException e) {
            return 0;
        }        
    }

    public void exchange(Product product) throws InsufficientStockException, ExchangeDeniedException, CannotBeExchangedException {
        if(this.getQtStock() == 0){
            throw new InsufficientStockException("There is no product in stock for exchanging.");
        }
        if(this.calculatePercentualPriceDifference(product) > Exchangeable.MINIMAL_PERCENTUAL_PRICE_DIFFERENCE){
            throw new ExchangeDeniedException(String.format("The exchange price difference between the two products is higher than %.2f%", Exchangeable.MINIMAL_PERCENTUAL_PRICE_DIFFERENCE * 100));
        }
        this.decreaseStock();
        product.increaseStock();
    }

    public String toString(){
        String salePriceStr = String.format("%.2f", this.getSalePrice());
        String exchangePriceStr = String.format("%.2f", this.getExchangePrice());
        if(this.getSalePrice() == -1){
            salePriceStr = "Cannot be sold.";
        }
        if(this.getExchangePrice() == -1){
            exchangePriceStr = "Cannot be exchanged.";
        }
        return String.format(
            "Code: %s%nName: %s%nDescription: %s%nSale Price: %s%nExchange Price: %s%nQuantity in Stock: %d%n",
            this.getCode(),
            this.getName(),
            this.getDescription(),
            salePriceStr,
            exchangePriceStr,
            this.getQtStock()
        );
    }
}
