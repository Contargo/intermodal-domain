package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import tec.units.ri.quantity.Quantities;

import java.util.ArrayList;
import java.util.List;

import javax.measure.Quantity;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Temperature;

import javax.validation.constraints.NotNull;

import static tec.units.ri.unit.Units.CELSIUS;
import static tec.units.ri.unit.Units.KILOGRAM;


/**
 * The description of the process data of an {@link Order} for a {@link LoadingUnit}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Ladeeinheit Auftrag
 * @name_english  loading unit order
 * @synonym_german  LE Auftrag
 * @synonym_german  lu order
 * @definition_german  Die Beschreibung der Prozessdaten zu einem {@link Order Auftrag} für eine Ladeeinheit erfolgt in
 *                     dieser Gruppe durch die Verknüpfung von Auftragsdaten mit Daten zur Ladeeinheit. Insbesondere
 *                     Informationen zu Eigenheiten der Ladeeinheit inklusive dem transportierten Gut und zu
 *                     Operateuren sowie Transportrichtung sind hier gesammelt.
 * @definition_english  The description of the process data of an {@link Order} for a loading unit is made in this
 *                      class with the connection between order data and loading unit data. Especially information
 *                      about peculiarities of the loading unit including the transported goods and operators as well
 *                      as the direction of transport are collected here.
 * @minimum_requirement  loadingUnit, weightBrutto, weightNetto, weightTare, dangerousGoodsIndication, wasteIndication
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class LUOrder {

    private String reference;

    @NotNull(message = "loadingUnit is part of minimum requirement and must not be null")
    private LoadingUnit loadingUnit;

    @NotNull(message = "weight is part of minimum requirement and must not be null")
    @LUOrderWeightConstraint(message = "brutto, netto and tare are part of minimum requirement")
    private Weight weight;

    @NotNull(message = "dangerousGoodsIndication is part of minimum requirement and must not be null")
    private DangerousGoods dangerousGoodsIndication;

    @NotNull(message = "wasteIndication is part of minimum requirement and must not be null")
    private Waste wasteIndication;

    /**
     * For refrigerated containers (in °C).
     */
    @JsonDeserialize(using = QuantityJsonDeserializer.class)
    private Quantity<Temperature> setTemperature;

    private Operator operator;

    private Operator client;

    private Direction direction;

    private Customs customs;

    private String goods;

    private Boolean empty;

    @JsonProperty("seal")
    private List<Seal> seal;

    private LUOrder() {

        // OK
    }

    /**
     * Creates a new builder for {@link LUOrder}.
     *
     * @return  new builder
     */
    public static Builder newBuilder() {

        return new Builder();
    }


    /**
     * Creates a new builder with the values of another {@link LUOrder}.
     *
     * @param  luOrder  that should be copied.
     *
     * @return  new builder with values of given luOrder.
     */
    public static Builder newBuilder(LUOrder luOrder) {

        return new Builder().withOperator(luOrder.getOperator())
            .withCustoms(luOrder.getCustoms())
            .isEmpty(luOrder.isEmpty())
            .withSetTemperature(luOrder.getSetTemperature())
            .withDirection(luOrder.getDirection())
            .withLoadingUnit(luOrder.getLoadingUnit())
            .withClient(luOrder.getClient())
            .withDangerousGoodsIndication(luOrder.getDangerousGoodsIndication())
            .withWasteIndication(luOrder.getWasteIndication())
            .withGoods(luOrder.getGoods())
            .withReference(luOrder.getReference())
            .withSeals(luOrder.getSeals())
            .withWeight(luOrder.getWeight());
    }


    public static StepBuilder newStepBuilder(LUOrder copy) {

        StepBuilder stepBuilder = new StepBuilder();
        stepBuilder.reference = copy.reference;
        stepBuilder.setTemperature = copy.setTemperature;
        stepBuilder.operator = copy.operator;
        stepBuilder.client = copy.client;
        stepBuilder.direction = copy.direction;
        stepBuilder.customs = copy.customs;
        stepBuilder.goods = copy.goods;
        stepBuilder.empty = copy.empty;
        stepBuilder.seal = copy.seal;
        stepBuilder.wasteIndication = copy.wasteIndication;
        stepBuilder.dangerousGoodsIndication = copy.dangerousGoodsIndication;
        stepBuilder.weightBrutto = copy.getWeightBrutto();
        stepBuilder.weightNetto = copy.getWeightNetto();
        stepBuilder.weightTare = copy.getWeightTare();
        stepBuilder.loadingUnit = copy.loadingUnit;

        return stepBuilder;
    }


    public static ILoadingUnit newStepBuilder() {

        return new StepBuilder();
    }


    public String getReference() {

        return reference;
    }


    public LoadingUnit getLoadingUnit() {

        return loadingUnit;
    }


    @JsonIgnore
    public Quantity<Mass> getWeightBrutto() {

        if (weight != null) {
            return weight.getBrutto();
        }

        return null;
    }


    @JsonIgnore
    public Quantity<Mass> getWeightNetto() {

        if (weight != null) {
            return weight.getNetto();
        }

        return null;
    }


    @JsonIgnore
    public Quantity<Mass> getWeightTare() {

        if (weight != null) {
            return weight.getTare();
        }

        return null;
    }


    public DangerousGoods getDangerousGoodsIndication() {

        return dangerousGoodsIndication;
    }


    public Waste getWasteIndication() {

        return wasteIndication;
    }


    @JsonSerialize(using = QuantityJsonSerializer.class)
    public Quantity<Temperature> getSetTemperature() {

        return setTemperature;
    }


    @JsonIgnore
    public String getSetTemperatureUnit() {

        if (setTemperature != null) {
            return setTemperature.getUnit().getSymbol();
        }

        return null;
    }


    public Operator getOperator() {

        return operator;
    }


    public Operator getClient() {

        return client;
    }


    public Direction getDirection() {

        return direction;
    }


    public Customs getCustoms() {

        return customs;
    }


    public String getGoods() {

        return goods;
    }


    public Boolean isEmpty() {

        return empty;
    }


    @JsonProperty("seal")
    public List<Seal> getSeals() {

        return seal;
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


    public Weight getWeight() {

        return weight;
    }

    public interface IBuild {

        IBuild withReference(String reference);


        IBuild withSetTemperature(Integer temperature, TemperatureUnit unit);


        IBuild withOperator(Operator operator);


        IBuild withClient(Operator operator);


        IBuild withDirection(Direction direction);


        IBuild withCustoms(Customs customs);


        IBuild withGoods(String goods);


        IBuild isEmpty(Boolean isEmpty);


        IBuild withSeals(List<Seal> seals);


        IBuild withSeal(Seal seal);


        LUOrder build();


        LUOrder buildAndValidate();
    }

    public interface IWasteIndication {

        IBuild withWasteIndication(Waste waste);
    }

    public interface IDangerousGoodsIndication {

        IWasteIndication withDangerousGoodsIndication(DangerousGoods dangerousGoods);
    }

    public interface IWeightBrutto {

        IWeightNetto withWeightBrutto(Double weightBrutto, MassUnit unit);
    }

    public interface IWeightNetto {

        IWeightTare withWeightNetto(Double weightNetto, MassUnit unit);
    }

    public interface IWeightTare {

        IDangerousGoodsIndication withWeightTare(Double weightTare, MassUnit unit);
    }

    public interface ILoadingUnit {

        IWeightBrutto withLoadingUnit(LoadingUnit loadingUnit);
    }

    public static final class Builder {

        private String reference;
        private LoadingUnit loadingUnit;
        private Quantity<Mass> weightBrutto;
        private Quantity<Mass> weightNetto;
        private Quantity<Mass> weightTare;
        private DangerousGoods dangerousGoodsIndication;
        private Waste wasteIndication;
        private Quantity<Temperature> setTemperature;
        private Operator operator;
        private Operator client;
        private Direction direction;
        private Customs customs;
        private String goods;
        private Boolean empty;
        private List<Seal> seal = new ArrayList<>();

        private Builder() {
        }

        public Builder withReference(String reference) {

            this.reference = reference;

            return this;
        }


        public Builder withLoadingUnit(LoadingUnit loadingUnit) {

            this.loadingUnit = loadingUnit;

            return this;
        }


        public Builder withWeightBrutto(Double weightBrutto, MassUnit unit) {

            if (unit.equals(MassUnit.KILOGRAM)) {
                this.weightBrutto = Quantities.getQuantity(weightBrutto, KILOGRAM);
            } else if (unit.equals(MassUnit.TON)) {
                this.weightBrutto = UnitConverter.tonToKilogram(weightBrutto);
            }

            return this;
        }


        public Builder withWeightNetto(Double weightNetto, MassUnit unit) {

            if (unit.equals(MassUnit.KILOGRAM)) {
                this.weightNetto = Quantities.getQuantity(weightNetto, KILOGRAM);
            } else if (unit.equals(MassUnit.TON)) {
                this.weightNetto = UnitConverter.tonToKilogram(weightNetto);
            }

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
                this.weightBrutto = weight.getBrutto();
                this.weightNetto = weight.getNetto();
                this.weightTare = weight.getTare();
            }

            return this;
        }


        public Builder withDangerousGoodsIndication(DangerousGoods dangerousGoodsIndication) {

            this.dangerousGoodsIndication = dangerousGoodsIndication;

            return this;
        }


        public Builder withWasteIndication(Waste wasteIndication) {

            this.wasteIndication = wasteIndication;

            return this;
        }


        public Builder withSetTemperature(Integer setTemperature, TemperatureUnit unit) {

            if (unit.toUnit().equals(CELSIUS)) {
                this.setTemperature = Quantities.getQuantity(setTemperature, CELSIUS);
            }

            return this;
        }


        Builder withSetTemperature(Quantity<Temperature> setTemperature) {

            this.setTemperature = setTemperature;

            return this;
        }


        public Builder withOperator(Operator operator) {

            this.operator = operator;

            return this;
        }


        public Builder withClient(Operator client) {

            this.client = client;

            return this;
        }


        public Builder withDirection(Direction direction) {

            this.direction = direction;

            return this;
        }


        public Builder withCustoms(Customs customs) {

            this.customs = customs;

            return this;
        }


        public Builder withGoods(String goods) {

            this.goods = goods;

            return this;
        }


        public Builder isEmpty(Boolean empty) {

            this.empty = empty;

            return this;
        }


        public Builder withSeal(Seal seal) {

            this.seal.add(seal);

            return this;
        }


        public Builder withSeals(List<Seal> seals) {

            this.seal.addAll(seals);

            return this;
        }


        /**
         * Builds {@link LUOrder} without input validation.
         *
         * @return  new {@link LUOrder} with attributes specified in {@link Builder}
         */
        public LUOrder build() {

            LUOrder luOrder = new LUOrder();
            luOrder.operator = this.operator;
            luOrder.customs = this.customs;
            luOrder.empty = this.empty;
            luOrder.setTemperature = this.setTemperature;
            luOrder.direction = this.direction;
            luOrder.loadingUnit = this.loadingUnit;
            luOrder.client = this.client;
            luOrder.dangerousGoodsIndication = this.dangerousGoodsIndication;
            luOrder.wasteIndication = this.wasteIndication;
            luOrder.goods = this.goods;
            luOrder.reference = this.reference;
            luOrder.seal = this.seal;

            Weight weight = new Weight();
            weight.setNetto(this.weightNetto);
            weight.setBrutto(this.weightBrutto);
            weight.setTare(this.weightTare);
            luOrder.weight = weight;

            return luOrder;
        }


        /**
         * Validates the input and builds {@link LUOrder}. Throws IllegalStateException if input doesn't fulfill the
         * minimum requirement of {@link LUOrder}.
         *
         * @return  new {@link LUOrder} with attributes specified in {@link Builder}
         */
        public LUOrder buildAndValidate() {

            LUOrder LUOrder = this.build();

            MinimumRequirementValidator.validate(LUOrder);

            return LUOrder;
        }
    }

    public static final class StepBuilder implements IWasteIndication, IDangerousGoodsIndication, IWeightBrutto,
        IWeightNetto, IWeightTare, ILoadingUnit, IBuild {

        private String reference;
        private Quantity<Temperature> setTemperature;
        private Operator operator;
        private Operator client;
        private Direction direction;
        private Customs customs;
        private String goods;
        private Boolean empty;
        private List<Seal> seal = new ArrayList<>();
        @NotNull(message = "wasteIndication is part of minimum requirement and must not be null")
        private Waste wasteIndication;
        @NotNull(message = "dangerousGoodsIndication is part of minimum requirement and must not be null")
        private DangerousGoods dangerousGoodsIndication;
        @NotNull(message = "weight netto is part of minimum requirement and must not be null")
        private Quantity<Mass> weightBrutto;
        @NotNull(message = "weight brutto is part of minimum requirement and must not be null")
        private Quantity<Mass> weightNetto;
        @NotNull(message = "weight tare is part of minimum requirement and must not be null")
        private Quantity<Mass> weightTare;
        @NotNull(message = "loadingUnit is part of minimum requirement and must not be null")
        private LoadingUnit loadingUnit;

        private StepBuilder() {
        }

        @Override
        public IBuild withWasteIndication(Waste val) {

            wasteIndication = val;

            return this;
        }


        @Override
        public IWasteIndication withDangerousGoodsIndication(DangerousGoods val) {

            dangerousGoodsIndication = val;

            return this;
        }


        @Override
        public IWeightNetto withWeightBrutto(Double weightBrutto, MassUnit unit) {

            if (unit.equals(MassUnit.KILOGRAM)) {
                this.weightBrutto = Quantities.getQuantity(weightBrutto, KILOGRAM);
            } else if (unit.equals(MassUnit.TON)) {
                this.weightBrutto = UnitConverter.tonToKilogram(weightBrutto);
            }

            return this;
        }


        @Override
        public IWeightTare withWeightNetto(Double weightNetto, MassUnit unit) {

            if (unit.equals(MassUnit.KILOGRAM)) {
                this.weightNetto = Quantities.getQuantity(weightNetto, KILOGRAM);
            } else if (unit.equals(MassUnit.TON)) {
                this.weightNetto = UnitConverter.tonToKilogram(weightNetto);
            }

            return this;
        }


        @Override
        public IDangerousGoodsIndication withWeightTare(Double weightTare, MassUnit unit) {

            if (unit.equals(MassUnit.KILOGRAM)) {
                this.weightTare = Quantities.getQuantity(weightTare, KILOGRAM);
            } else if (unit.equals(MassUnit.TON)) {
                this.weightTare = UnitConverter.tonToKilogram(weightTare);
            }

            return this;
        }


        @Override
        public IWeightBrutto withLoadingUnit(LoadingUnit loadingUnit) {

            this.loadingUnit = loadingUnit;

            return this;
        }


        @Override
        public IBuild withReference(String reference) {

            this.reference = reference;

            return this;
        }


        @Override
        public IBuild withSetTemperature(Integer setTemperature, TemperatureUnit unit) {

            if (unit.toUnit().equals(CELSIUS)) {
                this.setTemperature = Quantities.getQuantity(setTemperature, CELSIUS);
            }

            return this;
        }


        @Override
        public IBuild withOperator(Operator operator) {

            this.operator = operator;

            return this;
        }


        @Override
        public IBuild withClient(Operator operator) {

            client = operator;

            return this;
        }


        @Override
        public IBuild withDirection(Direction direction) {

            this.direction = direction;

            return this;
        }


        @Override
        public IBuild withCustoms(Customs customs) {

            this.customs = customs;

            return this;
        }


        @Override
        public IBuild withGoods(String goods) {

            this.goods = goods;

            return this;
        }


        @Override
        public IBuild isEmpty(Boolean isEmpty) {

            empty = isEmpty;

            return this;
        }


        @Override
        public IBuild withSeals(List<Seal> seals) {

            this.seal.addAll(seals);

            return this;
        }


        @Override
        public IBuild withSeal(Seal seal) {

            this.seal.add(seal);

            return this;
        }


        /**
         * Builds {@link LUOrder} without input validation.
         *
         * @return  new {@link LUOrder} with attributes specified in {@link Builder}
         */
        @Override
        public LUOrder build() {

            LUOrder luOrder = new LUOrder();
            luOrder.loadingUnit = this.loadingUnit;
            luOrder.dangerousGoodsIndication = this.dangerousGoodsIndication;
            luOrder.wasteIndication = this.wasteIndication;
            luOrder.reference = this.reference;
            luOrder.setTemperature = this.setTemperature;
            luOrder.operator = this.operator;
            luOrder.client = this.client;
            luOrder.direction = this.direction;
            luOrder.customs = this.customs;
            luOrder.goods = this.goods;
            luOrder.empty = this.empty;
            luOrder.seal = this.seal;

            Weight weight = new Weight();
            weight.setBrutto(this.weightBrutto);
            weight.setNetto(this.weightNetto);
            weight.setTare(this.weightTare);
            luOrder.weight = weight;

            return luOrder;
        }


        /**
         * Validates the input and builds {@link LUOrder}. Throws IllegalStateException if input doesn't fulfill the
         * minimum requirement of {@link LUOrder}.
         *
         * @return  new {@link LUOrder} with attributes specified in {@link Builder}
         */
        @Override
        public LUOrder buildAndValidate() {

            LUOrder LUOrder = this.build();

            MinimumRequirementValidator.validate(LUOrder);

            return LUOrder;
        }
    }
}
