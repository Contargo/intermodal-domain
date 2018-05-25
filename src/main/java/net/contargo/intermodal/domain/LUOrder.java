package net.contargo.intermodal.domain;

import java.util.List;

import javax.validation.constraints.NotNull;


/**
 * The description of the process data of an {@link net.contargo.intermodal.domain.Order} for a {@link LoadingUnit}.
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
 * @minimum_requirement  loadingUnit, weightBrutto, weightNetto, weightTara, dangerousGoodsIndication, wasteIndication
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class LUOrder {

    private String reference;

    @NotNull(message = "loadingUnit is part of minimum requirement")
    private LoadingUnit loadingUnit;

    /**
     * in kg.
     */
    @NotNull(message = "weightBrutto is part of minimum requirement")
    private Double weightBrutto;

    /**
     * in kg.
     */
    @NotNull(message = "weightNetto is part of minimum requirement")
    private Double weightNetto;

    /**
     * in kg.
     */
    @NotNull(message = "weightTara is part of minimum requirement")
    private Double weightTara;

    @NotNull(message = "dangerousGoodsIndication is part of minimum requirement")
    private DangerousGoods dangerousGoodsIndication;

    @NotNull(message = "wasteIndication is part of minimum requirement")
    private Waste wasteIndication;

    /**
     * For refrigerated containers (in °C).
     */
    private Integer setTemperature;

    private Operator operator;

    private Operator client;

    private Direction direction;

    private Customs customs;

    private String goods;

    private Boolean empty;

    private List<String> seal;

    private String sealType;

    private String sealNumber;

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


    @Override
    public String toString() {

        return "LUOrder {"
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

    public static final class Builder {

        private String reference;
        private LoadingUnit loadingUnit;
        private Double weightBrutto;
        private Double weightNetto;
        private Double weightTara;
        private DangerousGoods dangerousGoodsIndication;
        private Waste wasteIndication;
        private Integer setTemperature;
        private Operator operator;
        private Operator client;
        private Direction direction;
        private Customs customs;
        private String goods;
        private Boolean empty;
        private List<String> seal;
        private String sealType;
        private String sealNumber;

        private Builder() {
        }

        public static Builder newOrder() {

            return new Builder();
        }


        public Builder withReference(String reference) {

            this.reference = reference;

            return this;
        }


        public Builder withLoadingUnit(LoadingUnit loadingUnit) {

            this.loadingUnit = loadingUnit;

            return this;
        }


        public Builder withWeightBrutto(Double weightBrutto) {

            this.weightBrutto = weightBrutto;

            return this;
        }


        public Builder withWeightNetto(Double weightNetto) {

            this.weightNetto = weightNetto;

            return this;
        }


        public Builder withWeightTara(Double weightTara) {

            this.weightTara = weightTara;

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


        public Builder withSetTemperature(Integer setTemperature) {

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


        public Builder withSeal(List<String> seal) {

            this.seal = seal;

            return this;
        }


        public Builder withSealType(String sealType) {

            this.sealType = sealType;

            return this;
        }


        public Builder withSealNumber(String sealNumber) {

            this.sealNumber = sealNumber;

            return this;
        }


        public LUOrder build() {

            LUOrder LUOrder = new LUOrder();
            LUOrder.sealNumber = this.sealNumber;
            LUOrder.weightTara = this.weightTara;
            LUOrder.seal = this.seal;
            LUOrder.operator = this.operator;
            LUOrder.weightBrutto = this.weightBrutto;
            LUOrder.customs = this.customs;
            LUOrder.empty = this.empty;
            LUOrder.setTemperature = this.setTemperature;
            LUOrder.weightNetto = this.weightNetto;
            LUOrder.direction = this.direction;
            LUOrder.loadingUnit = this.loadingUnit;
            LUOrder.client = this.client;
            LUOrder.dangerousGoodsIndication = this.dangerousGoodsIndication;
            LUOrder.wasteIndication = this.wasteIndication;
            LUOrder.goods = this.goods;
            LUOrder.reference = this.reference;
            LUOrder.sealType = this.sealType;

            return LUOrder;
        }


        public LUOrder buildAndValidate() {

            LUOrder LUOrder = this.build();

            Validator.validate(LUOrder);

            return LUOrder;
        }
    }
}
