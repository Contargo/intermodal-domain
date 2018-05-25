package net.contargo.intermodal.domain;

import javax.validation.constraints.NotNull;


/**
 * Case for the transport of goods for the change to another {@link MeansOfTransport means of transport}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Container
 * @name_english  Container
 * @definition_german  Behälter für den Gütertransport für den Wechsel von einer zur anderen
 *                     {@link MeansOfTransport Transportform}.
 * @definition_english  Case for the transport of goods for the change to another
 *                      {@link MeansOfTransport means of transport}.
 * @note_german  Containertypen können Flat-, Open-Top-, High-Cube-, Bulk-, ISO-, Reefer- oder Tank-Container sein.
 *               (@see DIN EN ISO 17261:2012-12, 3.14 — modifiziert, Änderung der Anmerkung)
 * @note_english  Container types can be flat, open top, high cube, bulk, ISO, reefer- or tank containers. (@see DIN EN
 *                ISO 17261:2012-12, 3.14 — modifiziert, Änderung der Anmerkung)
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 * @minimum_requirement  sizeType, type, size, also @see minimum requirements of {@link LoadingUnit}
 */
public class Container extends LoadingUnit {

    /**
     * ISO 6346 Container Size Type e.g. 20G0 for GENERAL PURPOSE CONTAINERS
     */
    @NotNull(message = "sizeType is part of minimum requirement")
    private String sizeType;

    /**
     * e.g. flat, open top, high cube, bulk, ISO, reefer- or tank containers.
     */
    @NotNull(message = "type is part of minimum requirement")
    private String type;

    /**
     * in foot.
     */
    @NotNull(message = "size is part of minimum requirement")
    private Integer size;

    public Container withSizeType(String sizeType) {

        this.sizeType = sizeType;

        return this;
    }


    public Container withType(String type) {

        this.type = type;

        return this;
    }


    public Container withSize(Integer size) {

        this.size = size;

        return this;
    }


    public String getSizeType() {

        return sizeType;
    }


    public String getType() {

        return type;
    }


    public Integer getSize() {

        return size;
    }


    @Override
    public String toString() {

        return "Container {" + String.format("identification='%s', ", super.getIdentification())
            + String.format("number='%s', ", super.getNumber()) + String.format("category='%s', ", super.getCategory())
            + String.format("weightBruttoMax='%s', ", super.getWeightBruttoMax())
            + String.format("weightNettoMax='%s', ", super.getWeightNettoMax())
            + String.format("weightTara='%s', ", super.getWeight())
            + String.format("condition='%s', ", super.getCondition())
            + String.format("reefer='%s', ", super.isReefer()) + String.format("operator='%s', ", super.getOperator())
            + String.format("size='%s', ", this.size) + String.format("type='%s', ", this.type)
            + String.format("sizeType='%s'", this.sizeType) + "}";
    }

    public static final class Builder {

        private String identification;
        private String number;
        private LoadingUnitCategory category;
        private Double weightBruttoMax;
        private Double weightNettoMax;
        private String sizeType;
        private Double weightTara;
        private String condition;
        private String type;
        private Boolean reefer;
        private Integer size;
        private String operator;

        private Builder() {
        }

        public static Builder newContainer() {

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


        public Builder withWeightNettoMax(Double weightNettoMax) {

            this.weightNettoMax = weightNettoMax;

            return this;
        }


        public Builder withSizeType(String sizeType) {

            this.sizeType = sizeType;

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


        public Builder withType(String type) {

            this.type = type;

            return this;
        }


        public Builder isReefer(Boolean reefer) {

            this.reefer = reefer;

            return this;
        }


        public Builder withSize(Integer size) {

            this.size = size;

            return this;
        }


        public Builder withOperator(String operator) {

            this.operator = operator;

            return this;
        }


        public Container build() {

            Container container = new Container();
            container.setIdentification(identification);
            container.setNumber(number);
            container.setCondition(condition);
            container.setReefer(reefer);
            container.setOperator(operator);
            container.sizeType = this.sizeType;
            container.type = this.type;
            container.size = this.size;

            Weight weight = new Weight();
            weight.setBruttoMax(weightBruttoMax);
            weight.setNettoMax(weightNettoMax);
            weight.setTara(weightTara);
            container.setWeight(weight);

            container.setCategory(LoadingUnitCategory.CONTAINER);

            return container;
        }


        public Container buildAndValidate() {

            Container container = this.build();

            Validator.validate(container);

            return container;
        }
    }
}
