package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import tec.units.ri.quantity.Quantities;

import java.time.Instant;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import static tec.units.ri.unit.Units.KILOGRAM;
import static tec.units.ri.unit.Units.METRE;


/**
 * Trailer to transport loading units.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Fahrgestell
 * @name_english  chassis
 * @definition_german  Anhänger zur Beförderung von Ladeeinheiten.
 * @definition_english  Trailer to transport loading units.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Chassis {

    /**
     * Format: spaces included e.g. in Germany: DU CO 1782
     */
    private String numberPlate;

    /**
     * Validity Date in DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
     *
     * @name_english  Ministry of Transport Test
     * @name_german  Hauptuntersuchung
     */
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant mot;

    /**
     * e.g&#046; Multichassis.
     */
    private String type;

    private Integer axles;

    /**
     * in meter.
     */
    @JsonDeserialize(using = QuantityJsonDeserializer.class)
    private Quantity<Length> size;

    /**
     * in meter.
     */
    @JsonDeserialize(using = QuantityJsonDeserializer.class)
    private Quantity<Length> height;

    /**
     * @name_german  EU Zulassung
     */
    private Boolean euAuthorization;

    /**
     * @name_english  safety test
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
     * @name_german  Reefereignung
     */
    private Boolean suitabilityReefer;

    /**
     * in kg.
     */
    private Weight weight;

    private Chassis() {

        // OK
    }

    /**
     * Creates a new builder for {@link Chassis}.
     *
     * @return  new builder
     */
    public static Builder newBuilder() {

        return new Builder();
    }


    /**
     * Creates a new builder with the values of another {@link Chassis}.
     *
     * @param  chassis  that should be copied.
     *
     * @return  new builder with values of given chassis.
     */
    public static Builder newBuilder(Chassis chassis) {

        return new Builder().withNumberPlate(chassis.getNumberPlate())
            .withNumberOfAxles(chassis.getAxles())
            .withHeight(chassis.getHeight())
            .withEuAuthorization(chassis.getEuAuthorization())
            .withSecurityTest(chassis.getSt())
            .withType(chassis.getType())
            .withSize(chassis.getSize())
            .isSuitableForDangerousGoods(chassis.getSuitabilityDangerousGoods())
            .isSuitableForWaste(chassis.getSuitabilityWaste())
            .isSuitableForReefer(chassis.getSuitabilityReefer())
            .withMinistryOfTransportTest(chassis.getMinistryOfTransportTest())
            .withWeight(chassis.getWeight());
    }


    public String getNumberPlate() {

        return numberPlate;
    }


    @JsonSerialize(using = InstantJsonSerializer.class)
    @JsonProperty("mot")
    public Instant getMinistryOfTransportTest() {

        return mot;
    }


    public String getType() {

        return type;
    }


    public Integer getAxles() {

        return axles;
    }


    @JsonSerialize(using = QuantityJsonSerializer.class)
    public Quantity<Length> getSize() {

        return size;
    }


    @JsonSerialize(using = QuantityJsonSerializer.class)
    public Quantity<Length> getHeight() {

        return height;
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


    public Boolean getSuitabilityReefer() {

        return suitabilityReefer;
    }


    public Weight getWeight() {

        return weight;
    }


    @JsonIgnore
    public Quantity<Mass> getWeightTare() {

        if (weight != null) {
            return weight.getTare();
        }

        return null;
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
        private Instant mot;
        private String type;
        private Integer axles;
        private Quantity<Length> size;
        private Quantity<Length> height;
        private Boolean euAuthorization;
        private Boolean st;
        private Boolean suitabilityDangerousGoods;
        private Boolean suitabilityWaste;
        private Boolean suitabilityReefer;
        private Quantity<Mass> weightTare;

        private Builder() {
        }

        public Builder withNumberPlate(String numberPlate) {

            this.numberPlate = numberPlate;

            return this;
        }


        public Builder withMinistryOfTransportTest(Instant validityDate) {

            this.mot = validityDate;

            return this;
        }


        public Builder withType(String type) {

            this.type = type;

            return this;
        }


        public Builder withNumberOfAxles(Integer axles) {

            this.axles = axles;

            return this;
        }


        Builder withSize(Quantity<Length> size) {

            this.size = size;

            return this;
        }


        public Builder withSize(Double size, LengthUnit unit) {

            if (unit.equals(LengthUnit.METRE)) {
                this.size = Quantities.getQuantity(size, METRE);
            } else if (unit.equals(LengthUnit.FOOT)) {
                this.size = UnitConverter.footToMetre(size);
            }

            return this;
        }


        Builder withHeight(Quantity<Length> height) {

            this.height = height;

            return this;
        }


        public Builder withHeight(Double height, LengthUnit unit) {

            if (unit.equals(LengthUnit.METRE)) {
                this.height = Quantities.getQuantity(height, METRE);
            } else if (unit.equals(LengthUnit.FOOT)) {
                this.height = UnitConverter.footToMetre(height);
            }

            return this;
        }


        public Builder withEuAuthorization(Boolean euAuthorization) {

            this.euAuthorization = euAuthorization;

            return this;
        }


        public Builder withSecurityTest(Boolean st) {

            this.st = st;

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


        public Builder isSuitableForReefer(Boolean suitabilityReefer) {

            this.suitabilityReefer = suitabilityReefer;

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

            this.weightTare = weight.getTare();

            return this;
        }


        /**
         * Builds {@link Chassis} without input validation.
         *
         * @return  new {@link Chassis} with attributes specified in {@link Builder}
         */
        public Chassis build() {

            Chassis chassis = new Chassis();
            chassis.numberPlate = this.numberPlate;
            chassis.axles = this.axles;
            chassis.height = this.height;
            chassis.euAuthorization = this.euAuthorization;
            chassis.st = this.st;
            chassis.type = this.type;
            chassis.size = this.size;
            chassis.suitabilityWaste = this.suitabilityWaste;
            chassis.mot = this.mot;
            chassis.suitabilityDangerousGoods = this.suitabilityDangerousGoods;
            chassis.suitabilityReefer = this.suitabilityReefer;

            Weight weight = new Weight();
            weight.setTare(this.weightTare);
            chassis.weight = weight;

            return chassis;
        }


        /**
         * Validates the input and builds {@link Chassis}. Throws IllegalStateException if input doesn't fulfill the
         * minimum requirement of {@link Chassis}.
         *
         * @return  new {@link Chassis} with attributes specified in {@link Builder}
         */
        public Chassis buildAndValidate() {

            Chassis chassis = this.build();

            MinimumRequirementValidator.validate(chassis);

            return chassis;
        }
    }
}
