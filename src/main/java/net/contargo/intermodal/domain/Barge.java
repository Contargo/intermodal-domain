package net.contargo.intermodal.domain;

/**
 * A ship build to drive on inland waters and inland waterways.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Binnenschiff
 * @name_english  barge
 * @definition_german  Schiff, das zur Fahrt auf Binnengewässern und Binnenwasserstraßen konstruiert ist.
 * @definition_english  A ship build to drive on inland waters and inland waterways.
 * @note_german  Im Vergleich zum {@link Vessel Seeschiff} bestehen weniger Anforderungen an Stabilität, Navigation und
 *               Rettungsgerät, wohingegen spezielle Konstruktionen für die Brückendurchfahrt o. ä. notwendig sein
 *               können. Es gibt diverse Schiffstypen dieser Art, die für den Kombinierten Verkehr relevant sind, z. B.
 *               Containerschiffe, Lastkähne, Leichter bzw. Schubverbände, Koppelverbände.
 * @note_english  In comparison to a {@link Vessel} there are less requirements in means of stability, navigation and
 *                rescue devices but special constructions for navigating under bridges or or the like might be
 *                necessary. There are different types of barges that are relevant in combined traffic e.g. container
 *                ships, lighter and tug barges.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Barge implements MeansOfTransport {

    private String name;

    /**
     * Maritime Mobile Service Identity (9 digits).
     */
    private String mmsi;

    /**
     * European Number of Identification e.g. 040-059 for Germany.
     */
    private String eni;

    private Operator operator;

    /**
     * in meter.
     */
    private Double length;

    /**
     * in meter.
     */
    private Double width;

    /**
     * in meter.
     */
    private Double draught;

    private Integer bays;

    private Integer rows;

    private Integer tiers;

    /**
     * @name_german  Gefahrguteignung
     */
    private Boolean suitabilityDangerousGoods;

    /**
     * in TEU.
     */
    private Double capacityTeu;

    /**
     * in tons.
     */
    private Double capacityTons;

    public String getName() {

        return name;
    }


    public String getMmsi() {

        return mmsi;
    }


    public String getEni() {

        return eni;
    }


    public Operator getOperator() {

        return operator;
    }


    public Double getLength() {

        return length;
    }


    public Double getWidth() {

        return width;
    }


    public Double getDraught() {

        return draught;
    }


    public Integer getBays() {

        return bays;
    }


    public Integer getRows() {

        return rows;
    }


    public Integer getTiers() {

        return tiers;
    }


    public Boolean getSuitabilityDangerousGoods() {

        return suitabilityDangerousGoods;
    }


    public Double getCapacityTeu() {

        return capacityTeu;
    }


    public Double getCapacityTons() {

        return capacityTons;
    }

    public static final class BargeBuilder {

        private String name;
        private String mmsi;
        private String eni;
        private Operator operator;
        private Double length;
        private Double width;
        private Double draught;
        private Integer bays;
        private Integer rows;
        private Integer tiers;
        private Boolean suitabilityDangerousGoods;
        private Double capacityTeu;
        private Double capacityTons;

        private BargeBuilder() {
        }

        public static BargeBuilder newBarge() {

            return new BargeBuilder();
        }


        public BargeBuilder withName(String name) {

            this.name = name;

            return this;
        }


        public BargeBuilder withMmsi(String mmsi) {

            this.mmsi = mmsi;

            return this;
        }


        public BargeBuilder withEni(String eni) {

            this.eni = eni;

            return this;
        }


        public BargeBuilder withOperator(Operator operator) {

            this.operator = operator;

            return this;
        }


        public BargeBuilder withLength(Double length) {

            this.length = length;

            return this;
        }


        public BargeBuilder withWidth(Double width) {

            this.width = width;

            return this;
        }


        public BargeBuilder withDraught(Double draught) {

            this.draught = draught;

            return this;
        }


        public BargeBuilder withBays(Integer bays) {

            this.bays = bays;

            return this;
        }


        public BargeBuilder withRows(Integer rows) {

            this.rows = rows;

            return this;
        }


        public BargeBuilder withTiers(Integer tiers) {

            this.tiers = tiers;

            return this;
        }


        public BargeBuilder withSuitabilityDangerousGoods(Boolean suitabilityDangerousGoods) {

            this.suitabilityDangerousGoods = suitabilityDangerousGoods;

            return this;
        }


        public BargeBuilder withCapacityTeu(Double capacityTeu) {

            this.capacityTeu = capacityTeu;

            return this;
        }


        public BargeBuilder withCapacityTons(Double capacityTons) {

            this.capacityTons = capacityTons;

            return this;
        }


        public Barge build() {

            Barge barge = new Barge();
            barge.name = this.name;
            barge.width = this.width;
            barge.draught = this.draught;
            barge.operator = this.operator;
            barge.length = this.length;
            barge.suitabilityDangerousGoods = this.suitabilityDangerousGoods;
            barge.bays = this.bays;
            barge.mmsi = this.mmsi;
            barge.capacityTeu = this.capacityTeu;
            barge.capacityTons = this.capacityTons;
            barge.tiers = this.tiers;
            barge.rows = this.rows;
            barge.eni = this.eni;

            return barge;
        }


        public Barge buildAndValidate() {

            Barge barge = this.build();

            Validator.validate(barge);

            return barge;
        }
    }
}
