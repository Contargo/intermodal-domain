package net.contargo.intermodal.domain.person;

import net.contargo.intermodal.domain.Address;
import net.contargo.intermodal.domain.utility.ISO8601DateFormatter;


/**
 * A {@link net.contargo.intermodal.domain.person.Person} driving a ship.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Schiffsführer
 * @name_english  skipper
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Skipper extends Person {

    /**
     * ADNR (fr: Accord européen relatif au transport international des marchandises dangereuses par voie de navigation
     * intérieure sur le Rhin): european treaty for transport of dangerous goods on the Rhine. (Format: DateTime ISO
     * 8601 inclusive) UTC.
     *
     * <p>Value is optional and can be null.</p>
     */
    private String adnr;

    public Skipper withAdnr(int year, int month, int day) {

        this.adnr = ISO8601DateFormatter.format(year, month, day);

        return this;
    }


    @Override
    public Skipper withName(String firstName, String lastName) {

        super.withName(firstName, lastName);

        return this;
    }


    @Override
    public Skipper withAddress(Address address) {

        super.withAddress(address);

        return this;
    }


    @Override
    public Skipper withCellphone(String cellphone) {

        super.withCellphone(cellphone);

        return this;
    }


    @Override
    public Skipper withDateOfBirth(int year, int month, int day) {

        super.withDateOfBirth(year, month, day);

        return this;
    }


    @Override
    public Skipper withCityOfBirth(String locationCity) {

        super.withCityOfBirth(locationCity);

        return this;
    }


    @Override
    public Skipper withCountryCode(String countryCode) {

        super.withCountryCode(countryCode);

        return this;
    }


    public String getAdnr() {

        return adnr;
    }
}
