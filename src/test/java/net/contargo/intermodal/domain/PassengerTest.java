package net.contargo.intermodal.domain;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class PassengerTest {

    @Test
    void ensureCanBeCreated() {

        Passenger passenger = Passenger.newBuilder()
                .withName("Mustermann")
                .withFirstName("Max")
                .withAddress(new Address())
                .withCellphone("01234/56789")
                .withDateOfBirth(Instant.parse("1980-01-13T00:00:00Z"))
                .withLocation("Karlsruhe")
                .withCountryCode("DE")
                .buildAndValidate();

        assertEquals("Mustermann", passenger.getName());
        assertEquals("Max", passenger.getFirstName());
        assertNotNull(passenger.getAddress());
        assertEquals("01234/56789", passenger.getCellphone());
        assertEquals("1980-01-13T00:00:00Z", passenger.getDateOfBirth().toString());
        assertEquals("Karlsruhe", passenger.getCityOfBirth());
        assertEquals("DE", passenger.getCountryCode());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        Passenger passenger = Passenger.newBuilder()
                .withName("Mustermann")
                .withFirstName("Max")
                .withAddress(new Address())
                .withCellphone("01234/56789")
                .withDateOfBirth(Instant.parse("1980-01-13T00:00:00Z"))
                .withLocation("Karlsruhe")
                .withCountryCode("DE")
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(passenger);

        Passenger deserialize = mapper.readValue(jsonString, Passenger.class);

        assertEquals("Mustermann", deserialize.getName());
        assertEquals("Max", deserialize.getFirstName());
        assertNotNull(deserialize.getAddress());
        assertEquals("01234/56789", deserialize.getCellphone());
        assertEquals("1980-01-13T00:00:00Z", deserialize.getDateOfBirth().toString());
        assertEquals("Karlsruhe", deserialize.getCityOfBirth());
        assertEquals("DE", deserialize.getCountryCode());
    }
}
