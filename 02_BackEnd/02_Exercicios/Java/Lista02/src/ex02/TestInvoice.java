package ex02;

import ex02.entities.Invoice;
import ex02.entities.Item;

public class TestInvoice {
    public static void main(String[] args) {
        Item orange = new Item("Orange", 4, 2.50);
        Invoice invoice = new Invoice("1234-56", orange);

        System.out.println(invoice);
    }    
}
