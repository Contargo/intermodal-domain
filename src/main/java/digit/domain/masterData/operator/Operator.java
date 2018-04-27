package digit.domain.masterData.operator;

import digit.domain.masterData.address.Address;


/**
 * Unit for organization of multiple actors in trimodal transport.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @DIGIT_name_german  Operateur
 * @DIGIT_name_english  operator
 * @DIGIT_definition_german  Funktionseinheit, die bei der Güterbeförderung im Kombinierten Verkehr die
 *                           akteurübergreifende Organisation durchführt.
 * @DIGIT_definition_english  Unit for organization of multiple actors in trimodal transport.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
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
