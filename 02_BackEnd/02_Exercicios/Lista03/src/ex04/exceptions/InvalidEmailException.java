package ex04.exceptions;

public class InvalidEmailException extends Exception {
    public InvalidEmailException(){
        super();
    }

    public InvalidEmailException(String message){
        super(message);
    }
}
