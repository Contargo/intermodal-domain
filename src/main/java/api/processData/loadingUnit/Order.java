package api.processData.loadingUnit;

import api.masterData.customs.Customs;

import api.masterData.dangerousGoods.DangerousGoods;

import api.masterData.loadingUnit.LoadingUnit;

import api.masterData.operator.Operator;

import api.masterData.waste.Waste;

import java.util.List;


/**
 * Describes the process data of an order for a {@link api.masterData.loadingUnit.LoadingUnit}.
 *
 * <p>In german Auftrag</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Order {

    private String reference;

    private LoadingUnit loadingUnit;

    /**
     * in kg.
     */
    private double weightBrutto;

    /**
     * in kg.
     */
    private double weightNetto;

    /**
     * in kg.
     */
    private double weightTara;

    /**
     * Value is optional and can be null.
     */
    private DangerousGoods dangerousGoodsIndication;

    private Waste wasteIndication;

    /**
     * For refrigerated containers (in °C).
     */
    private int setTemperature;

    private Operator operator;

    private Operator client;

    private Direction direction;

    /**
     * Value is optional and can be null.
     */
    private Customs customs;

    private String goods;

    private boolean empty;

    private List<String> seal;

    private String sealType;

    private String sealNumber;
}
