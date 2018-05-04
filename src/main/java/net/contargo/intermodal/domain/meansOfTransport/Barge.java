package net.contargo.intermodal.domain.meansOfTransport;

import net.contargo.intermodal.domain.Operator;


/**
 * A ship build to drive on inland waters and inland waterways.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Binnenschiff
 * @name_english  barge
 * @definition_german  Schiff, das zur Fahrt auf Binnengewässern und Binnenwasserstraßen konstruiert ist.
 * @definition_english  A ship build to drive on inland waters and inland waterways.
 * @note_german  Im Vergleich zum {@link Vessel Seeschiff} bestehen weniger Anforderungen an Stabilität, Navigation und
 *               Rettungsgerät, wohingegen spezielle Konstruktionen für die Brückendurchfahrt o. ä. notwendig sein
 *               können. Es gibt diverse Schiffstypen dieser Art, die für den Kombinierten Verkehr relevant sind, z. B.
 *               Containerschiffe, Lastkähne, Leichter bzw. Schubverbände, Koppelverbände.
 * @note_english  In comparison to a {@link Vessel} there are less requirements in means of stability, navigation and
 *                rescue devices but special constructions for navigating under bridges or or the like might be
 *                necessary. There are different types of barges that are relevant in combined traffic e.g. container
 *                ships, lighter and tug barges.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Barge implements MeansOfTransport {

    private String name;

    /**
     * Maritime Mobile Service Identity (9 digits).
     */
    private Integer mmsi;

    /**
     * European Number of Identification e.g. 040-059 for Germany.
     */
    private String eni;

    private Operator operator;

    /**
     * in meter.
     */
    private Double length;

    /**
     * in meter.
     */
    private Double width;

    /**
     * in meter.
     */
    private Double draught;

    private Integer bays;

    private Integer rows;

    private Integer tiers;

    private Boolean suitabilityDangerousGoods;

    /**
     * in TEU.
     */
    private Double capacityTeu;

    /**
     * in tons.
     */
    private Double capacityTons;
}
