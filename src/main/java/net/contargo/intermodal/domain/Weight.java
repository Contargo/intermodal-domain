package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.measure.Quantity;
import javax.measure.quantity.Mass;


/**
 * Weight of a {@link LoadingUnit}, {@link Truck}, {@link Chassis}, {@link Waste} or {@link Order}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Gewicht
 * @name_english  weight
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class Weight {

    /**
     * in kg.
     *
     * @note_german  Abweichung von der DIGIT 2018-04: Eigentlich Brutto.Max, wird in nächster Version der DIGIT
     *               angepasst.
     * @note_english  Difference from Digit 2018-04: Should be Brutto.Max but will be changed in next version of DIGIT
     */
    @JsonDeserialize(using = QuantityJsonDeserializer.class)
    private Quantity<Mass> bruttoMax;

    /**
     * in kg.
     *
     * @note_german  Abweichung von der DIGIT 2018-04: Eigentlich Netto.Max, wird in nächster Version der DIGIT
     *               angepasst.
     * @note_english  Difference from Digit 2018-04: Should be Netto.Max but will be changed in next version of DIGIT
     */
    @JsonDeserialize(using = QuantityJsonDeserializer.class)
    private Quantity<Mass> nettoMax;

    /**
     * in kg.
     */
    @JsonDeserialize(using = QuantityJsonDeserializer.class)
    private Quantity<Mass> brutto;

    /**
     * in kg.
     */
    @JsonDeserialize(using = QuantityJsonDeserializer.class)
    private Quantity<Mass> netto;

    /**
     * in kg.
     */
    @JsonDeserialize(using = QuantityJsonDeserializer.class)
    private Quantity<Mass> tare;

    Weight() {

        // OK
    }

    @JsonSerialize(using = QuantityJsonSerializer.class)
    public Quantity<Mass> getBruttoMax() {

        return bruttoMax;
    }


    public void setBruttoMax(Quantity<Mass> bruttoMax) {

        this.bruttoMax = bruttoMax;
    }


    @JsonSerialize(using = QuantityJsonSerializer.class)
    public Quantity<Mass> getNettoMax() {

        return nettoMax;
    }


    public void setNettoMax(Quantity<Mass> nettoMax) {

        this.nettoMax = nettoMax;
    }


    @JsonSerialize(using = QuantityJsonSerializer.class)
    public Quantity<Mass> getBrutto() {

        return brutto;
    }


    public void setBrutto(Quantity<Mass> brutto) {

        this.brutto = brutto;
    }


    @JsonSerialize(using = QuantityJsonSerializer.class)
    public Quantity<Mass> getNetto() {

        return netto;
    }


    public void setNetto(Quantity<Mass> netto) {

        this.netto = netto;
    }


    @JsonSerialize(using = QuantityJsonSerializer.class)
    public Quantity<Mass> getTare() {

        return tare;
    }


    public void setTare(Quantity<Mass> tare) {

        this.tare = tare;
    }
}
