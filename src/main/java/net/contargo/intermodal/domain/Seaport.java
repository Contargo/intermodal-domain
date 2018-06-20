package net.contargo.intermodal.domain;

/**
 * Port that can be accessed by vessels.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Seehafen
 * @name_english  seaport
 * @definition_german  Hafen, der von (Hoch-)Seeschiffen angelaufen werden kann.
 * @definition_english  Port that can be accessed by vessels.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */

class Seaport {

    /**
     * UN/LOCODE 2 characters.
     */
    private String name;

    public String getName() {

        return name;
    }


    public void setName(String name) {

        this.name = name;
    }
}
