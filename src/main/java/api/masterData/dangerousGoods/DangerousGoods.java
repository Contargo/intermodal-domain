package api.masterData.dangerousGoods;

/**
 * Substances or objects that are dangerous in context of public safety and order because of their nature, properties
 * or state.
 *
 * <p>DIGIT_name: Gefahrgut</p>
 *
 * <p>DIGIT_english: dangerous goods</p>
 *
 * <p>DIGIT_definition: Stoffe und Gegenstände, von denen auf Grund ihrer Natur, ihrer Eigenschaften oder ihres
 * Zustandes im Zusammenhang mit der Beförderung Gefahren für die öffentliche Sicherheit oder Ordnung, insbesondere für
 * die Allgemeinheit, für wichtige Gemeingüter, für Leben und Gesundheit von Menschen sowie für Tiere und Sachen
 * ausgehen können.</p>
 *
 * <p>DIGIT_definition_english: Substances or objects that are dangerous in context of public safety and order because
 * of their nature, properties or state.</p>
 *
 * <p>DIGIT_annotation: Bei verschiedenen Verkehrsträgern kommt das entsprechende Regelwerk zum Tragen.</p>
 *
 * <p>DIGIT_annotation_english: There are different rules for different modes of transport.</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
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
