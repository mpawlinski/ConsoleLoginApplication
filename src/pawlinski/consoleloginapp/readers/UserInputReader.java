package pawlinski.consoleloginapp.readers;

import pawlinski.consoleloginapp.validators.EmailValidator;
import pawlinski.consoleloginapp.validators.PasswordValidator;
import pawlinski.consoleloginapp.validators.PhoneNumberValidator;
import pawlinski.consoleloginapp.validators.UsernameValidator;

import java.util.Scanner;

public class UserInputReader {

    private static final Scanner SCANNER = new Scanner(System.in);

    private PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator();
    private UsernameValidator usernameValidator = new UsernameValidator();
    private PasswordValidator passwordValidator = new PasswordValidator();
    private EmailValidator emailValidator = new EmailValidator();

    public String readPhoneNumber() {
        String phoneNumber = "";
        do {
            System.out.print("Enter phone number (format 111222333): ");
            phoneNumber = SCANNER.nextLine();
        } while(!phoneNumberValidator.validate(phoneNumber));

        return phoneNumber;
    }

        public String readUsername() {
        String username = "";

        do {
            System.out.print("Enter username (Minimum 3 characters): ");
            username = SCANNER.nextLine();
        } while (!usernameValidator.validate(username));

        return username;
    }

    public String readPassword() {
        String password = "";

        do {
            System.out.println("Enter password between 8 and 15 characters. (Must contain at least: 1 uppercase letter, " +
                    "1 alphanumeric character " +
                    "1 special character): ");
            password = SCANNER.nextLine();
        } while (!passwordValidator.validate(password));

        return password;
    }

    public String readEmail() {
        String email = "";

        do {
            System.out.print("Enter email (format example@example.com): ");
            email = SCANNER.nextLine();
        } while (!emailValidator.validate(email));

        return email;
    }
}
