package api.loadingUnit;

import api.transport.Customs;
import api.transport.DangerousGoods;
import api.transport.Operator;
import api.transport.Waste;


/**
 * Describes the process data of an order for a {@link api.loadingUnit.LoadingUnit}.
 *
 * <p>In german Auftrag</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Order {

    // TODO - type: ?
    private Object reference;

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

    // TODO - type: ja / nein --> ja details @DangerousGoods
    private DangerousGoods dangerousGoodsIndication;

    // TODO - type: ja / nein --> ja details @Waste
    private Waste wasteIndication;

    /**
     * For refrigerated containers in °C.
     */
    private int setTemperature;

    private Operator operator;

    private Operator client;

    private Direction direction;

    // TODO - type: ja / nein --> ja details @Customs
    private Customs customs;

    // TODO - type: ?
    private Object goods;

    // TODO- type: ?
    private boolean empty;

    // TODO - type: {1-n}?
    private Object seal;

    // TODO - type: ?
    private Object sealType;

    // TODO - type: ?
    private Object sealNumber;
}
