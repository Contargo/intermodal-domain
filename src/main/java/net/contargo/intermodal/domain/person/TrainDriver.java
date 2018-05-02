package net.contargo.intermodal.domain.person;

import net.contargo.intermodal.domain.Address;
import net.contargo.intermodal.domain.utility.ISO8601DateFormatter;


/**
 * A {@link net.contargo.intermodal.domain.person.Person} driving a train.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Lokführer
 * @name_english  train driver
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class TrainDriver extends Person {

    /**
     * RID (fr: Règlement concernant le transport international ferroviaire de marchandises dangereuses): treaty for
     * regulation of international transport of dangerous goods in rail transport. (Format: DateTime ISO 8601 inclusive
     * UTC.)*
     *
     * <p>Value is optional and can be null.</p>
     */
    private String rid;

    public TrainDriver withRid(int year, int month, int day) {

        this.rid = ISO8601DateFormatter.format(year, month, day);

        return this;
    }


    @Override
    public TrainDriver withName(String firstName, String lastName) {

        super.withName(firstName, lastName);

        return this;
    }


    @Override
    public TrainDriver withAddress(Address address) {

        super.withAddress(address);

        return this;
    }


    @Override
    public TrainDriver withCellphone(String cellphone) {

        super.withCellphone(cellphone);

        return this;
    }


    @Override
    public TrainDriver withDateOfBirth(int year, int month, int day) {

        super.withDateOfBirth(year, month, day);

        return this;
    }


    @Override
    public TrainDriver withCityOfBirth(String locationCity) {

        super.withCityOfBirth(locationCity);

        return this;
    }


    @Override
    public TrainDriver withCountryCode(String countryCode) {

        super.withCountryCode(countryCode);

        return this;
    }


    public String getRid() {

        return rid;
    }
}
