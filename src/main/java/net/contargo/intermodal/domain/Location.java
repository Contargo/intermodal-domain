package net.contargo.intermodal.domain;

import javax.validation.constraints.NotNull;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Location {

    /**
     * @definition_german  Eigenname Terminal
     * @defintion_english  name of terminal
     */
    @NotNull(message = "designation is part of minimum requirement")
    private String designation;
    private String city;

    /**
     * e.g. loading place, sea or hinterland terminal
     */
    private String type;

    private String postalCode;

    public void setDesignation(String designation) {

        this.designation = designation;
    }


    public void setCity(String city) {

        this.city = city;
    }


    public void setType(String type) {

        this.type = type;
    }


    public String getDesignation() {

        return designation;
    }


    public String getCity() {

        return city;
    }


    public String getType() {

        return type;
    }


    public String getPostalCode() {

        return postalCode;
    }


    public void setPostalCode(String postalCode) {

        this.postalCode = postalCode;
    }
}
