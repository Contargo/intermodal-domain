package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;

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
                .withWeightBruttoMax(30480.0, MassUnit.KILOGRAM)
                .withWeightNettoMax(28080.0, MassUnit.KILOGRAM)
                .withWeightTare(2400.0, MassUnit.KILOGRAM)
                .withCondition("schadhaft")
                .isReefer(false)
                .withOperator("Contargo")
                .withSizeType("45G0")
                .withType("HIGH CUBE CONTAINER")
                .withSize(21.58, LengthUnit.FOOT)
                .buildAndValidate();

        assertEquals("OOOCSSSSSS", container.getIdentification());
        assertEquals("OOOCSSSSSS", container.getNumber());
        assertEquals(LoadingUnitCategory.CONTAINER, container.getCategory());
        assertNotNull(container.getWeight());
        assertEquals(30480., container.getWeightBruttoMax().getValue().doubleValue());
        assertEquals(28080.0, container.getWeightNettoMax().getValue().doubleValue());
        assertEquals(2400.0, container.getWeightTare().getValue().doubleValue());
        assertEquals("schadhaft", container.getCondition());
        assertFalse(container.isReefer());
        assertEquals("Contargo", container.getOperator());
        assertEquals("45G0", container.getSizeType());
        assertEquals("HIGH CUBE CONTAINER", container.getType());
        assertEquals(21.58, container.getSize().getValue().doubleValue());
    }


    @Test
    void ensureWeightCanBeSetInTons() {

        Container container = Container.Builder.newContainer()
                .withNumber("OOOCSSSSSS")
                .isReefer(false)
                .withSizeType("45G0")
                .withType("HIGH CUBE CONTAINER")
                .withSize(6.58, LengthUnit.METRE)
                .withWeightBruttoMax(30.48, MassUnit.TON)
                .withWeightNettoMax(28.08, MassUnit.TON)
                .withWeightTare(2.4, MassUnit.TON)
                .buildAndValidate();

        assertEquals(30480.0, container.getWeightBruttoMax().getValue().doubleValue(), 0.1);
        assertEquals(28080.0, container.getWeightNettoMax().getValue().doubleValue(), 0.1);
        assertEquals(2400.0, container.getWeightTare().getValue().doubleValue(), 0.1);
    }


    @Test
    void ensureCanBeCreatedWithMinimumRequirements() {

        Container.Builder.newContainer()
            .withNumber("OOOCSSSSSS")
            .isReefer(false)
            .withSizeType("45G0")
            .withType("HIGH CUBE CONTAINER")
            .withSize(6.58, LengthUnit.METRE)
            .buildAndValidate();
    }


    @Test
    void ensureSizeCanBeSetInFoot() {

        Container container = Container.Builder.newContainer()
                .withNumber("OOOCSSSSSS")
                .isReefer(false)
                .withSizeType("45G0")
                .withType("HIGH CUBE CONTAINER")
                .withSize(21.58, LengthUnit.FOOT)
                .buildAndValidate();

        assertEquals(21.58, container.getSize().getValue().doubleValue(), 0.1);
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class,
            () ->
                Container.Builder.newContainer()
                    .isReefer(false)
                    .withSizeType("45G0")
                    .withType("HIGH CUBE CONTAINER")
                    .withSize(21.58, LengthUnit.FOOT)
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                Container.Builder.newContainer()
                    .withNumber("OOOCSSSSSS")
                    .withSizeType("45G0")
                    .withType("HIGH CUBE CONTAINER")
                    .withSize(21.58, LengthUnit.FOOT)
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                Container.Builder.newContainer()
                    .withNumber("OOOCSSSSSS")
                    .isReefer(false)
                    .withType("HIGH CUBE CONTAINER")
                    .withSize(21.58, LengthUnit.FOOT)
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                Container.Builder.newContainer()
                    .withNumber("OOOCSSSSSS")
                    .isReefer(false)
                    .withSizeType("45G0")
                    .withSize(21.58, LengthUnit.FOOT)
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


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        Container container = Container.Builder.newContainer()
                .withIdentification("OOOCSSSSSS")
                .withNumber("OOOCSSSSSS")
                .withWeightBruttoMax(30480.0, MassUnit.KILOGRAM)
                .withWeightNettoMax(28080.0, MassUnit.KILOGRAM)
                .withWeightTare(2400.0, MassUnit.KILOGRAM)
                .withCondition("schadhaft")
                .isReefer(false)
                .withOperator("Contargo")
                .withSizeType("45G0")
                .withType("HIGH CUBE CONTAINER")
                .withSize(21.58, LengthUnit.FOOT)
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(container);

        Container deserialize = mapper.readValue(jsonString, Container.class);

        assertEquals("OOOCSSSSSS", deserialize.getIdentification());
        assertEquals("OOOCSSSSSS", deserialize.getNumber());
        assertEquals(LoadingUnitCategory.CONTAINER, deserialize.getCategory());
        assertNotNull(container.getWeight());
        assertEquals(30480., container.getWeightBruttoMax().getValue().doubleValue());
        assertEquals(28080.0, container.getWeightNettoMax().getValue().doubleValue());
        assertEquals(2400.0, container.getWeightTare().getValue().doubleValue());
        assertEquals("schadhaft", deserialize.getCondition());
        assertFalse(deserialize.isReefer());
        assertEquals("Contargo", deserialize.getOperator());
        assertEquals("45G0", deserialize.getSizeType());
        assertEquals("HIGH CUBE CONTAINER", deserialize.getType());
        assertEquals(21.58, deserialize.getSize().getValue().doubleValue());
    }
}
