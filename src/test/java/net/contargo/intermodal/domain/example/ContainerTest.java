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

        Container container = Container.newBuilder()
                .withNumberAndIdentification("MSKU1806510")
                .withWeightBruttoMax(30480.0, MassUnit.KILOGRAM)
                .withWeightNettoMax(28080.0, MassUnit.KILOGRAM)
                .withWeightTare(2400.0, MassUnit.KILOGRAM)
                .withCondition("schadhaft")
                .isReefer(false)
                .withOperator("Contargo")
                .withSizeType("45G0")
                .withSize(40.0, LengthUnit.FOOT)
                .withType("General purpose container (without ventilation)")
                .buildAndValidate();

        assertEquals("MSKU1806510", container.getIdentification());
        assertEquals("MSKU1806510", container.getNumber());
        assertEquals(LoadingUnitCategory.CONTAINER, container.getCategory());
        assertNotNull(container.getWeight());
        assertEquals(30480., container.getWeightBruttoMax().getValue().doubleValue());
        assertEquals(28080.0, container.getWeightNettoMax().getValue().doubleValue());
        assertEquals(2400.0, container.getWeightTare().getValue().doubleValue());
        assertEquals("schadhaft", container.getCondition());
        assertFalse(container.isReefer());
        assertEquals("Contargo", container.getOperator());
        assertEquals("45G0", container.getSizeType());
        assertEquals("General purpose container (without ventilation)", container.getType());
        assertEquals(40.0, container.getSize().getValue().doubleValue());
    }


    @Test
    void ensureCanBeCreatedWithMinimumRequirements() {

        Container.newBuilder()
            .withNumberAndIdentification("MSKU1806510")
            .isReefer(false)
            .withSizeType("45G0")
            .withType("General purpose container (without ventilation)")
            .withSize(40.0, LengthUnit.FOOT)
            .buildAndValidate();
    }


    @Test
    void ensureTypeAndSizeCanBeSetBySizeType() {

        Container container = Container.newBuilder()
                .withNumberAndIdentification("MSKU1806510")
                .isReefer(false)
                .withSizeType("45G0")
                .buildAndValidate();

        assertEquals("General purpose container (without ventilation)", container.getType());
        assertEquals(40.0, container.getSize().getValue());
    }


    @Test
    void ensureSpecialCharactersInNumberAreIgnored() {

        Container container = Container.newBuilder()
                .withNumberAndIdentification("MSKU 180651-0")
                .isReefer(false)
                .withSizeType("45G0")
                .withType("General purpose container (without ventilation)")
                .withSize(40.0, LengthUnit.FOOT)
                .buildAndValidate();

        assertEquals("MSKU1806510", container.getNumber());
        assertEquals("MSKU1806510", container.getIdentification());
    }


    @Test
    void ensureWeightCanBeSetInTons() {

        Container container = Container.newBuilder()
                .withNumberAndIdentification("MSKU1806510")
                .isReefer(false)
                .withSizeType("45G0")
                .withType("General purpose container (without ventilation)")
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
    void ensureSizeCanBeSetInMetre() {

        Container container = Container.newBuilder()
                .withNumberAndIdentification("MSKU1806510")
                .isReefer(false)
                .withSizeType("45G0")
                .withType("General purpose container (without ventilation)")
                .withSize(12.192, LengthUnit.METRE)
                .buildAndValidate();

        assertEquals(40.0, container.getSize().getValue().doubleValue(), 0.1);
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class,
            () ->
                Container.newBuilder()
                    .isReefer(false)
                    .withSizeType("45G0")
                    .withType("General purpose container (without ventilation)")
                    .withSize(40.0, LengthUnit.FOOT)
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                Container.newBuilder()
                    .withNumberAndIdentification("MSKU1806510")
                    .isReefer(false)
                    .withType("General purpose container (without ventilation)")
                    .withSize(40.0, LengthUnit.FOOT)
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                Container.newBuilder()
                    .withNumberAndIdentification("MSKU1806510")
                    .isReefer(false)
                    .withSizeType("45G0")
                    .withType(null)
                    .withSize(40.0, LengthUnit.FOOT)
                    .buildAndValidate());

        // Wrong type code in sizeType
        assertThrows(IllegalArgumentException.class,
            () ->
                Container.newBuilder()
                    .withNumberAndIdentification("MSKU1806510")
                    .isReefer(false)
                    .withSizeType("45X0")
                    .withSize(40.0, LengthUnit.FOOT)
                    .buildAndValidate());

        // Wrong length code sizeType
        assertThrows(IllegalArgumentException.class,
            () ->
                Container.newBuilder()
                    .withNumberAndIdentification("MSKU1806510")
                    .isReefer(false)
                    .withSizeType("82G0")
                    .withType("General purpose container (without ventilation)")
                    .buildAndValidate());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        Container container = Container.newBuilder()
                .withNumberAndIdentification("MSKU1806510")
                .withWeightBruttoMax(30480.0, MassUnit.KILOGRAM)
                .withWeightNettoMax(28080.0, MassUnit.KILOGRAM)
                .withWeightTare(2400.0, MassUnit.KILOGRAM)
                .withCondition("schadhaft")
                .isReefer(false)
                .withOperator("Contargo")
                .withSizeType("45G0")
                .withType("General purpose container (without ventilation)")
                .withSize(40.0, LengthUnit.FOOT)
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(container);

        Container deserialize = mapper.readValue(jsonString, Container.class);

        assertEquals("MSKU1806510", deserialize.getIdentification());
        assertEquals("MSKU1806510", deserialize.getNumber());
        assertEquals(LoadingUnitCategory.CONTAINER, deserialize.getCategory());
        assertNotNull(container.getWeight());
        assertEquals(30480., container.getWeightBruttoMax().getValue().doubleValue());
        assertEquals(28080.0, container.getWeightNettoMax().getValue().doubleValue());
        assertEquals(2400.0, container.getWeightTare().getValue().doubleValue());
        assertEquals("schadhaft", deserialize.getCondition());
        assertFalse(deserialize.isReefer());
        assertEquals("Contargo", deserialize.getOperator());
        assertEquals("45G0", deserialize.getSizeType());
        assertEquals("General purpose container (without ventilation)", deserialize.getType());
        assertEquals(40.0, deserialize.getSize().getValue().doubleValue());
    }
}
