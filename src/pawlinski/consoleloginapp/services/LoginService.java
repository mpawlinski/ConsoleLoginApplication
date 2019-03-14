package pawlinski.consoleloginapp.services;

import pawlinski.consoleloginapp.model.User;
import pawlinski.consoleloginapp.repositories.UserRepository;

import java.util.Scanner;

public class LoginService {

    public boolean logged = false;
    public User loggedUser = new User();
    private static final Scanner SCANNER = new Scanner(System.in);

    public void login() {
        if(!UserRepository.getInstance().getUserList().isEmpty()) {
            if(!logged) {
                System.out.print("Login: ");
                String username = SCANNER.nextLine();

                System.out.print("Password: ");
                String password = SCANNER.nextLine();

                if(checkIfUserExistsAndLog(username, password)) {
                    logged = true;
                    System.out.println("Successfuly logged in as: " + loggedUser.getUsername() + "\n");

                } else {
                    System.out.println("Invalid username/password.");
                    login();
                }

            } else {
                System.out.println("You are logged in.");
            }

        } else {
            System.out.println("User doesn't exist. Register a new account.");
        }
    }

    public boolean checkIfUserExistsAndLog(String username, String password) {

        for(User user : UserRepository.getInstance().getUserList()) {
            if((username.equals(user.getUsername())) && (password.equals(user.getPassword()))) {
                loggedUser = user;
                return true;
            }
        }

        return false;
    }
}
