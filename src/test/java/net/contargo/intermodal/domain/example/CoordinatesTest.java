package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Coordinates;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class CoordinatesTest {

    @Test
    void ensureCanBeCreated() {

        Coordinates coordinates = Coordinates.newBuilder()
                .withLatitude(49.0594626)
                .withLongitude(8.2966241)
                .buildAndValidate();

        assertEquals(49.0594626, coordinates.getLatitude().doubleValue());
        assertEquals(8.2966241, coordinates.getLongitude().doubleValue());
    }


    @Test
    void ensureCanBeCreatedWithMinimumRequirements() {

        Coordinates.newBuilder().withLatitude(49.0594626).withLongitude(8.2966241).buildAndValidate();
    }


    @Test
    void ensureCanBeCopied() {

        Coordinates coordinates = Coordinates.newBuilder()
                .withLatitude(49.0594626)
                .withLongitude(8.2966241)
                .buildAndValidate();

        Coordinates copiedCoordinates = Coordinates.newBuilder(coordinates).buildAndValidate();

        assertEquals(49.0594626, copiedCoordinates.getLatitude().doubleValue());
        assertEquals(8.2966241, copiedCoordinates.getLongitude().doubleValue());
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class,
            () -> Coordinates.newBuilder().withLongitude(8.2966241).buildAndValidate());

        assertThrows(IllegalStateException.class,
            () -> Coordinates.newBuilder().withLatitude(49.0594626).buildAndValidate());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        Coordinates coordinates = Coordinates.newBuilder()
                .withLatitude(49.0594626)
                .withLongitude(8.2966241)
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(coordinates);

        Coordinates deserialize = mapper.readValue(jsonString, Coordinates.class);

        assertEquals(49.0594626, deserialize.getLatitude().doubleValue());
        assertEquals(8.2966241, deserialize.getLongitude().doubleValue());
    }
}
