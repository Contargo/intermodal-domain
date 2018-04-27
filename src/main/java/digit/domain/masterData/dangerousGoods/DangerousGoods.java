package digit.domain.masterData.dangerousGoods;

/**
 * Substances or objects that are dangerous in context of public safety and order because of their nature, properties
 * or state.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Gefahrgut
 * @name_english  dangerous goods
 * @definition_german  Stoffe und Gegenstände, von denen auf Grund ihrer Natur, ihrer Eigenschaften oder ihres
 *                     Zustandes im Zusammenhang mit der Beförderung Gefahren für die öffentliche Sicherheit oder
 *                     Ordnung, insbesondere für die Allgemeinheit, für wichtige Gemeingüter, für Leben und Gesundheit
 *                     von Menschen sowie für Tiere und Sachen ausgehen können.
 * @definition_english  Substances or objects that are dangerous in context of public safety and order because of their
 *                      nature, properties or state.
 * @note_german  Bei verschiedenen Verkehrsträgern kommt das entsprechende Regelwerk zum Tragen.
 * @note_english  There are different rules for different modes of transport.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class DangerousGoods {

    /**
     * 4 digits.
     */
    private String unNumber;

    private String material;

    private String dangerNote;

    private String packagingGroup;

    private int packages;

    private int totalQuantity;

    private TunnelRestrictionCode tunnelRestrictionCode;

    // TODO
    private String mandatoryRouting;

    private boolean limitedQuantity;

    private boolean marinePollutants;
}
