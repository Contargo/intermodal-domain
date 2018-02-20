package api.person;

import api.miscellaneous.Address;

import java.util.Date;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public abstract class Person {

    private String name;

    private String firstName;

    private Address address;

    private String cellphone;

    // TODO - type: yyyy-mm-dd
    private Date dateOfBirth;

    private String locationCity;

    private String countryCode;
}
