package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.Address;
import net.contargo.intermodal.domain.person.Driver;
import net.contargo.intermodal.domain.person.Person;
import net.contargo.intermodal.domain.person.Skipper;
import net.contargo.intermodal.domain.person.TrainDriver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class PersonTest {

    @Test
    void ensureDriverCanBeCreated() {

        Address address = new Address().withStreet("Gartenstraße 67")
                .withLocationPostalCode("76135")
                .withLocationCity("Karlsruhe")
                .withCountryCode("DE");

        Person person = new Driver().withName("Max", "Mustermann")
                .withAddress(address)
                .withCellphone("12345678")
                .withDateOfBirth(1980, 1, 13)
                .withCityOfBirth("Karlsruhe")
                .withCountryCode("DE")
                .withLicenseValidity(2020, 9, 25)
                .withLicenseNumber("12345678")
                .withId("42")
                .withAdr(2018, 12, 31)
                .withModuleEntry95(2018, 12, 31);

        Driver driver = (Driver) person;

        Assertions.assertEquals("Mustermann", driver.getName());
        Assertions.assertEquals("Max", driver.getFirstName());
        Assertions.assertNotNull(driver.getAddress());
        Assertions.assertEquals("12345678", driver.getCellphone());
        Assertions.assertEquals("1980-01-13T00:00:00.000Z", driver.getDateOfBirth());
        Assertions.assertEquals("Karlsruhe", driver.getLocationCity());
        Assertions.assertEquals("DE", driver.getCountryCode());
        Assertions.assertEquals("12345678", driver.getLicenseNumber());
        Assertions.assertEquals("12345678", driver.getCellphone());
        Assertions.assertEquals("42", driver.getId());
        Assertions.assertEquals("2018-12-31T00:00:00.000Z", driver.getAdr());
        Assertions.assertEquals("2018-12-31T00:00:00.000Z", driver.getModuleEntry95());
    }


    @Test
    void ensureTrainDriverCanBeCreated() {

        Address address = new Address().withStreet("Gartenstraße 67")
                .withLocationPostalCode("76135")
                .withLocationCity("Karlsruhe")
                .withCountryCode("DE");

        Person person = new TrainDriver().withName("Max", "Mustermann")
                .withAddress(address)
                .withCellphone("12345678")
                .withDateOfBirth(1980, 1, 13)
                .withCityOfBirth("Karlsruhe")
                .withCountryCode("DE")
                .withRid(2018, 12, 31);

        TrainDriver trainDriver = (TrainDriver) person;

        Assertions.assertEquals("Mustermann", trainDriver.getName());
        Assertions.assertEquals("Max", trainDriver.getFirstName());
        Assertions.assertNotNull(trainDriver.getAddress());
        Assertions.assertEquals("12345678", trainDriver.getCellphone());
        Assertions.assertEquals("1980-01-13T00:00:00.000Z", trainDriver.getDateOfBirth());
        Assertions.assertEquals("Karlsruhe", trainDriver.getLocationCity());
        Assertions.assertEquals("DE", trainDriver.getCountryCode());
        Assertions.assertEquals("2018-12-31T00:00:00.000Z", trainDriver.getRid());
    }


    @Test
    void ensureSkipperCanBeCreated() {

        Address address = new Address().withStreet("Gartenstraße 67")
                .withLocationPostalCode("76135")
                .withLocationCity("Karlsruhe")
                .withCountryCode("DE");

        Person person = new Skipper().withName("Max", "Mustermann")
                .withAddress(address)
                .withCellphone("12345678")
                .withDateOfBirth(1980, 1, 13)
                .withCityOfBirth("Karlsruhe")
                .withCountryCode("DE")
                .withAdnr(2018, 12, 31);

        Skipper skipper = (Skipper) person;

        Assertions.assertEquals("Mustermann", skipper.getName());
        Assertions.assertEquals("Max", skipper.getFirstName());
        Assertions.assertNotNull(skipper.getAddress());
        Assertions.assertEquals("12345678", skipper.getCellphone());
        Assertions.assertEquals("1980-01-13T00:00:00.000Z", skipper.getDateOfBirth());
        Assertions.assertEquals("Karlsruhe", skipper.getLocationCity());
        Assertions.assertEquals("DE", skipper.getCountryCode());
        Assertions.assertEquals("2018-12-31T00:00:00.000Z", skipper.getAdnr());
    }
}
