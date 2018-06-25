package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import tec.units.ri.quantity.Quantities;

import java.time.Instant;

import javax.measure.Quantity;
import javax.measure.quantity.Length;

import javax.validation.constraints.NotNull;

import static tec.units.ri.unit.Units.METRE;


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
 * @minimum_requirement  trainTitle, railwayOperator, terminalEta, terminalEtd, shuntingYardEta, shunter, totalLength,
 *                       waggonQuantity, volume to discharge and to load, trainPaths
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class RegistrationTrain {

    /**
     * @definition_german  Produktnummer oder Name
     * @definition_english  product number or name
     */
    @NotNull(message = "trainTitle is part of minimum requirement and must not be null")
    private String trainTitle;

    /**
     * @name_german  Eisenbahnverkehrsunternehmen
     * @abbreviation_german  EVU
     */
    @NotNull(message = "railwayOperator is part of minimum requirement and must not be null")
    private Operator railwayOperator;

    /**
     * @note_english  only set this attribute if its value differs from railwayOperator
     */
    private Operator operator;

    /**
     * Estimated Time of Arrival (Format: ISO 8601 inclusive UTC)
     */
    @NotNull(message = "terminalEta is part of minimum requirement and must not be null")
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant terminalEta;

    /**
     * Estimated Time of Departure (Format: ISO 8601 inclusive UTC)
     */
    @NotNull(message = "terminalEtd is part of minimum requirement and must not be null")
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant terminalEtd;

    /**
     * Estimated Time of Arrival (Format: ISO 8601 inclusive UTC)
     */
    @NotNull(message = "shuntingYardEta is part of minimum requirement and must not be null")
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant shuntingYardEta;

    @NotNull(message = "shunter is part of minimum requirement and must not be null")
    private String shunter;

    /**
     * in meter.
     */
    @NotNull(message = "totalLength is part of minimum requirement and must not be null")
    @JsonDeserialize(using = QuantityJsonDeserializer.class)
    private Quantity<Length> totalLength;

    @NotNull(message = "waggonQuantity is part of minimum requirement and must not be null")
    private Integer waggonQuantity;

    private DangerousGoods dangerousGoodsIndication;

    /**
     * everything in number of LUs.
     */
    @NotNull(message = "volume is part of minimum requirement and must not be null")
    @RegistrationVolumeConstraint(message = "toDischarge and toLoad are part of the minimum Requirement of Volume")
    private Volume volume;

    /**
     * @name_german  Trassennummer
     */
    @NotNull(message = "trainPaths is part of minimum requirement and must not be null")
    private String trainPaths;

    /**
     * Creates a new builder for {@link RegistrationTrain}.
     *
     * @return  new builder
     */
    public static Builder newBuilder() {

        return new Builder();
    }


    /**
     * Creates a new builder with the values of another {@link RegistrationTrain}.
     *
     * @param  registrationTrain  that should be copied.
     *
     * @return  new builder with values of given registrationTrain.
     */
    public static Builder newBuilder(RegistrationTrain registrationTrain) {

        return new Builder().withTotalLength(registrationTrain.getTotalLength())
            .withRailwayOperator(registrationTrain.getRailwayOperator())
            .withOperator(registrationTrain.getOperator())
            .withTrainTitle(registrationTrain.getTrainTitle())
            .withShuntingYardEta(registrationTrain.getShuntingYardEta())
            .withWaggonQuantity(registrationTrain.getWaggonQuantity())
            .withDangerousGoodsIndication(registrationTrain.getDangerousGoodsIndication())
            .withTerminalEtd(registrationTrain.getTerminalEtd())
            .withTerminalEta(registrationTrain.getTerminalEta())
            .withShunter(registrationTrain.getShunter())
            .withTrainPaths(registrationTrain.getTrainPaths())
            .withVolume(registrationTrain.getVolume());
    }


    public String getTrainTitle() {

        return trainTitle;
    }


    public Operator getRailwayOperator() {

        return railwayOperator;
    }


    public Operator getOperator() {

        return operator;
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


    @JsonSerialize(using = QuantityJsonSerializer.class)
    public Quantity<Length> getTotalLength() {

        return totalLength;
    }


    public Integer getWaggonQuantity() {

        return waggonQuantity;
    }


    public Volume getVolume() {

        return volume;
    }


    @JsonIgnore
    public Integer getVolumeToDischarge() {

        if (volume != null) {
            return volume.getToDischarge();
        }

        return null;
    }


    @JsonIgnore
    public Integer getVolumeToLoad() {

        if (volume != null) {
            return volume.getToLoad();
        }

        return null;
    }


    public String getTrainPaths() {

        return trainPaths;
    }


    public DangerousGoods getDangerousGoodsIndication() {

        return dangerousGoodsIndication;
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

    public static final class Builder {

        private String trainTitle;
        private Operator railwayOperator;
        private Operator operator;
        private Instant terminalEta;
        private Instant terminalEtd;
        private Instant shuntingYardEta;
        private String shunter;
        private Quantity<Length> totalLength;
        private Integer waggonQuantity;
        private DangerousGoods dangerousGoodsIndication;
        private Integer volumeToDischarge;
        private Integer volumeToLoad;
        private String trainPaths;

        private Builder() {
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


        public Builder withTotalLength(Double totalLength, LengthUnit unit) {

            if (unit.equals(LengthUnit.METRE)) {
                this.totalLength = Quantities.getQuantity(totalLength, METRE);
            } else if (unit.equals(LengthUnit.FOOT)) {
                this.totalLength = UnitConverter.footToMetre(totalLength);
            }

            return this;
        }


        Builder withTotalLength(Quantity<Length> totalLength) {

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


        Builder withVolume(Volume volume) {

            if (volume != null) {
                this.volumeToDischarge = volume.getToDischarge();
                this.volumeToLoad = volume.getToLoad();
            }

            return this;
        }


        public Builder withTrainPaths(String trainPaths) {

            this.trainPaths = trainPaths;

            return this;
        }


        /**
         * Builds {@link RegistrationTrain} without input validation.
         *
         * @return  new {@link RegistrationTrain} with attributes specified in {@link Builder}
         */
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


        /**
         * Validates the input and builds {@link RegistrationTrain}. Throws IllegalStateException if input doesn't
         * fulfill the minimum requirement of {@link RegistrationTrain}.
         *
         * @return  new {@link RegistrationTrain} with attributes specified in {@link Builder}
         */
        public RegistrationTrain buildAndValidate() {

            RegistrationTrain registrationBarge = this.build();

            MinimumRequirementValidator.validate(registrationBarge);

            return registrationBarge;
        }
    }
}
