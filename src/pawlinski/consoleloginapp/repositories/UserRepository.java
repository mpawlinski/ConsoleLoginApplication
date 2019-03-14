package pawlinski.consoleloginapp.repositories;

import pawlinski.consoleloginapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private final List<User> userList = new ArrayList<>();

    private static UserRepository instance = new UserRepository();

    private UserRepository() {

    }

    public static UserRepository getInstance() {
        return instance;
    }

    public List<User> getUserList() {
        return userList;
    }

    public int findUser(String username) {
        for (User user : userList) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return userList.indexOf(user);
            }
        }

        return -1;
    }
}
