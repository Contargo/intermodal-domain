package net.contargo.intermodal.domain.loadingUnit;

/**
 * Trailer vehicle which has no front axle so a substantial part of its total weight is transferred to a tractor unit.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Sattelanhänger
 * @name_english  semi trailer
 * @synonym_german  Sattelauflieger, Trailer
 * @definition_german  Anhängerfahrzeug, bei dem anstelle der bei Gelenk-Deichselanhägern vorhandenen ersten Achse eine
 *                     Sattelvorrichtung angeordnet ist und ein wesentlicher Teil seines Gesamtgewichts auf eine
 *                     Sattelzugmaschine übertragen wird. (@see DIN 70010:2001, 2.3 — modifiziert, „(siehe 1.2.2.3.2)
 *                     (auch Deichselachse (Dolly))“ gestrichen, Anmerkung 1 hinzugefügt)
 * @definition_english  Trailer vehicle which has no front axle so a substantial part of its total weight is
 *                      transferred to a tractor unit. (@see DIN 70010:2001, 2.3 — modified, „(see 1.2.2.3.2) (auch
 *                      Deichselachse (Dolly))“ gestrichen, Anmerkung 1 hinzugefügt)
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Trailer extends LoadingUnit {

    /**
     * e.g&#046; XL, ...
     */
    private String type;

    /**
     * in meter.
     */
    private double size;

    private boolean craneable;

    public Trailer() {

        super.withCategory(LoadingUnitCategory.TRAILER);
    }

    public Trailer withType(String type) {

        this.type = type;

        return this;
    }


    public Trailer withSize(double size) {

        this.size = size;

        return this;
    }


    public Trailer isCraneable(boolean craneable) {

        this.craneable = craneable;

        return this;
    }


    @Override
    public Trailer withIdentification(String identification) {

        super.withIdentification(identification);

        return this;
    }


    @Override
    public Trailer withNumber(String number) {

        super.withNumber(number);

        return this;
    }


    @Override
    public Trailer withWeightBruttoMax(double weightBruttoMax) {

        super.withWeightBruttoMax(weightBruttoMax);

        return this;
    }


    @Override
    public Trailer withWeightNettoMax(double weightNettoMax) {

        super.withWeightNettoMax(weightNettoMax);

        return this;
    }


    @Override
    public Trailer withWeightTara(double weightTara) {

        super.withWeightTara(weightTara);

        return this;
    }


    @Override
    public Trailer withCondition(String condition) {

        super.withCondition(condition);

        return this;
    }


    @Override
    public Trailer isReefer(boolean reefer) {

        super.isReefer(reefer);

        return this;
    }


    @Override
    public Trailer withOperator(String operator) {

        super.withOperator(operator);

        return this;
    }


    public String getType() {

        return type;
    }


    public double getSize() {

        return size;
    }


    public boolean isCraneable() {

        return craneable;
    }
}
