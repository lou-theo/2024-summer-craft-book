package password;

import java.util.stream.Stream;

public class PasswordValidator {
    public boolean valid(String password) {
        return Stream.of(
            isLongEnough(password),
            hasUpperCase(password),
            hasLowerCase(password),
            hasDigit(password),
            hasSpecialCharacter(password),
            hasNotInvalidCharacter(password)
        ).allMatch(value -> value);
    }

    private static boolean isLongEnough(String password) {
        return password.length() >= 8;
    }

    private static boolean hasUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    private static boolean hasLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    private static boolean hasDigit(String password) {
        return password.matches(".*[0-9].*");
    }

    private static boolean hasSpecialCharacter(String password) {
        return password.matches(".*[.*#@$%&].*");
    }

    private static boolean hasNotInvalidCharacter(String password) {
        return !password.matches(".*[^A-Za-z0-9.*#@$%&].*");
    }
}
