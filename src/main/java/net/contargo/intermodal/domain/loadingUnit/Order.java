package net.contargo.intermodal.domain.loadingUnit;

import net.contargo.intermodal.domain.Customs;
import net.contargo.intermodal.domain.DangerousGoods;
import net.contargo.intermodal.domain.Operator;
import net.contargo.intermodal.domain.Waste;

import java.util.List;


/**
 * The description of the process data of an {@link net.contargo.intermodal.domain.Order} for a
 * {@link net.contargo.intermodal.domain.loadingUnit.LoadingUnit}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Ladeeinheit Auftrag
 * @name_english  loading unit order
 * @synonym_german  LE Auftrag
 * @synonym_german  lu order
 * @definition_german  Die Beschreibung der Prozessdaten zu einem {@link net.contargo.intermodal.domain.Order Auftrag}
 *                     für eine Ladeeinheit erfolgt in dieser Gruppe durch die Verknüpfung von Auftragsdaten mit Daten
 *                     zur Ladeeinheit. Insbesondere Informationen zu Eigenheiten der Ladeeinheit inklusive dem
 *                     transportierten Gut und zu Operateuren sowie Transportrichtung sind hier gesammelt.
 * @definition_english  The description of the process data of an {@link net.contargo.intermodal.domain.Order} for a
 *                      loading unit is made in this class with the connection between order data and loading unit
 *                      data. Especially information about peculiarities of the loading unit including the transported
 *                      goods and operators as well as the direction of transport are collected here.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Order {

    private String reference;

    private LoadingUnit loadingUnit;

    /**
     * in kg.
     */
    private Double weightBrutto;

    /**
     * in kg.
     */
    private Double weightNetto;

    /**
     * in kg.
     */
    private Double weightTara;

    /**
     * Value can be null.
     */
    private DangerousGoods dangerousGoodsIndication;

    /**
     * Value can be null.
     */
    private Waste wasteIndication;

    /**
     * For refrigerated containers (in °C).
     */
    private Integer setTemperature;

    private Operator operator;

    private Operator client;

    private Direction direction;

    /**
     * Value is optional and can be null.
     */
    private Customs customs;

    private String goods;

    private Boolean empty;

    private List<String> seal;

    private String sealType;

    private String sealNumber;

    Order(OrderBuilder orderBuilder) {

        this.reference = orderBuilder.reference;
        this.loadingUnit = orderBuilder.loadingUnit;
        this.weightBrutto = orderBuilder.weightBrutto;
        this.weightNetto = orderBuilder.weightNetto;
        this.weightTara = orderBuilder.weightTara;
        this.dangerousGoodsIndication = orderBuilder.dangerousGoodsIndication;
        this.wasteIndication = orderBuilder.wasteIndication;
        this.setTemperature = orderBuilder.setTemperature;
        this.operator = orderBuilder.operator;
        this.client = orderBuilder.client;
        this.direction = orderBuilder.direction;
        this.customs = orderBuilder.customs;
        this.goods = orderBuilder.goods;
        this.empty = orderBuilder.empty;
        this.seal = orderBuilder.seal;
        this.sealType = orderBuilder.sealType;
        this.sealNumber = orderBuilder.sealNumber;
    }

    @Override
    public String toString() {

        return "Order {"
            + String.format("reference='%s', ", this.reference)
            + String.format("loadingUnit='%s', ", this.loadingUnit.toString())
            + String.format("weightBrutto='%s' ,", this.weightBrutto)
            + String.format("weightNetto='%s' ,", this.weightNetto)
            + String.format("weightTara='%s',", this.weightTara)
            + String.format("dangerousGoodsIndication='%s' ,", this.dangerousGoodsIndication.toString())
            + String.format("wasteIndication='%s' ,", this.wasteIndication.toString())
            + String.format("setTemperature='%s' ,", this.setTemperature)
            + String.format("operator='%s' ,", this.operator.toString())
            + String.format("client='%s' ,", this.client.toString())
            + String.format("direction='%s' ,", this.direction)
            + String.format("customs='%s' ,", this.customs.toString()) + String.format("goods='%s' ,", this.goods)
            + String.format("empty='%s' ,", this.empty) + String.format("seal='%s' ,", this.seal)
            + String.format("sealType='%s' ,", this.sealType) + String.format("sealNumber='%s'", this.sealNumber)
            + "}";
    }


    public static OrderBuilder newBuilder() {

        return new OrderBuilder();
    }


    public String getReference() {

        return reference;
    }


    public LoadingUnit getLoadingUnit() {

        return loadingUnit;
    }


    public Double getWeightBrutto() {

        return weightBrutto;
    }


    public Double getWeightNetto() {

        return weightNetto;
    }


    public Double getWeightTara() {

        return weightTara;
    }


    public DangerousGoods getDangerousGoodsIndication() {

        return dangerousGoodsIndication;
    }


    public Waste getWasteIndication() {

        return wasteIndication;
    }


    public Integer getSetTemperature() {

        return setTemperature;
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


    public List<String> getSeal() {

        return seal;
    }


    public String getSealType() {

        return sealType;
    }


    public String getSealNumber() {

        return sealNumber;
    }

    public static class OrderBuilder {

        private String reference;

        private LoadingUnit loadingUnit;

        /**
         * in kg.
         */
        private Double weightBrutto;

        /**
         * in kg.
         */
        private Double weightNetto;

        /**
         * in kg.
         */
        private Double weightTara;

        /**
         * Value can be null.
         */
        private DangerousGoods dangerousGoodsIndication;

        /**
         * Value can be null.
         */
        private Waste wasteIndication;

        /**
         * For refrigerated containers (in °C).
         */
        private Integer setTemperature;

        private Operator operator;

        private Operator client;

        private Direction direction;

        /**
         * Value is optional and can be null.
         */
        private Customs customs;

        private String goods;

        private Boolean empty;

        private List<String> seal;

        private String sealType;

        private String sealNumber;

        public OrderBuilder withReference(String reference) {

            this.reference = reference;

            return this;
        }


        public OrderBuilder withLoadingUnit(LoadingUnit loadingUnit) {

            this.loadingUnit = loadingUnit;

            return this;
        }


        public OrderBuilder withWeightBrutto(double weightBrutto) {

            this.weightBrutto = weightBrutto;

            return this;
        }


        public OrderBuilder withWeightNetto(double weightNetto) {

            this.weightNetto = weightNetto;

            return this;
        }


        public OrderBuilder withWeightTara(double weightTara) {

            this.weightTara = weightTara;

            return this;
        }


        public OrderBuilder withDangerousGoodsIndication(DangerousGoods dangerousGoodsIndication) {

            this.dangerousGoodsIndication = dangerousGoodsIndication;

            return this;
        }


        public OrderBuilder withWasteIndication(Waste wasteIndication) {

            this.wasteIndication = wasteIndication;

            return this;
        }


        public OrderBuilder withSetTemperature(Integer setTemperature) {

            this.setTemperature = setTemperature;

            return this;
        }


        public OrderBuilder withOperator(Operator operator) {

            this.operator = operator;

            return this;
        }


        public OrderBuilder withClient(Operator client) {

            this.client = client;

            return this;
        }


        public OrderBuilder withDirection(Direction direction) {

            this.direction = direction;

            return this;
        }


        public OrderBuilder withCustoms(Customs customs) {

            this.customs = customs;

            return this;
        }


        public OrderBuilder withGoods(String goods) {

            this.goods = goods;

            return this;
        }


        public OrderBuilder isEmpty(Boolean empty) {

            this.empty = empty;

            return this;
        }


        public OrderBuilder withSeal(List<String> seal) {

            this.seal = seal;

            return this;
        }


        public OrderBuilder withSealType(String sealType) {

            this.sealType = sealType;

            return this;
        }


        public OrderBuilder withSealNumber(String sealNumber) {

            this.sealNumber = sealNumber;

            return this;
        }


        public Order build() {

            validate();

            return new Order(this);
        }


        private void validate() {

            if (this.loadingUnit == null) {
                throw new IllegalStateException("Loading unit has to be set to create an order for a loading unit.");
            } else if (this.weightBrutto == null) {
                throw new IllegalStateException("Weight brutto has to be set to create an order for a loading unit.");
            } else if (this.weightNetto == null) {
                throw new IllegalStateException("Weight netto has to be set to create an order for a loading unit.");
            } else if (this.weightTara == null) {
                throw new IllegalStateException("Weight tara has to be set to create an order for a loading unit.");
            } else if (this.dangerousGoodsIndication == null) {
                throw new IllegalStateException(
                    "Dangerous goods indication has to be set to create an order for a loading unit.");
            } else if (this.wasteIndication == null) {
                throw new IllegalStateException(
                    "Waste indication has to be set to create an order for a loading unit.");
            }
        }
    }
}
