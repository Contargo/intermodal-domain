package net.contargo.intermodal.domain;

import javax.validation.constraints.NotNull;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Destination {

    private Vessel vessel;

    private Seaport seaport;

    private Location location;

    /**
     * 2 characters (UN/LOCODE).
     */
    private Country country;

    public String getCountryCode() {

        return country.getCode();
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


    public void setCountry(String code) {

        this.country = new Country();
        this.country.setCode(code);
    }


    public void setVessel(Vessel vessel) {

        this.vessel = vessel;
    }


    public void setSeaport(Seaport seaport) {

        this.seaport = seaport;
    }


    public void setLocation(Location location) {

        this.location = location;
    }


    public void setCountry(Country country) {

        this.country = country;
    }


    public void setSeaport(String name) {

        this.seaport = new Seaport(name);
    }


    public void setLocation(String city, String designation) {

        this.location = new Location();
        this.location.setCity(city);
        this.location.setDesignation(designation);
    }


    public void setLocation(String designation) {

        this.location = new Location();
        this.location.setDesignation(designation);
    }
}
