package otm.profile.validation;

public class ValidationMessage {

    public ValidationMessage(Severity severity, String message, String path, ValidationCode code) {
        this.severity = severity;
        this.message = message;
        this.path = path;
        this.code = code;
    }

    public ValidationMessage() {
    }

    /**
     * The severity of the message (Info, Warning, Error).
     */
    private Severity severity;

    /**
     * The human-readable message.
     */
    private String message;

    /**
     * Optional path or property reference indicating the source of the issue.
     */
    private String path;

    /*
    Identifier for the failed rule; useful for filtering.
     */
    private ValidationCode code;

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ValidationCode getCode() {
        return code;
    }

    public void ValidationCode(ValidationCode code) {
        this.code = code;
    }
}