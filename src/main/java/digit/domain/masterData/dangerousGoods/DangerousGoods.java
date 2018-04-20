package digit.domain.masterData.dangerousGoods;

/**
 * Substances or objects that are dangerous in context of public safety and order because of their nature, properties
 * or state.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @DIGIT_name  Gefahrgut
 * @DIGIT_name_english  dangerous goods
 * @DIGIT_definition  Stoffe und Gegenstände, von denen auf Grund ihrer Natur, ihrer Eigenschaften oder ihres Zustandes
 *                    im Zusammenhang mit der Beförderung Gefahren für die öffentliche Sicherheit oder Ordnung,
 *                    insbesondere für die Allgemeinheit, für wichtige Gemeingüter, für Leben und Gesundheit von
 *                    Menschen sowie für Tiere und Sachen ausgehen können.
 * @DIGIT_definition_english  Substances or objects that are dangerous in context of public safety and order because of
 *                            their nature, properties or state.
 * @DIGIT_note  Bei verschiedenen Verkehrsträgern kommt das entsprechende Regelwerk zum Tragen.
 * @DIGIT_note_english  There are different rules for different modes of transport.
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
