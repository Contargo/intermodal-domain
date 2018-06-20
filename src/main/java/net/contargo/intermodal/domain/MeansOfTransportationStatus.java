package net.contargo.intermodal.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.Instant;


/**
 * Status of means of transport for communication flow of intermodal freight transport.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Verkehrsmittelstatus
 * @name_english  means of transportation status
 * @definition_german  Verkehrsmittelstatus für den Informationsfluss in der intermodalen Kette. Über den
 *                     Verkehrsmittelstatus und den {@link StatusLU Ladeeinheitenstatus} kann ein reibungsloser
 *                     Austausch zwischen den Akteuren sichergestellt werden. Prinzipiell sollten die beiden Status als
 *                     Paket verstanden werden. Die Kerndaten sind jeweils immer gleich und werden durch den jeweiligen
 *                     Status konkretisiert. Dabei gibt es zwei Blöcke pro Statuspaket. Zum einen die Identifikation
 *                     des Handelnden inklusive Begleitinformationen und zum anderen die Konkretisierung was genau zu
 *                     welchem Zeitpunkt passiert. Begleitinformationen beim Verkehrsmittel betreffen die
 *                     Transportrelation.
 * @definition_english  Status of means of transport for communication flow of intermodal freight transport. The means
 *                      of transportation status and {@link StatusLU loading unit status} ensure a fluent exchange
 *                      between actors. Both statuses should be seen as package. Their core data is similar and is
 *                      concretized by their status. There are two blocks per status package. On one hand the
 *                      identification of the doer on the other hand the schedule of the different operational steps.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class MeansOfTransportationStatus {

    /**
     * Actual Time of Departure of the {@link MeansOfTransport MoT} at the handling point (Format: ISO 8601 inclusive
     * UTC).
     *
     * @name_german  Abfahrt
     * @definition_german  Tatsächliche Abfahrt des {@link MeansOfTransport VM} beim Verlassen des Umschlagpunktes.
     */
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant atd;

    /**
     * Estimated Time of Arrival of the {@link MeansOfTransport MoT} at the handling point (Format: ISO 8601 inclusive
     * UTC).
     *
     * @name_german  Avisiert
     * @definition_german  Geplante Ankunft des {@link MeansOfTransport VM} am Umschlagpunkt.
     */
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant eta;

    /**
     * Actual Time of Arrival of the {@link MeansOfTransport MoT} at the handling point (Format: ISO 8601 inclusive
     * UTC).
     *
     * @name_german  Ankunft
     * @definition_german  Tatsächliche Ankunft des {@link MeansOfTransport VM} am Umschlagpunkt.
     */
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant ata;

    /**
     * {@link MeansOfTransport MoT} is ready for handling of the {@link LoadingUnit LU} (Format: ISO 8601 inclusive
     * UTC).
     *
     * @name_german  Bereitstellung
     * @synonym_german  Bearbeitungsstart
     * @abbreviation_german  BS
     * @definition_german  {@link MeansOfTransport VM} ist bereit für den Umschlag der {@link LoadingUnit LE} („erste
     *                     Kranung“).
     */
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant handlingStart;

    /**
     * {@link MeansOfTransport MoT} is loaded, end of loading process (Format: ISO 8601 inclusive UTC).
     *
     * @name_german  Bearbeitungsende
     * @synonym_german  Ladeschluss
     * @abbreviation_german  BE
     * @definition_german  {@link MeansOfTransport VM} beladen, Ende Verladung erreicht („letzte Kranung“).
     */
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant handlingEnd;

    /**
     * Safety control of the loaded waggons.
     *
     * @name_german  Wagentechnische Untersuchung
     * @abbreviation_german  WTU
     * @definition_german  Kontrolle der Betriebssicherheit der Waggons mit Ladung.
     */
    private Integer waggonTechnicalInspection;

    public static Builder newBuilder() {

        return new Builder();
    }


    @JsonSerialize(using = InstantJsonSerializer.class)
    public Instant getAtd() {

        return atd;
    }


    @JsonSerialize(using = InstantJsonSerializer.class)
    public Instant getEta() {

        return eta;
    }


    @JsonSerialize(using = InstantJsonSerializer.class)
    public Instant getAta() {

        return ata;
    }


    @JsonSerialize(using = InstantJsonSerializer.class)
    public Instant getHandlingStart() {

        return handlingStart;
    }


    @JsonSerialize(using = InstantJsonSerializer.class)
    public Instant getHandlingEnd() {

        return handlingEnd;
    }


    public Integer getWaggonTechnicalInspection() {

        return waggonTechnicalInspection;
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

        private Instant atd;
        private Instant eta;
        private Instant ata;
        private Instant handlingStart;
        private Instant handlingEnd;
        private Integer waggonTechnicalInspection;

        private Builder() {
        }

        public Builder withAtd(Instant instant) {

            this.atd = instant;

            return this;
        }


        public Builder withEta(Instant instant) {

            this.eta = instant;

            return this;
        }


        public Builder withAta(Instant instant) {

            this.ata = instant;

            return this;
        }


        public Builder withHandlingStart(Instant instant) {

            this.handlingStart = instant;

            return this;
        }


        public Builder withHandlingEnd(Instant instant) {

            this.handlingEnd = instant;

            return this;
        }


        public Builder withWaggonTechnicalInspection(Integer waggonTechnicalInspection) {

            this.waggonTechnicalInspection = waggonTechnicalInspection;

            return this;
        }


        /**
         * Builds {@link MeansOfTransportationStatus} without input validation.
         *
         * @return  new {@link MeansOfTransportationStatus} with attributes specified in {@link Builder}
         */
        public MeansOfTransportationStatus build() {

            MeansOfTransportationStatus meansOfTransportationStatus = new MeansOfTransportationStatus();
            meansOfTransportationStatus.atd = this.atd;
            meansOfTransportationStatus.eta = this.eta;
            meansOfTransportationStatus.ata = this.ata;
            meansOfTransportationStatus.waggonTechnicalInspection = this.waggonTechnicalInspection;
            meansOfTransportationStatus.handlingStart = this.handlingStart;
            meansOfTransportationStatus.handlingEnd = this.handlingEnd;

            return meansOfTransportationStatus;
        }


        /**
         * Validates the input and builds {@link MeansOfTransportationStatus}. Throws IllegalStateException if input
         * doesn't fulfill the minimum requirement of {@link MeansOfTransportationStatus}.
         *
         * @return  new {@link MeansOfTransportationStatus} with attributes specified in {@link Builder}
         */
        public MeansOfTransportationStatus buildAndValidate() {

            MeansOfTransportationStatus meansOfTransportationStatus = this.build();

            MinimumRequirementValidator.validate(meansOfTransportationStatus);

            return meansOfTransportationStatus;
        }
    }
}
