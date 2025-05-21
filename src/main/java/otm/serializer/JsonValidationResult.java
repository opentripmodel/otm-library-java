package otm.serializer;

public class JsonValidationResult {
    /**
     * Indicates whether the JSON was valid.
     */
    private final boolean isValid;

    /**
     * Descriptive error message if validation fails.
     */
    private final String errorMessage;

    /**
     * Optional inner exception if applicable.
     */
    private final Exception exception;

    private JsonValidationResult(boolean isValid, String errorMessage, Exception exception) {
        this.isValid = isValid;
        this.errorMessage = errorMessage;
        this.exception = exception;
    }

    /**
     * Indicates whether the JSON was valid.
     *
     * @return True if the JSON is valid, false otherwise.
     */
    public boolean isValid() {
        return isValid;
    }

    /**
     * Descriptive error message if validation fails.
     *
     * @return The error message, or null if validation was successful.
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Optional inner exception if applicable.
     *
     * @return The exception that occurred during validation, or null.
     */
    public Exception getException() {
        return exception;
    }

    /**
     * Creates a successful validation result.
     *
     * @return A {@link JsonValidationResult} indicating success.
     */
    public static JsonValidationResult success() {
        return new JsonValidationResult(true, null, null);
    }

    /**
     * Creates a failed validation result with a message and an optional exception.
     *
     * @param message The error message.
     * @param ex      The exception that caused the failure (can be null).
     * @return A {@link JsonValidationResult} indicating failure.
     */
    public static JsonValidationResult failure(String message, Exception ex) {
        return new JsonValidationResult(false, message, ex);
    }
}