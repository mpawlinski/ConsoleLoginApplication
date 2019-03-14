package pawlinski.tests.generators;

import org.junit.jupiter.api.Test;
import pawlinski.consoleloginapp.generators.PasswordGenerator;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordGeneratorTest {

    private static final int MIN = 8;
    private static final int MAX = 15;

    @Test
    void generateRandomPasswordTestRange() {
        String generatedPassword = PasswordGenerator.generateRandomPassword();

        assertTrue(MIN <= generatedPassword.length() && generatedPassword.length() <= MAX);
    }
}