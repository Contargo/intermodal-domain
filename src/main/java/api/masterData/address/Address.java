package api.masterData.address;

/**
 * <p>DIGIT_name: Adresse</p>
 *
 * <p>DIGIT_english: address</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
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
