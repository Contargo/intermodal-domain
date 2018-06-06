package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Address;
import net.contargo.intermodal.domain.Skipper;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class SkipperTest {

    @Test
    void ensureSkipperCanBeCreated() {

        Address address = Address.Builder.newAddress()
                .withCountryCode("DE")
                .withCountryName("Germany")
                .withLocationCity("Karlsruhe")
                .withLocationPostalCode("76131")
                .withStreet("Hauptstraße 42")
                .buildAndValidate();

        Skipper skipper = Skipper.Builder.newSkipper()
                .withName("Mustermann")
                .withFirstName("Max")
                .withAddress(address)
                .withCellphone("01234/56789")
                .bornOn(1980, 1, 13)
                .bornIn("Karlsruhe")
                .withCountryCode("DE")
                .withAdnr(2018, 12, 31)
                .buildAndValidate();

        assertEquals("Mustermann", skipper.getName());
        assertEquals("Max", skipper.getFirstName());
        assertNotNull(skipper.getAddress());
        assertEquals("01234/56789", skipper.getCellphone());
        assertEquals("1980-01-13T00:00:00", skipper.getDateOfBirth());
        assertEquals("Karlsruhe", skipper.getCityOfBirth());
        assertEquals("DE", skipper.getCountryCode());
        assertEquals("2018-12-31T00:00:00", skipper.getAdnr());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        Address address = Address.Builder.newAddress()
                .withCountryCode("DE")
                .withCountryName("Germany")
                .withLocationCity("Karlsruhe")
                .withLocationPostalCode("76131")
                .withStreet("Hauptstraße 42")
                .buildAndValidate();

        Skipper skipper = Skipper.Builder.newSkipper()
                .withName("Mustermann")
                .withFirstName("Max")
                .withAddress(address)
                .withCellphone("01234/56789")
                .bornOn(1980, 1, 13)
                .bornIn("Karlsruhe")
                .withCountryCode("DE")
                .withAdnr(2018, 12, 31)
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(skipper);

        Skipper deserialize = mapper.readValue(jsonString, Skipper.class);

        assertEquals("Mustermann", deserialize.getName());
        assertEquals("Max", deserialize.getFirstName());
        assertNotNull(deserialize.getAddress());
        assertEquals("01234/56789", deserialize.getCellphone());
        assertEquals("1980-01-13T00:00:00", deserialize.getDateOfBirth());
        assertEquals("Karlsruhe", deserialize.getCityOfBirth());
        assertEquals("DE", deserialize.getCountryCode());
        assertEquals("2018-12-31T00:00:00", deserialize.getAdnr());
    }
}
