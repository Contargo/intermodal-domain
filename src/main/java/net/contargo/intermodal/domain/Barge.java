package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import systems.uom.common.Imperial;

import tec.units.ri.quantity.Quantities;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import static systems.uom.common.USCustomary.FOOT;

import static tec.units.ri.unit.Units.METRE;


/**
 * A ship build to drive on inland waters and inland waterways.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Binnenschiff
 * @name_english  barge
 * @definition_german  Schiff, das zur Fahrt auf Binnengewässern und Binnenwasserstraßen konstruiert ist.
 * @definition_english  A ship build to drive on inland waters and inland waterways.
 * @note_german  Im Vergleich zum {@link Vessel Seeschiff} bestehen weniger Anforderungen an Stabilität, Navigation und
 *               Rettungsgerät, wohingegen spezielle Konstruktionen für die Brückendurchfahrt o. ä. notwendig sein
 *               können. Es gibt diverse Schiffstypen dieser Art, die für den Kombinierten Verkehr relevant sind, z. B.
 *               Containerschiffe, Lastkähne, Leichter bzw. Schubverbände, Koppelverbände.
 * @note_english  In comparison to a {@link Vessel} there are less requirements in means of stability, navigation and
 *                rescue devices but special constructions for navigating under bridges or or the like might be
 *                necessary. There are different types of barges that are relevant in combined traffic e.g. container
 *                ships, lighter and tug barges.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Barge implements MeansOfTransport {

    private String name;

    /**
     * Maritime Mobile Service Identity (9 digits).
     */
    private String mmsi;

    /**
     * European Number of Identification e.g. 040-059 for Germany.
     */
    private String eni;

    private Operator operator;

    /**
     * in meter.
     */
    @JsonDeserialize(using = QuantityJsonDeserializer.class)
    private Quantity<Length> length;

    /**
     * in meter.
     */
    @JsonDeserialize(using = QuantityJsonDeserializer.class)
    private Quantity<Length> width;

    /**
     * in meter.
     */
    @JsonDeserialize(using = QuantityJsonDeserializer.class)
    private Quantity<Length> draught;

    private Integer bays;

    private Integer rows;

    private Integer tiers;

    /**
     * @name_german  Gefahrguteignung
     */
    private Boolean suitabilityDangerousGoods;

    private Capacity capacity;

    public static Builder newBuilder() {

        return new Builder();
    }


    public String getName() {

        return name;
    }


    public String getMmsi() {

        return mmsi;
    }


    public String getEni() {

        return eni;
    }


    public Operator getOperator() {

        return operator;
    }


    @JsonIgnore
    public double getLengthValue() {

        return length.getValue().doubleValue();
    }


    @JsonSerialize(using = QuantityJsonSerializer.class)
    public Quantity<Length> getLength() {

        return length;
    }


    @JsonIgnore
    public String getLenghtUnit() {

        return length.getUnit().getSymbol();
    }


    @JsonIgnore
    public double getWidthValue() {

        return width.getValue().doubleValue();
    }


    @JsonIgnore
    public String getWidthUnit() {

        return width.getUnit().getSymbol();
    }


    @JsonSerialize(using = QuantityJsonSerializer.class)
    public Quantity<Length> getWidth() {

        return width;
    }


    @JsonIgnore
    public double getDraughtValue() {

        return draught.getValue().doubleValue();
    }


    @JsonIgnore
    public String getDraughtUnit() {

        return draught.getUnit().getSymbol();
    }


    @JsonSerialize(using = QuantityJsonSerializer.class)
    public Quantity<Length> getDraught() {

        return draught;
    }


    public Integer getBays() {

        return bays;
    }


    public Integer getRows() {

        return rows;
    }


    public Integer getTiers() {

        return tiers;
    }


    public Boolean getSuitabilityDangerousGoods() {

        return suitabilityDangerousGoods;
    }


    @JsonIgnore
    public Double getCapacityTeu() {

        return this.capacity.getTeu();
    }


    @JsonIgnore
    public Double getCapacityTons() {

        return this.capacity.getTons().doubleValue();
    }


    public Capacity getCapacity() {

        return this.capacity;
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

        private String name;
        private String mmsi;
        private String eni;
        private Operator operator;
        private Quantity<Length> length;
        private Quantity<Length> width;
        private Quantity<Length> draught;
        private Integer bays;
        private Integer rows;
        private Integer tiers;
        private Boolean suitabilityDangerousGoods;
        private Double capacityTeu;
        private Double capacityTons;

        private Builder() {
        }

        public Builder withName(String name) {

            this.name = name;

            return this;
        }


        public Builder withMmsi(String mmsi) {

            this.mmsi = mmsi;

            return this;
        }


        public Builder withEni(String eni) {

            this.eni = eni;

            return this;
        }


        public Builder withOperator(Operator operator) {

            this.operator = operator;

            return this;
        }


        public Builder withLength(Double length, LengthUnit unit) {

            if (unit.toUnit().equals(METRE)) {
                this.length = Quantities.getQuantity(length, METRE);
            } else if (unit.toUnit().equals(FOOT)) {
                this.length = UnitConverter.footToMetre(length);
            }

            return this;
        }


        public Builder withWidth(Double width, LengthUnit unit) {

            if (unit.toUnit().equals(METRE)) {
                this.width = Quantities.getQuantity(width, METRE);
            } else if (unit.toUnit().equals(FOOT)) {
                this.width = UnitConverter.footToMetre(width);
            }

            return this;
        }


        public Builder withDraught(Double draught, LengthUnit unit) {

            if (unit.toUnit().equals(METRE)) {
                this.draught = Quantities.getQuantity(draught, METRE);
            } else if (unit.toUnit().equals(FOOT)) {
                this.draught = UnitConverter.footToMetre(draught);
            }

            return this;
        }


        public Builder withBays(Integer bays) {

            this.bays = bays;

            return this;
        }


        public Builder withRows(Integer rows) {

            this.rows = rows;

            return this;
        }


        public Builder withTiers(Integer tiers) {

            this.tiers = tiers;

            return this;
        }


        public Builder withSuitabilityDangerousGoods(Boolean suitabilityDangerousGoods) {

            this.suitabilityDangerousGoods = suitabilityDangerousGoods;

            return this;
        }


        public Builder withCapacityTeu(Double capacityTeu) {

            this.capacityTeu = capacityTeu;

            return this;
        }


        public Builder withCapacityTons(Double capacity) {

            this.capacityTons = capacity;

            return this;
        }


        public Barge build() {

            Barge barge = new Barge();
            barge.name = this.name;
            barge.width = this.width;
            barge.draught = this.draught;
            barge.operator = this.operator;
            barge.length = this.length;
            barge.suitabilityDangerousGoods = this.suitabilityDangerousGoods;
            barge.bays = this.bays;
            barge.mmsi = this.mmsi;

            Capacity capacity = new Capacity();
            capacity.setTeu(this.capacityTeu);
            capacity.setTons(this.capacityTons);
            barge.capacity = capacity;

            barge.tiers = this.tiers;
            barge.rows = this.rows;
            barge.eni = this.eni;

            return barge;
        }


        public Barge buildAndValidate() {

            Barge barge = this.build();

            Validator.validate(barge);

            return barge;
        }
    }
}
