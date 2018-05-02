package net.contargo.intermodal.domain.person;

import net.contargo.intermodal.domain.Address;
import net.contargo.intermodal.domain.utility.ISO8601DateFormatter;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Person
 * @name_english  person
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public abstract class Person {

    private String name;

    private String firstName;

    private Address address;

    private String cellphone;

    /**
     * format: ISO 8601 yyyy-mm-dd e.g. 1994-02-25
     */
    private String dateOfBirth;

    /**
     * City of birth.
     */
    private String locationCity;

    /**
     * 2 characters (UN/LOCODE).
     */
    private String countryCode;

    Person withName(String firstName, String lastName) {

        this.name = lastName;
        this.firstName = firstName;

        return this;
    }


    Person withAddress(Address address) {

        this.address = address;

        return this;
    }


    Person withCellphone(String cellphone) {

        this.cellphone = cellphone;

        return this;
    }


    Person withDateOfBirth(int year, int month, int day) {

        this.dateOfBirth = ISO8601DateFormatter.format(year, month, day);

        return this;
    }


    Person withCityOfBirth(String locationCity) {

        this.locationCity = locationCity;

        return this;
    }


    Person withCountryCode(String countryCode) {

        this.countryCode = countryCode;

        return this;
    }


    public String getName() {

        return name;
    }


    public String getFirstName() {

        return firstName;
    }


    public Address getAddress() {

        return address;
    }


    public String getCellphone() {

        return cellphone;
    }


    public String getDateOfBirth() {

        return dateOfBirth;
    }


    public String getLocationCity() {

        return locationCity;
    }


    public String getCountryCode() {

        return countryCode;
    }
}
