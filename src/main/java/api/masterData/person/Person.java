package api.masterData.person;

import api.masterData.Address;

import java.util.Date;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
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

    private String locationCity;

    /**
     * 2 characters (UN/LOCODE).
     */
    private String countryCode;
}
