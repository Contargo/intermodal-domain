package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import tec.units.ri.quantity.Quantities;

import javax.measure.Quantity;
import javax.measure.quantity.Mass;


/**
 * Capacity of a {@link Barge}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Kapazität
 * @name_english  capacity
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
class Capacity {

    // TODO - Custom Quantity for TEU
    private Double teu;
    @JsonDeserialize(using = QuantityJsonDeserializer.class)
    private Quantity<Mass> tons;

    public Double getTeu() {

        return teu;
    }


    void setTeu(Double teu) {

        this.teu = teu;
    }


    @JsonSerialize(using = QuantityJsonSerializer.class)
    public Quantity<Mass> getTons() {

        return tons;
    }


    @JsonIgnore
    public double getTonsValue() {

        return tons.getValue().doubleValue();
    }


    void setTons(Quantity<Mass> tons) {

        this.tons = tons;
    }
}
