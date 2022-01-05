package ex06.exceptions;

public class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message){
        super(message);
    }
}
