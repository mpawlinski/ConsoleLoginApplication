package pawlinski.consoleloginapp.ui;

public class Menu {

    public static void showMainMenu() {
        System.out.println("Available options:\n" +
                "1 - Create a new account\n" +
                "2 - Login\n" +
                "3 - Quit");
    }

    public static void showUserMenu() {
        System.out.println("Available options:\n" +
                "1 - Change phone number\n" +
                "2 - Change email\n" +
                "3 - Logout");
    }

    public static void passwordMenu() {
        System.out.println("Available options:\n" +
                "1 - Generate random password\n" +
                "2 - Enter password");
    }
}
