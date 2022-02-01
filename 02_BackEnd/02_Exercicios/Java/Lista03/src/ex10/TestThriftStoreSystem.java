package ex10;

import java.util.NoSuchElementException;
import java.util.Scanner;

import ex10.entities.Product;
import ex10.entities.ProductExchangeOnly;
import ex10.entities.ProductSellOnly;
import ex10.entities.Stock;
import ex10.exceptions.NoSuchProductException;

public class TestThriftStoreSystem {
    public static Scanner in = new Scanner(System.in);
    public static Stock stock = new Stock();

    public static void addProductSellOnly(){
        try{
            in.nextLine();
            System.out.print("Code: ");
            String code = in.nextLine();
            System.out.print("Name: ");
            String name = in.nextLine();
            System.out.print("Description: ");
            String description = in.nextLine();
            System.out.print("Sale Price: ");
            double salePrice = in.nextDouble();
            System.out.print("Quantity in Stock: ");
            int qtStock = in.nextInt();
            stock.addProduct(new ProductSellOnly(code, name, description, salePrice, qtStock));
            System.out.println("Product added successfully!");
        } catch (NoSuchElementException e){
            System.out.println("Invalid input.");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void addProductExchangeOnly(){
        try{
            in.nextLine();
            System.out.print("Code: ");
            String code = in.nextLine();
            System.out.print("Name: ");
            String name = in.nextLine();
            System.out.print("Description: ");
            String description = in.nextLine();
            System.out.print("Exchange Price: ");
            double exchangePrice = in.nextDouble();
            System.out.print("Quantity in Stock: ");
            int qtStock = in.nextInt();
            stock.addProduct(new ProductExchangeOnly(code, name, description, exchangePrice, qtStock));
            System.out.println("Product added successfully!");
        } catch (NoSuchElementException e){
            System.out.println("Invalid input.");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void addProduct(){
        try{
            in.nextLine();
            System.out.print("Code: ");
            String code = in.nextLine();
            System.out.print("Name: ");
            String name = in.nextLine();
            System.out.print("Description: ");
            String description = in.nextLine();
            System.out.print("Sale Price: ");
            double salePrice = in.nextDouble();
            System.out.print("Exchange Price: ");
            double exchangePrice = in.nextDouble();
            stock.addProduct(new Product(code, name, description, salePrice, exchangePrice, 0));
            System.out.println("Product added successfully!");
        } catch (NoSuchElementException e){
            System.out.println("Invalid input.");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static Product createNewProductToExchange(){
        try{
            in.nextLine();
            System.out.print("Code: ");
            String code = in.nextLine();
            System.out.print("Name: ");
            String name = in.nextLine();
            System.out.print("Description: ");
            String description = in.nextLine();
            System.out.print("Sale Price: ");
            double salePrice = in.nextDouble();
            System.out.print("Exchange Price: ");
            double exchangePrice = in.nextDouble();
            System.out.print("Quantity in Stock: ");
            int qtStock = in.nextInt();
            Product product = new Product(code, name, description, salePrice, exchangePrice, qtStock);
            stock.addProduct(product);
            System.out.println("Product added successfully!");
            return product;
        } catch (NoSuchElementException e){
            System.out.println("Invalid input.");
            return null;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Product getProductFromStockToExchange(){
        try{
            in.nextLine();
            System.out.print("Code: ");
            String code = in.nextLine();
            Product product = stock.getProduct(code);
            return product;
        } catch (NoSuchElementException e){
            System.out.println("Invalid input.");
            return null;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            stock.addProduct(new Product("123456", "Tênis Reebok", "Este é um tênis confortável", 199.99, 139.99, 1));
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        try {
            stock.addProduct(new ProductSellOnly("234567", "Camisa Lacoste", "Esta é uma camisa estilosa.", 139.99, 2));
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        try {
            stock.addProduct(new ProductExchangeOnly("345678", "Calça Jeans Zoomp", "Esta é uma calça boa para o trabalho.", 129.99, 1));
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        // try {
        //     stock.addProduct(new Product("123456", "Fatal Error", "Este é um teste de erro", 100, 100, 1));
        // } catch(Exception e){
        //     System.out.println(e.getMessage());
        // }
        // try {
        //     stock.addProduct(new Product("999999", "Fatal Error 2", "Este é um teste de erro 2", 100, 100, -1));
        // } catch(Exception e){
        //     System.out.println(e.getMessage());
        // }
        int option = 0;
        do {
            System.out.println("Thrift Store System");
            System.out.println("1 - Add new product");
            System.out.println("2 - List stock");
            System.out.println("3 - Sell product");
            System.out.println("4 - Exchange product");
            System.out.println("0 - Exit");
            try{
                option = in.nextInt();
                switch(option){
                    case 0: break;
                    case 1: {
                        in.nextLine();
                        int option2 = 0;
                        do {
                            System.out.println("Product type:");
                            System.out.println("1 - Sell only");
                            System.out.println("2 - Exchange only");
                            System.out.println("3 - Both for sell and exchange");
                            try {
                                option2 = in.nextInt();
                                switch(option2){
                                    case 1: TestThriftStoreSystem.addProductSellOnly(); break;
                                    case 2: TestThriftStoreSystem.addProductExchangeOnly(); break;
                                    case 3: TestThriftStoreSystem.addProduct(); break;
                                    default: {
                                        System.out.println("Invalid option.");
                                        option2 = 0;                                
                                    }
                                }
                            } catch(NoSuchElementException e){
                                System.out.println("Invalid option.");
                                option2 = 0; 
                            }
                        } while(option2 == 0);
                        break;                      
                    }
                    case 2: {
                        System.out.println(stock);
                        break;
                    }
                    case 3: {
                        in.nextLine();
                        System.out.print("Inform product code: ");
                        String code = in.nextLine();
                        Product product = stock.getProduct(code);
                        product.sell();
                        System.out.printf("Product sold successfully!%n%s%n", product.toString());
                        break;
                    }
                    case 4: {
                        in.nextLine();
                        System.out.print("Inform product code (from stock): ");
                        String code = in.nextLine();
                        Product product1 = stock.getProduct(code);
                        if(product1.isStockEmpty()){
                            throw new NoSuchProductException("The stock of this product is empty.");
                        }
                        int option2 = -1;
                        Product product2 = null;
                        do {
                            System.out.println("Is the product you want to exchange already in the stock? 1 - Yes, 0 - No");
                            try {
                                option2 = in.nextInt();
                                switch(option2){
                                    case 0: product2 = TestThriftStoreSystem.createNewProductToExchange(); break;
                                    case 1: product2 = TestThriftStoreSystem.getProductFromStockToExchange(); break;
                                    default: {
                                        System.out.println("Invalid option.");
                                        option2 = -1;
                                    }
                                }
                                if(product2 == null){
                                    throw new NoSuchProductException("The product you want to exchange doesn't exist.");
                                }
                                product1.exchange(product2);
                                System.out.printf("Products exchanged successfully!%n%s%n%s%n", product1.toString(), product2.toString());                              
                            } catch(NoSuchElementException e){
                                System.out.println("Invalid option.");
                                option2 = -1;
                            } 
                        } while(option2 == -1);
                        break;                        
                    }
                }            
            } catch(NoSuchElementException e){
                System.out.println("Invalid option.");
                option = 1;
            } catch(Exception e){
                System.out.println(e.getMessage());
            }   
        } while(option != 0);
        System.out.println("Leaving system...");
    }    
}
