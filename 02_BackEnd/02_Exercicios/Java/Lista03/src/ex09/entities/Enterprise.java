package ex09.entities;

import ex09.exceptions.InvalidDocumentIdException;

public class Enterprise extends Contact {
    private static final int DOCUMENT_ID_DIGITS_NUMBER = 14;

    public Enterprise(String name, String primaryPhoneNumber, String secondaryPhoneNumber, String docId) throws InvalidDocumentIdException{
        super(name, primaryPhoneNumber, secondaryPhoneNumber, docId);
        if(!docId.matches(String.format("^\\d{%d}$", DOCUMENT_ID_DIGITS_NUMBER))){
            throw new InvalidDocumentIdException(String.format("The document must have %d digits.", DOCUMENT_ID_DIGITS_NUMBER));
        }
    }
}
