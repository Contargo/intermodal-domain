package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Land
 * @name_english  country
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class Country {

    /**
     * 2 characters (UN/LOCODE).
     */
    private String code;
    private String name;

    public String getName() {

        return name;
    }


    public void setName(String name) {

        this.name = name;
    }


    public String getCode() {

        return code;
    }


    public void setCode(String code) {

        this.code = code;
    }
}
