package net.contargo.intermodal.domain;

import net.contargo.intermodal.domain.utility.ISO8601DateFormatter;

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
public class ProcessingTrain {

    /**
     * @definition_english  product number or name.
     * @definition_german  Produktnummer oder Name
     */
    private String trainTitel;

    private List<String> loadingListWaggon;

    private List<String> loadingListWaggonType;

    private List<String> loadingListWaggonId;

    /**
     * @name_german  Verladelistewagenreihung
     * @note  driving direction sequence
     */
    private List<Integer> loadingListWaggonRanking;

    private List<LUOrder> loadingListWaggonLoadingPositionLuOrder;

    /**
     * Estimated Time of Arrival (Format: ISO 8601 inclusive UTC)
     */
    private String terminalEta;

    /**
     * Estimated Time of Departure (Format: ISO 8601 inclusive UTC)
     */
    private String terminalEtd;

    /**
     * Estimated Time of Arrival (Format: ISO 8601 inclusive UTC)
     */
    private String shuntingYardEta;

    private String shunter;

    /**
     * @name_german  Trassennummer
     */
    private String trainPaths;

    public String getTrainTitel() {

        return trainTitel;
    }


    public List<String> getLoadingListWaggon() {

        return loadingListWaggon;
    }


    public List<String> getLoadingListWaggonType() {

        return loadingListWaggonType;
    }


    public List<String> getLoadingListWaggonId() {

        return loadingListWaggonId;
    }


    public List<Integer> getLoadingListWaggonRanking() {

        return loadingListWaggonRanking;
    }


    public List<LUOrder> getLoadingListWaggonLoadingPositionLuOrder() {

        return loadingListWaggonLoadingPositionLuOrder;
    }


    public String getTerminalEta() {

        return terminalEta;
    }


    public String getTerminalEtd() {

        return terminalEtd;
    }


    public String getShuntingYardEta() {

        return shuntingYardEta;
    }


    public String getShunter() {

        return shunter;
    }


    public String getTrainPaths() {

        return trainPaths;
    }

    public static final class Builder {

        private String trainTitel;
        private List<String> loadingListWaggon;
        private List<String> loadingListWaggonType;
        private List<String> loadingListWaggonId;
        private List<Integer> loadingListWaggonRanking;
        private List<LUOrder> loadingListWaggonLoadingPositionLuOrder;
        private String terminalEta;
        private String terminalEtd;
        private String shuntingYardEta;
        private String shunter;
        private String trainPaths;

        private Builder() {
        }

        public static Builder newProcessingTrain() {

            return new Builder();
        }


        public Builder withTrainTitel(String trainTitel) {

            this.trainTitel = trainTitel;

            return this;
        }


        public Builder withLoadingListWaggon(List<String> loadingListWaggon) {

            this.loadingListWaggon = loadingListWaggon;

            return this;
        }


        public Builder withLoadingListWaggonType(List<String> loadingListWaggonType) {

            this.loadingListWaggonType = loadingListWaggonType;

            return this;
        }


        public Builder withLoadingListWaggonId(List<String> loadingListWaggonId) {

            this.loadingListWaggonId = loadingListWaggonId;

            return this;
        }


        public Builder withLoadingListWaggonRanking(List<Integer> loadingListWaggonRanking) {

            this.loadingListWaggonRanking = loadingListWaggonRanking;

            return this;
        }


        public Builder withLoadingListWaggonLoadingPositionLuOrder(
            List<LUOrder> loadingListWaggonLoadingPositionLuOrder) {

            this.loadingListWaggonLoadingPositionLuOrder = loadingListWaggonLoadingPositionLuOrder;

            return this;
        }


        public Builder withTerminalEta(int year, int month, int day, int hour, int minute) {

            this.terminalEta = ISO8601DateFormatter.format(year, month, day, hour, minute);

            return this;
        }


        public Builder withTerminalEtd(int year, int month, int day, int hour, int minute) {

            this.terminalEtd = ISO8601DateFormatter.format(year, month, day, hour, minute);

            return this;
        }


        public Builder withShuntingYardEta(int year, int month, int day, int hour, int minute) {

            this.shuntingYardEta = ISO8601DateFormatter.format(year, month, day, hour, minute);

            return this;
        }


        public Builder withShunter(String shunter) {

            this.shunter = shunter;

            return this;
        }


        public Builder withTrainPaths(String trainPaths) {

            this.trainPaths = trainPaths;

            return this;
        }


        public ProcessingTrain build() {

            ProcessingTrain processingTrain = new ProcessingTrain();
            processingTrain.loadingListWaggonLoadingPositionLuOrder = this.loadingListWaggonLoadingPositionLuOrder;
            processingTrain.shunter = this.shunter;
            processingTrain.trainTitel = this.trainTitel;
            processingTrain.loadingListWaggonRanking = this.loadingListWaggonRanking;
            processingTrain.shuntingYardEta = this.shuntingYardEta;
            processingTrain.loadingListWaggonType = this.loadingListWaggonType;
            processingTrain.loadingListWaggon = this.loadingListWaggon;
            processingTrain.trainPaths = this.trainPaths;
            processingTrain.loadingListWaggonId = this.loadingListWaggonId;
            processingTrain.terminalEtd = this.terminalEtd;
            processingTrain.terminalEta = this.terminalEta;

            return processingTrain;
        }


        public ProcessingTrain buildAndValidate() {

            ProcessingTrain processingTrain = this.build();

            Validator.validate(processingTrain);

            return processingTrain;
        }
    }
}
