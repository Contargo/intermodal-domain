package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Address;
import net.contargo.intermodal.domain.TrainDriver;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class TrainDriverTest {

    @Test
    void ensureTrainDriverCanBeCreated() {

        Address address = Address.Builder.newAddress()
                .withCountryCode("DE")
                .withCountryName("Germany")
                .withLocationCity("Karlsruhe")
                .withLocationPostalCode("76131")
                .withStreet("Hauptstraße 42")
                .buildAndValidate();

        TrainDriver trainDriver = TrainDriver.Builder.newTrainDriver()
                .withName("Mustermann")
                .withFirstName("Max")
                .withAddress(address)
                .withCellphone("01234/56789")
                .bornOn(Instant.parse("1980-01-13T00:00:00Z"))
                .bornIn("Karlsruhe")
                .withCountryCode("DE")
                .withRid(Instant.parse("2018-12-31T00:00:00Z"))
                .buildAndValidate();

        assertEquals("Mustermann", trainDriver.getName());
        assertEquals("Max", trainDriver.getFirstName());
        assertNotNull(trainDriver.getAddress());
        assertEquals("01234/56789", trainDriver.getCellphone());
        assertEquals("1980-01-13T00:00:00Z", trainDriver.getDateOfBirth().toString());
        assertEquals("Karlsruhe", trainDriver.getCityOfBirth());
        assertEquals("DE", trainDriver.getCountryCode());
        assertEquals("2018-12-31T00:00:00Z", trainDriver.getRid().toString());
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

        TrainDriver trainDriver = TrainDriver.Builder.newTrainDriver()
                .withName("Mustermann")
                .withFirstName("Max")
                .withAddress(address)
                .withCellphone("01234/56789")
                .bornOn(Instant.parse("1980-01-13T00:00:00Z"))
                .bornIn("Karlsruhe")
                .withCountryCode("DE")
                .withRid(Instant.parse("2018-12-31T00:00:00Z"))
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(trainDriver);

        TrainDriver deserialize = mapper.readValue(jsonString, TrainDriver.class);

        assertEquals("Mustermann", deserialize.getName());
        assertEquals("Max", deserialize.getFirstName());
        assertNotNull(deserialize.getAddress());
        assertEquals("01234/56789", deserialize.getCellphone());
        assertEquals("1980-01-13T00:00:00Z", deserialize.getDateOfBirth().toString());
        assertEquals("Karlsruhe", deserialize.getCityOfBirth());
        assertEquals("DE", deserialize.getCountryCode());
        assertEquals("2018-12-31T00:00:00Z", deserialize.getRid().toString());
    }
}
