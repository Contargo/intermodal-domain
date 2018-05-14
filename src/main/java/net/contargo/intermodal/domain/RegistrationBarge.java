package net.contargo.intermodal.domain;

import net.contargo.intermodal.domain.DangerousGoods;
import net.contargo.intermodal.domain.utility.ISO8601DateFormatter;

import java.util.Date;

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
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class RegistrationBarge {

    @NotNull(message = "barge is part of minimum requirement")
    private net.contargo.intermodal.domain.Barge barge;

    /**
     * Estimated Time of Arrival (Format: ISO 8601 inclusive UTC)
     */
    @NotNull(message = "eta is part of minimum requirement")
    private String eta;

    /**
     * Estimated Time of Departure (Format: ISO 8601 inclusive UTC)
     */
    @NotNull(message = "etd is part of minimum requirement")
    private String etd;

    /**
     * Value is optional and can be null.
     */
    @NotNull(message = "dangerousGoodsIndication is part of minimum requirement")
    private DangerousGoods dangerousGoodsIndication;

    /**
     * Number of LUs.
     */
    @NotNull(message = "volumeToDischarge is part of minimum requirement")
    private Integer volumeToDischarge;

    /**
     * Number of LUs.
     */
    @NotNull(message = "volumeToLoad is part of minimum requirement")
    private Integer volumeToLoad;

    public Barge getBarge() {

        return barge;
    }


    public String getEta() {

        return eta;
    }


    public String getEtd() {

        return etd;
    }


    public DangerousGoods getDangerousGoodsIndication() {

        return dangerousGoodsIndication;
    }


    public Integer getVolumeToDischarge() {

        return volumeToDischarge;
    }


    public Integer getVolumeToLoad() {

        return volumeToLoad;
    }

    public static final class Builder {

        private Barge barge;
        private String eta;
        private String etd;
        private DangerousGoods dangerousGoodsIndication;
        private Integer volumeToDischarge;
        private Integer volumeToLoad;

        private Builder() {
        }

        public static Builder newRegistrationBarge() {

            return new Builder();
        }


        public Builder withBarge(Barge barge) {

            this.barge = barge;

            return this;
        }


        public Builder withEta(int year, int month, int day, int hour, int minute) {

            this.eta = ISO8601DateFormatter.format(year, month, day, hour, minute);

            return this;
        }


        public Builder withEtd(int year, int month, int day, int hour, int minute) {

            this.etd = ISO8601DateFormatter.format(year, month, day, hour, minute);

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


        public RegistrationBarge build() {

            RegistrationBarge registrationBarge = new RegistrationBarge();
            registrationBarge.barge = this.barge;
            registrationBarge.volumeToDischarge = this.volumeToDischarge;
            registrationBarge.volumeToLoad = this.volumeToLoad;
            registrationBarge.eta = this.eta;
            registrationBarge.etd = this.etd;
            registrationBarge.dangerousGoodsIndication = this.dangerousGoodsIndication;

            return registrationBarge;
        }


        public RegistrationBarge buildAndValidate() {

            RegistrationBarge registrationBarge = this.build();

            Validator.validate(registrationBarge);

            return registrationBarge;
        }
    }
}
