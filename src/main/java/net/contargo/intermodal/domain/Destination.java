package net.contargo.intermodal.domain;

import javax.validation.constraints.NotNull;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class Destination {

    private Vessel vessel;
    private Seaport seaport;
    @NotNull(message = "locationDesignation is part of minimum requirement")
    private String locationDesignation;

    /**
     * 2 characters (UN/LOCODE).
     */
    private String countryCode;
    private String locationCity;

    Destination() {
    }


    Destination(Vessel vessel, String seaportName, String locationDesignation, String countryCode,
        String locationCity) {

        this.vessel = vessel;
        this.seaport = new Seaport(seaportName);
        this.locationDesignation = locationDesignation;

        this.countryCode = countryCode;
        this.locationCity = locationCity;
    }

    public Vessel getVessel() {

        return vessel;
    }


    public String getSeaportName() {

        return seaport.getName();
    }


    public String getLocationDesignation() {

        return locationDesignation;
    }


    public String getCountryCode() {

        return countryCode;
    }


    public String getLocationCity() {

        return locationCity;
    }
}
