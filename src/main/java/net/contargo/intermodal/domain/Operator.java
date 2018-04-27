package net.contargo.intermodal.domain;

import net.contargo.intermodal.domain.Address;


/**
 * Unit for organization of multiple actors in trimodal transport.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Operateur
 * @name_english  operator
 * @definition_german  Funktionseinheit, die bei der Güterbeförderung im Kombinierten Verkehr die akteurübergreifende
 *                     Organisation durchführt.
 * @definition_english  Unit for organization of multiple actors in trimodal transport.
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
