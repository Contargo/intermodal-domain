package net.contargo.intermodal.domain.person;

import net.contargo.intermodal.domain.Address;
import net.contargo.intermodal.domain.utility.ISO8601DateFormatter;


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
     * /** DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
     */
    private String licenseValidity;

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
    private String adr;

    /**
     * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
     */
    private String moduleEntry95;

    public Driver withLicenseValidity(int year, int month, int day) {

        this.licenseValidity = ISO8601DateFormatter.format(year, month, day);

        return this;
    }


    public Driver withLicenseNumber(String licenseNumber) {

        this.licenseNumber = licenseNumber;

        return this;
    }


    public Driver withId(String id) {

        this.id = id;

        return this;
    }


    public Driver withAdr(int year, int month, int day) {

        this.adr = ISO8601DateFormatter.format(year, month, day);

        return this;
    }


    public Driver withModuleEntry95(int year, int month, int day) {

        this.moduleEntry95 = ISO8601DateFormatter.format(year, month, day);

        return this;
    }


    @Override
    public Driver withName(String firstName, String lastName) {

        super.withName(firstName, lastName);

        return this;
    }


    @Override
    public Driver withAddress(Address address) {

        super.withAddress(address);

        return this;
    }


    @Override
    public Driver withCellphone(String cellphone) {

        super.withCellphone(cellphone);

        return this;
    }


    @Override
    public Driver withDateOfBirth(int year, int month, int day) {

        super.withDateOfBirth(year, month, day);

        return this;
    }


    @Override
    public Driver withCityOfBirth(String locationCity) {

        super.withCityOfBirth(locationCity);

        return this;
    }


    @Override
    public Driver withCountryCode(String countryCode) {

        super.withCountryCode(countryCode);

        return this;
    }


    public String getLicenseValidity() {

        return licenseValidity;
    }


    public String getLicenseNumber() {

        return licenseNumber;
    }


    public String getId() {

        return id;
    }


    public String getAdr() {

        return adr;
    }


    public String getModuleEntry95() {

        return moduleEntry95;
    }
}
