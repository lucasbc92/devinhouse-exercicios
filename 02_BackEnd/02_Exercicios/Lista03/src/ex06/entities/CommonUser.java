package ex06.entities;

import ex04.exceptions.InvalidEmailException;
import ex06.exceptions.InvalidPasswordException;

public class CommonUser extends User {
    private static final int MIN_PASSWORD_LENGTH = 8;
    //private static final String VALID_PASSWORD_REGEX = String.format("^(?=.*\\w).{%d,}$", MIN_PASSWORD_LENGTH);

    public CommonUser(String email, String password) throws InvalidEmailException, InvalidPasswordException{
        super(email, password);
        passwordRegex = String.format("^(?=.*\\w).{%d,}$", MIN_PASSWORD_LENGTH);
        if(!this.isValidPassword(password)){
            throw new InvalidPasswordException(String.format("Error: The password must have at least %d characters", MIN_PASSWORD_LENGTH));
        }
    }

    // protected boolean isValidPassword(String password) {
    //    if(password.matches(VALID_PASSWORD_REGEX)){
    //         return true;
    //     } else return false;
    // }
}
