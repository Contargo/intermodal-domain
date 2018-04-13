package api.masterData.person;

import java.util.Date;


/**
 * A {@link api.masterData.person.Person} driving a ship.
 *
 * <p>DIGIT_name: Schiffsführer</p>
 *
 * <p>DIGIT_english: skipper</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Skipper extends Person {

    /**
     * ADNR (fr: Accord européen relatif au transport international des marchandises dangereuses par voie de navigation
     * intérieure sur le Rhin): european treaty for transport of dangerous goods on the Rhine. (Format: DateTime ISO
     * 8601 incl.) UTC.
     *
     * <p>Value is optional and can be null.</p>
     */
    private Date adnr;
}
