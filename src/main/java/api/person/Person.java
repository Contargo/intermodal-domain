package api.person;

public abstract class Person {

    private String name;

    private String firstName;

    // TODO - type: siehe Details bei @Anschrift
    private Anschrift addressMD;

    private String cellphone;

    // TODO - type: yyyy-mm-dd
    private Date dateOfBirth;

    private String locationCity;

    private String countryCode;
}
