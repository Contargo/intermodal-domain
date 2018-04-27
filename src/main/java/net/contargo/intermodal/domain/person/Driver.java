package net.contargo.intermodal.domain.person;

import java.util.Date;


/**
 * A {@link net.contargo.intermodal.domain.person.Person} driving a motor vehicle.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Fahrer
 * @name_english  driver
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Driver extends Person {

    /**
     * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
     */
    private Date licenseValidity;

    private String licenseNumber;

    /**
     * @name_german  Fahrerkartennummer
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
