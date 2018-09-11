package net.contargo.intermodal.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import tec.units.ri.quantity.Quantities;

import java.util.Optional;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import javax.validation.constraints.NotNull;

import static systems.uom.common.USCustomary.FOOT;

import static tec.units.ri.unit.Units.KILOGRAM;


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
 * @minimum_requirement  sizeType, type, size, @see also minimum requirements of {@link LoadingUnit}
 */
public class Container extends LoadingUnit {

    /**
     * ISO 6346 Container Size Type e.g. 20G0 for GENERAL PURPOSE CONTAINERS
     */
    @NotNull(message = "sizeType is part of minimum requirement and must not be null")
    private String sizeType;

    /**
     * e.g. flat, open top, high cube, bulk, ISO, reefer- or tank containers.
     */
    @NotNull(message = "type is part of minimum requirement and must not be null")
    private String type;

    /**
     * in foot.
     */
    @NotNull(message = "size is part of minimum requirement and must not be null")
    @JsonDeserialize(using = QuantityJsonDeserializer.class)
    private Quantity<Length> size;

    private Container() {

        // OK
    }

    /**
     * Creates a new builder for {@link Container}.
     *
     * @return  new builder
     */
    public static Builder newBuilder() {

        return new Builder();
    }


    /**
     * Creates a new builder with the values of another {@link Container}.
     *
     * @param  container  that should be copied.
     *
     * @return  new builder with values of given container.
     */
    public static Builder newBuilder(Container container) {

        return new Builder().withNumberAndIdentification(container.getNumber())
            .withCondition(container.getCondition())
            .isReefer(container.isReefer())
            .withOperator(container.getOperator())
            .withSizeType(container.sizeType)
            .withType(container.getType())
            .withSize(container.getSize())
            .withWeight(container.getWeight());
    }


    /**
     * Starts a new step builder pattern for {@link Container}. Other than the normal {@link Builder} the
     * {@link StepBuilder} will enforce the order in which fields are set to make sure the minimum requirements are
     * fulfilled.
     *
     * @return  INumber
     */
    public static INumber newStepBuilder() {

        return new StepBuilder();
    }


    public String getSizeType() {

        return sizeType;
    }


    public String getType() {

        return type;
    }


