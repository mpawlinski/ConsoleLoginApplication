package pawlinski.consoleloginapp.accountmanagement;

import pawlinski.consoleloginapp.model.User;
import pawlinski.consoleloginapp.ui.Menu;
import pawlinski.consoleloginapp.validators.EmailValidator;
import pawlinski.consoleloginapp.validators.PhoneNumberValidator;

import java.util.Scanner;

public class AccountManagement {

    private static final Scanner SCANNER = new Scanner(System.in);
    private PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator();
    private EmailValidator emailValidator = new EmailValidator();
    private User loggedUser;

    public AccountManagement(User user) {
        loggedUser = user;
    }

    public void changePhoneNumber() {
        System.out.print("Enter new phone number: ");
        String newPhoneNumber = SCANNER.nextLine();

        if(phoneNumberValidator.validate(newPhoneNumber)) {
            loggedUser.setPhoneNumber(newPhoneNumber);
            System.out.println("Phone number successfully changed!\n" + "New phone number: " + newPhoneNumber + "\n");
            Menu.showUserMenu();

        } else {
            changePhoneNumber();
        }
    }

    public void changeEmail() {
        System.out.print("Enter new email: ");
        String newEmail = SCANNER.nextLine();

        if(emailValidator.validate(newEmail) && (!newEmail.equals(loggedUser.getEmail()))) {
            loggedUser.setEmail(newEmail);
            System.out.println("Email successfully changed!\n" + "New email: " + newEmail + "\n");
            Menu.showUserMenu();

        } else {
            changeEmail();
        }
    }
}
