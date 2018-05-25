package net.contargo.intermodal.domain;

import javax.validation.constraints.Min;
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
 * @note_german  Spezielle Ladeeinheiten des Kombinierten Verkehrs sind {@link Container},
 *               {@link SwapBody Wechselbehälter}, {@link Trailer Sattelauflieger}.
 * @note_english  Loading units in combined traffic are {@link Container}, {@link SwapBody} and {@link Trailer}.
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

    void setIdentification(String identification) {

        this.identification = identification;
    }


    void setNumber(String number) {

        this.number = number;
    }


    void setCategory(LoadingUnitCategory category) {

        this.category = category;
    }


    void setWeightBruttoMax(Double weightBruttoMax) {

        this.weightBruttoMax = weightBruttoMax;
    }


    void setWeightNettoMax(Double weightNettoMax) {

        this.weightNettoMax = weightNettoMax;
    }


    void setWeightTara(Double weightTara) {

        this.weightTara = weightTara;
    }


    void setCondition(String condition) {

        this.condition = condition;
    }


    void setReefer(Boolean reefer) {

        this.reefer = reefer;
    }


    void setOperator(String operator) {

        this.operator = operator;
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