    @JsonSerialize(using = QuantityJsonSerializer.class)
    public Quantity<Length> getSize() {

        return size;
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

    public interface IBuild {

        IBuild withCondition(String condition);


        IBuild withCondition(LoadingUnitCondition loadingUnitCondition);


        IBuild withOperator(String operatorName);


        IBuild withWeightBruttoMax(Double weightBruttoMax, MassUnit unit);


        IBuild withWeightNettoMax(Double weightNettoMax, MassUnit unit);


        IBuild withWeightTare(Double weightTare, MassUnit unit);


        /**
         * Builds {@link Container} without input validation.
         *
         * @return  new {@link Container} with attributes specified in {@link StepBuilder}
         */
        Container build();


        /**
         * Validates the input and builds {@link Container}. Throws IllegalStateException if input doesn't fulfill the
         * minimum requirement of {@link Container}.
         *
         * @return  new {@link Container} with attributes specified in {@link Container}
         */
        Container buildAndValidate();
    }

    public interface INumber {

        IReefer withNumberAndIdentification(String number);


        IReefer withNumberAndIdentification(String number, LoadingUnitIdentification loadingUnitIdentification);
    }

    public interface IReefer {

        ISizeType isReefer(Boolean isReefer);
    }

    public interface ISize {

        IBuild withSize(Double size, LengthUnit unit);
    }

    public interface IType {

        ISize withType(String val);
    }

    public interface ISizeType {

        IType withSizeType(String val);
    }

    public static final class Builder {

        private String identification;
        private String number;
        private Quantity<Mass> weightBruttoMax;
        private Quantity<Mass> weightNettoMax;
        private String sizeType;
        private Quantity<Mass> weightTare;
        private String condition;
        private String type;
        private boolean reefer;
        private Quantity<Length> size;
        private String operator;

        private Builder() {
        }

        public Builder withNumberAndIdentification(String number,
            LoadingUnitIdentification loadingUnitIdentification) {

            number = checkIdentification(number, loadingUnitIdentification);

            this.number = number;
            this.identification = number;

            return this;
        }


        Builder withNumberAndIdentification(String number) {

            this.number = number;
            this.identification = number;

            return this;
        }


        public Builder withWeightBruttoMax(Double weightBruttoMax, MassUnit unit) {

            if (unit.equals(MassUnit.KILOGRAM)) {
                this.weightBruttoMax = Quantities.getQuantity(weightBruttoMax, KILOGRAM);
            } else if (unit.equals(MassUnit.TON)) {
                this.weightBruttoMax = UnitConverter.tonToKilogram(weightBruttoMax);
            }

            return this;
        }


        public Builder withWeightNettoMax(Double weightNettoMax, MassUnit unit) {

            if (unit.equals(MassUnit.KILOGRAM)) {
                this.weightNettoMax = Quantities.getQuantity(weightNettoMax, KILOGRAM);
            } else if (unit.equals(MassUnit.TON)) {
                this.weightNettoMax = UnitConverter.tonToKilogram(weightNettoMax);
            }

            return this;
        }


        public Builder withSizeType(String sizeType) {

            this.sizeType = sizeType;

            if (sizeType != null && sizeType.length() == 4) {
                getInformationFromSizeType();
            } else {
                throw new IllegalArgumentException(String.format(
                        "Invalid container size type \'%s\': Wrong length of sizeType.", sizeType));
            }

            return this;
        }


        private void getInformationFromSizeType() {

            Optional<Double> lengthFromSizeType = ISO6346SizeTypeConverter.getLengthFromSizeType(sizeType);

            lengthFromSizeType.ifPresent(length -> this.size = Quantities.getQuantity(length, FOOT));

            Optional<String> typeDesignationFromSizeType = ISO6346SizeTypeConverter.getTypeDesignationFromSizeType(
                    sizeType);

            typeDesignationFromSizeType.ifPresent(containerType -> this.type = containerType);
        }


        public Builder withWeightTare(Double weightTare, MassUnit unit) {

            if (unit.equals(MassUnit.KILOGRAM)) {
                this.weightTare = Quantities.getQuantity(weightTare, KILOGRAM);
            } else if (unit.equals(MassUnit.TON)) {
                this.weightTare = UnitConverter.tonToKilogram(weightTare);
            }

            return this;
        }


        public Builder withCondition(String condition) {

            this.condition = condition;

            return this;
        }


        public Builder withCondition(LoadingUnitCondition loadingUnitCondition) {

            this.condition = loadingUnitCondition.name();

            return this;
        }


        public Builder withType(String type) {

            this.type = type;

            return this;
        }


        Builder withWeight(Weight weight) {

            if (weight != null) {
                this.weightNettoMax = weight.getNettoMax();
                this.weightBruttoMax = weight.getBruttoMax();
                this.weightTare = weight.getTare();
            }

            return this;
        }


        public Builder isReefer(boolean reefer) {

            this.reefer = reefer;

            return this;
        }


        Builder withSize(Quantity<Length> size) {

            this.size = size;

            return this;
        }


        public Builder withSize(Double size, LengthUnit unit) {

            if (unit.equals(LengthUnit.FOOT) && size != null) {
                this.size = Quantities.getQuantity(size, FOOT);
            } else if (unit.equals(LengthUnit.METRE) && size != null) {
                this.size = UnitConverter.metreToFoot(size);
            }

            return this;
        }


        public Builder withOperator(String operator) {

            this.operator = operator;

            return this;
        }


        /**
         * Builds {@link Container} without input validation.
         *
         * @return  new {@link Container} with attributes specified in {@link Builder}
         */
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

            if (weightBruttoMax != null || weightNettoMax != null) {
                Weight weight = new Weight();
                weight.setBruttoMax(weightBruttoMax);
                weight.setNettoMax(weightNettoMax);
                weight.setTare(weightTare);
                container.setWeight(weight);
            }

            container.setCategory(LoadingUnitCategory.CONTAINER);

            return container;
        }


        /**
         * Validates the input and builds {@link Container}. Throws IllegalStateException if input doesn't fulfill the
         * minimum requirement of {@link Container}.
         *
         * @return  new {@link Container} with attributes specified in {@link Builder}
         */
        public Container buildAndValidate() {

            Container container = this.build();

            MinimumRequirementValidator.validate(container);

            return container;
        }
    }

    public static final class StepBuilder implements INumber, IReefer, ISize, IType, ISizeType, IBuild {

        @NotNull(message = "reefer is part of minimum requirement and must not be null")
        private boolean reefer;
        @NotNull(message = "size is part of minimum requirement and must not be null")
        private Quantity<Length> size;
        @NotNull(message = "type is part of minimum requirement and must not be null")
        private String type;
        @NotNull(message = "sizeType is part of minimum requirement and must not be null")
        private String sizeType;
        private String identification;
        private String number;
        private Quantity<Mass> weightBruttoMax;
        private Quantity<Mass> weightNettoMax;
        private Quantity<Mass> weightTare;
        private String condition;
        private String operator;

