package net.contargo.intermodal.domain;

/**
 * Commercial vehicle which is mostly or exclusively used for carrying trailed vehicles.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Zugmaschine
 * @name_english  truck
 * @definition_german  Nutzkraftwagen, der ausschließlich oder überwiegend zum Mitführen von Anhängerfahrzeugen
 *                     bestimmt ist. (@see DIN 70010:2001-04, 1.2.2.3)
 * @definition_english  Commercial vehicle which is mostly or exclusively used for carrying trailed vehicles. (@see DIN
 *                      70010:2001-04, 1.2.2.3)
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Truck implements MeansOfTransport {

    /**
     * Format: spaces included.
     */
    private String numberPlate;

    /**
     * 2 Characters (UN/LOCODE).
     */
    private String countryCode;

    /**
     * Format: DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
     *
     * @name_english  Ministry of Transport test
     * @name_german  Hauptuntersuchung
     * @abbreviation_german  TÜV
     * @abbreviation_english  MOT
     */
    private String mot;

    /**
     * @name_german  Umweltplakette
     */
    private EnvironmentBadge environmentBadge;

    private String type;

    /**
     * @name_german  EU Zulassung
     */
    private Boolean euAuthorization;

    /**
     * @name_english  security test
     * @name_german  Sicherheitsprüfung
     */
    private Boolean st;

    /**
     * @name_german  Gefahrguteignung
     */
    private Boolean suitabilityDangerousGoods;

    /**
     * @name_german  Abfalleignung
     */
    private Boolean suitabilityWaste;

    /**
     * in kg.
     */
    private Double weightTara;

    public String getNumberPlate() {

        return numberPlate;
    }


    public String getCountryCode() {

        return countryCode;
    }


    public String getMot() {

        return mot;
    }


    public EnvironmentBadge getEnvironmentBadge() {

        return environmentBadge;
    }


    public String getType() {

        return type;
    }


    public Boolean getEuAuthorization() {

        return euAuthorization;
    }


    public Boolean getSt() {

        return st;
    }


    public Boolean getSuitabilityDangerousGoods() {

        return suitabilityDangerousGoods;
    }


    public Boolean getSuitabilityWaste() {

        return suitabilityWaste;
    }


    public Double getWeightTara() {

        return weightTara;
    }

    public static final class TruckBuilder {

        private String numberPlate;
        private String countryCode;
        private String mot;
        private EnvironmentBadge environmentBadge;
        private String type;
        private Boolean euAuthorization;
        private Boolean st;
        private Boolean suitabilityDangerousGoods;
        private Boolean suitabilityWaste;
        private Double weightTara;

        private TruckBuilder() {
        }

        public static TruckBuilder newTruck() {

            return new TruckBuilder();
        }


        public TruckBuilder withNumberPlate(String numberPlate) {

            this.numberPlate = numberPlate;

            return this;
        }


        public TruckBuilder withCountryCode(String countryCode) {

            this.countryCode = countryCode;

            return this;
        }


        public TruckBuilder withMot(int year, int month, int day) {

            this.mot = ISO8601DateFormatter.format(year, month, day);

            return this;
        }


        public TruckBuilder withEnvironmentBadge(EnvironmentBadge environmentBadge) {

            this.environmentBadge = environmentBadge;

            return this;
        }


        public TruckBuilder withType(String type) {

            this.type = type;

            return this;
        }


        public TruckBuilder withEuAuthorization(Boolean euAuthorization) {

            this.euAuthorization = euAuthorization;

            return this;
        }


        public TruckBuilder withST(Boolean st) {

            this.st = st;

            return this;
        }


        public TruckBuilder withSuitabilityDangerousGoods(Boolean suitabilityDangerousGoods) {

            this.suitabilityDangerousGoods = suitabilityDangerousGoods;

            return this;
        }


        public TruckBuilder withSuitabilityWaste(Boolean suitabilityWaste) {

            this.suitabilityWaste = suitabilityWaste;

            return this;
        }


        public TruckBuilder withWeightTara(Double weightTara) {

            this.weightTara = weightTara;

            return this;
        }


        public Truck build() {

            Truck truck = new Truck();
            truck.mot = this.mot;
            truck.suitabilityWaste = this.suitabilityWaste;
            truck.euAuthorization = this.euAuthorization;
            truck.numberPlate = this.numberPlate;
            truck.countryCode = this.countryCode;
            truck.environmentBadge = this.environmentBadge;
            truck.weightTara = this.weightTara;
            truck.suitabilityDangerousGoods = this.suitabilityDangerousGoods;
            truck.type = this.type;
            truck.st = this.st;

            return truck;
        }


        public Truck buildAndValidate() {

            Truck truck = this.build();

            // TODO
            // Validator.validate(driver);

            return truck;
        }
    }
}
