package ex09.exceptions;

public class InvalidDocumentIdException extends Exception {
    public InvalidDocumentIdException(String message){
        super(message);
    }
}
