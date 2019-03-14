package pawlinski.tests.validators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pawlinski.consoleloginapp.validators.CredentialsValidator;
import pawlinski.consoleloginapp.validators.EmailValidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmailValidatorTest {

    CredentialsValidator credentialsValidator;

    @BeforeEach
    void setUp() {
        credentialsValidator = new EmailValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"test@test.com", "test123@test123.com", "test@test.com.en",
            "test.test2@test.com", "test.test2.test3@test.com", "TEST.2test@test.com", "TEST@test.com",
            "123.123@test.com", "1.2@test.com"})
    void validateCorrectEmail(String email) {

        boolean isValid = credentialsValidator.validate(email);
        assertTrue(isValid);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test@test", "@test.com", "test@test.", "test@test..com", "test@.test.com",
            "#test@test.com", "#test@test.com", "t@est@test.com", "", "test@@test.com", " @test.com",
            "TEST.@test.com", " @test.com", " ", "1.@test.com.en"})
    void validateIncorrectEmail(String email) {

        boolean isValid = credentialsValidator.validate(email);
        assertFalse(isValid);
    }
}