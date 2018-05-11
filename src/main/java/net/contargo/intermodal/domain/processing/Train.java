package net.contargo.intermodal.domain.processing;

import net.contargo.intermodal.domain.LUOrder;

import java.util.Date;
import java.util.List;


/**
 * Contains all data needed for the processing of trains on handling points by connecting train data and schedules as
 * well as loading and shunting information.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Abfertigung Zug
 * @name_english  processing train
 * @definition_german  Alle Daten für die Abwicklung von Zügen an Umschlagknoten werden durch die Verknüpfung von
 *                     Zugdaten, Fahrplänen, Beladung sowie Rangierinformationen erreicht.
 * @definition_english  Contains all data needed for the processing of trains on handling points by connecting train
 *                      data and schedules as well as loading and shunting information.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Train {

    /**
     * product number/name.
     */
    private String trainTitel;

    private List<String> loadingListWaggon;

    private String loadingListWaggonType;

    private String loadingListWaggonId;

    private Integer loadingListWaggonRanking;

    private LUOrder loadingListWaggonLoadingPositionLuLUOrder;

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
