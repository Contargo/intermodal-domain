package net.contargo.intermodal.domain;

import com.fasterxml.jackson.core.JsonProcessingException;

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
    @NotNull(message = "unNumber is part of minimum requirement and must not be null")
    private String unNumber;

    /**
     * @name_german  Stoffbezeichnung
     */
    private String material;

    /**
     * @name_german  Gefahrzettel
     */
    private Boolean dangerNote;

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

    private DangerousGoods() {

        // OK
    }

    /**
     * Creates a new builder for {@link DangerousGoods}.
     *
     * @return  new builder
     */
    public static Builder newBuilder() {

        return new Builder();
    }


    /**
     * Creates a new builder with the values of another {@link DangerousGoods}.
     *
     * @param  dangerousGoods  that should be copied.
     *
     * @return  new builder with values of given dangerousGoods.
     */
    public static Builder newBuilder(DangerousGoods dangerousGoods) {

        return new Builder().withDangerNote(dangerousGoods.getDangerNote())
            .withPackagingGroup(dangerousGoods.getPackagingGroup())
            .withMaterial(dangerousGoods.getMaterial())
            .withTunnelRestrictionCode(dangerousGoods.getTunnelRestrictionCode())
            .withUnNumber(dangerousGoods.getUnNumber())
            .withTotalQuantity(dangerousGoods.getTotalQuantity())
            .withPackages(dangerousGoods.getPackages())
            .withLimitedQuantity(dangerousGoods.getLimitedQuantity())
            .withMarinePollutants(dangerousGoods.getMarinePollutants())
            .withMandatoryRouting(dangerousGoods.getMandatoryRouting());
    }


    /**
     * Starts a new step builder pattern for {@link DangerousGoods}. Other than the normal {@link Builder} the
     * {@link StepBuilder} will enforce the order in which fields are set to make sure the minimum requirements are
     * fulfilled.
     *
     * @return  IUnNumber
     */
    public static IUnNumber newStepBuilder() {

        return new StepBuilder();
    }


    public String getUnNumber() {

        return unNumber;
    }


    public String getMaterial() {

        return material;
    }


    public Boolean getDangerNote() {

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


    @Override
    public String toString() {

        try {
            return this.getClass().getSimpleName() + ": " + JsonStringMapper.map(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "";
    }

    public interface IBuild {

        DangerousGoods build();


        DangerousGoods buildAndValidate();


        IBuild withMarinePollutants(Boolean val);


        IBuild withLimitedQuantity(Boolean limitedQuantity);


        IBuild withMandatoryRouting(String mandatoryRouting);


        IBuild withTunnelRestrictionCode(TunnelRestrictionCode tunnelRestrictionCode);


        IBuild withTotalQuantity(String totalQuantity);


        IBuild withPackages(Integer packages);


        IBuild withPackagingGroup(String packagingGroup);


        IBuild withDangerNote(Boolean dangerNote);


        IBuild withMaterial(String material);
    }

    public interface IUnNumber {

        IBuild withUnNumber(String val);
    }

    public static final class Builder {

        private String unNumber;
        private String material;
        private Boolean dangerNote;
        private String packagingGroup;
        private Integer packages;
        private String totalQuantity;
        private TunnelRestrictionCode tunnelRestrictionCode;
        private String mandatoryRouting;
        private Boolean limitedQuantity;
        private Boolean marinePollutants;

        private Builder() {
        }

        public Builder withUnNumber(String unNumber) {

            this.unNumber = unNumber;

            return this;
        }


        public Builder withMaterial(String material) {

            this.material = material;

            return this;
        }


        public Builder withDangerNote(Boolean dangerNote) {

            this.dangerNote = dangerNote;

            return this;
        }


        public Builder withPackagingGroup(String packagingGroup) {

            this.packagingGroup = packagingGroup;

            return this;
        }


        public Builder withPackages(Integer packages) {

            this.packages = packages;

            return this;
        }


        public Builder withTotalQuantity(String totalQuantity) {

            this.totalQuantity = totalQuantity;

            return this;
        }


        public Builder withTunnelRestrictionCode(TunnelRestrictionCode tunnelRestrictionCode) {

            this.tunnelRestrictionCode = tunnelRestrictionCode;

            return this;
        }


        public Builder withMandatoryRouting(String mandatoryRouting) {

            this.mandatoryRouting = mandatoryRouting;

            return this;
        }


        public Builder withLimitedQuantity(Boolean limitedQuantity) {

            this.limitedQuantity = limitedQuantity;

            return this;
        }


        public Builder withMarinePollutants(Boolean marinePollutants) {

            this.marinePollutants = marinePollutants;

            return this;
        }


        /**
         * Builds {@link DangerousGoods} without input validation.
         *
         * @return  new {@link DangerousGoods} with attributes specified in {@link Builder}
         */
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


        /**
         * Validates the input and builds {@link DangerousGoods}. Throws IllegalStateException if input doesn't fulfill
         * the minimum requirement of {@link DangerousGoods}.
         *
         * @return  new {@link DangerousGoods} with attributes specified in {@link Builder}
         */
        public DangerousGoods buildAndValidate() {

            DangerousGoods dangerousGoods = this.build();

            MinimumRequirementValidator.validate(dangerousGoods);

            return dangerousGoods;
        }
    }

    public static final class StepBuilder implements IUnNumber, IBuild {

        private Boolean marinePollutants;
        private Boolean limitedQuantity;
        private String mandatoryRouting;
        private TunnelRestrictionCode tunnelRestrictionCode;
        private String totalQuantity;
        private Integer packages;
        private String packagingGroup;
        private Boolean dangerNote;
        private String material;
        @NotNull(message = "unNumber is part of minimum requirement and must not be null")
        private String unNumber;

        private StepBuilder() {
        }

        @Override
        public IBuild withMarinePollutants(Boolean val) {

            marinePollutants = val;

            return this;
        }


        @Override
        public IBuild withLimitedQuantity(Boolean val) {

            limitedQuantity = val;

            return this;
        }


        @Override
        public IBuild withMandatoryRouting(String val) {

            mandatoryRouting = val;

            return this;
        }


        @Override
        public IBuild withTunnelRestrictionCode(TunnelRestrictionCode val) {

            tunnelRestrictionCode = val;

            return this;
        }


        @Override
        public IBuild withTotalQuantity(String val) {

            totalQuantity = val;

            return this;
        }


        @Override
        public IBuild withPackages(Integer val) {

            packages = val;

            return this;
        }


        @Override
        public IBuild withPackagingGroup(String val) {

            packagingGroup = val;

            return this;
        }


        @Override
        public IBuild withDangerNote(Boolean val) {

            dangerNote = val;

            return this;
        }


        @Override
        public IBuild withMaterial(String val) {

            material = val;

            return this;
        }


        @Override
        public IBuild withUnNumber(String val) {

            unNumber = val;

            return this;
        }


        /**
         * Builds {@link DangerousGoods} without input validation.
         *
         * @return  new {@link DangerousGoods} with attributes specified in {@link Builder}
         */
        @Override
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


        /**
         * Validates the input and builds {@link DangerousGoods}. Throws IllegalStateException if input doesn't fulfill
         * the minimum requirement of {@link DangerousGoods}.
         *
         * @return  new {@link DangerousGoods} with attributes specified in {@link Builder}
         */
        @Override
        public DangerousGoods buildAndValidate() {

            DangerousGoods dangerousGoods = this.build();

            MinimumRequirementValidator.validate(dangerousGoods);

            return dangerousGoods;
        }
    }
}
