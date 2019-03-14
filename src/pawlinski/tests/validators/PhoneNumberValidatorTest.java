package pawlinski.tests.validators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pawlinski.consoleloginapp.validators.PhoneNumberValidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PhoneNumberValidatorTest {

    PhoneNumberValidator phoneNumberValidator;

    @BeforeEach
    void setUp() {
        phoneNumberValidator = new PhoneNumberValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456789", "555555555", "012345678"})
    void validateCorrectPhoneNumber(String phoneNumber) {

        boolean isValid = phoneNumberValidator.validate(phoneNumber);
        assertTrue(isValid);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345678", "0123456789", "!@#$%^&*(", "123 456 789", "+0012345", "123-456-789",
                            "+123456789", "", " ", "0"})
    void validateIncorrectPhoneNumber(String phoneNumber) {

        boolean isValid = phoneNumberValidator.validate(phoneNumber);
        assertFalse(isValid);
    }
}