package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.StatusLU;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class StatusLUTest {

    @Test
    void canBeCreated() {

        StatusLU statusLU = StatusLU.Builder.newStatusLU()
                .isReadyForLoading(true)
                .isLoaded(false)
                .isInspectionOut(false)
                .isOut(false)
                .hasInspectionIn(true)
                .isIn(true)
                .isReadyForUnloading(false)
                .isUnloaded(true)
                .buildAndValidate();

        assertTrue(statusLU.isReadyForLoading());
        assertTrue(statusLU.getInspectionIn());
        assertTrue(statusLU.isIn());
        assertTrue(statusLU.isUnloaded());
        assertFalse(statusLU.isLoaded());
        assertFalse(statusLU.getInspectionOut());
        assertFalse(statusLU.isOut());
        assertFalse(statusLU.isReadyForUnloading());
    }
}
