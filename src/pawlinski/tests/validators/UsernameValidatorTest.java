package pawlinski.tests.validators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pawlinski.consoleloginapp.validators.UsernameValidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UsernameValidatorTest {

    UsernameValidator usernameValidator;

    @BeforeEach
    void setUp() {
        usernameValidator = new UsernameValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"username", "123username", "username3", "user2name", "USERNAME", "USERNAME123",
            "123USERNAME123", "2uSERname33", "123456789", "123", "VERYlongusername1234"})
    void validateCorrectUsername(String username) {

        boolean isValid = usernameValidator.validate(username);
        assertTrue(isValid);
    }

    @ParameterizedTest
    @ValueSource(strings = {"   ", "", "ab", "AB", "12", "!@#", "veryVeryVeryLongUsername", "TE@ST", "test.test",
                            "test1test@", "a    "})
    void validateIncorrectUsername(String username) {

        boolean isValid = usernameValidator.validate(username);
        assertFalse(isValid);
    }
}