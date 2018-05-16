package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.Chassis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class ChassisTest {

    @Test
    void ensureCanBeCreated() {

        Chassis chassis = Chassis.ChassisBuilder.newChassis()
                .withNumberPlate("DU CO 1782")
                .withMot(2020, 5, 22)
                .withType("Multichassis")
                .withAxles(2)
                .withSize(8.0)
                .withHeight(2.0)
                .withEuAuthorization(true)
                .withSt(true)
                .withSuitabilityDangerousGoods(true)
                .withSuitabilityWaste(true)
                .withSuitabilityReefer(true)
                .withWeightTara(500.0)
                .buildAndValidate();

        assertEquals("DU CO 1782", chassis.getNumberPlate());
        assertEquals("2020-05-22T00:00:00.000Z", chassis.getMot());
        assertEquals("Multichassis", chassis.getType());
        assertEquals(2, chassis.getAxles().intValue());
        assertEquals(8.0, chassis.getSize().doubleValue());
        assertEquals(2.0, chassis.getHeight().doubleValue());
        assertTrue(chassis.getEuAuthorization());
        assertTrue(chassis.getSt());
        assertTrue(chassis.getSuitabilityDangerousGoods());
        assertTrue(chassis.getSuitabilityWaste());
        assertTrue(chassis.getSuitabilityReefer());
        assertEquals(500.0, chassis.getWeightTara().doubleValue());
    }
}
