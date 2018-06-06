package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.Instant;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * Contains information about pick ups, drop offs and stops of an {@link Order}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
class Transport {

    private Direction direction;
    private PickUp pickUp = new PickUp();
    private DropOff dropOff = new DropOff();
    @NotEmpty(message = "stop is part of minimum requirement")
    private List<Stop> stop = new ArrayList<>();

    void setDirection(Direction direction) {

        this.direction = direction;
    }


    void setPickUpLocation(String city, String designation, String type) {

        this.pickUp.setLocation(city, designation, type);
    }


    void setPickUpLocation(String city, String designation) {

        this.pickUp.setLocation(city, designation);
    }


    void setPickUpLoadingUnit(String reference, Boolean isEmpty) {

        this.pickUp.setLoadingUnit(reference, isEmpty);
    }


    void setPickUpLoadingUnitOperator(Operator operator) {

        this.pickUp.setLoadingUnitOperator(operator);
    }


    void setPickUpBillingReference(String billingReference) {

        this.pickUp.setBillingReference(billingReference);
    }


    void setEarliestPickUp(Instant instant) {

        this.pickUp.setEarliest(instant);
    }


    void setLatestPickUp(Instant instant) {

        this.pickUp.setLatest(instant);
    }


    void setPickUpMoT(MeansOfTransport meansOfTransport) {

        this.pickUp.setMoT(meansOfTransport);
    }


    void setDropOffLocation(String city, String designation, String type) {

        this.dropOff.setLocation(city, designation, type);
    }


    void setDropOffLocation(String city, String designation) {

        this.dropOff.setLocation(city, designation);
    }


    void setDropOffLoadingUnit(String reference, Boolean isEmpty) {

        this.dropOff.setLoadingUnit(reference, isEmpty);
    }


    void setDropOffLoadingUnitOperator(Operator operator) {

        this.dropOff.setLoadingUnitOperator(operator);
    }


    void setDropOffBillingReference(String billingReference) {

        this.dropOff.setBillingReference(billingReference);
    }


    void setEarliestDropOff(Instant instant) {

        this.dropOff.setEarliest(instant);
    }


    void setLatestDropOff(Instant instant) {

        this.dropOff.setLatest(instant);
    }


    void setDropOffMoT(MeansOfTransport meansOfTransport) {

        this.dropOff.setMoT(meansOfTransport);
    }


    public void addStop(Stop stop) {

        this.stop.add(stop);
    }


    public Direction getDirection() {

        return direction;
    }


    public PickUp getPickUp() {

        return pickUp;
    }


    public DropOff getDropOff() {

        return dropOff;
    }


    @JsonProperty("stop")
    public List<Stop> getStops() {

        return stop;
    }

    public static class DropOff {

        @NotNull(message = "location is part of minimum requirement")
        private Location location;

        private LoadingUnit loadingUnit = new LoadingUnit();

        /**
         * Abrechnungsreferenz, PO-number für Dienstl.
         */
        private String billingReference;

        /**
         * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
         */
        @JsonDeserialize(using = InstantJsonDeserializer.class)
        private Instant earliest;

        /**
         * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
         */
        @JsonDeserialize(using = InstantJsonDeserializer.class)
        private Instant latest;

        /**
         * @see  MeansOfTransport
         */
        @NotNull(message = "mot is part of minimum requirement")
        private MeansOfTransport mot;

        void setLocation(String city, String designation, String type) {

            this.location = new Location();
            this.location.setCity(city);
            this.location.setDesignation(designation);
            this.location.setType(type);
        }


        void setLocation(String city, String designation) {

            this.location = new Location();
            this.location.setCity(city);
            this.location.setDesignation(designation);
        }


        void setLoadingUnit(String reference, Boolean isEmpty) {

            this.loadingUnit.setEmpty(isEmpty);
            this.loadingUnit.setReference(reference);
        }


        void setLoadingUnitOperator(Operator operator) {

            this.loadingUnit.setOperator(operator);
        }


        void setBillingReference(String billingReference) {

            this.billingReference = billingReference;
        }


        void setEarliest(Instant instant) {

            this.earliest = instant;
        }


        void setLatest(Instant instant) {

            this.latest = instant;
        }


        void setMoT(MeansOfTransport mot) {

            this.mot = mot;
        }


        public void setMot(MeansOfTransport mot) {

            this.mot = mot;
        }


        public Location getLocation() {

            return location;
        }


        public String getBillingReference() {

            return billingReference;
        }


        @JsonSerialize(using = InstantJsonSerializer.class)
        public Instant getEarliest() {

            return earliest;
        }


        @JsonSerialize(using = InstantJsonSerializer.class)
        public Instant getLatest() {

            return latest;
        }


        public MeansOfTransport getMot() {

            return mot;
        }


        public LoadingUnit getLoadingUnit() {

            return loadingUnit;
        }
    }

    public static class PickUp {

        private Location location;

        private LoadingUnit loadingUnit = new LoadingUnit();

        /**
         * @definition_german  Abrechnungsreferenz, PO-number für Dienstleister
         */
        private String billingReference;

        /**
         * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
         */
        @NotNull(message = "earliest is part of minimum requirement")
        @JsonDeserialize(using = InstantJsonDeserializer.class)
        private Instant earliest;

        /**
         * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
         */
        @JsonDeserialize(using = InstantJsonDeserializer.class)
        private Instant latest;

        @NotNull(message = "mot is part of minimum requirement")
        private MeansOfTransport mot;

        void setLocation(String city, String designation, String type) {

            this.location = new Location();
            this.location.setCity(city);
            this.location.setDesignation(designation);
            this.location.setType(type);
        }


        void setLocation(String city, String designation) {

            this.location = new Location();
            this.location.setCity(city);
            this.location.setDesignation(designation);
        }


        void setLoadingUnit(String reference, Boolean isEmpty) {

            this.loadingUnit.setEmpty(isEmpty);
            this.loadingUnit.setReference(reference);
        }


        void setLoadingUnitOperator(Operator operator) {

            this.loadingUnit.setOperator(operator);
        }


        void setBillingReference(String billingReference) {

            this.billingReference = billingReference;
        }


        void setEarliest(Instant instant) {

            this.earliest = instant;
        }


        void setLatest(Instant instant) {

            this.latest = instant;
        }


        void setMoT(MeansOfTransport mot) {

            this.mot = mot;
        }


        public String getBillingReference() {

            return billingReference;
        }


        @JsonSerialize(using = InstantJsonSerializer.class)
        public Instant getEarliest() {

            return earliest;
        }


        @JsonSerialize(using = InstantJsonSerializer.class)
        public Instant getLatest() {

            return latest;
        }


        public MeansOfTransport getMot() {

            return mot;
        }


        public Location getLocation() {

            return location;
        }


        public LoadingUnit getLoadingUnit() {

            return loadingUnit;
        }
    }

    public static class LoadingUnit {

        private String reference;
        private Boolean empty;
        private Operator operator;

        public Boolean isEmpty() {

            return empty;
        }


        void setEmpty(Boolean empty) {

            this.empty = empty;
        }


        public String getReference() {

            return reference;
        }


        void setReference(String reference) {

            this.reference = reference;
        }


        public Operator getOperator() {

            return operator;
        }


        void setOperator(Operator operator) {

            this.operator = operator;
        }
    }
}
