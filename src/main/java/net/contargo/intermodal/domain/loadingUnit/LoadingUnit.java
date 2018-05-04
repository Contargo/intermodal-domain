package net.contargo.intermodal.domain.loadingUnit;

import net.contargo.intermodal.domain.Operator;

import javax.validation.constraints.NotNull;


/**
 * Physical transport unit which can include wares and goods.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Ladeeinheit
 * @name_english  loading unit
 * @abbreviation_german  LE
 * @abbreviation_english  LU
 * @definition_german  Physische Transporteinheit, die Waren und Güter umschließen kann.
 * @definition_english  Physical transport unit which can include wares and goods.
 * @note_german  Spezielle Ladeeinheiten des Kombinierten Verkehrs sind
 *               {@link net.contargo.intermodal.domain.loadingUnit.Container},
 *               {@link net.contargo.intermodal.domain.loadingUnit.SwapBody Wechselbehälter},
 *               {@link net.contargo.intermodal.domain.loadingUnit.Trailer Sattelauflieger}.
 * @note_english  Loading units in combined traffic are {@link net.contargo.intermodal.domain.loadingUnit.Container},
 *                {@link net.contargo.intermodal.domain.loadingUnit.SwapBody} and
 *                {@link net.contargo.intermodal.domain.loadingUnit.Trailer}.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public abstract class LoadingUnit {

    /**
     * e.g&#046; BIC, ILU, SOC.
     */
    private String identification;

    /**
     * BIC, ILU (4 characters, 7 digits).
     */
    @NotNull(message = "number is part of minimum requirement")
    private String number;

    /**
     * Is set automatically.
     */
    @NotNull(message = "category is part of minimum requirement")
    private LoadingUnitCategory category;

    /**
     * in kg.
     */
    private Double weightBruttoMax;

    /**
     * in kg.
     */
    private Double weightNettoMax;

    /**
     * in kg.
     */
    private Double weightTara;

    /**
     * german examples in Ordnung (i.O.), schadhaft.
     */
    private String condition;

    /**
     * Is Loading Unit refrigerated?
     */
    @NotNull(message = "reefer is part of minimum requirement")
    private Boolean reefer;

    /**
     * Name of {@link Operator}.
     */
    private String operator;

    LoadingUnit withCategory(LoadingUnitCategory loadingUnitCategory) {

        this.category = loadingUnitCategory;

        return this;
    }


    LoadingUnit withIdentification(String identification) {

        this.identification = identification;

        return this;
    }


    LoadingUnit withNumber(String number) {

        this.number = number;

        return this;
    }


    LoadingUnit withWeightBruttoMax(double weightBruttoMax) {

        this.weightBruttoMax = weightBruttoMax;

        return this;
    }


    LoadingUnit withWeightNettoMax(double weightNettoMax) {

        this.weightNettoMax = weightNettoMax;

        return this;
    }


    LoadingUnit withWeightTara(double weightTara) {

        this.weightTara = weightTara;

        return this;
    }


    LoadingUnit withCondition(String condition) {

        this.condition = condition;

        return this;
    }


    LoadingUnit isReefer(Boolean reefer) {

        this.reefer = reefer;

        return this;
    }


    LoadingUnit withOperator(String operator) {

        this.operator = operator;

        return this;
    }


    public String getIdentification() {

        return identification;
    }


    public String getNumber() {

        return number;
    }


    public LoadingUnitCategory getCategory() {

        return category;
    }


    public Double getWeightBruttoMax() {

        return weightBruttoMax;
    }


    public Double getWeightNettoMax() {

        return weightNettoMax;
    }


    public Double getWeightTara() {

        return weightTara;
    }


    public String getCondition() {

        return condition;
    }


    public Boolean isReefer() {

        return reefer;
    }


    public String getOperator() {

        return operator;
    }
}
