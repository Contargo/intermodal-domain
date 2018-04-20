package digit.domain.masterData.barge;

import digit.domain.masterData.meansOfTransport.MeansOfTransport;
import digit.domain.masterData.operator.Operator;
import digit.domain.masterData.vessel.Vessel;


/**
 * A ship build to drive on inland waters and inland waterways.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @DIGIT_name  Binnenschiff
 * @DIGIT_english  barge
 * @DIGIT_definition  Schiff, das zur Fahrt auf Binnengewässern und Binnenwasserstraßen konstruiert ist.
 * @DIGIT_definition_english  A ship build to drive on inland waters and inland waterways.
 * @DIGIT_annotation  Im Vergleich zum {@link Vessel Seeschiff} bestehen weniger Anforderungen an Stabilität,
 *                    Navigation und Rettungsgerät, wohingegen spezielle Konstruktionen für die Brückendurchfahrt o. ä.
 *                    notwendig sein können. Es gibt diverse Schiffstypen dieser Art, die für den Kombinierten Verkehr
 *                    relevant sind, z. B. Containerschiffe, Lastkähne, Leichter bzw. Schubverbände, Koppelverbände.
 * @DIGIT_annotation_english  In comparison to a {@link Vessel} there are less requirements in means of stability,
 *                            navigation and rescue devices but special constructions for navigating under bridges or
 *                            or the like might be necessary. There are different types of barges that are relevant in
 *                            combined traffic e.g. container ships, lighter and tug barges.
 */
public class Barge implements MeansOfTransport {

    private String name;

    /**
     * Maritime Mobile Service Identity (9 digits).
     */
    private int mmsi;

    /**
     * European Number of Identification e.g. 040-059 for Germany.
     */
    private String eni;

    private Operator operator;

    /**
     * in meter.
     */
    private double length;

    /**
     * in meter.
     */
    private double width;

    /**
     * in meter.
     */
    private double draught;

    private int bays;

    private int rows;

    private int tiers;

    private boolean suitabilityDangerousGoods;

    /**
     * in TEU.
     */
    private double capacityTeu;

    /**
     * in tons.
     */
    private double capacityTons;
}