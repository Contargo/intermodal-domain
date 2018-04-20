package digit.domain.processData.processing;

import digit.domain.processData.loadingUnit.Order;

import java.util.Date;
import java.util.List;


/**
 * Contains all data needed for the processing of trains on handling points by connecting train data and schedules as
 * well as loading and shunting information.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @DIGIT_name  Abfertigung Zug
 * @DIGIT_name_english  processing train
 * @DIGIT_definition  Alle Daten für die Abwicklung von Zügen an Umschlagknoten werden durch die Verknüpfung von
 *                    Zugdaten, Fahrplänen, Beladung sowie Rangierinformationen erreicht.
 * @DIGIT_definition_english  Contains all data needed for the processing of trains on handling points by connecting
 *                            train data and schedules as well as loading and shunting information.
 */
public class Train {

    /**
     * product number/name.
     */
    private String trainTitel;

    private List<String> loadingListWaggon;

    private String loadingListWaggonType;

    private String loadingListWaggonId;

    private int loadingListWaggonRanking;

    private Order loadingListWaggonLoadingPositionLuOrder;

    /**
     * Estimated Time of Arrival (Format: ISO 8601 inclusive UTC)
     */
    private Date terminalEta;

    /**
     * Estimated Time of Departure (Format: ISO 8601 inclusive UTC)
     */
    private Date terminalEtd;

    /**
     * Estimated Time of Arrival (Format: ISO 8601 inclusive UTC)
     */
    private Date shuntingYardEta;

    private String shunter;

    private String trainPaths;
}