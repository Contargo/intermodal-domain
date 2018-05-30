package net.contargo.intermodal.domain;

import systems.uom.common.Imperial;

import tec.units.ri.unit.Units;


/**
 * Enum for units of mass needed by DIGIT.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */

public enum MassUnit {

    KILOGRAM,
    TON,
    TEU;

    javax.measure.Unit toUnit() {

        switch (this) {
            case KILOGRAM:
                return Units.KILOGRAM;

            case TON:
                return Imperial.METRIC_TON;

            // TODO - Custom Quantity for TEU
            case TEU:
                return Imperial.METRIC_TON;

            default:
                return Units.METRE;
        }
    }
}
