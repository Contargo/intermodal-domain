package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.Instant;

import javax.validation.constraints.NotNull;


/**
 * Contains data for registration of {@link net.contargo.intermodal.domain.Barge barges} on handling points by
 * connecting barge, schedule and quantity information.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Anmeldung Binnenschiff
 * @name_english  registration barge
 * @definition_german  Enthält Daten für die Anmeldung von {@link net.contargo.intermodal.domain.Barge Binnenschiffen}
 *                     an Umschlagpunkten durch die Verknüpfung der Binnenschiffdaten mit Zeitplänen und Mengen.
 * @definition_english  Contains data for registration of {@link net.contargo.intermodal.domain.Barge barges} on
 *                      handling points by connecting barge, schedule and quantity information.
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
    private Instant eta;

    /**
     * Estimated Time of Departure (Format: ISO 8601 inclusive UTC)
     */
    @NotNull(message = "etd is part of minimum requirement and must not be null")
    @JsonDeserialize(using = InstantJsonDeserializer.class)
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

    public static Builder newBuilder() {

        return new Builder();
    }


    public Barge getBarge() {

        return barge;
    }


    @JsonSerialize(using = InstantJsonSerializer.class)
    public Instant getEta() {

        return eta;
    }


    @JsonSerialize(using = InstantJsonSerializer.class)
    public Instant getEtd() {

        return etd;
    }


    public DangerousGoods getDangerousGoodsIndication() {

        return dangerousGoodsIndication;
    }


    @JsonIgnore
    public Integer getVolumeToDischarge() {

        return volume.getToDischarge();
    }


    @JsonIgnore
    public Integer getVolumeToLoad() {

        return volume.getToLoad();
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


        public Builder withEta(Instant instant) {

            this.eta = instant;

            return this;
        }


        public Builder withEtd(Instant instant) {

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
}
