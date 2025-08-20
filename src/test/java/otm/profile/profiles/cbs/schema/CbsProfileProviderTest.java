package otm.profile.profiles.cbs.schema;

import com.networknt.schema.JsonSchema;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class CbsProfileProviderTest{
    @Test
    void testGetSchema() throws IOException {
        JsonSchema schema = CbsProfileProvider.getSchema();
    }
}