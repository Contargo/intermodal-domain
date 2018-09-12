package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.Instant;

import javax.validation.constraints.NotNull;


/**
 * Contains data for registration of {@link Barge barges} on handling points by connecting barge, schedule and quantity
 * information.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Anmeldung Binnenschiff
 * @name_english  registration barge
 * @definition_german  Enthält Daten für die Anmeldung von {@link Barge Binnenschiffen} an Umschlagpunkten durch die
 *                     Verknüpfung der Binnenschiffdaten mit Zeitplänen und Mengen.
 * @definition_english  Contains data for registration of {@link Barge barges} on handling points by connecting barge,
 *                      schedule and quantity information.
 * @minimum_requirement  barge, eta, etd, dangerousGoodsIndication, volume
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class RegistrationBarge {

    @NotNull(message = "barge is part of minimum requirement and must not be null")
    private Barge barge;

    /**
     * Estimated Time of Arrival (Format: ISO 8601 inclusive UTC)
     */
    @NotNull(message = "eta is part of minimum requirement and must not be null")
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    @JsonProperty("eta")
    @JsonSerialize(using = InstantJsonSerializer.class)
    private Instant eta;

    /**
     * Estimated Time of Departure (Format: ISO 8601 inclusive UTC)
     */
    @NotNull(message = "etd is part of minimum requirement and must not be null")
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    @JsonProperty("etd")
    @JsonSerialize(using = InstantJsonSerializer.class)
    private Instant etd;

    /**
     * Value is optional and can be null.
     */
    @NotNull(message = "dangerousGoodsIndication is part of minimum requirement and must not be null")
    private DangerousGoods dangerousGoodsIndication;

    /**
     * everything in number of LUs.
     */
    @NotNull(message = "volume is part of minimum requirement and must not be null")
    @RegistrationVolumeConstraint(message = "toDischarge and toLoad are part of the minimum Requirement of Volume")
    private Volume volume;

    private RegistrationBarge() {

        // OK
    }

    /**
     * Creates a new builder for {@link RegistrationBarge}.
     *
     * @return  new builder
     */
    public static Builder newBuilder() {

        return new Builder();
    }


    /**
     * Creates a new builder with the values of another {@link RegistrationBarge}.
     *
     * @param  registrationBarge  that should be copied.
     *
     * @return  new builder with values of given registrationBarge.
     */
    public static Builder newBuilder(RegistrationBarge registrationBarge) {

        return new Builder().withBarge(registrationBarge.getBarge())
            .withEstimatedTimeOfArrival(registrationBarge.getEstimatedTimeOfArrival())
            .withEstimatedTimeOfDeparture(registrationBarge.getEstimatedTimeOfDepature())
            .withDangerousGoodsIndication(registrationBarge.getDangerousGoodsIndication())
            .withVolume(registrationBarge.getVolume());
    }


    /**
     * Starts a new step builder pattern for {@link RegistrationBarge}. Other than the normal {@link Builder} the
     * {@link StepBuilder} will enforce the order in which fields are set to make sure the minimum requirements are
     * fulfilled.
     *
     * @return  IBarge
     */
    public static IBarge newStepBuilder() {

        return new StepBuilder();
    }


    public Barge getBarge() {

        return barge;
    }


    @JsonIgnore
    public Instant getEstimatedTimeOfArrival() {

        return eta;
    }


    @JsonIgnore
    public Instant getEstimatedTimeOfDepature() {

        return etd;
    }


    public DangerousGoods getDangerousGoodsIndication() {

        return dangerousGoodsIndication;
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


    public Volume getVolume() {

        return volume;
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

    public interface IBuild {

        RegistrationBarge build();


        RegistrationBarge buildAndValidate();
    }

    public interface IVolumeToDischarge {

        IVolumeToLoad withVolumeToDischarge(Integer volumeToDischarge);
    }

    public interface IVolumeToLoad {

        IBuild withVolumeToLoad(Integer volumeToLoad);
    }

    public interface IDangerousGoodsIndication {

        IVolumeToDischarge withDangerousGoodsIndication(DangerousGoods dangerousGoods);
    }

    public interface IEtd {

        IDangerousGoodsIndication withEstimatedTimeOfDeparture(Instant etd);
    }

    public interface IEta {

        IEtd withEstimatedTimeOfArrival(Instant eta);
    }

    public interface IBarge {

        IEta withBarge(Barge barge);
    }

    public static final class Builder {

        private Barge barge;
        private Instant eta;
        private Instant etd;
        private DangerousGoods dangerousGoodsIndication;
        private Integer volumeToDischarge;
        private Integer volumeToLoad;

        private Builder() {
        }

        public Builder withBarge(Barge barge) {

            this.barge = barge;

            return this;
        }


        public Builder withEstimatedTimeOfArrival(Instant instant) {

            this.eta = instant;

            return this;
        }


        public Builder withEstimatedTimeOfDeparture(Instant instant) {

            this.etd = instant;

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


        /**
         * Builds {@link RegistrationBarge} without input validation.
         *
         * @return  new {@link RegistrationBarge} with attributes specified in {@link Builder}
         */
        public RegistrationBarge build() {

            RegistrationBarge registrationBarge = new RegistrationBarge();
            registrationBarge.barge = this.barge;

            Volume volume = new Volume();
            volume.setToDischarge(this.volumeToDischarge);
            volume.setToLoad(this.volumeToLoad);
            registrationBarge.volume = volume;

            registrationBarge.eta = this.eta;
            registrationBarge.etd = this.etd;
            registrationBarge.dangerousGoodsIndication = this.dangerousGoodsIndication;

            return registrationBarge;
        }


        /**
         * Validates the input and builds {@link RegistrationBarge}. Throws IllegalStateException if input doesn't
         * fulfill the minimum requirement of {@link RegistrationBarge}.
         *
         * @return  new {@link RegistrationBarge} with attributes specified in {@link Builder}
         */
        public RegistrationBarge buildAndValidate() {

            RegistrationBarge registrationBarge = this.build();

            MinimumRequirementValidator.validate(registrationBarge);

            return registrationBarge;
        }
    }

    public static final class StepBuilder implements IVolumeToLoad, IVolumeToDischarge, IDangerousGoodsIndication,
        IEtd, IEta, IBarge, IBuild {

        @NotNull(message = "volume to discharge is part of minimum requirement and must not be null")
        private Integer volumeToDischarge;
        @NotNull(message = "volume to load is part of minimum requirement and must not be null")
        private Integer volumeToLoad;
        @NotNull(message = "dangerousGoodsIndication is part of minimum requirement and must not be null")
        private DangerousGoods dangerousGoodsIndication;
        @NotNull(message = "etd is part of minimum requirement and must not be null")
        private Instant etd;
        @NotNull(message = "eta is part of minimum requirement and must not be null")
        private Instant eta;
        @NotNull(message = "barge is part of minimum requirement and must not be null")
        private Barge barge;

        private StepBuilder() {
        }

        @Override
        public IVolumeToLoad withVolumeToDischarge(Integer volumeToDischarge) {

            this.volumeToDischarge = volumeToDischarge;

            return this;
        }


        @Override
        public IBuild withVolumeToLoad(Integer volumeToLoad) {

            this.volumeToLoad = volumeToLoad;

            return this;
        }


        @Override
        public IVolumeToDischarge withDangerousGoodsIndication(DangerousGoods dangerousGoods) {

            dangerousGoodsIndication = dangerousGoods;

            return this;
        }


        @Override
        public IDangerousGoodsIndication withEstimatedTimeOfDeparture(Instant etd) {

            this.etd = etd;

            return this;
        }


        @Override
        public IEtd withEstimatedTimeOfArrival(Instant eta) {

            this.eta = eta;

            return this;
        }


        @Override
        public IEta withBarge(Barge barge) {

            this.barge = barge;

            return this;
        }


        /**
         * Builds {@link RegistrationBarge} without input validation.
         *
         * @return  new {@link RegistrationBarge} with attributes specified in {@link Builder}
         */
        @Override
        public RegistrationBarge build() {

            RegistrationBarge registrationBarge = new RegistrationBarge();
            registrationBarge.barge = this.barge;

            Volume volume = new Volume();
            volume.setToDischarge(this.volumeToDischarge);
            volume.setToLoad(this.volumeToLoad);
            registrationBarge.volume = volume;

            registrationBarge.eta = this.eta;
            registrationBarge.etd = this.etd;
            registrationBarge.dangerousGoodsIndication = this.dangerousGoodsIndication;

            return registrationBarge;
        }


        /**
         * Validates the input and builds {@link RegistrationBarge}. Throws IllegalStateException if input doesn't
         * fulfill the minimum requirement of {@link RegistrationBarge}.
         *
         * @return  new {@link RegistrationBarge} with attributes specified in {@link Builder}
         */
        @Override
        public RegistrationBarge buildAndValidate() {

            RegistrationBarge registrationBarge = this.build();

            MinimumRequirementValidator.validate(registrationBarge);

            return registrationBarge;
        }
    }
}
