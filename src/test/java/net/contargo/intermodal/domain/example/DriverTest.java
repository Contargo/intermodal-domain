package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Address;
import net.contargo.intermodal.domain.Driver;
import net.contargo.intermodal.domain.Location;
import net.contargo.intermodal.domain.TestDataCreator;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class DriverTest {

    @Test
    void ensureDriverCanBeCreated() {

        Address address = TestDataCreator.createAddress();

        Driver driver = Driver.newBuilder()
                .named("Max", "Mustermann")
                .withAddress(address)
                .withCellphoneNumber("01234/56789")
                .bornOn("1980-01-13")
                .bornIn(Location.newBuilder().withCity("Karlsruhe").buildAndValidate())
                .withNationality("DE")
                .withLicense("12345678", Instant.parse("2020-09-25T00:00:00Z"))
                .withDriverCardNumber("42")
                .withAdr(Instant.parse("2018-12-31T00:00:00Z"))
                .withModuleEntry95(Instant.parse("2018-12-31T00:00:00Z"))
                .buildAndValidate();

        assertEquals("Mustermann", driver.getName());
        assertEquals("Max", driver.getFirstName());
        assertNotNull(driver.getAddress());
        assertEquals("01234/56789", driver.getCellphone());
        assertEquals("1980-01-13", driver.getDateOfBirth().toString());
        assertEquals("Karlsruhe", driver.getCityOfBirth().getCity());
        assertEquals("DE", driver.getNationality());
        assertEquals("12345678", driver.getLicense().getNumber());
        assertEquals("2020-09-25T00:00:00Z", driver.getLicense().getValidity().toString());
        assertEquals("42", driver.getDriverCardNumber());
        assertEquals("2018-12-31T00:00:00Z", driver.getAdr().toString());
        assertEquals("2018-12-31T00:00:00Z", driver.getModuleEntry95().toString());
    }


    @Test
    void ensureCanBeCopied() {

        Driver driver = Driver.newBuilder()
                .named("Max", "Mustermann")
                .withAddress(TestDataCreator.createAddress())
                .withCellphoneNumber("01234/56789")
                .bornOn("1980-01-13")
                .bornIn(Location.newBuilder().withCity("Karlsruhe").buildAndValidate())
                .withNationality("DE")
                .withLicense("12345678", Instant.parse("2020-09-25T00:00:00Z"))
                .withDriverCardNumber("42")
                .withAdr(Instant.parse("2018-12-31T00:00:00Z"))
                .withModuleEntry95(Instant.parse("2018-12-31T00:00:00Z"))
                .buildAndValidate();

        Driver copiedDriver = Driver.newBuilder(driver).buildAndValidate();

        assertEquals("Mustermann", copiedDriver.getName());
        assertEquals("Max", copiedDriver.getFirstName());
        assertNotNull(copiedDriver.getAddress());
        assertEquals("01234/56789", copiedDriver.getCellphone());
        assertEquals("1980-01-13", copiedDriver.getDateOfBirth().toString());
        assertEquals("Karlsruhe", copiedDriver.getCityOfBirth().getCity());
        assertEquals("DE", copiedDriver.getNationality());
        assertEquals("12345678", copiedDriver.getLicense().getNumber());
        assertEquals("2020-09-25T00:00:00Z", copiedDriver.getLicense().getValidity().toString());
        assertEquals("42", copiedDriver.getDriverCardNumber());
        assertEquals("2018-12-31T00:00:00Z", copiedDriver.getAdr().toString());
        assertEquals("2018-12-31T00:00:00Z", copiedDriver.getModuleEntry95().toString());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        Address address = TestDataCreator.createAddress();

        Driver driver = Driver.newBuilder()
                .named("Max", "Mustermann")
                .withAddress(address)
                .withCellphoneNumber("01234/56789")
                .bornOn("1980-01-13")
                .bornIn(Location.newBuilder().withCity("Karlsruhe").buildAndValidate())
                .withNationality("DE")
                .withLicense("12345678", Instant.parse("2020-09-25T00:00:00Z"))
                .withDriverCardNumber("42")
                .withAdr(Instant.parse("2018-12-31T00:00:00Z"))
                .withModuleEntry95(Instant.parse("2018-12-31T00:00:00Z"))
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(driver);

        Driver deserialize = mapper.readValue(jsonString, Driver.class);

        assertEquals("Mustermann", deserialize.getName());
        assertEquals("Max", deserialize.getFirstName());
        assertNotNull(deserialize.getAddress());
        assertEquals("01234/56789", deserialize.getCellphone());
        assertEquals("1980-01-13", deserialize.getDateOfBirth().toString());
        assertEquals("Karlsruhe", deserialize.getCityOfBirth().getCity());
        assertEquals("DE", deserialize.getNationality());
        assertEquals("12345678", deserialize.getLicense().getNumber());
        assertEquals("2020-09-25T00:00:00Z", deserialize.getLicense().getValidity().toString());
        assertEquals("42", deserialize.getDriverCardNumber());
        assertEquals("2018-12-31T00:00:00Z", deserialize.getAdr().toString());
        assertEquals("2018-12-31T00:00:00Z", deserialize.getModuleEntry95().toString());
    }
}
