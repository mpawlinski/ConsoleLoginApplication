package pawlinski.tests.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pawlinski.consoleloginapp.model.User;
import pawlinski.consoleloginapp.repositories.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserRepositoryTest {

    private static final String USERNAME = "John";
    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setUsername(USERNAME);
        UserRepository.getInstance().getUserList().add(user);
    }

    @Test
    void testFindUserPositive() {
        int index = UserRepository.getInstance().findUser(USERNAME);

        assertEquals(0, index);
    }

    @Test
    void testFindUserNegative() {
        int negativeIndex = UserRepository.getInstance().findUser("Bill");

        assertEquals(-1, negativeIndex);
    }
}