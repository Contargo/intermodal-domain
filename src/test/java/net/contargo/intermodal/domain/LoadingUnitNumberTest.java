package net.contargo.intermodal.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class LoadingUnitNumberTest {

    @Test
    void ensureWrongLengthIsDetected() {

        assertTrue(LoadingUnitNumber.isValidBIC("MSKU1806510"));
        assertFalse(LoadingUnitNumber.isValidBIC("MSKU18065100"));
    }


    @Test
    void ensureWrongOwnerCodeIsDetected() {

        assertFalse(LoadingUnitNumber.isValidBIC("M1KU1806510"));
    }


    @Test
    void ensureWrongProductKeyIsDetected() {

        assertFalse(LoadingUnitNumber.isValidBIC("MSK31806510"));
    }


    @Test
    void ensureWrongSerialKeyIsDetected() {

        assertFalse(LoadingUnitNumber.isValidBIC("MSKU18A6510"));
    }


    @Test
    void ensureWrongCheckDigitIsDetected() {

        assertFalse(LoadingUnitNumber.isValidBIC("MSKU1806513"));
    }
}
