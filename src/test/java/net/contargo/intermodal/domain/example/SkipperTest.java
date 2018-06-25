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
                .withName("Mustermann")
                .withFirstName("Max")
                .withAddress(address)
                .withCellphone("01234/56789")
                .bornOn(Instant.parse("1980-01-13T00:00:00Z"))
                .bornIn("Karlsruhe")
                .withCountryCode("DE")
                .withAdnr(Instant.parse("2018-12-31T00:00:00Z"))
                .buildAndValidate();

        assertEquals("Mustermann", skipper.getName());
        assertEquals("Max", skipper.getFirstName());
        assertNotNull(skipper.getAddress());
        assertEquals("01234/56789", skipper.getCellphone());
        assertEquals("1980-01-13T00:00:00Z", skipper.getDateOfBirth().toString());
        assertEquals("Karlsruhe", skipper.getCityOfBirth());
        assertEquals("DE", skipper.getCountryCode());
        assertEquals("2018-12-31T00:00:00Z", skipper.getAdnr().toString());
    }


    @Test
    void ensureCanBeCopied() {

        Skipper skipper = Skipper.newBuilder()
                .withName("Mustermann")
                .withFirstName("Max")
                .withAddress(new Address())
                .withCellphone("01234/56789")
                .bornOn(Instant.parse("1980-01-13T00:00:00Z"))
                .bornIn("Karlsruhe")
                .withCountryCode("DE")
                .withAdnr(Instant.parse("2018-12-31T00:00:00Z"))
                .buildAndValidate();

        Skipper copiedSkipper = Skipper.newBuilder(skipper).buildAndValidate();

        assertEquals("Mustermann", copiedSkipper.getName());
        assertEquals("Max", copiedSkipper.getFirstName());
        assertNotNull(copiedSkipper.getAddress());
        assertEquals("01234/56789", copiedSkipper.getCellphone());
        assertEquals("1980-01-13T00:00:00Z", copiedSkipper.getDateOfBirth().toString());
        assertEquals("Karlsruhe", copiedSkipper.getCityOfBirth());
        assertEquals("DE", copiedSkipper.getCountryCode());
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
                .withName("Mustermann")
                .withFirstName("Max")
                .withAddress(address)
                .withCellphone("01234/56789")
                .bornOn(Instant.parse("1980-01-13T00:00:00Z"))
                .bornIn("Karlsruhe")
                .withCountryCode("DE")
                .withAdnr(Instant.parse("2018-12-31T00:00:00Z"))
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(skipper);

        Skipper deserialize = mapper.readValue(jsonString, Skipper.class);

        assertEquals("Mustermann", deserialize.getName());
        assertEquals("Max", deserialize.getFirstName());
        assertNotNull(deserialize.getAddress());
        assertEquals("01234/56789", deserialize.getCellphone());
        assertEquals("1980-01-13T00:00:00Z", deserialize.getDateOfBirth().toString());
        assertEquals("Karlsruhe", deserialize.getCityOfBirth());
        assertEquals("DE", deserialize.getCountryCode());
        assertEquals("2018-12-31T00:00:00Z", deserialize.getAdnr().toString());
    }
}
