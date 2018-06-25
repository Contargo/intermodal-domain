package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Address;
import net.contargo.intermodal.domain.Passenger;

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
                .named("Max", "Mustermann")
                .withAddress(new Address())
                .withCellphoneNumber("01234/56789")
                .bornOn(Instant.parse("1980-01-13T00:00:00Z"))
                .bornIn("Karlsruhe")
                .withNationality("DE")
                .buildAndValidate();

        assertEquals("Mustermann", passenger.getLastName());
        assertEquals("Max", passenger.getFirstName());
        assertNotNull(passenger.getAddress());
        assertEquals("01234/56789", passenger.getCellphone());
        assertEquals("1980-01-13T00:00:00Z", passenger.getDateOfBirth().toString());
        assertEquals("Karlsruhe", passenger.getCityOfBirth());
        assertEquals("DE", passenger.getNationality());
    }


    @Test
    void ensureCanBeCopied() {

        Passenger passenger = Passenger.newBuilder()
                .named("Max", "Mustermann")
                .withAddress(new Address())
                .withCellphoneNumber("01234/56789")
                .bornOn(Instant.parse("1980-01-13T00:00:00Z"))
                .bornIn("Karlsruhe")
                .withNationality("DE")
                .buildAndValidate();

        Passenger copiedPassenger = Passenger.newBuilder(passenger).buildAndValidate();

        assertEquals("Mustermann", copiedPassenger.getLastName());
        assertEquals("Max", copiedPassenger.getFirstName());
        assertNotNull(copiedPassenger.getAddress());
        assertEquals("01234/56789", copiedPassenger.getCellphone());
        assertEquals("1980-01-13T00:00:00Z", copiedPassenger.getDateOfBirth().toString());
        assertEquals("Karlsruhe", copiedPassenger.getCityOfBirth());
        assertEquals("DE", copiedPassenger.getNationality());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        Passenger passenger = Passenger.newBuilder()
                .named("Max", "Mustermann")
                .withAddress(new Address())
                .withCellphoneNumber("01234/56789")
                .bornOn(Instant.parse("1980-01-13T00:00:00Z"))
                .bornIn("Karlsruhe")
                .withNationality("DE")
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(passenger);

        Passenger deserialize = mapper.readValue(jsonString, Passenger.class);

        assertEquals("Mustermann", deserialize.getLastName());
        assertEquals("Max", deserialize.getFirstName());
        assertNotNull(deserialize.getAddress());
        assertEquals("01234/56789", deserialize.getCellphone());
        assertEquals("1980-01-13T00:00:00Z", deserialize.getDateOfBirth().toString());
        assertEquals("Karlsruhe", deserialize.getCityOfBirth());
        assertEquals("DE", deserialize.getNationality());
    }
}