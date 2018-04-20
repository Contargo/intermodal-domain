package digit.domain.masterData.person;

import digit.domain.masterData.address.Address;

import java.util.Date;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @DIGIT_name  Person
 * @DIGIT_english  person
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
