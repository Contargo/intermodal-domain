package api.processData.loadingUnit;

import api.masterData.customs.Customs;

import api.masterData.dangerousGoods.DangerousGoods;

import api.masterData.loadingUnit.LoadingUnit;

import api.masterData.operator.Operator;

import api.masterData.waste.Waste;

import java.util.List;


/**
 * The description of the process data of an {@link api.processData.order.Order} for a
 * {@link api.masterData.loadingUnit.LoadingUnit}.
 *
 * <p>DIGIT_name: Ladeeinheit Auftrag</p>
 *
 * <p>DIGIT_english: loading unit order</p>
 *
 * <p>DIGIT_synonym: LE Auftrag</p>
 *
 * <p>DIGIT_synonym: lu order</p>
 *
 * <p>DIGIT_definition: Die Beschreibung der Prozessdaten zu einem {@link api.processData.order.Order Auftrag} für eine
 * Ladeeinheit erfolgt in dieser Gruppe durch die Verknüpfung von Auftragsdaten mit Daten zur Ladeeinheit. Insbesondere
 * Informationen zu Eigenheiten der Ladeeinheit inklusive dem transportierten Gut und zu Operateuren sowie
 * Transportrichtung sind hier gesammelt.</p>
 *
 * <p>DIGIT_definition_english: The description of the process data of an {@link api.processData.order.Order} for a
 * loading unit is made in this class with the connection between order data and loading unit data. Especially
 * information about peculiarities of the loading unit including the transported goods and operators as well as the
 * direction of transport are collected here.</p>
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

    /**
     * Value is optional and can be null.
     */
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
