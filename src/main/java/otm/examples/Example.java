package otm.examples;

import otm.model.entities.Trip;
import otm.model.entities.TripStatus;
import otm.serializer.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class Example {
    public static void main(String[] args) {
        // Create a sample Trip object
        Trip trip = new Trip();
        trip.setId(UUID.randomUUID().toString());
        trip.setName("Hello trip ;-D");
        trip.setStatus(TripStatus.IN_TRANSIT);

        // Initialize the serializer
        IOtmSerializer serializer = new OtmSerializer();

        try {
            // === String-Based Serialization ===
            String json = serializer.serialize(trip);
            System.out.println("Serialized JSON:\n" + json);

            Trip tripFromString = serializer.deserialize(json, Trip.class);
            System.out.println("\nDeserialized from string: Trip ID = " + tripFromString.getId());

            // === Stream-Based Serialization ===
            String path = "trip.json";

            // Ensure the file is created/overwritten, then close the stream
            try (FileOutputStream fs = new FileOutputStream(path)) {
                serializer.serializeToStream(trip, fs);
                System.out.println("\nTrip object serialized to " + path);
            }

            // Read the file and deserialize
            try (FileInputStream fs = new FileInputStream(path)) {
                Trip tripFromStream = serializer.deserializeFromStream(fs, Trip.class);
                System.out.println("\nDeserialized from stream: Trip Name = " + tripFromStream.getName());
            }

            // Clean up the created file
            Files.deleteIfExists(Paths.get(path));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}