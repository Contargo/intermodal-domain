package net.contargo.intermodal.domain;

import javax.validation.constraints.NotNull;


/**
 * Substances or objects that are dangerous in context of public safety and order because of their nature, properties
 * or state.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Gefahrgut
 * @name_english  dangerous goods
 * @definition_german  Stoffe und Gegenstände, von denen auf Grund ihrer Natur, ihrer Eigenschaften oder ihres
 *                     Zustandes im Zusammenhang mit der Beförderung Gefahren für die öffentliche Sicherheit oder
 *                     Ordnung, insbesondere für die Allgemeinheit, für wichtige Gemeingüter, für Leben und Gesundheit
 *                     von Menschen sowie für Tiere und Sachen ausgehen können.
 * @definition_english  Substances or objects that are dangerous in context of public safety and order because of their
 *                      nature, properties or state.
 * @note_german  Bei verschiedenen Verkehrsträgern kommt das entsprechende Regelwerk zum Tragen.
 * @note_english  There are different rules for different modes of transport.
 * @minimum_requirement  unNumber
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class DangerousGoods {

    /**
     * 4 digits.
     */
    @NotNull(message = "unNumber is part of minimum requirement")
    private String unNumber;

    /**
     * @name_german  Stoffbezeichnung
     */
    private String material;

    /**
     * @name_german  Gefahrzettel
     */
    private String dangerNote;

    private String packagingGroup;

    /**
     * @name_german  Versandstücke
     */
    private Integer packages;

    private String totalQuantity;

    private TunnelRestrictionCode tunnelRestrictionCode;

    /**
     * @name_german  Fahrwegbestimmung
     */
    private String mandatoryRouting;

    private Boolean limitedQuantity;

    /**
     * @name_german  Umweltgefährdend
     */
    private Boolean marinePollutants;

    public String getUnNumber() {

        return unNumber;
    }


    public String getMaterial() {

        return material;
    }


    public String getDangerNote() {

        return dangerNote;
    }


    public String getPackagingGroup() {

        return packagingGroup;
    }


    public Integer getPackages() {

        return packages;
    }


    public String getTotalQuantity() {

        return totalQuantity;
    }


    public TunnelRestrictionCode getTunnelRestrictionCode() {

        return tunnelRestrictionCode;
    }


    public String getMandatoryRouting() {

        return mandatoryRouting;
    }


    public Boolean getLimitedQuantity() {

        return limitedQuantity;
    }


    public Boolean getMarinePollutants() {

        return marinePollutants;
    }

    public static final class DangerousGoodsBuilder {

        private String unNumber;
        private String material;
        private String dangerNote;
        private String packagingGroup;
        private Integer packages;
        private String totalQuantity;
        private TunnelRestrictionCode tunnelRestrictionCode;
        private String mandatoryRouting;
        private Boolean limitedQuantity;
        private Boolean marinePollutants;

        private DangerousGoodsBuilder() {
        }

        public static DangerousGoodsBuilder newDangerousGoods() {

            return new DangerousGoodsBuilder();
        }


        public DangerousGoodsBuilder withUnNumber(String unNumber) {

            this.unNumber = unNumber;

            return this;
        }


        public DangerousGoodsBuilder withMaterial(String material) {

            this.material = material;

            return this;
        }


        public DangerousGoodsBuilder withDangerNote(String dangerNote) {

            this.dangerNote = dangerNote;

            return this;
        }


        public DangerousGoodsBuilder withPackagingGroup(String packagingGroup) {

            this.packagingGroup = packagingGroup;

            return this;
        }


        public DangerousGoodsBuilder withPackages(Integer packages) {

            this.packages = packages;

            return this;
        }


        public DangerousGoodsBuilder withTotalQuantity(String totalQuantity) {

            this.totalQuantity = totalQuantity;

            return this;
        }


        public DangerousGoodsBuilder withTunnelRestrictionCode(TunnelRestrictionCode tunnelRestrictionCode) {

            this.tunnelRestrictionCode = tunnelRestrictionCode;

            return this;
        }


        public DangerousGoodsBuilder withMandatoryRouting(String mandatoryRouting) {

            this.mandatoryRouting = mandatoryRouting;

            return this;
        }


        public DangerousGoodsBuilder withLimitedQuantity(Boolean limitedQuantity) {

            this.limitedQuantity = limitedQuantity;

            return this;
        }


        public DangerousGoodsBuilder withMarinePollutants(Boolean marinePollutants) {

            this.marinePollutants = marinePollutants;

            return this;
        }


        public DangerousGoods build() {

            DangerousGoods dangerousGoods = new DangerousGoods();
            dangerousGoods.dangerNote = this.dangerNote;
            dangerousGoods.packagingGroup = this.packagingGroup;
            dangerousGoods.material = this.material;
            dangerousGoods.tunnelRestrictionCode = this.tunnelRestrictionCode;
            dangerousGoods.unNumber = this.unNumber;
            dangerousGoods.totalQuantity = this.totalQuantity;
            dangerousGoods.packages = this.packages;
            dangerousGoods.limitedQuantity = this.limitedQuantity;
            dangerousGoods.marinePollutants = this.marinePollutants;
            dangerousGoods.mandatoryRouting = this.mandatoryRouting;

            return dangerousGoods;
        }


        public DangerousGoods buildAndValidate() {

            DangerousGoods dangerousGoods = this.build();

            Validator.validate(dangerousGoods);

            return dangerousGoods;
        }
    }
}
