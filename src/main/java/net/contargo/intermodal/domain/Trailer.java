package net.contargo.intermodal.domain;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.validation.constraints.NotNull;


/**
 * Trailer vehicle which has no front axle so a substantial part of its total weight is transferred to a tractor unit.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Sattelanhänger
 * @name_english  semi trailer
 * @synonym_german  Sattelauflieger, Trailer
 * @definition_german  Anhängerfahrzeug, bei dem anstelle der bei Gelenk-Deichselanhägern vorhandenen ersten Achse eine
 *                     Sattelvorrichtung angeordnet ist und ein wesentlicher Teil seines Gesamtgewichts auf eine
 *                     Sattelzugmaschine übertragen wird. (@see DIN 70010:2001, 2.3 — modifiziert, „(siehe 1.2.2.3.2)
 *                     (auch Deichselachse (Dolly))“ gestrichen, Anmerkung 1 hinzugefügt)
 * @definition_english  Trailer vehicle which has no front axle so a substantial part of its total weight is
 *                      transferred to a tractor unit. (@see DIN 70010:2001, 2.3 — modified, „(see 1.2.2.3.2) (auch
 *                      Deichselachse (Dolly))“ gestrichen, Anmerkung 1 hinzugefügt)
 * @minimum_requirement  type, size, craneable, also @see minimum requirements of {@link LoadingUnit}
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Trailer extends LoadingUnit {

    /**
     * e.g&#046; XL, ...
     */
    @NotNull(message = "type is part of minimum requirement")
    private String type;

    /**
     * in meter.
     */
    @NotNull(message = "size is part of minimum requirement")
    private Double size;

    @NotNull(message = "craneable is part of minimum requirement")
    private Boolean craneable;

    public Trailer withType(String type) {

        this.type = type;

        return this;
    }


    public Trailer withSize(double size) {

        this.size = size;

        return this;
    }


    public Trailer isCraneable(Boolean craneable) {

        this.craneable = craneable;

        return this;
    }


    public String getType() {

        return type;
    }


    public Double getSize() {

        return size;
    }


    public Boolean isCraneable() {

        return craneable;
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

        private String identification;
        private String number;
        private String type;
        private Double size;
        private Double weightBruttoMax;
        private Boolean craneable;
        private Double weightNettoMax;
        private Double weightTara;
        private String condition;
        private Boolean reefer;
        private String operator;

        private Builder() {
        }

        public static Builder newTrailer() {

            return new Builder();
        }


        public Builder withIdentification(String identification) {

            this.identification = identification;

            return this;
        }


        public Builder withNumber(String number) {

            this.number = number;

            return this;
        }


        public Builder withType(String type) {

            this.type = type;

            return this;
        }


        public Builder withSize(Double size) {

            this.size = size;

            return this;
        }


        public Builder withWeightBruttoMax(Double weightBruttoMax) {

            this.weightBruttoMax = weightBruttoMax;

            return this;
        }


        public Builder isCraneable(Boolean craneable) {

            this.craneable = craneable;

            return this;
        }


        public Builder withWeightNettoMax(Double weightNettoMax) {

            this.weightNettoMax = weightNettoMax;

            return this;
        }


        public Builder withWeightTara(Double weightTara) {

            this.weightTara = weightTara;

            return this;
        }


        public Builder withCondition(String condition) {

            this.condition = condition;

            return this;
        }


        public Builder isReefer(Boolean reefer) {

            this.reefer = reefer;

            return this;
        }


        public Builder withOperator(String operator) {

            this.operator = operator;

            return this;
        }


        public Trailer build() {

            Trailer trailer = new Trailer();
            trailer.setIdentification(identification);
            trailer.setNumber(number);
            trailer.setCondition(condition);
            trailer.setReefer(reefer);
            trailer.setOperator(operator);
            trailer.type = this.type;
            trailer.size = this.size;
            trailer.craneable = this.craneable;

            if (weightBruttoMax != null || weightNettoMax != null) {
                Weight weight = new Weight();
                weight.setBruttoMax(weightBruttoMax);
                weight.setNettoMax(weightNettoMax);
                weight.setTara(weightTara);
                trailer.setWeight(weight);
            }

            trailer.setCategory(LoadingUnitCategory.TRAILER);

            return trailer;
        }


        public Trailer buildAndValidate() {

            Trailer trailer = this.build();

            Validator.validate(trailer);

            return trailer;
        }
    }
}
