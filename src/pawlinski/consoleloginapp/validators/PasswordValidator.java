package pawlinski.consoleloginapp.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements CredentialsValidator {

    private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[A-Z])(?=.*\\W).{8,15})";

    @Override
    public boolean validate(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);

        if(!matcher.matches()) {
            System.out.print("Invalid password. ");
            return false;

        } else {
            return true;
        }
    }
}