        private StepBuilder() {
        }

        @Override
        public IBuild withSize(Double size, LengthUnit unit) {

            if (unit.equals(LengthUnit.FOOT) && size != null) {
                this.size = Quantities.getQuantity(size, FOOT);
            } else if (unit.equals(LengthUnit.METRE) && size != null) {
                this.size = UnitConverter.metreToFoot(size);
            }

            return this;
        }


        @Override
        public ISize withType(String val) {

            type = val;

            return this;
        }


        @Override
        public IType withSizeType(String sizeType) {

            this.sizeType = sizeType;

            if (sizeType != null && sizeType.length() == 4) {
                getInformationFromSizeType();
            } else {
                throw new IllegalArgumentException(String.format(
                        "Invalid container size type \'%s\': Wrong length of sizeType.", sizeType));
            }

            return this;
        }


        @Override
        public IBuild withCondition(String condition) {

            this.condition = condition;

            return this;
        }


        @Override
        public IBuild withCondition(LoadingUnitCondition loadingUnitCondition) {

            this.condition = loadingUnitCondition.name();

            return this;
        }


        @Override
        public IBuild withOperator(String operator) {

            this.operator = operator;

            return this;
        }


        @Override
        public IBuild withWeightBruttoMax(Double weightBruttoMax, MassUnit unit) {

            if (unit.equals(MassUnit.KILOGRAM)) {
                this.weightBruttoMax = Quantities.getQuantity(weightBruttoMax, KILOGRAM);
            } else if (unit.equals(MassUnit.TON)) {
                this.weightBruttoMax = UnitConverter.tonToKilogram(weightBruttoMax);
            }

            return this;
        }


        @Override
        public IBuild withWeightNettoMax(Double weightNettoMax, MassUnit unit) {

            if (unit.equals(MassUnit.KILOGRAM)) {
                this.weightNettoMax = Quantities.getQuantity(weightNettoMax, KILOGRAM);
            } else if (unit.equals(MassUnit.TON)) {
                this.weightNettoMax = UnitConverter.tonToKilogram(weightNettoMax);
            }

            return this;
        }


        @Override
        public IBuild withWeightTare(Double weightTare, MassUnit unit) {

            if (unit.equals(MassUnit.KILOGRAM)) {
                this.weightTare = Quantities.getQuantity(weightTare, KILOGRAM);
            } else if (unit.equals(MassUnit.TON)) {
                this.weightTare = UnitConverter.tonToKilogram(weightTare);
            }

            return this;
        }


        @Override
        public Container build() {

            Container container = new Container();

            container.setCategory(LoadingUnitCategory.CONTAINER);

            container.setIdentification(identification);
            container.setNumber(number);
            container.setCondition(condition);
            container.setReefer(reefer);
            container.setOperator(operator);
            container.sizeType = this.sizeType;
            container.type = this.type;
            container.size = this.size;

            if (weightBruttoMax != null || weightNettoMax != null) {
                Weight weight = new Weight();
                weight.setBruttoMax(weightBruttoMax);
                weight.setNettoMax(weightNettoMax);
                weight.setTare(weightTare);
                container.setWeight(weight);
            }

            return container;
        }


        private void getInformationFromSizeType() {

            Optional<Double> lengthFromSizeType = ISO6346SizeTypeConverter.getLengthFromSizeType(sizeType);

            lengthFromSizeType.ifPresent(length -> this.size = Quantities.getQuantity(length, FOOT));

            Optional<String> typeDesignationFromSizeType = ISO6346SizeTypeConverter.getTypeDesignationFromSizeType(
                    sizeType);

            typeDesignationFromSizeType.ifPresent(containerType -> this.type = containerType);
        }


        @Override
        public Container buildAndValidate() {

            Container container = this.build();

            MinimumRequirementValidator.validate(container);

            return container;
        }


        @Override
        public IReefer withNumberAndIdentification(String number) {

            this.number = number;
            this.identification = number;

            return this;
        }


        @Override
        public IReefer withNumberAndIdentification(String number,
            LoadingUnitIdentification loadingUnitIdentification) {

            number = checkIdentification(number, loadingUnitIdentification);

            this.number = number;
            this.identification = number;

            return this;
        }


        @Override
        public ISizeType isReefer(Boolean isReefer) {

            this.reefer = isReefer;

            return this;
        }
    }
}
