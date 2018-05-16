package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.Barge;
import net.contargo.intermodal.domain.Operator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class BargeTest {

    @Test
    void ensureCanBeCreated() {

        Barge barge = Barge.BargeBuilder.newBarge()
                .withName("My Barge")
                .withMmsi("021112345")
                .withEni("050XXXXX")
                .withOperator(new Operator())
                .withLength(35.0)
                .withWidth(5.0)
                .withDraught(5.0)
                .withBays(4)
                .withRows(8)
                .withTiers(2)
                .withSuitabilityDangerousGoods(true)
                .withCapacityTeu(200.0)
                .withCapacityTons(3400.0)
                .buildAndValidate();

        assertEquals("My Barge", barge.getName());
        assertEquals("021112345", barge.getMmsi());
        assertEquals("050XXXXX", barge.getEni());
        assertNotNull(barge.getOperator());
        assertEquals(35.0, barge.getLength().doubleValue());
        assertEquals(5.0, barge.getWidth().doubleValue());
        assertEquals(5.0, barge.getDraught().doubleValue());
        assertEquals(4, barge.getBays().intValue());
        assertEquals(8, barge.getRows().intValue());
        assertEquals(2, barge.getTiers().intValue());
        assertTrue(barge.getSuitabilityDangerousGoods());
        assertEquals(200.0, barge.getCapacityTeu().doubleValue());
        assertEquals(3400.0, barge.getCapacityTons().doubleValue());
    }
}
