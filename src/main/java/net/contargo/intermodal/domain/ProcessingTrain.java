package net.contargo.intermodal.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.Instant;

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
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant terminalEta;

    /**
     * Estimated Time of Departure (Format: ISO 8601 inclusive UTC)
     */
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant terminalEtd;

    /**
     * Estimated Time of Arrival (Format: ISO 8601 inclusive UTC)
     */
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant shuntingYardEta;

    private String shunter;

    /**
     * @name_german  Trassennummer
     */
    private String trainPaths;

    public static Builder newBuilder() {

        return new Builder();
    }


    public String getTrainTitle() {

        return trainTitle;
    }


    @JsonSerialize(using = InstantJsonSerializer.class)
    public Instant getTerminalEta() {

        return terminalEta;
    }


    @JsonSerialize(using = InstantJsonSerializer.class)
    public Instant getTerminalEtd() {

        return terminalEtd;
    }


    @JsonSerialize(using = InstantJsonSerializer.class)
    public Instant getShuntingYardEta() {

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


    @Override
    public String toString() {

        try {
            return this.getClass().getSimpleName() + ": " + JsonStringMapper.map(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static class Waggon {

        private String type;
        private String id;

        /**
         * @name_german  Verladelistewagenreihung
         * @note_english  driving direction sequence
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
        private Instant terminalEta;
        private Instant terminalEtd;
        private Instant shuntingYardEta;
        private String shunter;
        private String trainPaths;

        private Builder() {
        }

        public Builder withTrainTitle(String trainTitle) {

            this.trainTitle = trainTitle;

            return this;
        }


        public Builder withWaggon(String type, String id, Integer ranking, List<LUOrder> loadingPosition) {

            this.loadingList.add(new Waggon(type, id, ranking, loadingPosition));

            return this;
        }


        public Builder withTerminalEta(Instant instant) {

            this.terminalEta = instant;

            return this;
        }


        public Builder withTerminalEtd(Instant instant) {

            this.terminalEtd = instant;

            return this;
        }


        public Builder withShuntingYardEta(Instant instant) {

            this.shuntingYardEta = instant;

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
