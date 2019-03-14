package pawlinski.tests.validators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pawlinski.consoleloginapp.validators.PasswordValidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordValidatorTest {

    PasswordValidator passwordValidator;

    @BeforeEach
    void setUp() {
        passwordValidator = new PasswordValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"A123456?", "aB123456?", "aB123456@", "aB123456:", "|aB123456", "aB12:3456?", "a;B123456?",
            "aB12345-6?", "ABC_123_?", "A12345?A", "&G123456?", "1B12?4562", "a123?BCd", "P@ssW0RD",
            "ABCDE12345?@#$%"})
    void validateCorrectPassword(String password) {

        boolean isValid = passwordValidator.validate(password);
        assertTrue(isValid);
    }

    @ParameterizedTest
    @ValueSource(strings = {"literalsOnly", "tooShort", "veryVeryLongPassword", "noNumbers@", "nouppercase123?",
                            "NOspecialCHAR12", "!@#$%^&*(", " ", ""})
    void validateIncorrectPassword(String password) {

        boolean isValid = passwordValidator.validate(password);
        assertFalse(isValid);
    }
}