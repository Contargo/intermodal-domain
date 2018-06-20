package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;


/**
 * A location used in drop off, pick up and stops of an {@link Transport}. Also used to specify the city of birth of a
 * {@link Person}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @minimum_requirement  designation
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Location {

    /**
     * @definition_german  Eigenname Terminal
     * @definition_english  name of terminal
     */
    @NotNull(message = "designation is part of minimum requirement")
    private String designation;
    private String city;

    /**
     * e.g. loading place, sea or hinterland terminal
     */
    private String type;

    private String postalCode;

    void setDesignation(String designation) {

        this.designation = designation;
    }


    void setCity(String city) {

        this.city = city;
    }


    void setType(String type) {

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


    void setPostalCode(String postalCode) {

        this.postalCode = postalCode;
    }
}
