package net.contargo.intermodal.domain;

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

    public void setVessel(Vessel vessel) {

        this.vessel = vessel;
    }


    public void setCountry(String code) {

        this.country = new Country();
        this.country.setCode(code);
    }


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


    public void setSeaport(String name) {

        this.seaport = new Seaport(name);
    }


    public void setLocation(String city, String designation) {

        this.location = new Location();
        this.location.setCity(city);
        this.location.setDesignation(designation);
    }
}
