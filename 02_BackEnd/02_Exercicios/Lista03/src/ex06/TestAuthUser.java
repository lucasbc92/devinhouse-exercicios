package ex06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import ex04.exceptions.InvalidEmailException;
import ex06.entities.AdminUser;
import ex06.entities.CommonUser;
import ex06.entities.SuperUser;
import ex06.entities.User;
//import ex06.exceptions.InvalidPasswordException;
import ex06.entities.UserAuthenticator;

public class TestAuthUser {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        UserAuthenticator authenticator = new UserAuthenticator();
        int option = 0;
        do {
            System.out.println("1 - Sign up new user");
            System.out.println("2 - Sign in user");
            System.out.println("0 - Exit");
            option = in.nextInt();
            
            switch(option){
                case 0: break;
                case 1: {
                    in.nextLine();
                    int userType = 0;
                    do {
                        System.out.println("User Type:");
                        System.out.println("1 - Common User");
                        System.out.println("2 - Admin User");
                        System.out.println("3 - Super User");
                        userType = in.nextInt();
                        switch(userType){
                            case 1: break;
                            case 2: break;
                            case 3: break;
                            default: {
                                System.out.println("Invalid option. Please type again.");
                                userType = 0;
                            }
                        }
                    } while(userType == 0);
                    in.nextLine();
                    System.out.print("Email: ");
                    String email = in.nextLine();
                    System.out.print("Password: ");
                    String password = in.nextLine();
                    try{
                        User newUser = new CommonUser(email, password);
                        switch(userType){
                            case 1: newUser = new CommonUser(email, password); break;
                            case 2: newUser = new AdminUser(email, password); break;
                            case 3: newUser = new SuperUser(email, password); break;
                        }
                        if(authenticator.addUser(newUser)){
                            System.out.println("User created successfully!");
                        } else {
                            System.out.println("Email already exists!");
                        }

                    // } catch(InvalidEmailException e){
                    //     System.out.println(e.getMessage());
                    // } catch(InvalidPasswordException e){
                    //     System.out.println(e.getMessage());
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;    
                }
                case 2: {
                    in.nextLine();
                    System.out.print("Email: ");
                    String email = in.nextLine();
                    System.out.print("Password: ");
                    String password = in.nextLine();
                    if(authenticator.authenticate(email, password)){
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Wrong email or password.");
                    }
                    break;
                }
                default: {
                    System.out.println("Invalid option.");
                }
            }
        } while(option != 0);
        System.out.println("Leaving program...");
    }
}
