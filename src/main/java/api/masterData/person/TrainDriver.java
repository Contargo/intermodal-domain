package api.masterData.person;

import java.util.Date;


/**
 * A {@link api.masterData.person.Person} driving a train.
 *
 * <p>DIGIT_name: Lokführer</p>
 *
 * <p>DIGIT_english: train driver</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class TrainDriver extends Person {

    /**
     * RID (fr: Règlement concernant le transport international ferroviaire de marchandises dangereuses): treaty for
     * regulation of international transport of dangerous goods in rail transport. (Format: DateTime ISO 8601 incl.
     * UTC.)*
     *
     * <p>Value is optional and can be null.</p>
     */
    private Date rid;
}
