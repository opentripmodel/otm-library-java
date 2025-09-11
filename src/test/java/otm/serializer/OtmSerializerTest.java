package otm.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import otm.BaseTest;
import otm.model.entities.Trip;
import java.io.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("OTM serializer test")
public class OtmSerializerTest extends BaseTest {
    static ZoneId systemZone = ZoneId.systemDefault();
    static ZonedDateTime zonedDateTimeStart = START_TIME.atZone(systemZone);
    static ZonedDateTime zonedDateTimeEnd = END_TIME.atZone(systemZone);
    static String formattedStartDate = zonedDateTimeStart.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
    static String formattedEndDate = zonedDateTimeEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));

    private final static String TRIP_JSON =  """
                {
                  "id" : "baa6e209-2b2b-4f35-86e1-dd229ca839e4",
                  "name" : "Trip with errors",
                  "status" : "completed",
                  "transportMode" : "road",
                  "vehicle" : {
                    "associationType" : "inline",
                    "entity" : {
                      "id" : "a2a0925f-3ad5-4d01-a00a-4031b0e54e09",
                      "vehicleType" : "truck",
                      "averageFuelConsumption" : {
                        "unit" : "l/100km",
                        "value" : 32.5
                      },
                      "licensePlate" : "NL-01-AB"
                    }
                  },
                  "actors" : [ {
                    "associationType" : "inline",
                    "entity" : {
                      "id" : "2f86b0c6-383f-40da-9de0-167b26450303",
                      "name" : "Logistics BV",
                      "contactDetails" : [ {
                        "type" : "email",
                        "value" : "info@logistics.nl"
                      } ],
                      "locations" : [ {
                        "associationType" : "inline",
                        "entity" : {
                          "geoReference" : {
                            "type" : "addressGeoReference",
                            "street" : "Prinsengracht",
                            "houseNumber" : "263",
                            "postalCode" : "1016 XP",
                            "city" : "Amsterdam",
                            "country" : "NL"
                          }
                        }
                      } ]
                    },
                    "roles" : [ "carrier" ]
                  } ],
                  "actions" : [ {
                    "associationType" : "inline",
                    "entity" : {
                      "id" : "ff3251c5-dd40-4a1f-9abd-0fd0205fd2aa",
                      "actionType" : "stop",
                      "lifecycle" : "actual",
                      "location" : {
                        "associationType" : "inline",
                        "entity" : {
                          "name" : "Warehouse Amsterdam",
                          "type" : "customer"
                        }
                      },
                      "startTime" : "%s",
                      "endTime" : "%s"
                    }
                  } ],
                  "entityType" : "trip"
                }""".formatted(formattedStartDate, formattedEndDate);

    /*
     * A simple test that checks if the serializer works. It takes the trip provided by the BaseTest class
     * and serializes it to a JSON string. The resulting JSON string should be equal to the expected JSON string.
     * The dates and IDs are hard set in the BaseTest class.
     */
    @Test
    @DisplayName("test the OtmSerializer serialize method")
    void testOtmSerializerSerialize() throws Exception {
        IOtmSerializer serializer = new OtmSerializer();
        String json = serializer.serialize(trip);

        assertEquals(TRIP_JSON, json);
    }

    /*
     * A simple test that checks if the serializer works. It takes the trip provided by the BaseTest class
     * and serializes it to a JSON string. The resulting JSON string should be equal to the expected JSON string.
     * The dates and IDs are hard set in the BaseTest class.
     */
    @Test
    @DisplayName("test the OtmSerializer deserialize method")
    void testOtmSerializerDeserialize() throws Exception {
        IOtmSerializer serializer = new OtmSerializer();
        Trip tripFromString = serializer.deserialize(TRIP_JSON, Trip.class);

        assertThat(tripFromString).usingRecursiveComparison().isEqualTo(trip);
    }

    @Test
    @DisplayName("test the OtmSerializer deserialize method wiht forced error")
    void testOtmSerializerDeserializeWithForcedError() throws Exception {
        IOtmSerializer serializer = new OtmSerializer();
        Trip tripFromString = serializer.deserialize(TRIP_JSON, Trip.class);

        // Force an error into the trip
        trip.setName(null);

        assertThat(tripFromString).usingRecursiveComparison().isNotEqualTo(trip);
    }

    @Test
    @DisplayName("test serialize a valid object to a JSON string")
    void testSerializeToStreamWithValidObject() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); // In-memory stream
        IOtmSerializer serializer = new OtmSerializer();

        // Act
        serializer.serializeToStream(trip, outputStream);
        String actualJson = outputStream.toString();

        // Assert
        assertEquals(TRIP_JSON, actualJson);
    }

    @Test
    @DisplayName("test throw NullPointerException when the OutputStream is null")
    void testSerializeToStreamWithNullStream() {
        IOtmSerializer serializer = new OtmSerializer();

        // We assert that calling the method with a null stream throws the expected exception.
        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> serializer.serializeToStream(trip, null)
        );

        // Also, check that the exception message is correct.
        assertEquals("outputStream cannot be null", exception.getMessage());
    }

    @Test
    @DisplayName("test propagate IOException when the stream fails to write")
    void testSerializeToStreamWithFailingStream() throws IOException {
        IOtmSerializer serializer = new OtmSerializer();
        // Create a "pipe" with a writing end and a reading end.
        PipedOutputStream failingStream = new PipedOutputStream();
        PipedInputStream inputStream = new PipedInputStream(failingStream);

        // Close the reading end. Now, any attempt to write will fail.
        inputStream.close();

        // We expect an IOException because the pipe is broken.
        IOException exception = assertThrows(
                IOException.class,
                () -> serializer.serializeToStream(trip, failingStream)
        );

        assertNotNull(exception.getMessage());
        assertTrue(exception.getMessage().contains("Pipe closed"));
    }

    @Test
    @DisplayName("test that deserializeFromStream should deserialize a valid JSON stream to an object")
    void testDeserializeFromStreamWithValidJson() throws IOException {
        IOtmSerializer serializer = new OtmSerializer();

        // Convert the string to an in-memory input stream
        InputStream inputStream = new ByteArrayInputStream(TRIP_JSON.getBytes());

        Trip result = serializer.deserializeFromStream(inputStream, Trip.class);

        assertThat(result).usingRecursiveComparison().isEqualTo(trip);
    }

    @Test
    @DisplayName("test that deserializeFromStream should throw NullPointerException when the InputStream is null")
    void testDeserializeFromStreamWithNullInputStream() {
        IOtmSerializer serializer = new OtmSerializer();

        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> serializer.deserializeFromStream(null, Trip.class)
        );

        assertEquals("inputStream cannot be null", exception.getMessage());
    }

    @Test
    @DisplayName("that that deserializeFromStream should throw NullPointerException when the valueType is null")
    void testDeserializeFromStreamWithNullValueType() {
        IOtmSerializer serializer = new OtmSerializer();

        String json = "{\"id\":1}";
        InputStream inputStream = new ByteArrayInputStream(json.getBytes());

        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> serializer.deserializeFromStream(inputStream, null)
        );

        assertEquals("valueType cannot be null for deserialization from stream", exception.getMessage());
    }

    @Test
    @DisplayName("test that deserializeFromStream should throw IOException for malformed JSON")
    void testDeserializeFromStreamWithMalformedJson() {
        IOtmSerializer serializer = new OtmSerializer();

        String malformedJson = "{\"id\":99,\"title\":\"Incomplete"; // Missing quote and brace
        InputStream inputStream = new ByteArrayInputStream(malformedJson.getBytes());

        // JsonProcessingException is a subclass of IOException, so this check is valid.
        assertThrows(
                JsonProcessingException.class,
                () -> serializer.deserializeFromStream(inputStream, Trip.class)
        );
    }
}
