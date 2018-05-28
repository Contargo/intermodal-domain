package net.contargo.intermodal.domain;

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
    private String atd;

    /**
     * Estimated Time of Arrival of the {@link MeansOfTransport MoT} at the handling point (Format: ISO 8601 inclusive
     * UTC).
     *
     * @name_german  Avisiert
     * @definition_german  Geplante Ankunft des {@link MeansOfTransport VM} am Umschlagpunkt.
     */
    private String eta;

    /**
     * Actual Time of Arrival of the {@link MeansOfTransport MoT} at the handling point (Format: ISO 8601 inclusive
     * UTC).
     *
     * @name_german  Ankunft
     * @definition_german  Tatsächliche Ankunft des {@link MeansOfTransport VM} am Umschlagpunkt.
     */
    private String ata;

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
    private String handlingStart;

    /**
     * {@link MeansOfTransport MoT} is loaded, end of loading process (Format: ISO 8601 inclusive UTC).
     *
     * @name_german  Bearbeitungsende
     * @synonym_german  Ladeschluss
     * @abbreviation_german  BE
     * @definition_german  {@link MeansOfTransport VM} beladen, Ende Verladung erreicht („letzte Kranung“).
     */
    private String handlingEnd;

    /**
     * Safety control of the loaded waggons.
     *
     * @name_german  Wagentechnische Untersuchung
     * @abbreviation_german  WTU
     * @definition_german  Kontrolle der Betriebssicherheit der Waggons mit Ladung.
     */
    private Integer waggonTechnicalInspection;

    public String getAtd() {

        return atd;
    }


    public String getEta() {

        return eta;
    }


    public String getAta() {

        return ata;
    }


    public String getHandlingStart() {

        return handlingStart;
    }


    public String getHandlingEnd() {

        return handlingEnd;
    }


    public Integer getWaggonTechnicalInspection() {

        return waggonTechnicalInspection;
    }

    public static final class Builder {

        private String atd;
        private String eta;
        private String ata;
        private String handlingStart;
        private String handlingEnd;
        private Integer waggonTechnicalInspection;

        private Builder() {
        }

        public static Builder newMeansOfTransportationStatus() {

            return new Builder();
        }


        public Builder withAtd(int year, int month, int day, int hour, int minute) {

            this.atd = ISO8601DateFormatter.format(year, month, day, hour, minute);

            return this;
        }


        public Builder withEta(int year, int month, int day, int hour, int minute) {

            this.eta = ISO8601DateFormatter.format(year, month, day, hour, minute);

            return this;
        }


        public Builder withAta(int year, int month, int day, int hour, int minute) {

            this.ata = ISO8601DateFormatter.format(year, month, day, hour, minute);

            return this;
        }


        public Builder withHandlingStart(int year, int month, int day, int hour, int minute) {

            this.handlingStart = ISO8601DateFormatter.format(year, month, day, hour, minute);

            return this;
        }


        public Builder withHandlingEnd(int year, int month, int day, int hour, int minute) {

            this.handlingEnd = ISO8601DateFormatter.format(year, month, day, hour, minute);

            return this;
        }


        public Builder withWaggonTechnicalInspection(Integer waggonTechnicalInspection) {

            this.waggonTechnicalInspection = waggonTechnicalInspection;

            return this;
        }


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


        public MeansOfTransportationStatus buildAndValidate() {

            MeansOfTransportationStatus meansOfTransportationStatus = this.build();

            Validator.validate(meansOfTransportationStatus);

            return meansOfTransportationStatus;
        }
    }
}
