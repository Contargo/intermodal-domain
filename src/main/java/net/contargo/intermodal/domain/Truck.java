package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;

import tec.units.ri.quantity.Quantities;

import javax.measure.Quantity;
import javax.measure.quantity.Mass;

import static tec.units.ri.unit.Units.KILOGRAM;


/**
 * Commercial vehicle which is mostly or exclusively used for carrying trailed vehicles.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Zugmaschine
 * @name_english  truck
 * @definition_german  Nutzkraftwagen, der ausschließlich oder überwiegend zum Mitführen von Anhängerfahrzeugen
 *                     bestimmt ist. (@see DIN 70010:2001-04, 1.2.2.3)
 * @definition_english  Commercial vehicle which is mostly or exclusively used for carrying trailed vehicles. (@see DIN
 *                      70010:2001-04, 1.2.2.3)
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Truck implements MeansOfTransport {

    /**
     * Format: spaces included.
     */
    private String numberPlate;

    private Country country;

    /**
     * Format: DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
     *
     * @name_english  Ministry of Transport test
     * @name_german  Hauptuntersuchung
     * @abbreviation_german  TÜV
     * @abbreviation_english  MOT
     */
    private String mot;

    /**
     * @name_german  Umweltplakette
     */
    private EnvironmentBadge environmentBadge;

    private String type;

    /**
     * @name_german  EU Zulassung
     */
    private Boolean euAuthorization;

    /**
     * @name_english  security test
     * @name_german  Sicherheitsprüfung
     */
    private Boolean st;

    /**
     * @name_german  Gefahrguteignung
     */
    private Boolean suitabilityDangerousGoods;

    /**
     * @name_german  Abfalleignung
     */
    private Boolean suitabilityWaste;

    /**
     * in kg.
     */
    private Weight weight;

    public String getNumberPlate() {

        return numberPlate;
    }


    @JsonIgnore
    public String getCountryCode() {

        return country.getCode();
    }


    public String getMot() {

        return mot;
    }


    public EnvironmentBadge getEnvironmentBadge() {

        return environmentBadge;
    }


    public String getType() {

        return type;
    }


    public Boolean getEuAuthorization() {

        return euAuthorization;
    }


    public Boolean getSt() {

        return st;
    }


    public Boolean getSuitabilityDangerousGoods() {

        return suitabilityDangerousGoods;
    }


    public Boolean getSuitabilityWaste() {

        return suitabilityWaste;
    }


    @JsonIgnore
    public Quantity<Mass> getWeightTara() {

        return weight.getTara();
    }


    public Weight getWeight() {

        return weight;
    }


    public Country getCountry() {

        return country;
    }


    @Override
    public String toString() {

        try {
            return this.getClass().getSimpleName() + ": " + JsonStringMapper.map(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static final class Builder {

        private String numberPlate;
        private String countryCode;
        private String mot;
        private EnvironmentBadge environmentBadge;
        private String type;
        private Boolean euAuthorization;
        private Boolean st;
        private Boolean suitabilityDangerousGoods;
        private Boolean suitabilityWaste;
        private Quantity<Mass> weightTara;

        private Builder() {
        }

        public static Builder newTruck() {

            return new Builder();
        }


        public Builder withNumberPlate(String numberPlate) {

            this.numberPlate = numberPlate;

            return this;
        }


        /**
         * @param  countryCode  2 characters (UN/LOCODE).
         *
         * @return  this
         */
        public Builder withCountryCode(String countryCode) {

            this.countryCode = countryCode;

            return this;
        }


        public Builder withMot(int year, int month, int day) {

            this.mot = ISO8601DateFormatter.format(year, month, day);

            return this;
        }


        public Builder withEnvironmentBadge(EnvironmentBadge environmentBadge) {

            this.environmentBadge = environmentBadge;

            return this;
        }


        public Builder withType(String type) {

            this.type = type;

            return this;
        }


        public Builder withEuAuthorization(Boolean euAuthorization) {

            this.euAuthorization = euAuthorization;

            return this;
        }


        public Builder withST(Boolean st) {

            this.st = st;

            return this;
        }


        public Builder withSuitabilityDangerousGoods(Boolean suitabilityDangerousGoods) {

            this.suitabilityDangerousGoods = suitabilityDangerousGoods;

            return this;
        }


        public Builder withSuitabilityWaste(Boolean suitabilityWaste) {

            this.suitabilityWaste = suitabilityWaste;

            return this;
        }


        public Builder withWeightTara(Double weightTara, MassUnit unit) {

            if (unit.equals(MassUnit.KILOGRAM)) {
                this.weightTara = Quantities.getQuantity(weightTara, KILOGRAM);
            } else if (unit.equals(MassUnit.TON)) {
                this.weightTara = UnitConverter.tonToKilogram(weightTara);
            }

            return this;
        }


        public Truck build() {

            Truck truck = new Truck();
            truck.mot = this.mot;
            truck.suitabilityWaste = this.suitabilityWaste;
            truck.euAuthorization = this.euAuthorization;
            truck.numberPlate = this.numberPlate;
            truck.environmentBadge = this.environmentBadge;

            if (weightTara != null) {
                Weight weight = new Weight();
                weight.setTara(this.weightTara);
                truck.weight = weight;
            }

            truck.suitabilityDangerousGoods = this.suitabilityDangerousGoods;
            truck.type = this.type;
            truck.st = this.st;

            Country country = new Country();
            country.setCode(this.countryCode);
            truck.country = country;

            return truck;
        }


        public Truck buildAndValidate() {

            Truck truck = this.build();

            Validator.validate(truck);

            return truck;
        }
    }
}
