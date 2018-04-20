package digit.domain.masterData.address;

/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @DIGIT_name  Adresse
 * @DIGIT_english  address
 */
public class Address {

    private String street;

    private String locationPostalCode;

    private String locationCity;

    private String countryName;

    /**
     * 2 characters (UN/LOCODE).
     */
    private String countryCode;
}
