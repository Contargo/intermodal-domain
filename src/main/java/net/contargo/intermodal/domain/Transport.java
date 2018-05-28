package net.contargo.intermodal.domain;

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
public class Transport {

    private Direction direction;
    private PickUp pickUp = new PickUp();
    private DropOff dropOff = new DropOff();
    @NotEmpty(message = "stop is part of minimum requirement")
    private List<Stop> stop = new ArrayList<>();

    public void setDirection(Direction direction) {

        this.direction = direction;
    }


    public void setPickUpLocation(String city, String designation, String type) {

        this.pickUp.setLocation(city, designation, type);
    }


    public void setPickUpLocation(String city, String designation) {

        this.pickUp.setLocation(city, designation);
    }


    public void setPickUpLoadingUnit(String reference, Boolean isEmpty) {

        this.pickUp.setLoadingUnit(reference, isEmpty);
    }


    public void setPickUpLoadingUnitOperator(Operator operator) {

        this.pickUp.setLoadingUnitOperator(operator);
    }


    public void setPickUpBillingReference(String billingReference) {

        this.pickUp.setBillingReference(billingReference);
    }


    public void setEarliestPickUp(int year, int month, int day, int hour, int minute) {

        this.pickUp.setEarliest(year, month, day, hour, minute);
    }


    public void setLatestPickUp(int year, int month, int day, int hour, int minute) {

        this.pickUp.setLatest(year, month, day, hour, minute);
    }


    public void setPickUpMoT(MeansOfTransport meansOfTransport) {

        this.pickUp.setMoT(meansOfTransport);
    }


    public void setDropOffLocation(String city, String designation, String type) {

        this.dropOff.setLocation(city, designation, type);
    }


    public void setDropOffLocation(String city, String designation) {

        this.dropOff.setLocation(city, designation);
    }


    public void setDropOffLoadingUnit(String reference, Boolean isEmpty) {

        this.dropOff.setLoadingUnit(reference, isEmpty);
    }


    public void setDropOffLoadingUnitOperator(Operator operator) {

        this.dropOff.setLoadingUnitOperator(operator);
    }


    public void setDropOffBillingReference(String billingReference) {

        this.dropOff.setBillingReference(billingReference);
    }


    public void setEarliestDropOff(int year, int month, int day, int hour, int minute) {

        this.dropOff.setEarliest(year, month, day, hour, minute);
    }


    public void setLatestDropOff(int year, int month, int day, int hour, int minute) {

        this.dropOff.setLatest(year, month, day, hour, minute);
    }


    public void setDropOffMoT(MeansOfTransport meansOfTransport) {

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


    public List<Stop> getStops() {

        return stop;
    }

    public static class DropOff {

        @NotNull(message = "location is part of minimum requirement")
        private Location location;

        private LoadingUnit loadingUnit;

        /**
         * Abrechnungsreferenz, PO-number für Dienstl.
         */
        private String billingReference;

        /**
         * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
         */
        private String earliest;

        /**
         * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
         */
        private String latest;

        /**
         * @see  MeansOfTransport
         */
        @NotNull(message = "mot is part of minimum requirement")
        private MeansOfTransport mot;

        public void setLocation(String city, String designation, String type) {

            this.location = new Location();
            this.location.setCity(city);
            this.location.setDesignation(designation);
            this.location.setType(type);
        }


        public void setLocation(String city, String designation) {

            this.location = new Location();
            this.location.setCity(city);
            this.location.setDesignation(designation);
        }


        public void setLoadingUnit(String reference, Boolean isEmpty) {

            this.loadingUnit = new LoadingUnit();
            this.loadingUnit.setEmpty(isEmpty);
            this.loadingUnit.setReference(reference);
        }


        public void setLoadingUnitOperator(Operator operator) {

            this.loadingUnit.setOperator(operator);
        }


        public void setBillingReference(String billingReference) {

            this.billingReference = billingReference;
        }


        public void setEarliest(int year, int month, int day, int hour, int minute) {

            this.earliest = ISO8601DateFormatter.format(year, month, day, hour, minute);
        }


        public void setLatest(int year, int month, int day, int hour, int minute) {

            this.latest = ISO8601DateFormatter.format(year, month, day, hour, minute);
        }


        public void setMoT(MeansOfTransport mot) {

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


        public String getEarliest() {

            return earliest;
        }


        public String getLatest() {

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

        private LoadingUnit loadingUnit;

        /**
         * @definition_german  Abrechnungsreferenz, PO-number für Dienstleister
         */
        private String billingReference;

        /**
         * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
         */
        @NotNull(message = "earliest is part of minimum requirement")
        private String earliest;

        /**
         * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
         */
        private String latest;

        @NotNull(message = "mot is part of minimum requirement")
        private MeansOfTransport mot;

        public void setLocation(String city, String designation, String type) {

            this.location = new Location();
            this.location.setCity(city);
            this.location.setDesignation(designation);
            this.location.setType(type);
        }


        public void setLocation(String city, String designation) {

            this.location = new Location();
            this.location.setCity(city);
            this.location.setDesignation(designation);
        }


        public void setLoadingUnit(String reference, Boolean isEmpty) {

            this.loadingUnit = new LoadingUnit();
            this.loadingUnit.setEmpty(isEmpty);
            this.loadingUnit.setReference(reference);
        }


        public void setLoadingUnitOperator(Operator operator) {

            this.loadingUnit.setOperator(operator);
        }


        public void setBillingReference(String billingReference) {

            this.billingReference = billingReference;
        }


        public void setEarliest(int year, int month, int day, int hour, int minute) {

            this.earliest = ISO8601DateFormatter.format(year, month, day, hour, minute);
        }


        public void setLatest(int year, int month, int day, int hour, int minute) {

            this.latest = ISO8601DateFormatter.format(year, month, day, hour, minute);
        }


        public void setMoT(MeansOfTransport mot) {

            this.mot = mot;
        }


        public String getBillingReference() {

            return billingReference;
        }


        public String getEarliest() {

            return earliest;
        }


        public String getLatest() {

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


        public void setEmpty(Boolean empty) {

            this.empty = empty;
        }


        public String getReference() {

            return reference;
        }


        public void setReference(String reference) {

            this.reference = reference;
        }


        public Operator getOperator() {

            return operator;
        }


        public void setOperator(Operator operator) {

            this.operator = operator;
        }
    }
}
