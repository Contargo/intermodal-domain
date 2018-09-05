package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import tec.units.ri.quantity.Quantities;

import java.time.Instant;

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
     * Format: spaces included e.g. in Germany: DU CO 1782
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
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    @JsonSerialize(using = InstantJsonSerializer.class)
    @JsonProperty("mot")
    private Instant mot;

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
    @JsonProperty("st")
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

    private Truck() {

        // OK
    }

    /**
     * Creates a new builder for {@link Truck}.
     *
     * @return  new builder
     */
    public static Builder newBuilder() {

        return new Builder();
    }


    /**
     * Creates a new builder with the values of another {@link Truck}.
     *
     * @param  truck  that should be copied.
     *
     * @return  new builder with values of given truck.
     */
    public static Builder newBuilder(Truck truck) {

        return new Builder().withMinistryOfTransportTest(truck.getMinistryOfTransportTest())
            .isSuitableForWaste(truck.getSuitabilityWaste())
            .withEuAuthorization(truck.getEuAuthorization())
            .withNumberPlate(truck.getNumberPlate())
            .withEnvironmentBadge(truck.getEnvironmentBadge())
            .isSuitableForDangerousGoods(truck.getSuitabilityDangerousGoods())
            .withType(truck.getType())
            .withSafetyTest(truck.getSafetyTest())
            .withCountryCode(truck.getCountryCode())
            .withWeight(truck.getWeight());
    }


    public String getNumberPlate() {

        return numberPlate;
    }


    @JsonIgnore
    public String getCountryCode() {

        if (country != null) {
            return country.getCode();
        }

        return null;
    }


    @JsonIgnore
    public Instant getMinistryOfTransportTest() {

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


    @JsonProperty("st")
    public Boolean getSafetyTest() {

        return st;
    }


    public Boolean getSuitabilityDangerousGoods() {

        return suitabilityDangerousGoods;
    }


    public Boolean getSuitabilityWaste() {

        return suitabilityWaste;
    }


    @JsonIgnore
    public Quantity<Mass> getWeightTare() {

        if (weight != null) {
            return weight.getTare();
        }

        return null;
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
        private Instant mot;
        private EnvironmentBadge environmentBadge;
        private String type;
        private Boolean euAuthorization;
        private Boolean st;
        private Boolean suitabilityDangerousGoods;
        private Boolean suitabilityWaste;
        private Quantity<Mass> weightTare;

        private Builder() {
        }

        public Builder withNumberPlate(String numberPlate) {

            this.numberPlate = numberPlate;

            return this;
        }


        /**
         * @param  unLocode  2 characters (UN/LOCODE).
         *
         * @return  this
         */
        public Builder withCountryCode(String unLocode) {

            this.countryCode = unLocode;

            return this;
        }


        public Builder withMinistryOfTransportTest(Instant instant) {

            this.mot = instant;

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


        public Builder withSafetyTest(Boolean safetyTest) {

            this.st = safetyTest;

            return this;
        }


        public Builder isSuitableForDangerousGoods(Boolean suitabilityDangerousGoods) {

            this.suitabilityDangerousGoods = suitabilityDangerousGoods;

            return this;
        }


        public Builder isSuitableForWaste(Boolean suitabilityWaste) {

            this.suitabilityWaste = suitabilityWaste;

            return this;
        }


        public Builder withWeightTare(Double weightTare, MassUnit unit) {

            if (unit.equals(MassUnit.KILOGRAM)) {
                this.weightTare = Quantities.getQuantity(weightTare, KILOGRAM);
            } else if (unit.equals(MassUnit.TON)) {
                this.weightTare = UnitConverter.tonToKilogram(weightTare);
            }

            return this;
        }


        Builder withWeight(Weight weight) {

            if (weight != null) {
                this.weightTare = weight.getTare();
            }

            return this;
        }


        /**
         * Builds {@link Truck} without input validation.
         *
         * @return  new {@link Truck} with attributes specified in {@link Builder}
         */
        public Truck build() {

            Truck truck = new Truck();
            truck.mot = this.mot;
            truck.suitabilityWaste = this.suitabilityWaste;
            truck.euAuthorization = this.euAuthorization;
            truck.numberPlate = this.numberPlate;
            truck.environmentBadge = this.environmentBadge;

            if (weightTare != null) {
                Weight weight = new Weight();
                weight.setTare(this.weightTare);
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


        /**
         * Validates the input and builds {@link Truck}. Throws IllegalStateException if input doesn't fulfill the
         * minimum requirement of {@link Truck}.
         *
         * @return  new {@link Truck} with attributes specified in {@link Builder}
         */
        public Truck buildAndValidate() {

            Truck truck = this.build();

            MinimumRequirementValidator.validate(truck);

            return truck;
        }
    }
}
