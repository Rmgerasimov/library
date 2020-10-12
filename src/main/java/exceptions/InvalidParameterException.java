package exceptions;

/**
 * Thrown when a user enter a wrong input. These include:
 * Book validation
 * Person validation
 * todo
 */
public class InvalidParameterException extends RuntimeException {
    public InvalidParameterException(String message) {
        super(message);
    }
}
