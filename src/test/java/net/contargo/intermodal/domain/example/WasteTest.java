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
                .withPosition("position")
                .withKeyID("03 03 01")
                .withWasteRegulationNumber("02")
                .withReceiptNumber("65478")
                .withWeightNetto(75.0)
                .buildAndValidate();

        assertEquals("position", waste.getPosition());
        assertEquals("03 03 01", waste.getKeyID());
        assertEquals("02", waste.getWasteRegulationNumber());
        assertEquals("65478", waste.getReceiptNumber());
        assertEquals(75.0, waste.getWeightNetto().doubleValue());
    }


    @Test
    void ensureWasteCanBeValidated() {

        assertThrows(IllegalStateException.class,
            () ->
                Waste.Builder.newWaste()
                    .withPosition("position")
                    .withWasteRegulationNumber("02")
                    .withReceiptNumber("65478")
                    .withWeightNetto(75.0)
                    .buildAndValidate());
    }
}
