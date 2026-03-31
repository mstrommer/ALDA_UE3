package at.ac.hcw;

import at.ac.hcw.datastructures.Hashtable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public final class Util {
    private static final String STATIONS_FILE = "stations.csv";
    private static final int STATIONS_TABLE_CAPACITY = 100;

    public static Hashtable<String, String> parseStations() {
        // TODO implement a suitable constructor in Hashtable.java and uncomment the line below
        // Hashtable<String, String> stations = new Hashtable<>(STATIONS_TABLE_CAPACITY);

        try (InputStream inputStream = Util.class.getClassLoader().getResourceAsStream(STATIONS_FILE)) {
            if (inputStream == null) {
                throw new IllegalStateException("Resource not found: " + STATIONS_FILE);
            }

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    String trimmedLine = line.trim();

                    if (trimmedLine.isEmpty() || trimmedLine.startsWith("#")) {
                        continue;
                    }

                    String[] parts = trimmedLine.split(";", 2);
                    if (parts.length < 2) {
                        continue;
                    }

                    String icaoCode = parts[0].trim();
                    String airportName = parts[1].trim();

                    // TODO implement a suitable put method in Hashtable.java and uncomment the line below
                    // stations.put(icaoCode, airportName);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not parse " + STATIONS_FILE, e);
        }
        // TODO fix below
        //return stations;
        return null;
    }
}
