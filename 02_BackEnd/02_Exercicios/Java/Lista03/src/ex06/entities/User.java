package ex06.entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ex04.exceptions.InvalidEmailException;
import ex06.exceptions.InvalidPasswordException;

public abstract class User {
    private String email;
    private String password;
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    protected static String passwordRegex;

    public User(String email, String password) throws InvalidEmailException{
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        if(!matcher.matches()){
            throw new InvalidEmailException("Error: The email is invalid.");
        }        
        this.email = email;
        this.password = password;
        passwordRegex = "(.*?)";
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public void setEmail(String email) throws InvalidEmailException{
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        if(!matcher.matches()){
            throw new InvalidEmailException("The email is invalid.");
        }
        this.email = email;
    }

    protected boolean isValidPassword(String password){
        if(password.matches(passwordRegex)){
            return true;
        } else return false;
    }

    public void setPassword(String password) throws InvalidPasswordException {
        if(isValidPassword(password)){
            this.password = password;
        } else {
            throw new InvalidPasswordException("The password does not meet the security criteria.");
        }
    }
    
    @Override
    public String toString(){
        return String.format("Type:%s%nEmail:%s%nPassword:%s%n", this.getClass().getSimpleName(), this.getEmail(), this.getPassword());
    }
}
