package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * Weight of a {@link LoadingUnit}, {@link Truck}, {@link Chassis}, {@link Waste} or {@link Order}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class Weight {

    /**
     * in kg.
     */
    private Double bruttoMax;

    /**
     * in kg.
     */
    private Double nettoMax;

    /**
     * in kg.
     */
    private Double brutto;

    /**
     * in kg.
     */
    private Double netto;

    /**
     * in kg.
     */
    private Double tara;

    public Double getBruttoMax() {

        return bruttoMax;
    }


    public void setBruttoMax(Double bruttoMax) {

        this.bruttoMax = bruttoMax;
    }


    public Double getNettoMax() {

        return nettoMax;
    }


    public void setNettoMax(Double nettoMax) {

        this.nettoMax = nettoMax;
    }


    public Double getBrutto() {

        return brutto;
    }


    public void setBrutto(Double brutto) {

        this.brutto = brutto;
    }


    public Double getNetto() {

        return netto;
    }


    public void setNetto(Double netto) {

        this.netto = netto;
    }


    public Double getTara() {

        return tara;
    }


    public void setTara(Double tara) {

        this.tara = tara;
    }
}
