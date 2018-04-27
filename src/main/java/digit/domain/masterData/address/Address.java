package digit.domain.masterData.address;

/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Adresse
 * @name_english  address
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
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
