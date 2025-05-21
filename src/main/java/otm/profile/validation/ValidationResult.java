package otm.profile.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidationResult {
    private List<ValidationMessage> messages;

    public ValidationResult() {
        this.messages = new ArrayList<>();
    }

    public ValidationResult(ValidationMessage... validationMessages) {
        this();
        if (validationMessages != null && validationMessages.length > 0) {
            this.messages.addAll(Arrays.asList(validationMessages));
        }
    }

    /**
     * Gets whether the validation is considered successful (no errors).
     */
    public boolean isValid() {
        return this.messages.stream().noneMatch(m -> m.getSeverity() == Severity.Error);
    }

    /**
     * Gets the list of validation messages (errors, warnings, infos).
     */
    public List<ValidationMessage> getMessages() {
        return messages;
    }

    public static ValidationResult success() {
        return new ValidationResult();
    }

    public static ValidationResult failure(String message) {
        ValidationMessage errorMessage = new ValidationMessage();
        errorMessage.setSeverity(Severity.Error);
        errorMessage.setMessage(message);
        return new ValidationResult(errorMessage);
    }
}