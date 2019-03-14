package pawlinski.consoleloginapp;

import pawlinski.consoleloginapp.accountmanagement.AccountManagement;
import pawlinski.consoleloginapp.services.LoginService;
import pawlinski.consoleloginapp.services.RegisterService;
import pawlinski.consoleloginapp.ui.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static RegisterService registerService = new RegisterService();
    private static LoginService loginService = new LoginService();
    private static AccountManagement accountManagement;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean quit = false;
        Menu.showMainMenu();

        while(!quit) {
            try {
                int action = scanner.nextInt();
                scanner.nextLine();

                if(action >= 1 && action <= 3) {
                    switch(action) {
                        case 1:
                            registerService.registerNewAccount();
                            Menu.showMainMenu();
                            break;
                        case 2:
                            loginService.login();
                            redirectToUserAccount();
                            break;
                        case 3:
                            quit = true;
                            System.out.println("Exiting program..");
                            break;
                    }

                } else {
                    System.out.println("Enter an integer in range 1-3.");
                }

            } catch (InputMismatchException exception) {
                System.out.println("Please enter an Integer.");
                scanner.nextLine();
                continue;
            }
        }
    }

    private static void redirectToUserAccount() {
        Menu.showUserMenu();

        while(loginService.logged) {
            try {
                int action = scanner.nextInt();
                scanner.nextLine();
                accountManagement = new AccountManagement(loginService.loggedUser);

                if(action >= 1 && action <= 3) {
                    switch(action) {
                        case 1:
                            accountManagement.changePhoneNumber();
                            break;
                        case 2:
                            accountManagement.changeEmail();
                            break;
                        case 3:
                            loginService.logged = false;
                            System.out.println("Logout..");
                            Menu.showMainMenu();
                            break;
                    }

                } else {
                    System.out.println("Enter an integer in range 1-3.");
                }

            } catch (InputMismatchException exception) {
                System.out.println("Please enter an Integer.");
                scanner.nextLine();
                continue;
            }
        }
    }
}
