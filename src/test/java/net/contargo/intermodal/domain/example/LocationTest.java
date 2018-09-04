package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Location;
import net.contargo.intermodal.domain.TestDataCreator;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class LocationTest {

    @Test
    void ensureCanBeCreated() {

        Location location = Location.newBuilder()
                .withCity("Wörth")
                .withType("Terminal")
                .withPostalCode("76744")
                .withCoordinates(TestDataCreator.createCoordinates())
                .withDesignation("Terminal Wörth")
                .buildAndValidate();

        assertEquals("Terminal", location.getType());
        assertEquals("76744", location.getPostalCode());
        assertEquals("Wörth", location.getCity());
        assertEquals("Terminal Wörth", location.getDesignation());
        assertEquals(49.0594626, location.getCoordinates().getLatitude().doubleValue());
        assertEquals(8.2966241, location.getCoordinates().getLongitude().doubleValue());
    }


    @Test
    void ensureCanBeCopied() {

        Location location = Location.newBuilder()
                .withCity("Wörth")
                .withType("Terminal")
                .withPostalCode("76744")
                .withCoordinates(TestDataCreator.createCoordinates())
                .withDesignation("Terminal Wörth")
                .buildAndValidate();

        Location copiedLocation = Location.newBuilder(location).buildAndValidate();

        assertEquals("Terminal", copiedLocation.getType());
        assertEquals("76744", copiedLocation.getPostalCode());
        assertEquals("Wörth", copiedLocation.getCity());
        assertEquals("Terminal Wörth", copiedLocation.getDesignation());
        assertEquals(49.0594626, copiedLocation.getCoordinates().getLatitude().doubleValue());
        assertEquals(8.2966241, copiedLocation.getCoordinates().getLongitude().doubleValue());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        Location location = Location.newBuilder()
                .withCity("Wörth")
                .withType("Terminal")
                .withPostalCode("76744")
                .withCoordinates(TestDataCreator.createCoordinates())
                .withDesignation("Terminal Wörth")
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(location);

        Location deserialize = mapper.readValue(jsonString, Location.class);

        assertEquals("Terminal", deserialize.getType());
        assertEquals("76744", deserialize.getPostalCode());
        assertEquals("Wörth", deserialize.getCity());
        assertEquals("Terminal Wörth", deserialize.getDesignation());
        assertEquals(49.0594626, deserialize.getCoordinates().getLatitude().doubleValue());
        assertEquals(8.2966241, deserialize.getCoordinates().getLongitude().doubleValue());
    }
}
