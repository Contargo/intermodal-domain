package digit.domain.masterData.person;

import java.util.Date;


/**
 * A {@link digit.domain.masterData.person.Person} driving a ship.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @DIGIT_name  Schiffsführer
 * @DIGIT_name_english  skipper
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
