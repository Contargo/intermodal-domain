package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Address;
import net.contargo.intermodal.domain.Skipper;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class SkipperTest {

    @Test
    void ensureSkipperCanBeCreated() {

        Address address = Address.newBuilder()
                .withCountryCode("DE")
                .withCountryName("Germany")
                .withLocationCity("Karlsruhe")
                .withLocationPostalCode("76131")
                .withStreet("Hauptstraße 42")
                .buildAndValidate();

        Skipper skipper = Skipper.newBuilder()
                .named("Max", "Mustermann")
                .withAddress(address)
                .withCellphoneNumber("01234/56789")
                .bornOn("1980-01-13")
                .bornIn("Karlsruhe")
                .withNationality("DE")
                .withAdnr(Instant.parse("2018-12-31T00:00:00Z"))
                .buildAndValidate();

        assertEquals("Mustermann", skipper.getName());
        assertEquals("Max", skipper.getFirstName());
        assertNotNull(skipper.getAddress());
        assertEquals("01234/56789", skipper.getCellphone());
        assertEquals("1980-01-13", skipper.getDateOfBirth().toString());
        assertEquals("Karlsruhe", skipper.getCityOfBirth());
        assertEquals("DE", skipper.getNationality());
        assertEquals("2018-12-31T00:00:00Z", skipper.getAdnr().toString());
    }


    @Test
    void ensureCanBeCopied() {

        Skipper skipper = Skipper.newBuilder()
                .named("Max", "Mustermann")
                .withAddress(new Address())
                .withCellphoneNumber("01234/56789")
                .bornOn("1980-01-13")
                .bornIn("Karlsruhe")
                .withNationality("DE")
                .withAdnr(Instant.parse("2018-12-31T00:00:00Z"))
                .buildAndValidate();

        Skipper copiedSkipper = Skipper.newBuilder(skipper).buildAndValidate();

        assertEquals("Mustermann", copiedSkipper.getName());
        assertEquals("Max", copiedSkipper.getFirstName());
        assertNotNull(copiedSkipper.getAddress());
        assertEquals("01234/56789", copiedSkipper.getCellphone());
        assertEquals("1980-01-13", copiedSkipper.getDateOfBirth().toString());
        assertEquals("Karlsruhe", copiedSkipper.getCityOfBirth());
        assertEquals("DE", copiedSkipper.getNationality());
        assertEquals("2018-12-31T00:00:00Z", copiedSkipper.getAdnr().toString());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        Address address = Address.newBuilder()
                .withCountryCode("DE")
                .withCountryName("Germany")
                .withLocationCity("Karlsruhe")
                .withLocationPostalCode("76131")
                .withStreet("Hauptstraße 42")
                .buildAndValidate();

        Skipper skipper = Skipper.newBuilder()
                .named("Max", "Mustermann")
                .withAddress(address)
                .withCellphoneNumber("01234/56789")
                .bornOn("1980-01-13")
                .bornIn("Karlsruhe")
                .withNationality("DE")
                .withAdnr(Instant.parse("2018-12-31T00:00:00Z"))
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(skipper);

        Skipper deserialize = mapper.readValue(jsonString, Skipper.class);

        assertEquals("Mustermann", deserialize.getName());
        assertEquals("Max", deserialize.getFirstName());
        assertNotNull(deserialize.getAddress());
        assertEquals("01234/56789", deserialize.getCellphone());
        assertEquals("1980-01-13", deserialize.getDateOfBirth().toString());
        assertEquals("Karlsruhe", deserialize.getCityOfBirth());
        assertEquals("DE", deserialize.getNationality());
        assertEquals("2018-12-31T00:00:00Z", deserialize.getAdnr().toString());
    }
}
