package net.contargo.intermodal.domain;

import tec.units.ri.unit.Units;


/**
 * Enum for units of temperature needed by DIGIT.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public enum TemperatureUnit {

    CELSIUS;

    javax.measure.Unit toUnit() {

        switch (this) {
            case CELSIUS:
                return Units.CELSIUS;

            default:
                return Units.CELSIUS;
        }
    }
}
