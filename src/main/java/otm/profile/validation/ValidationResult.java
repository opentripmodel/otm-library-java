package otm.profile.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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

    @Override
    public String toString() {
        if(isValid()){
            return "Validation succeeded (0 errors)";
        }

        StringBuilder sb = new StringBuilder();

        messages.sort(Comparator.comparing(ValidationMessage::getSeverity));
        for(ValidationMessage msg : messages){
            sb.append("[")
                .append(msg.getSeverity())
                .append("] ")
                .append(msg.getPath())
                .append(" -> ")
                .append(msg.getMessage())
                .append("\n");
        }

        return sb.toString();
    }

    /**
     * Gets whether the validation is considered successful (no errors).
     */
    public boolean isValid() {
        return this.messages.stream().noneMatch(m -> m.getSeverity() == Severity.ERROR);
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
        errorMessage.setSeverity(Severity.ERROR);
        errorMessage.setMessage(message);
        return new ValidationResult(errorMessage);
    }
}