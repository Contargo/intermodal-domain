package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.Instant;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * Contains information about pick ups, drop offs and stops of an {@link Order}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
class Transport {

    private Direction direction;
    private PickUp pickUp = new PickUp();
    private DropOff dropOff = new DropOff();
    @NotEmpty(message = "stop is part of minimum requirement")
    private List<Stop> stop = new ArrayList<>();

    void setDirection(Direction direction) {

        this.direction = direction;
    }


    public void addStop(Stop stop) {

        this.stop.add(stop);
    }


    public Direction getDirection() {

        return direction;
    }


    public PickUp getPickUp() {

        return pickUp;
    }


    public DropOff getDropOff() {

        return dropOff;
    }


    @JsonProperty("stop")
    public List<Stop> getStops() {

        return stop;
    }


    public void setPickUp(PickUp pickUp) {

        this.pickUp = pickUp;
    }


    public void setDropOff(DropOff dropOff) {

        this.dropOff = dropOff;
    }

    public static class LoadingUnit {

        private String reference;

        private Boolean empty;
        private Operator operator;

        public Boolean getEmpty() {

            return empty;
        }


        public Boolean isEmpty() {

            return empty;
        }


        void setEmpty(Boolean empty) {

            this.empty = empty;
        }


        public String getReference() {

            return reference;
        }


        void setReference(String reference) {

            this.reference = reference;
        }


        public Operator getOperator() {

            return operator;
        }


        void setOperator(Operator operator) {

            this.operator = operator;
        }
    }
}
