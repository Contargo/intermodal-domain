package digit.domain.masterData.person;

import java.util.Date;


/**
 * A {@link digit.domain.masterData.person.Person} driving a train.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @DIGIT_name_german  Lokführer
 * @DIGIT_name_english  train driver
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
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
