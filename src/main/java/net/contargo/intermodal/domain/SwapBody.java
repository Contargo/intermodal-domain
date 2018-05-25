package net.contargo.intermodal.domain;

import javax.validation.constraints.NotNull;


/**
 * {@link LoadingUnit} intended for the transport of goods, optimized with regard to the dimensions of road vehicles
 * and equipped with gripping edges for the transfer between means of transport, usually between road/rail transport.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Wechselbrücke
 * @name_english  swap body
 * @abbreviation_english  SB
 * @synonym_german  Wechselbehälter, Wechselaufbau
 * @definition_german  Für den Gütertransport bestimmter Behälter, der im Hinblick auf die Abmessungen von
 *                     Straßenfahrzeugen optimiert wurde und mit Greifkanten für den Umschlag zwischen den
 *                     Verkehrsmitteln, in der Regel der Verkehrsträger Straße-Schiene, ausgestattet ist.
 * @definition_english  Loading unit intended for the transport of goods, optimized with regard to the dimensions of
 *                      road vehicles and equipped with gripping edges for the transfer between means of transport,
 *                      usually between road and rail transport.
 * @minimum_requirement  type, size, stackable, also @see minimum requirements of {@link LoadingUnit}
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class SwapBody extends LoadingUnit implements Wechselbrücke, Wechselaufbau, Wechselbehälter {

    /**
     * e.g. Klasse A, Klasse C (C715, C745, C765, C782), Open Top
     */
    @NotNull(message = "type is part of minimum requirement")
    private String type;

    /**
     * in foot.
     */
    @NotNull(message = "size is part of minimum requirement")
    private Double size;

    @NotNull(message = "stackable is part of minimum requirement")
    private Boolean stackable;

    public SwapBody withType(String type) {

        this.type = type;

        return this;
    }


    public SwapBody withSize(Double size) {

        this.size = size;

        return this;
    }


    public SwapBody isStackable(Boolean stackable) {

        this.stackable = stackable;

        return this;
    }


    public String getType() {

        return type;
    }


    public Double getSize() {

        return size;
    }


    public Boolean isStackable() {

        return stackable;
    }


    @Override
    public String toString() {

        return "SwapBody {" + String.format("identification='%s', ", super.getIdentification())
            + String.format("number='%s', ", super.getNumber()) + String.format("category='%s', ", super.getCategory())
            + String.format("weightBruttoMax='%s', ", super.getWeightBruttoMax())
            + String.format("weightNettoMax='%s', ", super.getWeightNettoMax())
            + String.format("weightTara='%s', ", super.getWeight())
            + String.format("condition='%s', ", super.getCondition())
            + String.format("reefer='%s', ", super.isReefer()) + String.format("operator='%s', ", super.getOperator())
            + String.format("type='%s', ", this.type) + String.format("size='%s', ", this.size)
            + String.format("stackable='%s'", this.stackable) + "}";
    }

    public static final class Builder {

        private String identification;
        private String number;
        private Double weightBruttoMax;
        private String type;
        private Double weightNettoMax;
        private Double weightTara;
        private Double size;
        private String condition;
        private Boolean stackable;
        private Boolean reefer;
        private String operator;

        private Builder() {
        }

        public static Builder newSwapBody() {

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


        public Builder withWeightBruttoMax(Double weightBruttoMax) {

            this.weightBruttoMax = weightBruttoMax;

            return this;
        }


        public Builder withType(String type) {

            this.type = type;

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


        public Builder withSize(Double size) {

            this.size = size;

            return this;
        }


        public Builder withCondition(String condition) {

            this.condition = condition;

            return this;
        }


        public Builder isStackable(Boolean stackable) {

            this.stackable = stackable;

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


        public SwapBody build() {

            SwapBody swapBody = new SwapBody();
            swapBody.setIdentification(identification);
            swapBody.setNumber(number);
            swapBody.setCondition(condition);
            swapBody.setReefer(reefer);
            swapBody.setOperator(operator);
            swapBody.stackable = this.stackable;
            swapBody.size = this.size;
            swapBody.type = this.type;

            Weight weight = new Weight();
            weight.setBruttoMax(weightBruttoMax);
            weight.setNettoMax(weightNettoMax);
            weight.setTara(weightTara);
            swapBody.setWeight(weight);

            swapBody.setCategory(LoadingUnitCategory.SWAP_BODY);

            return swapBody;
        }


        public SwapBody buildAndValidate() {

            SwapBody swapBody = this.build();

            Validator.validate(swapBody);

            return swapBody;
        }
    }
}

interface Wechselbrücke {
}

interface Wechselbehälter {
}

interface Wechselaufbau {
}
