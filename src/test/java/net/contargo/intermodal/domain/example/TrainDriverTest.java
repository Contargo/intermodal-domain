package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Address;
import net.contargo.intermodal.domain.TrainDriver;

import org.junit.jupiter.api.Test;

import java.io.IOException;

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
                .bornOn(1980, 1, 13)
                .bornIn("Karlsruhe")
                .withCountryCode("DE")
                .withRid(2018, 12, 31)
                .buildAndValidate();

        assertEquals("Mustermann", trainDriver.getName());
        assertEquals("Max", trainDriver.getFirstName());
        assertNotNull(trainDriver.getAddress());
        assertEquals("01234/56789", trainDriver.getCellphone());
        assertEquals("1980-01-13T00:00:00", trainDriver.getDateOfBirth());
        assertEquals("Karlsruhe", trainDriver.getCityOfBirth());
        assertEquals("DE", trainDriver.getCountryCode());
        assertEquals("2018-12-31T00:00:00", trainDriver.getRid());
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
                .bornOn(1980, 1, 13)
                .bornIn("Karlsruhe")
                .withCountryCode("DE")
                .withRid(2018, 12, 31)
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(trainDriver);

        TrainDriver deserialize = mapper.readValue(jsonString, TrainDriver.class);

        assertEquals("Mustermann", deserialize.getName());
        assertEquals("Max", deserialize.getFirstName());
        assertNotNull(deserialize.getAddress());
        assertEquals("01234/56789", deserialize.getCellphone());
        assertEquals("1980-01-13T00:00:00", deserialize.getDateOfBirth());
        assertEquals("Karlsruhe", deserialize.getCityOfBirth());
        assertEquals("DE", deserialize.getCountryCode());
        assertEquals("2018-12-31T00:00:00", deserialize.getRid());
    }
}
