package api.masterData;

/**
 * Unit for organization of multiple actors in trimodal transport.
 *
 * <p>DIGIT_name: Operateur</p>
 *
 * <p>DIGIT_english: operator</p>
 *
 * <p>DIGIT_definition: Funktionseinheit, die bei der Güterbeförderung im Kombinierten Verkehr die akteurübergreifende
 * Organisation durchführt.</p>
 *
 * <p>DIGIT_definition_english: Unit for organization of multiple actors in trimodal transport.</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Operator {

    private String name;

    private String legalForm;

    private Address adress;

    private String vatId;

    /**
     * Tax Identification Number.
     */
    private String tin;

    private String insurance;
}
