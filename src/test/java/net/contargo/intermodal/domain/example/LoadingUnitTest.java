package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.loadingUnit.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class LoadingUnitTest {

    @Test
    void ensureSwapBodyCanBeCreated() {

        SwapBody swapBody = new SwapBody().withIdentification("CSQU3054383")
                .withNumber("CSQU3054383")
                .withWeightBruttoMax(70)
                .withWeightNettoMax(65)
                .withWeightTara(70)
                .withCondition("i.O.")
                .isReefer(false)
                .withOperator("Contargo")
                .withType("Open Top")
                .withSize(6.5)
                .isStackable(true);

        Assertions.assertEquals("CSQU3054383", swapBody.getIdentification());
        Assertions.assertEquals("CSQU3054383", swapBody.getNumber());
        Assertions.assertEquals(LoadingUnitCategory.SWAP_BODY, swapBody.getCategory());
        Assertions.assertEquals(70, swapBody.getWeightBruttoMax());
        Assertions.assertEquals(65, swapBody.getWeightNettoMax());
        Assertions.assertEquals(70, swapBody.getWeightTara());
        Assertions.assertEquals("i.O.", swapBody.getCondition());
        Assertions.assertFalse(swapBody.isReefer());
        Assertions.assertEquals("Contargo", swapBody.getOperator());
        Assertions.assertEquals("Open Top", swapBody.getType());
        Assertions.assertEquals(6.5, swapBody.getSize());
        Assertions.assertTrue(swapBody.isStackable());
    }


    @Test
    void ensureContainerCanBeCreated() {

        Container container = new Container().withIdentification("CSQU3054383")
                .withNumber("CSQU3054383")
                .withWeightBruttoMax(70)
                .withWeightNettoMax(65)
                .withWeightTara(70)
                .withCondition("i.O.")
                .isReefer(false)
                .withOperator("Contargo")
                .withSizeType("20G0")
                .withType("Open Top")
                .withSize(6);

        Assertions.assertEquals("CSQU3054383", container.getIdentification());
        Assertions.assertEquals("CSQU3054383", container.getNumber());
        Assertions.assertEquals(LoadingUnitCategory.CONTAINER, container.getCategory());
        Assertions.assertEquals(70, container.getWeightBruttoMax());
        Assertions.assertEquals(65, container.getWeightNettoMax());
        Assertions.assertEquals(70, container.getWeightTara());
        Assertions.assertEquals("i.O.", container.getCondition());
        Assertions.assertFalse(container.isReefer());
        Assertions.assertEquals("Contargo", container.getOperator());
        Assertions.assertEquals("20G0", container.getSizeType());
        Assertions.assertEquals("Open Top", container.getType());
        Assertions.assertEquals(6, container.getSize());
    }


    @Test
    void ensureTrailerCanBeCreated() {

        Trailer trailer = new Trailer().withIdentification("CSQU3054383")
                .withNumber("CSQU3054383")
                .withWeightBruttoMax(70)
                .withWeightNettoMax(65)
                .withWeightTara(70)
                .withCondition("i.O.")
                .isReefer(false)
                .withOperator("Contargo")
                .withType("XL")
                .withSize(6)
                .isCraneable(true);

        Assertions.assertEquals("CSQU3054383", trailer.getIdentification());
        Assertions.assertEquals("CSQU3054383", trailer.getNumber());
        Assertions.assertEquals(LoadingUnitCategory.TRAILER, trailer.getCategory());
        Assertions.assertEquals(70, trailer.getWeightBruttoMax());
        Assertions.assertEquals(65, trailer.getWeightNettoMax());
        Assertions.assertEquals(70, trailer.getWeightTara());
        Assertions.assertEquals("i.O.", trailer.getCondition());
        Assertions.assertFalse(trailer.isReefer());
        Assertions.assertEquals("Contargo", trailer.getOperator());
        Assertions.assertEquals("XL", trailer.getType());
        Assertions.assertEquals(6, trailer.getSize());
        Assertions.assertTrue(trailer.isCraneable());
    }
}
