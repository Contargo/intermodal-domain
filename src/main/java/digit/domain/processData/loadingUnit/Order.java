package digit.domain.processData.loadingUnit;

import digit.domain.masterData.customs.Customs;
import digit.domain.masterData.dangerousGoods.DangerousGoods;
import digit.domain.masterData.loadingUnit.LoadingUnit;
import digit.domain.masterData.operator.Operator;
import digit.domain.masterData.waste.Waste;

import java.util.List;


/**
 * The description of the process data of an {@link digit.domain.processData.order.Order} for a
 * {@link digit.domain.masterData.loadingUnit.LoadingUnit}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @DIGIT_name_german  Ladeeinheit Auftrag
 * @DIGIT_name_english  loading unit order
 * @DIGIT_synonym_german  LE Auftrag
 * @DIGIT_synonym_german  lu order
 * @DIGIT_definition_german  Die Beschreibung der Prozessdaten zu einem
 *                           {@link digit.domain.processData.order.Order Auftrag} für eine Ladeeinheit erfolgt in
 *                           dieser Gruppe durch die Verknüpfung von Auftragsdaten mit Daten zur Ladeeinheit.
 *                           Insbesondere Informationen zu Eigenheiten der Ladeeinheit inklusive dem transportierten
 *                           Gut und zu Operateuren sowie Transportrichtung sind hier gesammelt.
 * @DIGIT_definition_english  The description of the process data of an {@link digit.domain.processData.order.Order}
 *                            for a loading unit is made in this class with the connection between order data and
 *                            loading unit data. Especially information about peculiarities of the loading unit
 *                            including the transported goods and operators as well as the direction of transport are
 *                            collected here.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
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
