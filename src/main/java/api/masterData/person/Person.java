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
     * format: yyyy-mm-dd
     */
    private Date dateOfBirth;

    private String locationCity;

    private String countryCode;
}
