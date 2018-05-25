package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.EnvironmentBadge;
import net.contargo.intermodal.domain.Truck;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class TruckTest {

    @Test
    void ensureCanBeCreated() {

        Truck truck = Truck.Builder.newTruck()
                .withNumberPlate("DU CO 1782")
                .withCountryCode("DE")
                .withMot(2020, 5, 22)
                .withEnvironmentBadge(EnvironmentBadge.GREEN)
                .withType("refrigerator truck")
                .withEuAuthorization(true)
                .withST(true)
                .withSuitabilityDangerousGoods(false)
                .withSuitabilityWaste(false)
                .withWeightTara(40000.0)
                .buildAndValidate();

        assertEquals("DU CO 1782", truck.getNumberPlate());
        assertEquals("DE", truck.getCountryCode());
        assertEquals("2020-05-22T00:00:00", truck.getMot());
        assertEquals(EnvironmentBadge.GREEN, truck.getEnvironmentBadge());
        assertEquals("refrigerator truck", truck.getType());
        assertTrue(truck.getEuAuthorization());
        assertTrue(truck.getSt());
        assertFalse(truck.getSuitabilityDangerousGoods());
        assertFalse(truck.getSuitabilityWaste());
        assertEquals(40000.0, truck.getWeightTara().doubleValue());
    }
}
