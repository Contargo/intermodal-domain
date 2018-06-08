package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Address;
import net.contargo.intermodal.domain.Driver;

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

        Address address = Address.newBuilder()
                .withCountryCode("DE")
                .withCountryName("Germany")
                .withLocationCity("Karlsruhe")
                .withLocationPostalCode("76131")
                .withStreet("Hauptstraße 42")
                .buildAndValidate();

        Driver driver = Driver.newBuilder()
                .withName("Mustermann")
                .withFirstName("Max")
                .withAddress(address)
                .withCellphone("01234/56789")
                .bornOn(Instant.parse("1980-01-13T00:00:00Z"))
                .bornIn("Karlsruhe")
                .withCountryCode("DE")
                .withLicenseValidity(Instant.parse("2020-09-25T00:00:00Z"))
                .withLicenseNumber("12345678")
                .withId("42")
                .withAdr(Instant.parse("2018-12-31T00:00:00Z"))
                .withModuleEntry95(Instant.parse("2018-12-31T00:00:00Z"))
                .buildAndValidate();

        assertEquals("Mustermann", driver.getName());
        assertEquals("Max", driver.getFirstName());
        assertNotNull(driver.getAddress());
        assertEquals("01234/56789", driver.getCellphone());
        assertEquals("1980-01-13T00:00:00Z", driver.getDateOfBirth().toString());
        assertEquals("Karlsruhe", driver.getCityOfBirth());
        assertEquals("DE", driver.getCountryCode());
        assertEquals("12345678", driver.getLicense().getNumber());
        assertEquals("2020-09-25T00:00:00Z", driver.getLicense().getValidity().toString());
        assertEquals("42", driver.getId());
        assertEquals("2018-12-31T00:00:00Z", driver.getAdr().toString());
        assertEquals("2018-12-31T00:00:00Z", driver.getModuleEntry95().toString());
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

        Driver driver = Driver.newBuilder()
                .withName("Mustermann")
                .withFirstName("Max")
                .withAddress(address)
                .withCellphone("01234/56789")
                .bornOn(Instant.parse("1980-01-13T00:00:00Z"))
                .bornIn("Karlsruhe")
                .withCountryCode("DE")
                .withLicenseValidity(Instant.parse("2020-09-25T00:00:00Z"))
                .withLicenseNumber("12345678")
                .withId("42")
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
        assertEquals("1980-01-13T00:00:00Z", deserialize.getDateOfBirth().toString());
        assertEquals("Karlsruhe", deserialize.getCityOfBirth());
        assertEquals("DE", deserialize.getCountryCode());
        assertEquals("12345678", deserialize.getLicense().getNumber());
        assertEquals("2020-09-25T00:00:00Z", deserialize.getLicense().getValidity().toString());
        assertEquals("42", deserialize.getId());
        assertEquals("2018-12-31T00:00:00Z", deserialize.getAdr().toString());
        assertEquals("2018-12-31T00:00:00Z", deserialize.getModuleEntry95().toString());
    }
}
