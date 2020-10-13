package common;

public class Validation {

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

    public static void checkEnumForNull(Enum<?> check, String message) {
        if (check == null) {
            throw new InvalidParameterException(message);
        }
    }

    public static void checkForValidYear(int year, String message) {
        if (year <= 0 || year > 2020) {
            throw new InvalidParameterException(message);
        }
    }

    public static void checkForCorrectDate(int year, int month, int day, String message) {
        checkForValidYear(year, message);
        if (month <= 0 || month > 12 || day <= 0 || day > 31) {     // todo -> what if February have 28 days ?
            throw new InvalidParameterException(message);
        }
    }

}
