package net.contargo.intermodal.domain;

/**
 * A seal used in {@link Customs} and {@link LUOrder}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Seal {

    private String type;

    private String number;

    public String getType() {

        return type;
    }


    public void setType(String type) {

        this.type = type;
    }


    public String getNumber() {

        return number;
    }


    public void setNumber(String number) {

        this.number = number;
    }

    public static final class Builder {

        private String type;
        private String number;

        private Builder() {
        }

        public static Builder newSeal() {

            return new Builder();
        }


        public Builder withType(String type) {

            this.type = type;

            return this;
        }


        public Builder withNumber(String number) {

            this.number = number;

            return this;
        }


        public Seal build() {

            Seal seal = new Seal();
            seal.setType(type);
            seal.setNumber(number);

            return seal;
        }
    }
}
