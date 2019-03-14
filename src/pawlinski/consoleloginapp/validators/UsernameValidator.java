package pawlinski.consoleloginapp.validators;

import pawlinski.consoleloginapp.repositories.UserRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsernameValidator implements CredentialsValidator {

    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]{3,20}$";

    @Override
    public boolean validate(String username) {
        Pattern pattern = Pattern.compile(USERNAME_PATTERN);
        Matcher matcher = pattern.matcher(username);

        if(UserRepository.getInstance().findUser(username) >= 0 || !matcher.matches()) {
            System.out.print("Username already exists/Invalid username. ");
            return false;

        } else {
            return true;
        }
    }
}
