package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The final destination specified in an {@link Order}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Reiseziel
 * @name_english  destination
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Destination {

    private Vessel vessel;

    private Seaport seaport;

    private Location location;

    /**
     * 2 characters (UN/LOCODE).
     */
    private Country country;

    @JsonIgnore
    public String getCountryCode() {

        return country.getCode();
    }


    public Country getCountry() {

        return country;
    }


    public Location getLocation() {

        return location;
    }


    public Vessel getVessel() {

        return vessel;
    }


    public Seaport getSeaport() {

        return seaport;
    }


    void setCountry(String code) {

        this.country = new Country();
        this.country.setCode(code);
    }


    void setVessel(Vessel vessel) {

        this.vessel = vessel;
    }


    void setSeaport(Seaport seaport) {

        this.seaport = seaport;
    }


    void setLocation(Location location) {

        this.location = location;
    }


    void setCountry(Country country) {

        this.country = country;
    }


    void setSeaport(String name) {

        this.seaport = new Seaport(name);
    }


    void setLocation(String city, String designation) {

        this.location = new Location();
        this.location.setCity(city);
        this.location.setDesignation(designation);
    }


    void setLocation(String designation) {

        this.location = new Location();
        this.location.setDesignation(designation);
    }
}
