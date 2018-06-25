package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.measure.Quantity;
import javax.measure.quantity.Mass;

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
 * @minimum_requirement  number, category (is set automatically), reefer (default = false)
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(
    {
        @JsonSubTypes.Type(value = Container.class, name = "container"),
        @JsonSubTypes.Type(value = SwapBody.class, name = "swapBody"),
        @JsonSubTypes.Type(value = Trailer.class, name = "trailer")
    }
)
public abstract class LoadingUnit {

    /**
     * e.g&#046; BIC, ILU, SOC.
     */
    @LoadingUnitNumberConstraint(message = "identification has to be valid BIC/ILU")
    private String identification;

    /**
     * BIC, ILU (4 characters, 7 digits).
     */
    @NotNull(message = "number is part of minimum requirement and must not be null")
    @LoadingUnitNumberConstraint(message = "number has to be valid BIC/ILU")
    private String number;

    /**
     * Is set automatically.
     */
    @NotNull(message = "category is part of minimum requirement and must not be null")
    private LoadingUnitCategory category;

    /**
     * everything in kg.
     */
    private Weight weight;

    /**
     * german examples in Ordnung (i.O.), schadhaft.
     */
    private String condition;

    /**
     * Is Loading Unit refrigerated?
     */
    @NotNull(message = "reefer is part of minimum requirement and must not be null")
    private boolean reefer;

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


    void setWeight(Weight weight) {

        this.weight = weight;
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


    @JsonIgnore
    public Quantity<Mass> getWeightBruttoMax() {

        return weight.getBruttoMax();
    }


    @JsonIgnore
    public Quantity<Mass> getWeightNettoMax() {

        return weight.getNettoMax();
    }


    @JsonIgnore
    public Quantity<Mass> getWeightTare() {

        return weight.getTare();
    }


    public Weight getWeight() {

        return weight;
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
