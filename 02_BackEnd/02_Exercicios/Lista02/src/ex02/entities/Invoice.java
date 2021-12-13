package ex02.entities;

public class Invoice {
    private String number;
    private Item item;

    public Invoice(String number, Item item){
        this.number = number;
        this.item = item;
    }

    public String getNumber(){
        return this.number;
    }
    public Item getItem(){
        return this.item;
    }

    public void setNumber(String number){
        this.number = number;
    }
    public void setItem(Item item){
        this.item = item;
    }

    public double getInvoiceValue(){
        return this.item.getQuantity() * this.item.getPrice();
    }

    public String toString(){
        return String.format("Invoice %s%nItem: %s%nTotal: %.2f", this.getNumber(), this.getItem(), this.getInvoiceValue());
    }
}