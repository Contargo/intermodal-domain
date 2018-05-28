package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.Waste;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Contains examples of the creation and validation of {@link net.contargo.intermodal.domain.Waste}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class WasteTest {

    @Test
    void ensureCanBeCreatedWithAllInformation() {

        Waste waste = Waste.Builder.newWaste()
                .withPosition(1)
                .withKeyID("03 03 01")
                .withWasteRegulationNumber("02")
                .withReceiptNumber("65478")
                .withWeightNetto(75.0)
                .buildAndValidate();

        assertEquals(1, waste.getPosition().intValue());
        assertEquals("03 03 01", waste.getKeyID());
        assertEquals("02", waste.getWasteRegulationNumber());
        assertEquals("65478", waste.getReceiptNumber());
        assertNotNull(waste.getWeight());
        assertEquals(75.0, waste.getWeightNetto().doubleValue());
    }


    @Test
    void ensureCanBeCreatedWithMinimumRequirements() {

        Waste.Builder.newWaste().withKeyID("03 03 01").buildAndValidate();
    }


    @Test
    void ensureWasteCanBeValidated() {

        assertThrows(IllegalStateException.class, () -> Waste.Builder.newWaste().buildAndValidate());
    }
}
