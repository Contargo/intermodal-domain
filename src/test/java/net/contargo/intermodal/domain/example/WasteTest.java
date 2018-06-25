package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Container;
import net.contargo.intermodal.domain.MassUnit;
import net.contargo.intermodal.domain.Waste;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Contains examples of the creation and validation of {@link net.contargo.intermodal.domain.Waste}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class WasteTest {

    @Test
    void ensureCanBeCreatedWithAllInformation() {

        Waste waste = Waste.newBuilder()
                .withPosition(1)
                .withKeyID("03 03 01")
                .withWasteRegulationNumber("02")
                .withReceiptNumber("65478")
                .withWeightNetto(75.0, MassUnit.KILOGRAM)
                .buildAndValidate();

        assertEquals(1, waste.getPosition().intValue());
        assertEquals("03 03 01", waste.getKeyID());
        assertEquals("02", waste.getWasteRegulationNumber());
        assertEquals("65478", waste.getReceiptNumber());
        assertNotNull(waste.getWeight());
        assertEquals(75.0, waste.getWeightNetto().getValue().doubleValue());
    }


    @Test
    void ensureCanBeCreatedWithMinimumRequirements() {

        Waste.newBuilder().withKeyID("03 03 01").buildAndValidate();
    }


    @Test
    void ensureCanBeCopied() {

        Waste waste = Waste.newBuilder()
                .withPosition(1)
                .withKeyID("03 03 01")
                .withWasteRegulationNumber("02")
                .withReceiptNumber("65478")
                .withWeightNetto(75.0, MassUnit.KILOGRAM)
                .buildAndValidate();

        Waste copiedWaste = Waste.newBuilder(waste).buildAndValidate();

        assertEquals(1, copiedWaste.getPosition().intValue());
        assertEquals("03 03 01", copiedWaste.getKeyID());
        assertEquals("02", copiedWaste.getWasteRegulationNumber());
        assertEquals("65478", copiedWaste.getReceiptNumber());
        assertNotNull(copiedWaste.getWeight());
        assertEquals(75.0, copiedWaste.getWeightNetto().getValue().doubleValue());
    }


    @Test
    void ensureWasteCanBeValidated() {

        assertThrows(IllegalStateException.class, () -> Waste.newBuilder().buildAndValidate());
    }


    @Test
    void ensureWeightCanBeSetInTons() {

        Waste waste = Waste.newBuilder().withKeyID("03 03 01").withWeightNetto(0.5, MassUnit.TON).buildAndValidate();

        assertEquals(500.0, waste.getWeightNetto().getValue().doubleValue(), 0.1);
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        Waste waste = Waste.newBuilder()
                .withPosition(1)
                .withKeyID("03 03 01")
                .withWasteRegulationNumber("02")
                .withReceiptNumber("65478")
                .withWeightNetto(75.0, MassUnit.KILOGRAM)
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(waste);

        Waste deserialize = mapper.readValue(jsonString, Waste.class);

        assertEquals(1, deserialize.getPosition().intValue());
        assertEquals("03 03 01", deserialize.getKeyID());
        assertEquals("02", deserialize.getWasteRegulationNumber());
        assertEquals("65478", deserialize.getReceiptNumber());
        assertNotNull(deserialize.getWeight());
        assertEquals(75.0, deserialize.getWeightNetto().getValue().doubleValue());
    }
}
