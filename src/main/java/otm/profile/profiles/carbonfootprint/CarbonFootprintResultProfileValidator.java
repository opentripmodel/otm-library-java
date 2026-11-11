package otm.profile.profiles.carbonfootprint;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.ValidationMessage;
import otm.model.entities.Trip;
import otm.profile.profiles.IProfileValidator;
import otm.profile.profiles.carbonfootprint.schema.CarbonFootprintProfileProvider;
import otm.profile.validation.ValidationResult;
import otm.serializer.OtmSerializer;

import java.io.IOException;
import java.util.Set;

/**
 * Validates a Trip entity carrying calculated CO2 emission results, according to the OTM
 * Carbon Footprint profile (CO2 Calculation Result). The trip must carry at least one emission
 * context event with the total CO2e emission and the calculation method details (framework,
 * ISO reference, allocation method, data quality), as defined by the DALTI
 * "Uniforme kernset CO2e".
 *
 * <p>The Carbon Footprint profile is still a DRAFT; this validator follows the draft message
 * model and will be updated once the profile is formally released by the OTM working group.</p>
 */
public class CarbonFootprintResultProfileValidator implements IProfileValidator<Trip> {

    @Override
    public ValidationResult validate(Trip trip) throws IOException {
        OtmSerializer serializer = new OtmSerializer();

        String serializedTrip = serializer.serialize(trip);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode tripJsonNode = objectMapper.readTree(serializedTrip);

        JsonSchema resultSchema = CarbonFootprintProfileProvider.getResultSchema();

        Set<ValidationMessage> validationMessages = resultSchema.validate(tripJsonNode);

        return CarbonFootprintEvaluationResultsMapper.map(validationMessages);
    }
}
