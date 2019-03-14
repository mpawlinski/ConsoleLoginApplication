package pawlinski.consoleloginapp.generators;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PasswordGenerator {

    private static final String CAPITAL_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*_=+-/.?<>)";

    private static final String PASSWORD_BASE = CAPITAL_LETTERS + LOWERCASE_LETTERS + NUMBERS + SPECIAL_CHARACTERS;

    private static final Random RANDOM = new Random();

    public static String generateRandomPassword() {
        int randomPasswordLength = 8 + RANDOM.nextInt(7);

        Character[] passCharArray = new Character[randomPasswordLength];

        passCharArray[0] = randomChar(CAPITAL_LETTERS);
        passCharArray[1] = randomChar(LOWERCASE_LETTERS);
        passCharArray[2] = randomChar(NUMBERS);
        passCharArray[3] = randomChar(SPECIAL_CHARACTERS);
        for(int i=4; i<randomPasswordLength; i++) {
            passCharArray[i] = PASSWORD_BASE.charAt(RANDOM.nextInt(PASSWORD_BASE.length()));
        }

        String generatedPassword = shuffleAndConvertToString(passCharArray);
        System.out.println("Generated password: " + generatedPassword);

        return generatedPassword;
    }

    private static char randomChar(String string) {
        return string.charAt(RANDOM.nextInt(string.length()));
    }

    private static String shuffleAndConvertToString(Character[] arr) {
        List<Character> charList = Arrays.asList(arr);
        Collections.shuffle(charList);

        String generatedPassword = "";
        for(Character character : charList) {
            generatedPassword += character;
        }

        return generatedPassword;
    }

}
