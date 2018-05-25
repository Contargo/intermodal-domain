package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class PersonTest {

    @Test
    void ensureDriverCanBeCreated() {

        Driver driver = Driver.Builder.newDriver()
                .withName("Mustermann")
                .withFirstName("Max")
                .withAddress(new Address())
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


    @Test
    void ensureTrainDriverCanBeCreated() {

        TrainDriver trainDriver = TrainDriver.Builder.newTrainDriver()
                .withName("Mustermann")
                .withFirstName("Max")
                .withAddress(new Address())
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
    void ensureSkipperCanBeCreated() {

        Skipper skipper = Skipper.Builder.newSkipper()
                .withName("Mustermann")
                .withFirstName("Max")
                .withAddress(new Address())
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
}
