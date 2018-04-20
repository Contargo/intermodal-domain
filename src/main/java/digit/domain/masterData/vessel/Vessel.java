package digit.domain.masterData.vessel;

import digit.domain.masterData.meansOfTransport.MeansOfTransport;
import digit.domain.masterData.operator.Operator;


/**
 * A ship build to drive on seas and oceans.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @DIGIT_name  Seeschiff
 * @DIGIT_name_english  vessel
 * @DIGIT_definition  Schiff, das zur Fahrt auf Meeren und Ozeanen konzipiert ist.
 * @DIGIT_definition_english  A ship build to drive on seas and oceans.
 * @DIGIT_note  Für diese API sind Schiffe relevant, die Ladeeinheiten des Kombinierten Verkehrs transportieren können.
 * @DIGIT_note_english  In this API only vessels which can transport loading units of combined traffic are relevant.
 */
public class Vessel implements MeansOfTransport {

    private String name;

    /**
     * Maritime Mobile Service Identity (9 digits).
     */
    private int mmsi;

    /**
     * International Maritime Organization (IMO plus 7 digits).
     */
    private String imo;

    private Operator operator;
}