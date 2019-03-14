package pawlinski.consoleloginapp.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator implements CredentialsValidator {

    private static final String PHONE_NUMBER_PATTERN = "^\\d{9}$";

    @Override
    public boolean validate(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(phoneNumber);

        if(!matcher.matches()) {
            System.out.print("Invalid phone number. ");
            return false;

        } else {
            return true;
        }
    }
}
