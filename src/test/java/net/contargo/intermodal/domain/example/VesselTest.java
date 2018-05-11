package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.Operator;
import net.contargo.intermodal.domain.Vessel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class VesselTest {

    @Test
    void ensureVesselCanBeCreated() {

        Vessel vessel = Vessel.VesselBuilder.newVessel()
                .withName("My Vessel")
                .withMmsi("021112345")
                .withImo("050XXXXX")
                .withOperator(new Operator())
                .buildAndValidate();

        assertEquals("My Vessel", vessel.getName());
        assertEquals("021112345", vessel.getMmsi());
        assertEquals("050XXXXX", vessel.getImo());
        assertNotNull(vessel.getOperator());
    }
}
