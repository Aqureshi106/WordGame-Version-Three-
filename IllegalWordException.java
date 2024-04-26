package project3;

/**
 * This class represents a custom exception for illegal words.
 */
public class IllegalWordException extends IllegalArgumentException {
	/**
     * Constructs an IllegalWordException with the specified message.
     *
     * @param message the detail message
     */
    public IllegalWordException(String message) { // A constructor which will be used to let the user know that their input is illegal.
        super(message);
    }
}
