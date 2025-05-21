package otm.profile.validation;

public class ValidationMessage {
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
}