package net.contargo.intermodal.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class LoadingUnitNumberTest {

    @Test
    void ensureWrongBicLengthIsDetected() {

        assertTrue(LoadingUnitNumber.isValidBIC("MSKU1806510"));
        assertTrue(LoadingUnitNumber.isValidBIC("MSKJ1806510"));
        assertTrue(LoadingUnitNumber.isValidBIC("MSKZ1806510"));
        assertFalse(LoadingUnitNumber.isValidBIC("MSKU18065100"));
    }


    @Test
    void ensureWrongBicOwnerCodeIsDetected() {

        assertFalse(LoadingUnitNumber.isValidBIC("M1KU1806510"));
    }


    @Test
    void ensureWrongBicProductKeyIsDetected() {

        assertFalse(LoadingUnitNumber.isValidBIC("MSK31806510"));
    }


    @Test
    void ensureWrongBicSerialKeyIsDetected() {

        assertFalse(LoadingUnitNumber.isValidBIC("MSKU18A6510"));
    }


    @Test
    void ensureWrongBicEquipmentCategoryIsDetected() {

        assertTrue(LoadingUnitNumber.isValidBIC("MSKU1806510"));
        assertTrue(LoadingUnitNumber.isValidBIC("MSKZ1806510"));
        assertTrue(LoadingUnitNumber.isValidBIC("MSKJ1806510"));
        assertFalse(LoadingUnitNumber.isValidBIC("MSKX1806510"));
        assertFalse(LoadingUnitNumber.isValidBIC("MSKZZ1806510"));
    }


    @Test
    void ensureSocCanBeValidated() {

        assertTrue(LoadingUnitNumber.isSOC("XXXU1806510"));
        assertTrue(LoadingUnitNumber.isSOC("NONU1806510"));
        assertFalse(LoadingUnitNumber.isSOC("XXXXU1806510"));
        assertFalse(LoadingUnitNumber.isSOC("XXXB1806510"));
    }


    @Test
    void ensureIluCanBeValidated() {

        assertTrue(LoadingUnitNumber.isValidILU("ABCA0012342"));
        assertFalse(LoadingUnitNumber.isValidILU("ABCAA0012342"));
        assertFalse(LoadingUnitNumber.isValidILU("ABCAA012342"));
    }
}
