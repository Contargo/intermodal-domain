package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Arrays;
import java.util.Locale;
import java.util.logging.Logger;


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

    private static final Logger LOG = Logger.getLogger(Country.class.getName());

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

        if (code.length() != 2) {
            LOG.warning(String.format(
                    "The country code \'%s\' has the wrong length. Please use the 2 characters LOCODE.", code));
        }

        if (Arrays.stream(Locale.getISOCountries()).noneMatch(country -> country.equals(code))) {
            LOG.warning(String.format("The country code \'%s\' was not found in Locale.getISOCountries()", code));
        }

        this.code = code;
    }
}
