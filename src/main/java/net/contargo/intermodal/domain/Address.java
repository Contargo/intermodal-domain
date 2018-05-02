package net.contargo.intermodal.domain;

/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Adresse
 * @name_english  address
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Address {

    private String street;

    private String locationPostalCode;

    private String locationCity;

    private String countryName;

    /**
     * 2 characters (UN/LOCODE).
     */
    private String countryCode;

    public Address withStreet(String street) {

        this.street = street;

        return this;
    }


    public Address withLocationPostalCode(String locationPostalCode) {

        this.locationPostalCode = locationPostalCode;

        return this;
    }


    public Address withLocationCity(String locationCity) {

        this.locationCity = locationCity;

        return this;
    }


    public Address withCountryName(String countryName) {

        this.countryName = countryName;

        return this;
    }


    public Address withCountryCode(String countryCode) {

        this.countryCode = countryCode;

        return this;
    }


    public String getStreet() {

        return street;
    }


    public String getLocationPostalCode() {

        return locationPostalCode;
    }


    public String getLocationCity() {

        return locationCity;
    }


    public String getCountryName() {

        return countryName;
    }


    public String getCountryCode() {

        return countryCode;
    }
}
