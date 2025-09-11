package otm.profile.profiles.cbs;

import com.networknt.schema.*;
import otm.model.entities.Trip;
import otm.profile.profiles.IProfileValidator;
import otm.profile.profiles.cbs.schema.CbsProfileProvider;
import otm.profile.validation.ValidationResult;
import otm.serializer.OtmSerializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Set;


public class CbsProfileValidator implements IProfileValidator<Trip> { // Using placeholder Trip for OpenTripModel.v5.Trip
    @Override
    public ValidationResult validate(Trip trip) throws IOException {
        OtmSerializer serializer = new OtmSerializer();

        String serializedTrip = serializer.serialize(trip);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode tripJsonNode = objectMapper.readTree(serializedTrip);

        JsonSchema cbsSchema = CbsProfileProvider.getSchema();

        Set<ValidationMessage> validationMessages = cbsSchema.validate(tripJsonNode);

        return CbsProfileEvaluationResultsMapper.map(validationMessages);
    }
}