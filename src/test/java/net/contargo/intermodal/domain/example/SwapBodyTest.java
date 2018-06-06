package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class SwapBodyTest {

    @Test
    void ensureCanBeCreatedWithAllInformation() {

        SwapBody swapBody = SwapBody.Builder.newSwapBody()
                .withIdentification("OOOCSSSSSS")
                .withNumber("OOOCSSSSSS")
                .withWeightBruttoMax(30480.0, MassUnit.KILOGRAM)
                .withWeightNettoMax(28080.0, MassUnit.KILOGRAM)
                .withWeightTare(2400.0, MassUnit.KILOGRAM)
                .withCondition("i.O.")
                .isReefer(false)
                .withOperator("Contargo")
                .withType("Open Top")
                .withSize(21.58, LengthUnit.FOOT)
                .isStackable(true)
                .buildAndValidate();

        assertEquals("OOOCSSSSSS", swapBody.getIdentification());
        assertEquals("OOOCSSSSSS", swapBody.getNumber());
        assertEquals(LoadingUnitCategory.SWAP_BODY, swapBody.getCategory());
        assertNotNull(swapBody.getWeight());
        assertEquals(30480.0, swapBody.getWeightBruttoMax().getValue().doubleValue());
        assertEquals(28080.0, swapBody.getWeightNettoMax().getValue().doubleValue());
        assertEquals(2400.0, swapBody.getWeightTare().getValue().doubleValue());
        assertEquals("i.O.", swapBody.getCondition());
        assertFalse(swapBody.isReefer());
        assertEquals("Contargo", swapBody.getOperator());
        assertEquals("Open Top", swapBody.getType());
        assertEquals(21.58, swapBody.getSize().getValue().doubleValue());
        assertTrue(swapBody.isStackable());
    }


    @Test
    void ensureCanBeCreatedWithMinimumRequirements() {

        SwapBody.Builder.newSwapBody()
            .withNumber("OOOCSSSSSS")
            .isReefer(false)
            .withType("Open Top")
            .withSize(21.58, LengthUnit.FOOT)
            .isStackable(true)
            .buildAndValidate();
    }


    @Test
    void ensureSizeCanBeSetInMetre() {

        SwapBody swapBody = SwapBody.Builder.newSwapBody()
                .withNumber("OOOCSSSSSS")
                .isReefer(false)
                .withType("Open Top")
                .withSize(6.58, LengthUnit.METRE)
                .isStackable(true)
                .buildAndValidate();

        assertEquals(21.58, swapBody.getSize().getValue().doubleValue(), 0.1);
    }


    @Test
    void ensureWeightCanBeSetInTons() {

        SwapBody swapBody = SwapBody.Builder.newSwapBody()
                .withNumber("OOOCSSSSSS")
                .isReefer(false)
                .withType("Open Top")
                .withSize(6.58, LengthUnit.METRE)
                .isStackable(true)
                .withWeightBruttoMax(30.480, MassUnit.TON)
                .withWeightNettoMax(28.080, MassUnit.TON)
                .withWeightTare(2.400, MassUnit.TON)
                .buildAndValidate();

        assertEquals(30480.0, swapBody.getWeightBruttoMax().getValue().doubleValue(), 0.1);
        assertEquals(28080.0, swapBody.getWeightNettoMax().getValue().doubleValue(), 0.1);
        assertEquals(2400.0, swapBody.getWeightTare().getValue().doubleValue(), 0.1);
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class,
            () ->
                SwapBody.Builder.newSwapBody()
                    .isReefer(false)
                    .withType("Open Top")
                    .withSize(21.58, LengthUnit.FOOT)
                    .isStackable(true)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                SwapBody.Builder.newSwapBody()
                    .withNumber("OOOCSSSSSS")
                    .withType("Open Top")
                    .withSize(21.58, LengthUnit.FOOT)
                    .isStackable(true)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                SwapBody.Builder.newSwapBody()
                    .withNumber("OOOCSSSSSS")
                    .isReefer(false)
                    .withSize(21.58, LengthUnit.FOOT)
                    .isStackable(true)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                SwapBody.Builder.newSwapBody()
                    .withNumber("OOOCSSSSSS")
                    .isReefer(false)
                    .withType("Open Top")
                    .isStackable(true)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                SwapBody.Builder.newSwapBody()
                    .withNumber("OOOCSSSSSS")
                    .isReefer(false)
                    .withType("Open Top")
                    .withSize(21.58, LengthUnit.FOOT)
                    .buildAndValidate());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        SwapBody swapBody = SwapBody.Builder.newSwapBody()
                .withIdentification("OOOCSSSSSS")
                .withNumber("OOOCSSSSSS")
                .withWeightBruttoMax(30480.0, MassUnit.KILOGRAM)
                .withWeightNettoMax(28080.0, MassUnit.KILOGRAM)
                .withWeightTare(2400.0, MassUnit.KILOGRAM)
                .withCondition("i.O.")
                .isReefer(false)
                .withOperator("Contargo")
                .withType("Open Top")
                .withSize(21.58, LengthUnit.FOOT)
                .isStackable(true)
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(swapBody);

        SwapBody deserialize = mapper.readValue(jsonString, SwapBody.class);

        assertEquals("OOOCSSSSSS", deserialize.getIdentification());
        assertEquals("OOOCSSSSSS", deserialize.getNumber());
        assertEquals(LoadingUnitCategory.SWAP_BODY, deserialize.getCategory());
        assertNotNull(deserialize.getWeight());
        assertEquals(30480.0, deserialize.getWeightBruttoMax().getValue().doubleValue());
        assertEquals(28080.0, deserialize.getWeightNettoMax().getValue().doubleValue());
        assertEquals(2400.0, deserialize.getWeightTare().getValue().doubleValue());
        assertEquals("i.O.", deserialize.getCondition());
        assertFalse(deserialize.isReefer());
        assertEquals("Contargo", deserialize.getOperator());
        assertEquals("Open Top", deserialize.getType());
        assertEquals(21.58, deserialize.getSize().getValue().doubleValue());
        assertTrue(deserialize.isStackable());
    }
}
