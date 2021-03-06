package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Person
 * @name_english  person
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(
    {
        @JsonSubTypes.Type(value = Driver.class, name = "driver"),
        @JsonSubTypes.Type(value = TrainDriver.class, name = "trainDriver"),
        @JsonSubTypes.Type(value = Skipper.class, name = "skipper")
    }
)
public abstract class Person {

    private String name;

    private String firstName;

    private Address address;

    private String cellphone;

    /**
     * format: ISO 8601 yyyy-mm-dd e.g. 1994-02-25
     */
    @JsonDeserialize(using = LocalDataJsonDeserializer.class)
    private LocalDate dateOfBirth;

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


    @JsonSerialize(using = LocalDataJsonSerializer.class)
    public LocalDate getDateOfBirth() {

        return dateOfBirth;
    }


    @JsonProperty("location")
    public Location getCityOfBirth() {

        return location;
    }


    @JsonIgnore
    public String getNationality() {

        if (country != null) {
            return country.getCode();
        }

        return null;
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


    void setDateOfBirth(LocalDate dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
    }


    public void setCityOfBirth(Location location) {

        this.location = location;
    }


    /**
     * @param  countryCode  2 characters (UN/LOCODE).
     */
    void setNationality(String countryCode) {

        Country country = new Country();
        country.setCode(countryCode);

        this.country = country;
    }


    public Country getCountry() {

        return country;
    }
}
