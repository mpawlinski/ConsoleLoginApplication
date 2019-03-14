package pawlinski.consoleloginapp.services;

import pawlinski.consoleloginapp.generators.PasswordGenerator;
import pawlinski.consoleloginapp.model.User;
import pawlinski.consoleloginapp.readers.UserInputReader;
import pawlinski.consoleloginapp.repositories.UserRepository;
import pawlinski.consoleloginapp.ui.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RegisterService {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static UserInputReader userInputReader = new UserInputReader();

    public void registerNewAccount() {
        User newUser = new User();

        //USERNAME
        String username = userInputReader.readUsername();
        newUser.setUsername(username);

        //PASSWORD
        Menu.passwordMenu();
        boolean flag = false;

        while(!flag) {
            try {
                int action = SCANNER.nextInt();
                SCANNER.nextLine();

                if (action == 1 || action == 2) {

                    switch (action) {
                        case 1:
                            System.out.println("Generating random password...");
                            newUser.setPassword(PasswordGenerator.generateRandomPassword());
                            flag=true;
                            break;
                        case 2:
                            String password = userInputReader.readPassword();
                            newUser.setPassword(password);
                            flag=true;
                            break;
                    }

                } else {
                    System.out.println("Enter an integer in range 1-2.");
                }

            } catch (InputMismatchException exception) {
                System.out.println("Please enter an integer.");
                SCANNER.nextLine();
            }
        }

        //EMAIL
        String email = userInputReader.readEmail();
        newUser.setEmail(email);

        //PHONE NUMBER
        String phoneNumber = userInputReader.readPhoneNumber();
        newUser.setPhoneNumber(phoneNumber);


        UserRepository.getInstance().getUserList().add(newUser);

        System.out.println("++++++++USERS: ");
        for(User user : UserRepository.getInstance().getUserList()) {
            System.out.println(user);
        }

        System.out.println("\nAccount successfully created!\n" +
                "Username: " + newUser.getUsername() + "\n" +
                "Password: " + newUser.getPassword() + "\n" +
                "Email: " + newUser.getEmail() + "\n" +
                "Phone number: " + newUser.getPhoneNumber() + "\n");
    }
}
