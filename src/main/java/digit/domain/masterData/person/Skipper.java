package digit.domain.masterData.person;

import java.util.Date;


/**
 * A {@link digit.domain.masterData.person.Person} driving a ship.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Schiffsführer
 * @name_english  skipper
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Skipper extends Person {

    /**
     * ADNR (fr: Accord européen relatif au transport international des marchandises dangereuses par voie de navigation
     * intérieure sur le Rhin): european treaty for transport of dangerous goods on the Rhine. (Format: DateTime ISO
     * 8601 inclusive) UTC.
     *
     * <p>Value is optional and can be null.</p>
     */
    private Date adnr;
}
