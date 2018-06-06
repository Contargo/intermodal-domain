package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Chassis implements MeansOfTransport {

    /**
     * Format: spaces included.
     */
    private String numberPlate;

    /**
     * Format: DateTime ISO 8601
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

    public String getNumberPlate() {

        return numberPlate;
    }


    @JsonSerialize(using = InstantJsonSerializer.class)
    public Instant getMot() {

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

        return weight.getTare();
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

        public static Builder newChassis() {

            return new Builder();
        }


        public Builder withNumberPlate(String numberPlate) {

            this.numberPlate = numberPlate;

            return this;
        }


        public Builder withMot(Instant instant) {

            this.mot = instant;

            return this;
        }


        public Builder withType(String type) {

            this.type = type;

            return this;
        }


        public Builder withAxles(Integer axles) {

            this.axles = axles;

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


        public Builder withSt(Boolean st) {

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


        public Builder withSuitabilityReefer(Boolean suitabilityReefer) {

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


        public Chassis buildAndValidate() {

            Chassis chassis = this.build();

            Validator.validate(chassis);

            return chassis;
        }
    }
}
