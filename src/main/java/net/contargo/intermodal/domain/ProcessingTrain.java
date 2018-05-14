package net.contargo.intermodal.domain;

import java.util.ArrayList;
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
    private String trainTitle;

    private List<Waggon> loadingList = new ArrayList<>();

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

    public String getTrainTitle() {

        return trainTitle;
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


    public List<Waggon> getLoadingList() {

        return loadingList;
    }

    public static class Waggon {

        private String type;
        private String id;

        /**
         * @name_german  Verladelistewagenreihung
         * @note  driving direction sequence
         */
        private Integer ranking;
        private List<LUOrder> loadingPosition = new ArrayList<>();

        private Waggon() {
        }


        private Waggon(String type, String id, Integer ranking, List<LUOrder> loadingPosition) {

            this.type = type;
            this.id = id;
            this.ranking = ranking;
            this.loadingPosition = loadingPosition;
        }

        public String getType() {

            return type;
        }


        public String getId() {

            return id;
        }


        public Integer getRanking() {

            return ranking;
        }


        public List<LUOrder> getLoadingPosition() {

            return loadingPosition;
        }
    }

    public static final class Builder {

        private String trainTitle;
        private List<Waggon> loadingList = new ArrayList<>();
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


        public Builder withTrainTitle(String trainTitle) {

            this.trainTitle = trainTitle;

            return this;
        }


        public Builder withWaggon(String type, String id, Integer ranking, List<LUOrder> loadingPosition) {

            this.loadingList.add(new Waggon(type, id, ranking, loadingPosition));

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
            processingTrain.shunter = this.shunter;
            processingTrain.trainTitle = this.trainTitle;
            processingTrain.shuntingYardEta = this.shuntingYardEta;
            processingTrain.loadingList = this.loadingList;
            processingTrain.trainPaths = this.trainPaths;
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
