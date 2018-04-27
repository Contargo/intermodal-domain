package digit.domain.masterData.person;

import digit.domain.masterData.address.Address;

import java.util.Date;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @DIGIT_name_german  Person
 * @DIGIT_name_english  person
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public abstract class Person {

    private String name;

    private String firstName;

    private Address address;

    private String cellphone;

    /**
     * format: ISO 8601 yyyy-mm-dd e.g. 1994-02-25
     */
    private Date dateOfBirth;

    /**
     * City of birth.
     */
    private String locationCity;

    /**
     * 2 characters (UN/LOCODE).
     */
    private String countryCode;
}
