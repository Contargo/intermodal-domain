package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.Container;
import net.contargo.intermodal.domain.LoadingUnitCategory;
import net.contargo.intermodal.domain.MassUnit;

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
                .withWeightBruttoMax(70.0, MassUnit.KILOGRAM)
                .withWeightNettoMax(65.0, MassUnit.KILOGRAM)
                .withWeightTara(70.0, MassUnit.KILOGRAM)
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
        assertNotNull(container.getWeight());
        assertEquals(70, container.getWeightBruttoMax().getValue().doubleValue());
        assertEquals(65, container.getWeightNettoMax().getValue().doubleValue());
        assertEquals(70, container.getWeightTara().getValue().doubleValue());
        assertEquals("schadhaft", container.getCondition());
        assertFalse(container.isReefer());
        assertEquals("Contargo", container.getOperator());
        assertEquals("45G0", container.getSizeType());
        assertEquals("HIGH CUBE CONTAINER", container.getType());
        assertEquals(38, container.getSize().doubleValue());
    }


    @Test
    void ensureCanBeCreatedWithMinimumRequirements() {

        Container.Builder.newContainer()
            .withNumber("OOOCSSSSSS")
            .isReefer(false)
            .withSizeType("45G0")
            .withType("HIGH CUBE CONTAINER")
            .withSize(38)
            .buildAndValidate();
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
