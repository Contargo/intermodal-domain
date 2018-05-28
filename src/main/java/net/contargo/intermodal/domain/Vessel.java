package net.contargo.intermodal.domain;

import com.fasterxml.jackson.core.JsonProcessingException;


/**
 * A ship build to drive on seas and oceans.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Seeschiff
 * @name_english  vessel
 * @definition_german  Schiff, das zur Fahrt auf Meeren und Ozeanen konzipiert ist.
 * @definition_english  A ship build to drive on seas and oceans.
 * @note_german  Für diese API sind Schiffe relevant, die Ladeeinheiten des Kombinierten Verkehrs transportieren
 *               können.
 * @note_english  In this API only vessels which can transport loading units of combined traffic are relevant.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Vessel implements MeansOfTransport {

    private String name;

    /**
     * Maritime Mobile Service Identity (9 digits).
     */
    private String mmsi;

    /**
     * International Maritime Organization (IMO plus 7 digits).
     */
    private String imo;

    private Operator operator;

    public String getName() {

        return name;
    }


    public String getMmsi() {

        return mmsi;
    }


    public String getImo() {

        return imo;
    }


    public Operator getOperator() {

        return operator;
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

    public static final class Builder {

        private String name;
        private String mmsi;
        private String imo;
        private Operator operator;

        private Builder() {
        }

        public static Builder newVessel() {

            return new Builder();
        }


        public Builder withName(String name) {

            this.name = name;

            return this;
        }


        public Builder withMmsi(String mmsi) {

            this.mmsi = mmsi;

            return this;
        }


        public Builder withImo(String imo) {

            this.imo = imo;

            return this;
        }


        public Builder withOperator(Operator operator) {

            this.operator = operator;

            return this;
        }


        public Vessel build() {

            Vessel vessel = new Vessel();
            vessel.name = this.name;
            vessel.mmsi = this.mmsi;
            vessel.imo = this.imo;
            vessel.operator = this.operator;

            return vessel;
        }


        public Vessel buildAndValidate() {

            Vessel vessel = this.build();

            Validator.validate(vessel);

            return vessel;
        }
    }
}
