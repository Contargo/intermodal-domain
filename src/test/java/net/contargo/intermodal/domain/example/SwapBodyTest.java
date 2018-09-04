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

        SwapBody swapBody = SwapBody.newBuilder()
                .withNumberAndIdentification("MSKU1806510")
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

        assertEquals("MSKU1806510", swapBody.getIdentification());
        assertEquals("MSKU1806510", swapBody.getNumber());
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

        SwapBody.newBuilder()
            .withNumberAndIdentification("MSKU1806510")
            .isReefer(false)
            .withType("Open Top")
            .withSize(21.58, LengthUnit.FOOT)
            .isStackable(true)
            .buildAndValidate();
    }


    @Test
    void ensureConditionCanBeSetAsLoadingUnitCondition() {

        SwapBody swapBody = SwapBody.newBuilder()
                .withNumberAndIdentification("MSKU1806510")
                .isReefer(false)
                .withType("Open Top")
                .withSize(21.58, LengthUnit.FOOT)
                .isStackable(true)
                .withCondition(LoadingUnitCondition.UNCHECKED)
                .buildAndValidate();

        assertEquals("UNCHECKED", swapBody.getCondition());
    }


    @Test
    void ensureCanBeCopied() {

        SwapBody swapBody = SwapBody.newBuilder()
                .withNumberAndIdentification("MSKU1806510")
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

        SwapBody copiedSwapBody = SwapBody.newBuilder(swapBody).buildAndValidate();

        assertEquals("MSKU1806510", copiedSwapBody.getIdentification());
        assertEquals("MSKU1806510", copiedSwapBody.getNumber());
        assertEquals(LoadingUnitCategory.SWAP_BODY, copiedSwapBody.getCategory());
        assertNotNull(copiedSwapBody.getWeight());
        assertEquals(30480.0, copiedSwapBody.getWeightBruttoMax().getValue().doubleValue());
        assertEquals(28080.0, copiedSwapBody.getWeightNettoMax().getValue().doubleValue());
        assertEquals(2400.0, copiedSwapBody.getWeightTare().getValue().doubleValue());
        assertEquals("i.O.", copiedSwapBody.getCondition());
        assertFalse(copiedSwapBody.isReefer());
        assertEquals("Contargo", copiedSwapBody.getOperator());
        assertEquals("Open Top", copiedSwapBody.getType());
        assertEquals(21.58, copiedSwapBody.getSize().getValue().doubleValue());
        assertTrue(copiedSwapBody.isStackable());
    }


    @Test
    void ensureSpecialCharactersInNumberAreIgnored() {

        SwapBody swapBody = SwapBody.newBuilder()
                .withNumberAndIdentification("MSKU 180651-0")
                .isReefer(false)
                .withType("Open Top")
                .withSize(21.58, LengthUnit.FOOT)
                .isStackable(true)
                .buildAndValidate();

        assertEquals("MSKU1806510", swapBody.getNumber());
        assertEquals("MSKU1806510", swapBody.getIdentification());
    }


    @Test
    void ensureSizeCanBeSetInMetre() {

        SwapBody swapBody = SwapBody.newBuilder()
                .withNumberAndIdentification("MSKU1806510")
                .isReefer(false)
                .withType("Open Top")
                .withSize(6.58, LengthUnit.METRE)
                .isStackable(true)
                .buildAndValidate();

        assertEquals(21.58, swapBody.getSize().getValue().doubleValue(), 0.1);
        assertEquals("ft", swapBody.getSize().getUnit().toString());
    }


    @Test
    void ensureWeightCanBeSetInTons() {

        SwapBody swapBody = SwapBody.newBuilder()
                .withNumberAndIdentification("MSKU1806510")
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

        assertEquals("kg", swapBody.getWeightBruttoMax().getUnit().toString());
        assertEquals("kg", swapBody.getWeightNettoMax().getUnit().toString());
        assertEquals("kg", swapBody.getWeightTare().getUnit().toString());
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class,
            () ->
                SwapBody.newBuilder()
                    .isReefer(false)
                    .withType("Open Top")
                    .withSize(21.58, LengthUnit.FOOT)
                    .isStackable(true)
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                SwapBody.newBuilder()
                    .withNumberAndIdentification("MSKU1806510")
                    .isReefer(false)
                    .withSize(21.58, LengthUnit.FOOT)
                    .isStackable(true)
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                SwapBody.newBuilder()
                    .withNumberAndIdentification("MSKU1806510")
                    .isReefer(false)
                    .withType("Open Top")
                    .isStackable(true)
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                SwapBody.newBuilder()
                    .withNumberAndIdentification("MSKU1806510")
                    .isReefer(false)
                    .withType("Open Top")
                    .withSize(21.58, LengthUnit.FOOT)
                    .buildAndValidate());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        SwapBody swapBody = SwapBody.newBuilder()
                .withNumberAndIdentification("MSKU1806510")
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

        assertEquals("MSKU1806510", deserialize.getIdentification());
        assertEquals("MSKU1806510", deserialize.getNumber());
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
