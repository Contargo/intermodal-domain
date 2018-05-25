package net.contargo.intermodal.domain;

/**
 * Trailer to transport loading units.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Fahrgestell
 * @name_english  chassis
 * @definition_german  Anhänger zur Beförderung von Ladeeinheiten.
 * @definition_english  Trailer to transport loading units.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Chassis implements MeansOfTransport {

    /**
     * Format: spaces included.
     */
    private String numberPlate;

    /**
     * Format: DateTime ISO 8601
     *
     * @name_english  Ministry of Transport Test
     * @name_german  Hauptuntersuchung
     */
    private String mot;

    /**
     * e.g&#046; Multichassis.
     */
    private String type;

    private Integer axles;

    /**
     * in meter.
     */
    private Double size;

    /**
     * in meter.
     */
    private Double height;

    /**
     * @name_german  EU Zulassung
     */
    private Boolean euAuthorization;

    /**
     * @name_english  safety test
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
     * @name_german  Reefereignung
     */
    private Boolean suitabilityReefer;

    /**
     * in kg.
     */
    private Weight weight;

    public String getNumberPlate() {

        return numberPlate;
    }


    public String getMot() {

        return mot;
    }


    public String getType() {

        return type;
    }


    public Integer getAxles() {

        return axles;
    }


    public Double getSize() {

        return size;
    }


    public Double getHeight() {

        return height;
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


    public Boolean getSuitabilityReefer() {

        return suitabilityReefer;
    }


    public Weight getWeight() {

        return weight;
    }


    public Double getWeightTara() {

        return weight.getTara();
    }

    public static final class Builder {

        private String numberPlate;
        private String mot;
        private String type;
        private Integer axles;
        private Double size;
        private Double height;
        private Boolean euAuthorization;
        private Boolean st;
        private Boolean suitabilityDangerousGoods;
        private Boolean suitabilityWaste;
        private Boolean suitabilityReefer;
        private Double weightTara;

        private Builder() {
        }

        public static Builder newChassis() {

            return new Builder();
        }


        public Builder withNumberPlate(String numberPlate) {

            this.numberPlate = numberPlate;

            return this;
        }


        public Builder withMot(int year, int month, int day) {

            this.mot = ISO8601DateFormatter.format(year, month, day);

            return this;
        }


        public Builder withType(String type) {

            this.type = type;

            return this;
        }


        public Builder withAxles(Integer axles) {

            this.axles = axles;

            return this;
        }


        public Builder withSize(Double size) {

            this.size = size;

            return this;
        }


        public Builder withHeight(Double height) {

            this.height = height;

            return this;
        }


        public Builder withEuAuthorization(Boolean euAuthorization) {

            this.euAuthorization = euAuthorization;

            return this;
        }


        public Builder withSt(Boolean st) {

            this.st = st;

            return this;
        }


        public Builder withSuitabilityDangerousGoods(Boolean suitabilityDangerousGoods) {

            this.suitabilityDangerousGoods = suitabilityDangerousGoods;

            return this;
        }


        public Builder withSuitabilityWaste(Boolean suitabilityWaste) {

            this.suitabilityWaste = suitabilityWaste;

            return this;
        }


        public Builder withSuitabilityReefer(Boolean suitabilityReefer) {

            this.suitabilityReefer = suitabilityReefer;

            return this;
        }


        public Builder withWeightTara(Double weightTara) {

            this.weightTara = weightTara;

            return this;
        }


        public Chassis build() {

            Chassis chassis = new Chassis();
            chassis.numberPlate = this.numberPlate;
            chassis.axles = this.axles;
            chassis.height = this.height;
            chassis.euAuthorization = this.euAuthorization;
            chassis.st = this.st;
            chassis.type = this.type;
            chassis.size = this.size;
            chassis.suitabilityWaste = this.suitabilityWaste;
            chassis.mot = this.mot;
            chassis.suitabilityDangerousGoods = this.suitabilityDangerousGoods;
            chassis.suitabilityReefer = this.suitabilityReefer;

            Weight weight = new Weight();
            weight.setTara(this.weightTara);
            chassis.weight = weight;

            return chassis;
        }


        public Chassis buildAndValidate() {

            Chassis chassis = this.build();

            Validator.validate(chassis);

            return chassis;
        }
    }
}
