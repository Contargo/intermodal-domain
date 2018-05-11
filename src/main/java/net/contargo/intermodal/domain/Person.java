package net.contargo.intermodal.domain;

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
     * @definition_english  City of birth
     * @definition_german  Geburtsort
     */
    private String locationCity;

    /**
     * 2 characters (UN/LOCODE).
     */
    private String countryCode;

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


    void setName(String name) {

        this.name = name;
    }


    void setFirstName(String firstName) {

        this.firstName = firstName;
    }


    void setAddress(Address address) {

        this.address = address;
    }


    void setCellphone(String cellphone) {

        this.cellphone = cellphone;
    }


    void setDateOfBirth(String dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
    }


    void setLocationCity(String locationCity) {

        this.locationCity = locationCity;
    }


    void setCountryCode(String countryCode) {

        this.countryCode = countryCode;
    }
}
