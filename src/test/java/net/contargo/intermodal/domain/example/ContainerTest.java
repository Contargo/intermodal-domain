package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.Container;
import net.contargo.intermodal.domain.LoadingUnitCategory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class ContainerTest {

    @Test
    void ensureCanBeCreatedWithAllInformation() {

        Container container = Container.Builder.newContainer()
                .withIdentification("OOOCSSSSSS")
                .withNumber("OOOCSSSSSS")
                .withWeightBruttoMax(70.0)
                .withWeightNettoMax(65.0)
                .withWeightTara(70.0)
                .withCondition("schadhaft")
                .isReefer(false)
                .withOperator("Contargo")
                .withSizeType("45G0")
                .withType("HIGH CUBE CONTAINER")
                .withSize(38)
                .buildAndValidate();

        assertEquals("OOOCSSSSSS", container.getIdentification());
        assertEquals("OOOCSSSSSS", container.getNumber());
        assertEquals(LoadingUnitCategory.CONTAINER, container.getCategory());
        assertEquals(70, container.getWeightBruttoMax().doubleValue());
        assertEquals(65, container.getWeightNettoMax().doubleValue());
        assertEquals(70, container.getWeightTara().doubleValue());
        assertEquals("schadhaft", container.getCondition());
        assertFalse(container.isReefer());
        assertEquals("Contargo", container.getOperator());
        assertEquals("45G0", container.getSizeType());
        assertEquals("HIGH CUBE CONTAINER", container.getType());
        assertEquals(38, container.getSize().doubleValue());
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class,
            () ->
                Container.Builder.newContainer()
                    .isReefer(false)
                    .withSizeType("45G0")
                    .withType("HIGH CUBE CONTAINER")
                    .withSize(38)
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                Container.Builder.newContainer()
                    .withNumber("OOOCSSSSSS")
                    .withSizeType("45G0")
                    .withType("HIGH CUBE CONTAINER")
                    .withSize(38)
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                Container.Builder.newContainer()
                    .withNumber("OOOCSSSSSS")
                    .isReefer(false)
                    .withType("HIGH CUBE CONTAINER")
                    .withSize(38)
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                Container.Builder.newContainer()
                    .withNumber("OOOCSSSSSS")
                    .isReefer(false)
                    .withSizeType("45G0")
                    .withSize(38)
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                Container.Builder.newContainer()
                    .withNumber("OOOCSSSSSS")
                    .isReefer(false)
                    .withSizeType("45G0")
                    .withType("HIGH CUBE CONTAINER")
                    .buildAndValidate());
    }
}
