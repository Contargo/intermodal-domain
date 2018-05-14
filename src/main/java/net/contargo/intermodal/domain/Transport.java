package net.contargo.intermodal.domain;

import java.util.List;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class Transport {

    private Direction direction;

    private PickUp pickUp;
    private DropOff dropOff;
    private Stop stop;

    public Direction getDirection() {

        return direction;
    }


    public PickUp getPickUp() {

        return pickUp;
    }


    public DropOff getDropOff() {

        return dropOff;
    }


    public Stop getStop() {

        return stop;
    }

    public static class DropOff {

        private String locationCity;

        /**
         * name of terminal.
         */

        private String locationDesignation;

        /**
         * loading place, sea or hinterland terminal.
         */
        private String locationType;

        private Boolean luEmpty;

        private String luReference;

        /**
         * Abrechnungsreferenz, PO-number für Dienstl.
         */
        private String billingReference;

        private Operator luOperator;

        /**
         * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
         */
        private String earliest;

        /**
         * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
         */
        private String latest;

        private MeansOfTransport mot;

        public String getLocationCity() {

            return locationCity;
        }


        public String getLocationDesignation() {

            return locationDesignation;
        }


        public String getLocationType() {

            return locationType;
        }


        public Boolean getLuEmpty() {

            return luEmpty;
        }


        public String getLuReference() {

            return luReference;
        }


        public String getBillingReference() {

            return billingReference;
        }


        public Operator getLuOperator() {

            return luOperator;
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
    }

    public static class PickUp {

        private String locationCity;

        /**
         * name of terminal.
         */

        private String locationDesignation;

        /**
         * loading place, sea or hinterland terminal.
         */
        private String locationType;

        private Boolean luEmpty;

        private String luReference;

        /**
         * Abrechnungsreferenz, PO-number für Dienstl.
         */
        private String billingReference;

        private Operator luOperator;

        /**
         * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
         */
        private String earliest;

        /**
         * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
         */
        private String latest;

        private MeansOfTransport mot;

        public String getLocationCity() {

            return locationCity;
        }


        public String getLocationDesignation() {

            return locationDesignation;
        }


        public String getLocationType() {

            return locationType;
        }


        public Boolean getLuEmpty() {

            return luEmpty;
        }


        public String getLuReference() {

            return luReference;
        }


        public String getBillingReference() {

            return billingReference;
        }


        public Operator getLuOperator() {

            return luOperator;
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
    }

    public static class Stop {

        private List<String> location;

        private List<String> locationCity;

        private List<String> locationDesignation;

        private String locationType;

        private String sequence;

        /**
         * Format: ISO 8601 inclusive UTC.
         */
        private String earliest;

        /**
         * Format: ISO 8601 inclusive UTC.
         */
        private String latest;

        private String reference;

        private String billingReference;

        private MeansOfTransport mot;
    }
}
