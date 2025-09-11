package otm.profile.profiles.cbs;

import com.networknt.schema.ValidationMessage;
import otm.profile.validation.Severity;
import otm.profile.validation.ValidationCode;
import otm.profile.validation.ValidationResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CbsProfileEvaluationResultsMapper {

    public static ValidationResult map(Set<ValidationMessage> validationMessages) {
        // Collect error messages
        List<otm.profile.validation.ValidationMessage> messages = new ArrayList<>();

        for (ValidationMessage validationMessage : validationMessages) {
            messages.add(new otm.profile.validation.ValidationMessage(
                Severity.ERROR, // everything from JSON Schema is an error
                validationMessage.getMessage(),
                validationMessage.getSchemaLocation().toString(),
                ValidationCode.REQUIRED
            ));
        }

        return new ValidationResult(messages.toArray(new otm.profile.validation.ValidationMessage[0]));
    }
}