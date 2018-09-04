package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Arrays;
import java.util.Locale;


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

    Country() {

        // OK
    }

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

        if (code != null && code.length() != 2) {
            throw new IllegalArgumentException(String.format(
                    "Wrong length of country code \'%s\'. Please use 2 characters LOCODE.", code));
        }

        if (code != null && Arrays.stream(Locale.getISOCountries()).noneMatch(country -> country.equals(code))) {
            throw new IllegalArgumentException(String.format(
                    "Invalid country code \'%s\': Was not found in Locale.getISOCountries().", code));
        }

        this.code = code;
    }
}
