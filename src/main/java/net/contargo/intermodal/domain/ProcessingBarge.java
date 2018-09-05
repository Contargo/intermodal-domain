package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.Instant;

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
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant eta;

    /**
     * Estimated Time of Departure (Format: ISO 8601 inclusive UTC)
     */
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant etd;

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

    private List<LoadingListElement> loadingList;

    private ProcessingBarge() {

        // OK
    }

    /**
     * Creates a new builder for {@link ProcessingBarge}.
     *
     * @return  new builder
     */
    public static Builder newBuilder() {

        return new Builder();
    }


    /**
     * Creates a new builder with the values of another {@link ProcessingBarge}.
     *
     * @param  processingBarge  that should be copied.
     *
     * @return  new builder with values of given processingBarge.
     */
    public static Builder newBuilder(ProcessingBarge processingBarge) {

        return new Builder().withBarge(processingBarge.getBarge())
            .withReeferConnections(processingBarge.getReeferConnections())
            .withEta(processingBarge.getEta())
            .withEtd(processingBarge.getEtd())
            .withPassengers(processingBarge.getPassenger())
            .withCone(processingBarge.getCone())
            .withSkipper(processingBarge.getSkipper())
            .withAdnr(processingBarge.getAdnr())
            .withLoadingList(processingBarge.getLoadingList());
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


    public List<LoadingListElement> getLoadingList() {

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

    public static class LoadingListElement {

        private LUOrder luOrder;

        /**
         * Bay-Row-Tier-System (BBBRRTT) as described in: BICS2 Anweisungsblatt - Kodierung Stauplatz in der
         * Binnenschifffahrt.
         */
        private String storagePosition;

        LoadingListElement() {
        }

        @JsonProperty("luOrder")
        public LUOrder getLuOrder() {

            return luOrder;
        }


        public String getStoragePosition() {

            return storagePosition;
        }


        void setLuOrder(LUOrder luOrder) {

            this.luOrder = luOrder;
        }


        void setStoragePosition(String storagePosition) {

            this.storagePosition = storagePosition;
        }
    }

    public static final class Builder {

        private Barge barge;
        private Instant eta;
        private Instant etd;
        private Skipper skipper;
        private List<Person> passenger = new ArrayList<>();
        private Integer reeferConnections;
        private Cone cone;
        private Boolean adnr;
        private List<LoadingListElement> loadingList;

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


        public Builder withSkipper(Skipper skipper) {

            this.skipper = skipper;

            return this;
        }


        public Builder withPassengers(List<Person> passengers) {

            this.passenger.addAll(passengers);

            return this;
        }


        public Builder withPassenger(Person passenger) {

            this.passenger.add(passenger);

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


        public Builder withLuOrder(LUOrder luOrder, String storagePosition) {

            if (loadingList == null) {
                this.loadingList = new ArrayList<>();
            }

            LoadingListElement loadingListElement = new LoadingListElement();
            loadingListElement.setLuOrder(luOrder);
            loadingListElement.setStoragePosition(storagePosition);

            this.loadingList.add(loadingListElement);

            return this;
        }


        public Builder withLuOrder(LUOrder luOrder) {

            if (loadingList == null) {
                this.loadingList = new ArrayList<>();
            }

            LoadingListElement loadingListElement = new LoadingListElement();
            loadingListElement.setLuOrder(luOrder);

            this.loadingList.add(loadingListElement);

            return this;
        }


        Builder withLoadingList(List<LoadingListElement> loadingList) {

            this.loadingList = loadingList;

            return this;
        }


        /**
         * Builds {@link ProcessingBarge} without input validation.
         *
         * @return  new {@link ProcessingBarge} with attributes specified in {@link Builder}
         */
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


        /**
         * Validates the input and builds {@link ProcessingBarge}. Throws IllegalStateException if input doesn't
         * fulfill the minimum requirement of {@link ProcessingBarge}.
         *
         * @return  new {@link ProcessingBarge} with attributes specified in {@link Builder}
         */
        public ProcessingBarge buildAndValidate() {

            ProcessingBarge processingBarge = this.build();

            MinimumRequirementValidator.validate(processingBarge);

            return processingBarge;
        }
    }
}
