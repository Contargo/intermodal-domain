package net.contargo.intermodal.domain;

import net.contargo.intermodal.domain.utility.ISO8601DateFormatter;

import java.util.ArrayList;
import java.util.List;


/**
 * Contains data the data necessary for processing of loading and discharging
 * {@link net.contargo.intermodal.domain.Barge barges}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Abfertigung Binnenschiff
 * @name_english  processing barge
 * @definition_german  Nach erfolgreicher Anmeldung kommt es zur Abfertigung der Verkehrsmittel im Umschlagpunkt. In
 *                     dieser Gruppe werden die Daten, die für die Abwicklung der Be- und Entladungsvorgänge am
 *                     Binnenschiff notwendig sind, zusammengefasst. Die Prozesse werden durch die Verknüpfung von
 *                     Eigenschaften des {@link net.contargo.intermodal.domain.Barge Binnenschiffs}, relevanten
 *                     {@link Person Personen}, Fahrplänen sowie Beladungen und nötigen Dokumenteninformationen
 *                     dargestellt.
 * @definition_english  After successful registration the means of transport is processed on the handling point. In
 *                      this class the data necessary for processing of loading and discharging barges is summarized.
 *                      The processes are described by connecting properties of the
 *                      {@link net.contargo.intermodal.domain.Barge}, relevant {@link Person Persons} and schedules as
 *                      well as loads and necessary document information.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class ProcessingBarge {

    private net.contargo.intermodal.domain.Barge barge;

    /**
     * Estimated Time of Arrival (Format: ISO 8601 inclusive UTC)
     */
    private String eta;

    /**
     * Estimated Time of Departure (Format: ISO 8601 inclusive UTC)
     */
    private String etd;

    private Skipper skipper;

    private List<Person> passenger;

    private Integer reeferConnections;

    /**
     * @see  net.contargo.intermodal.domain.Cone
     */
    private Cone cone;

    /**
     * ADNR (fr: Accord europèen relatif au transport international des marchandises dangereuses par voie de navigation
     * intérieure sur le Rhin): european treaty for transport of dangerous goods on the Rhine. (Format: DateTime ISO
     * 8601 inclusive) UTC.
     */
    private Boolean adnr;

    private LoadingList loadingList;

    public Barge getBarge() {

        return barge;
    }


    public String getEta() {

        return eta;
    }


    public String getEtd() {

        return etd;
    }


    public Skipper getSkipper() {

        return skipper;
    }


    public List<Person> getPassenger() {

        return passenger;
    }


    public Integer getReeferConnections() {

        return reeferConnections;
    }


    public Cone getCone() {

        return cone;
    }


    public Boolean getAdnr() {

        return adnr;
    }


    public LoadingList getLoadingList() {

        return loadingList;
    }

    public static class LoadingList {

        private List<LUOrder> luOrders = new ArrayList<>();
        private List<StoragePosition> storagePositions = new ArrayList<>();

        LoadingList() {
        }

        public List<LUOrder> getLuOrders() {

            return luOrders;
        }


        public List<StoragePosition> getStoragePositions() {

            return storagePositions;
        }


        public void with(LUOrder luOrder, StoragePosition storagePosition) {

            this.luOrders.add(luOrder);
            this.storagePositions.add(storagePosition);
        }
    }

    public static final class Builder {

        private Barge barge;
        private String eta;
        private String etd;
        private Skipper skipper;
        private List<Person> passenger;
        private Integer reeferConnections;
        private Cone cone;
        private Boolean adnr;
        private LoadingList loadingList = new LoadingList();

        private Builder() {
        }

        public static Builder newProcessingBarge() {

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


        public Builder withSkipper(Skipper skipper) {

            this.skipper = skipper;

            return this;
        }


        public Builder withPassenger(List<Person> passenger) {

            this.passenger = passenger;

            return this;
        }


        public Builder withReeferConnections(Integer reeferConnections) {

            this.reeferConnections = reeferConnections;

            return this;
        }


        public Builder withCone(Cone cone) {

            this.cone = cone;

            return this;
        }


        public Builder withAdnr(Boolean adnr) {

            this.adnr = adnr;

            return this;
        }


        public Builder withLuOrder(LUOrder luOrder, StoragePosition storagePosition) {

            this.loadingList.with(luOrder, storagePosition);

            return this;
        }


        public ProcessingBarge build() {

            ProcessingBarge processingBarge = new ProcessingBarge();
            processingBarge.barge = this.barge;
            processingBarge.reeferConnections = this.reeferConnections;
            processingBarge.loadingList = this.loadingList;
            processingBarge.eta = this.eta;
            processingBarge.etd = this.etd;
            processingBarge.passenger = this.passenger;
            processingBarge.cone = this.cone;
            processingBarge.skipper = this.skipper;
            processingBarge.adnr = this.adnr;

            return processingBarge;
        }


        public ProcessingBarge buildAndValidate() {

            ProcessingBarge processingBarge = this.build();

            Validator.validate(processingBarge);

            return processingBarge;
        }
    }
}
