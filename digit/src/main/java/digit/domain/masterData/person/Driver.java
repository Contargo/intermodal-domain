package digit.domain.masterData.person;

import java.util.Date;


/**
 * A {@link digit.domain.masterData.person.Person} driving a motor vehicle.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @DIGIT_name  Fahrer
 * @DIGIT_english  driver
 */
public class Driver extends Person {

    /**
     * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
     */
    private Date licenseValidity;

    private String licenseNumber;

    /**
     * @DIGIT_name  Fahrerkartennummer
     */
    private String id;

    /**
     * ADR (fr: Accord européen relatif au transport international des marchandises dangereuses par route): european
     * treaty for international transport of dangerous goods. (Format: DateTime ISO 8601 inclusive UTC
     * (yyyy-MM-dd'T'HH:mm:ss.SSSX).)
     *
     * <p>Value is optional and can be null.</p>
     */
    private Date adr;

    /**
     * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
     */
    private Date moduleEntry95;
}
