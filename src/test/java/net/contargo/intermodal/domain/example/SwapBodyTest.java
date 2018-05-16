package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.LoadingUnitCategory;
import net.contargo.intermodal.domain.SwapBody;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class SwapBodyTest {

    @Test
    void ensureCanBeCreatedWithAllInformation() {

        SwapBody swapBody = SwapBody.Builder.newSwapBody()
                .withIdentification("CSQU3054383")
                .withNumber("CSQU3054383")
                .withWeightBruttoMax(70.0)
                .withWeightNettoMax(65.0)
                .withWeightTara(70.0)
                .withCondition("i.O.")
                .isReefer(false)
                .withOperator("Contargo")
                .withType("Open Top")
                .withSize(6.5)
                .isStackable(true)
                .buildAndValidate();

        assertEquals("CSQU3054383", swapBody.getIdentification());
        assertEquals("CSQU3054383", swapBody.getNumber());
        assertEquals(LoadingUnitCategory.SWAP_BODY, swapBody.getCategory());
        assertEquals(70, swapBody.getWeightBruttoMax().doubleValue());
        assertEquals(65, swapBody.getWeightNettoMax().doubleValue());
        assertEquals(70, swapBody.getWeightTara().doubleValue());
        assertEquals("i.O.", swapBody.getCondition());
        assertFalse(swapBody.isReefer());
        assertEquals("Contargo", swapBody.getOperator());
        assertEquals("Open Top", swapBody.getType());
        assertEquals(6.5, swapBody.getSize().doubleValue());
        assertTrue(swapBody.isStackable());
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class,
            () ->
                SwapBody.Builder.newSwapBody()
                    .withIdentification("CSQU3054383")
                    .withWeightBruttoMax(70.0)
                    .withWeightNettoMax(65.0)
                    .withWeightTara(70.0)
                    .withCondition("i.O.")
                    .isReefer(false)
                    .withOperator("Contargo")
                    .withType("Open Top")
                    .withSize(6.5)
                    .isStackable(true)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                SwapBody.Builder.newSwapBody()
                    .withIdentification("CSQU3054383")
                    .withNumber("CSQU3054383")
                    .withWeightBruttoMax(70.0)
                    .withWeightNettoMax(65.0)
                    .withWeightTara(70.0)
                    .withCondition("i.O.")
                    .withOperator("Contargo")
                    .withType("Open Top")
                    .withSize(6.5)
                    .isStackable(true)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                SwapBody.Builder.newSwapBody()
                    .withIdentification("CSQU3054383")
                    .withNumber("CSQU3054383")
                    .withWeightBruttoMax(70.0)
                    .withWeightNettoMax(65.0)
                    .withWeightTara(70.0)
                    .withCondition("i.O.")
                    .isReefer(false)
                    .withOperator("Contargo")
                    .withSize(6.5)
                    .isStackable(true)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                SwapBody.Builder.newSwapBody()
                    .withIdentification("CSQU3054383")
                    .withNumber("CSQU3054383")
                    .withWeightBruttoMax(70.0)
                    .withWeightNettoMax(65.0)
                    .withWeightTara(70.0)
                    .withCondition("i.O.")
                    .isReefer(false)
                    .withOperator("Contargo")
                    .withType("Open Top")
                    .isStackable(true)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                SwapBody.Builder.newSwapBody()
                    .withIdentification("CSQU3054383")
                    .withNumber("CSQU3054383")
                    .withWeightBruttoMax(70.0)
                    .withWeightNettoMax(65.0)
                    .withWeightTara(70.0)
                    .withCondition("i.O.")
                    .isReefer(false)
                    .withOperator("Contargo")
                    .withType("Open Top")
                    .withSize(6.5)
                    .buildAndValidate());
    }
}
