package ex02.entities;

public class Item {
    private String description;
    private int quantity;
    private double price;

    public Item(String description, int quantity, double price){
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public String getDescription(){
        return this.description;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public double getPrice(){
        return this.price;
    }

    public String toString(){
        return String.format("%d %s, $%.2f each", this.getQuantity(), this.getDescription(), this.getPrice());
    }
    
}
