package ex06.entities;

import ex04.exceptions.InvalidEmailException;
import ex06.exceptions.InvalidPasswordException;

public class AdminUser extends User {
    private static final int MIN_PASSWORD_LENGTH = 10;
    //private static final String VALID_PASSWORD_REGEX = String.format("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{%d,}$", MIN_PASSWORD_LENGTH);

    public AdminUser(String email, String password) throws InvalidEmailException, InvalidPasswordException {
        super(email, password);
        passwordRegex = String.format("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{%d,}$", MIN_PASSWORD_LENGTH);
        if(!this.isValidPassword(password)){
            throw new InvalidPasswordException(String.format("Error: The password must have at least %d characters between upper case letters, lower case letters and numbers.", MIN_PASSWORD_LENGTH));
        }
    }

    // protected boolean isValidPassword(String password){
    //     if(password.matches(VALID_PASSWORD_REGEX)){
    //         return true;
    //     } else return false;
    // }
}
