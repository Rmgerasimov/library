package validation;

public class GeneralValidation {

    public static void isValidString(String check, String message) {
        if (check == null || check.trim().isEmpty()) {
            throw new InvalidParameterException(message);
        }
    }

    public static void isValidInteger(int check, String message) {
        if (check <= 0) {
            throw new InvalidParameterException(message);
        }
    }
}
