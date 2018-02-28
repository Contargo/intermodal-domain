package api.masterData.person;

import java.util.Date;


/**
 * A {@link api.masterData.person.Person} driving a ship.
 *
 * <p>In german Schiffsführer</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Skipper extends Person {

    /**
     * ADNR (fr: Accord europèen relatif au transport international des marchandises dangereuses par voie de navigation
     * intérieure sur le Rhin): european treaty for transport of dangerous goods on the Rhine. (Format: DateTime ISO
     * 8601 incl.) UTC.
     */
    private Date adnr;
}
