package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.Address;
import net.contargo.intermodal.domain.Driver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class DriverTest {

    @Test
    void ensureDriverCanBeCreated() {

        Address address = Address.Builder.newAddress()
                .withCountryCode("DE")
                .withCountryName("Germany")
                .withLocationCity("Karlsruhe")
                .withLocationPostalCode("76131")
                .withStreet("Hauptstraße 42")
                .buildAndValidate();

        Driver driver = Driver.Builder.newDriver()
                .withName("Mustermann")
                .withFirstName("Max")
                .withAddress(address)
                .withCellphone("01234/56789")
                .bornOn(1980, 1, 13)
                .bornIn("Karlsruhe")
                .withCountryCode("DE")
                .withLicenseValidity(2020, 9, 25)
                .withLicenseNumber("12345678")
                .withId("42")
                .withAdr(2018, 12, 31)
                .withModuleEntry95(2018, 12, 31)
                .buildAndValidate();

        assertEquals("Mustermann", driver.getName());
        assertEquals("Max", driver.getFirstName());
        assertNotNull(driver.getAddress());
        assertEquals("01234/56789", driver.getCellphone());
        assertEquals("1980-01-13T00:00:00", driver.getDateOfBirth());
        assertEquals("Karlsruhe", driver.getCityOfBirth());
        assertEquals("DE", driver.getCountryCode());
        assertEquals("12345678", driver.getLicense().getLicenseNumber());
        assertEquals("42", driver.getId());
        assertEquals("2018-12-31T00:00:00", driver.getAdr());
        assertEquals("2018-12-31T00:00:00", driver.getModuleEntry95());
    }
}