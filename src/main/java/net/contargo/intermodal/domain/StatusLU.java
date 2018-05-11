package net.contargo.intermodal.domain;

/**
 * Status of loading unit for communication flow of intermodal freight transport.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Ladeeinheitenstatus
 * @name_english  loading unit status
 * @definition_german  Ladeeinheitenstatus für den Informationsfluss in der intermodalen Kette. Über den
 *                     Ladeeinheitenstatus und den {@link MeansOfTransportationStatus Verkehrsmittelstatus} kann ein
 *                     reibungsloser Austausch zwischen den Akteuren sichergestellt werden. Prinzipiell sollten die
 *                     beiden Status als Paket verstanden werden. Die Kerndaten sind jeweils immer gleich und werden
 *                     durch den jeweiligen Status konkretisiert. Dabei gibt es zwei Blöcke pro Statuspaket. Zum einen
 *                     die Identifikation des Handelnden inklusive Begleitinformationen und zum anderen die
 *                     Konkretisierung was genau zu welchem Zeitpunkt passiert. Begleitinformationen bei der
 *                     Ladeeinheit betreffen beispielsweise den Auftrag.
 * @definition_english  Status of means of transport for communication flow of intermodal freight transport. The
 *                      loading unit status and {@link MeansOfTransportationStatus means of transportation status}
 *                      ensure a fluent exchange between actors. Both statuses should be seen as package. Their core
 *                      data is similar and is concretized by their status. There are two blocks per status package. On
 *                      one hand the identification of the doer on the other hand the schedule of the different
 *                      operational steps.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class StatusLU {

    /**
     * {@link LoadingUnit LU} free and {@link MeansOfTransport MoT} present.
     *
     * @name_german  Verladebereit
     * @definition_german  {@link LoadingUnit Ladeeinheit} ist bereit für den Umschlag/ die Kranung.
     */

    private Boolean readyForLoading;

    /**
     * Loaded on {@link MeansOfTransport MoT}.
     *
     * @name_german  Verladen
     * @definition_german  {@link LoadingUnit Ladeeinheit} ist umgeschlagen und befindet sich auf dem
     *                     {@link MeansOfTransport VM}.
     */
    private Boolean loaded;

    /**
     * Ready for going out.
     *
     * @name_german  Ausgangskontrolle
     * @definition_german  {@link LoadingUnit Ladeeinheit} ist gesichtet und befindet sich auf dem
     *                     {@link MeansOfTransport VM}.
     */
    private Boolean inspectionOut;

    /**
     * {@link LoadingUnit LU} out confirmed.
     *
     * @name_german  Ausgegangen
     * @definition_german  {@link LoadingUnit Ladeeinheit} ist verladen und hat Umschlagpunkt verlassen.
     */
    private Boolean out;

    /**
     * Ready for going in.
     *
     * @name_german  Eingangskontrolle
     * @definition_german  {@link LoadingUnit Ladeeinheit} gesichtet, auf {@link MeansOfTransport VM} mit dem
     *                     Umschlagpunkt erreicht wurde.
     */
    private Boolean inspectionIn;

    /**
     * {@link LoadingUnit LU} in confirmed.
     *
     * @name_german  Eingegangen
     * @definition_german  {@link LoadingUnit Ladeeinheit} ist auf {@link MeansOfTransport VM} im Umschlagbereich.
     */
    private Boolean in;

    /**
     * {@link LoadingUnit LU} free and {@link MeansOfTransport MoT} present.
     *
     * @name_german  Entladebereit
     * @definition_german  {@link LoadingUnit Ladeeinheit} auf {@link MeansOfTransport VM} und im Umschlagbereich
     *                     bereit zum Entladen.
     */
    private Boolean readyForUnloading;

    /**
     * {@link LoadingUnit LU} in.
     *
     * @name_german  Entladen
     * @definition_german  {@link LoadingUnit Ladeeinheit} vom {@link MeansOfTransport VM} heruntergenommen, befindet
     *                     sich im Umschlagpunkt.
     */
    private Boolean unloaded;

    public Boolean isReadyForLoading() {

        return readyForLoading;
    }


    public Boolean isLoaded() {

        return loaded;
    }


    public Boolean hasInspectionOut() {

        return inspectionOut;
    }


    public Boolean isOut() {

        return out;
    }


    public Boolean hasInspectionIn() {

        return inspectionIn;
    }


    public Boolean isIn() {

        return in;
    }


    public Boolean isReadyForUnloading() {

        return readyForUnloading;
    }


    public Boolean isUnloaded() {

        return unloaded;
    }

    public static final class Builder {

        private Boolean readyForLoading;
        private Boolean loaded;
        private Boolean inspectionOut;
        private Boolean out;
        private Boolean inspectionIn;
        private Boolean in;
        private Boolean readyForUnloading;
        private Boolean unloaded;

        private Builder() {
        }

        public static Builder newStatusLU() {

            return new Builder();
        }


        public Builder isReadyForLoading(Boolean readyForLoading) {

            this.readyForLoading = readyForLoading;

            return this;
        }


        public Builder isLoaded(Boolean loaded) {

            this.loaded = loaded;

            return this;
        }


        public Builder isInspectionOut(Boolean inspectionOut) {

            this.inspectionOut = inspectionOut;

            return this;
        }


        public Builder isOut(Boolean out) {

            this.out = out;

            return this;
        }


        public Builder hasInspectionIn(Boolean inspectionIn) {

            this.inspectionIn = inspectionIn;

            return this;
        }


        public Builder isIn(Boolean in) {

            this.in = in;

            return this;
        }


        public Builder isReadyForUnloading(Boolean readyForUnloading) {

            this.readyForUnloading = readyForUnloading;

            return this;
        }


        public Builder isUnloaded(Boolean unloaded) {

            this.unloaded = unloaded;

            return this;
        }


        public StatusLU build() {

            StatusLU statusLU = new StatusLU();
            statusLU.readyForLoading = this.readyForLoading;
            statusLU.readyForUnloading = this.readyForUnloading;
            statusLU.in = this.in;
            statusLU.loaded = this.loaded;
            statusLU.inspectionOut = this.inspectionOut;
            statusLU.out = this.out;
            statusLU.unloaded = this.unloaded;
            statusLU.inspectionIn = this.inspectionIn;

            return statusLU;
        }


        public StatusLU buildAndValidate() {

            StatusLU statusLU = this.build();

            Validator.validate(statusLU);

            return statusLU;
        }
    }
}
