package net.contargo.intermodal.domain;

import systems.uom.common.USCustomary;

import tec.units.ri.unit.Units;


/**
 * Enum for units of length needed by DIGIT.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public enum LengthUnit {

    METRE,
    FOOT;

    javax.measure.Unit toUnit() {

        switch (this) {
            case METRE:
                return Units.METRE;

            case FOOT:
                return USCustomary.FOOT;

            default:
                return Units.METRE;
        }
    }
}
