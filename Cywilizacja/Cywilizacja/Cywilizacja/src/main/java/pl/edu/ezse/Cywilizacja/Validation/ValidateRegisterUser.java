package pl.edu.ezse.Cywilizacja.Validation;

import javax.validation.ValidationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateRegisterUser {
    public static void validateLogin(String login) {
        Pattern pattern = Pattern.compile("[A-Za-z0-9]{5}.*");
        Matcher matcher = pattern.matcher(login);
        if(!matcher.matches()) {
            throw new ValidationException("Login must have minimum 5 chars and containing only alphanumeric characters");
        }
    }

    public static void validatePassword(String password) {
        Pattern pattern = Pattern.compile("[A-Za-z0-9]{5}.*");
        Matcher matcher = pattern.matcher(password);
        if(!matcher.matches()) {
            throw new ValidationException("Login must have minimum 5 chars and containing only alphanumeric characters");
        }
    }
}
