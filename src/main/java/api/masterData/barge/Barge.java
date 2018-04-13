package api.masterData.barge;

import api.masterData.meansOfTransport.MeansOfTransport;

import api.masterData.operator.Operator;

import api.masterData.vessel.Vessel;


/**
 * A ship build to drive on inland waters and inland waterways.
 *
 * <p>DIGIT_name: Binnenschiff</p>
 *
 * <p>DIGIT_english: barge</p>
 *
 * <p>DIGIT_definition: Schiff, das zur Fahrt auf Binnengewässern und Binnenwasserstraßen konstruiert ist.</p>
 *
 * <p>DIGIT_definition_english: A ship build to drive on inland waters and inland waterways.</p>
 *
 * <p>DIGIT_annotation: Im Vergleich zum {@link Vessel Seeschiff} bestehen weniger Anforderungen an Stabilität,
 * Navigation und Rettungsgerät, wohingegen spezielle Konstruktionen für die Brückendurchfahrt o. ä. notwendig sein
 * können. Es gibt diverse Schiffstypen dieser Art, die für den Kombinierten Verkehr relevant sind, z. B.
 * Containerschiffe, Lastkähne, Leichter bzw. Schubverbände, Koppelverbände.</p>
 *
 * <p>DIGIT_annotation_english: In comparison to a {@link Vessel} there are less requirements in means of stability,
 * navigation and rescue devices but special constructions for navigating under bridges or or the like might be
 * necessary. There are different types of barges that are relevant in combined traffic e.g. container ships, lighter
 * and tug barges.</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Barge extends MeansOfTransport {

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
