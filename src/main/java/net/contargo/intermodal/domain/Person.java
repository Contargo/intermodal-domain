package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;


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
    private Location location;

    /**
     * Country code with 2 characters (UN/LOCODE).
     */
    private Country country;

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


    @JsonIgnore
    public String getDateOfBirth() {

        return dateOfBirth;
    }


    @JsonIgnore
    public String getCityOfBirth() {

        return location.getCity();
    }


    @JsonIgnore
    public String getCountryCode() {

        return country.getCode();
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

        Location location = new Location();
        location.setCity(locationCity);
        this.location = location;
    }


    /**
     * @param  countryCode  2 characters (UN/LOCODE).
     */
    void setCountryCode(String countryCode) {

        Country country = new Country();
        country.setCode(countryCode);

        this.country = country;
    }


    public Location getLocation() {

        return location;
    }


    public Country getCountry() {

        return country;
    }
}
