package otm.profile.profiles.cbs;

import com.networknt.schema.JsonSchema;
import com.networknt.schema.ValidationMessage;
import otm.profile.validation.Severity;
import otm.profile.validation.ValidationCode;
import otm.profile.validation.ValidationResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CbsProfileEvaluationResultsMapper {

    public static ValidationResult map(JsonSchema schema, Set<ValidationMessage> validationMessages) {
        // Collect error messages
        List<otm.profile.validation.ValidationMessage> messages = new ArrayList<>();

//         Flatten the tree into a list
//        validationMessages.toList();

//        // Get all nodes that have errors
//        List<EvaluationResults> errorNodes = validationMessages.getDetails().stream()
//                .filter(EvaluationResults::hasErrors)
//                .toList();

        for (ValidationMessage validationMessage : validationMessages) {
            messages.add(new otm.profile.validation.ValidationMessage(
                Severity.ERROR, // everything from JSON Schema is an error
                validationMessage.getMessage(),
                validationMessage.getSchemaLocation().toString(),
                ValidationCode.Required
            ));
        }
//
//        for (EvaluationResults errorNode : errorNodes) {
//            for (String keyword : errorNode.getErrors().keySet()) {
//                // Get the validation code from the keyword
//                String code = JsonSchemaKeywordValidationCodeMap.getCode(keyword);
//
//                // Get the instance location as a string
//                String instance = errorNode.getInstanceLocation().toString();
//
//                // Get the error message text
//                String text = ValidationMessageResolver.getMessage(schema, errorNode, code, errorNode.getErrors().get(keyword), instance);
//
//                // Create and add the validation message
//                ValidationMessage message = new ValidationMessage();
//                message.setSeverity(Severity.Error); // All JSON schema issues are errors
//                message.setPath(instance);
//                message.setCode(code);
//                message.setMessage(text);
//                messages.add(message);
//            }
//        }

        return new ValidationResult(messages.toArray(new otm.profile.validation.ValidationMessage[0]));
    }
}