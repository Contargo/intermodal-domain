package api.masterData.person;

import java.util.Date;


/**
 * A {@link api.masterData.person.Person} driving a train.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @DIGIT_name  Lokführer
 * @DIGIT_english  train driver
 */
public class TrainDriver extends Person {

    /**
     * RID (fr: Règlement concernant le transport international ferroviaire de marchandises dangereuses): treaty for
     * regulation of international transport of dangerous goods in rail transport. (Format: DateTime ISO 8601 inclusive
     * UTC.)*
     *
     * <p>Value is optional and can be null.</p>
     */
    private Date rid;
}
