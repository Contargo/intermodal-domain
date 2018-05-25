package net.contargo.intermodal.domain;

import javax.validation.constraints.NotNull;


/**
 * Contains data for registration of trains by connecting its properties and load as well as schedules and shunting
 * information.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Anmeldung Zug
 * @name_english  registration train
 * @definition_german  Enthält Daten für die Anmeldung von Zügen durch die Verknüpfung aller Zugeigenschaften und
 *                     Beladungen sowie Zeitplänen und Rangierdaten. Die Zugbezeichnung ermöglicht zusammen mit der
 *                     Trassennummer eine eindeutige Identifizierung des Verkehrsmittels.
 * @definition_english  Contains data for registration of trains by connecting its properties and load as well as
 *                      schedules and shunting information. The train title in combination with the train paths is used
 *                      for clear identification.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class RegistrationTrain {

    /**
     * @definition_german  Produktnummer oder Name
     * @definition_english  product number or name
     */
    @NotNull(message = "trainTitle is part of minimum requirement")
    private String trainTitle;

    /**
     * @name_german  Eisenbahnverkehrsunternehmen
     * @abbreviation_german  EVU
     */
    @NotNull(message = "railwayOperator is part of minimum requirement")
    private Operator railwayOperator;

    /**
     * @note_english  only set this attribute if its value differs from railwayOperator
     */
    private Operator operator;

    /**
     * Estimated Time of Arrival (Format: ISO 8601 inclusive UTC)
     */
    @NotNull(message = "terminalEta is part of minimum requirement")
    private String terminalEta;

    /**
     * Estimated Time of Departure (Format: ISO 8601 inclusive UTC)
     */
    @NotNull(message = "terminalEtd is part of minimum requirement")
    private String terminalEtd;

    /**
     * Estimated Time of Arrival (Format: ISO 8601 inclusive UTC)
     */
    @NotNull(message = "shuntingYardEta is part of minimum requirement")
    private String shuntingYardEta;

    @NotNull(message = "shunter is part of minimum requirement")
    private String shunter;

    /**
     * in meter.
     */
    @NotNull(message = "totalLength is part of minimum requirement")
    private Double totalLength;

    @NotNull(message = "waggonQuantity is part of minimum requirement")
    private Integer waggonQuantity;

    private DangerousGoods dangerousGoodsIndication;

    /**
     * everything in number of LUs.
     */
    @NotNull(message = "volume is part of minimum requirement")
    @RegistrationVolumeConstraint(message = "toDischarge and toLoad are part of the minimum Requirement of Volume")
    private Volume volume;

    /**
     * @name_german  Trassennummer
     */
    @NotNull(message = "trainPaths is part of minimum requirement")
    private String trainPaths;

    public String getTrainTitle() {

        return trainTitle;
    }


    public Operator getRailwayOperator() {

        return railwayOperator;
    }


    public Operator getOperator() {

        return operator;
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


    public Double getTotalLength() {

        return totalLength;
    }


    public Integer getWaggonQuantity() {

        return waggonQuantity;
    }


    public Volume getVolume() {

        return volume;
    }


    public Integer getVolumeToDischarge() {

        return volume.getToDischarge();
    }


    public Integer getVolumeToLoad() {

        return volume.getToLoad();
    }


    public String getTrainPaths() {

        return trainPaths;
    }


    public DangerousGoods getDangerousGoodsIndication() {

        return dangerousGoodsIndication;
    }

    public static final class Builder {

        private String trainTitle;
        private Operator railwayOperator;
        private Operator operator;
        private String terminalEta;
        private String terminalEtd;
        private String shuntingYardEta;
        private String shunter;
        private Double totalLength;
        private Integer waggonQuantity;
        private DangerousGoods dangerousGoodsIndication;
        private Integer volumeToDischarge;
        private Integer volumeToLoad;
        private String trainPaths;

        private Builder() {
        }

        public static Builder newRegistrationTrain() {

            return new Builder();
        }


        public Builder withTrainTitle(String trainTitle) {

            this.trainTitle = trainTitle;

            return this;
        }


        public Builder withRailwayOperator(Operator railwayOperator) {

            this.railwayOperator = railwayOperator;

            return this;
        }


        public Builder withOperator(Operator operator) {

            this.operator = operator;

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


        public Builder withTotalLength(Double totalLength) {

            this.totalLength = totalLength;

            return this;
        }


        public Builder withWaggonQuantity(Integer waggonQuantity) {

            this.waggonQuantity = waggonQuantity;

            return this;
        }


        public Builder withDangerousGoodsIndication(DangerousGoods dangerousGoodsIndication) {

            this.dangerousGoodsIndication = dangerousGoodsIndication;

            return this;
        }


        public Builder withVolumeToDischarge(Integer volumeToDischarge) {

            this.volumeToDischarge = volumeToDischarge;

            return this;
        }


        public Builder withVolumeToLoad(Integer volumeToLoad) {

            this.volumeToLoad = volumeToLoad;

            return this;
        }


        public Builder withTrainPaths(String trainPaths) {

            this.trainPaths = trainPaths;

            return this;
        }


        public RegistrationTrain build() {

            RegistrationTrain registrationTrain = new RegistrationTrain();
            registrationTrain.totalLength = this.totalLength;
            registrationTrain.railwayOperator = this.railwayOperator;
            registrationTrain.operator = this.operator;
            registrationTrain.trainTitle = this.trainTitle;
            registrationTrain.shuntingYardEta = this.shuntingYardEta;
            registrationTrain.waggonQuantity = this.waggonQuantity;
            registrationTrain.dangerousGoodsIndication = this.dangerousGoodsIndication;
            registrationTrain.terminalEtd = this.terminalEtd;
            registrationTrain.terminalEta = this.terminalEta;
            registrationTrain.shunter = this.shunter;
            registrationTrain.trainPaths = this.trainPaths;

            Volume volume = new Volume();
            volume.setToDischarge(this.volumeToDischarge);
            volume.setToLoad(this.volumeToLoad);
            registrationTrain.volume = volume;

            return registrationTrain;
        }


        public RegistrationTrain buildAndValidate() {

            RegistrationTrain registrationBarge = this.build();

            Validator.validate(registrationBarge);

            return registrationBarge;
        }
    }
}
