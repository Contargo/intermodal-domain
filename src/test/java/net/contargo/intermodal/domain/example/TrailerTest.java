package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class TrailerTest {

    @Test
    void ensureCanBeCreatedWithAllInformation() {

        Trailer trailer = Trailer.newBuilder()
                .withNumberAndIdentification("MSKU1806510")
                .withWeightBruttoMax(14082.331, MassUnit.KILOGRAM)
                .withWeightNettoMax(10000.0, MassUnit.KILOGRAM)
                .withWeightTare(4082.331, MassUnit.KILOGRAM)
                .withCondition("i.O.")
                .isReefer(false)
                .withOperator("Contargo")
                .withType("XL")
                .withSize(15.5, LengthUnit.METRE)
                .isCraneable(true)
                .buildAndValidate();

        assertEquals("MSKU1806510", trailer.getIdentification());
        assertEquals("MSKU1806510", trailer.getNumber());
        assertEquals(LoadingUnitCategory.TRAILER, trailer.getCategory());
        assertNotNull(trailer.getWeight());
        assertEquals(14082.331, trailer.getWeightBruttoMax().getValue().doubleValue());
        assertEquals(10000.0, trailer.getWeightNettoMax().getValue().doubleValue());
        assertEquals(4082.331, trailer.getWeightTare().getValue().doubleValue());
        assertEquals("i.O.", trailer.getCondition());
        assertFalse(trailer.isReefer());
        assertEquals("Contargo", trailer.getOperator());
        assertEquals("XL", trailer.getType());

        assertEquals(15.5, trailer.getSize().getValue().doubleValue());
        assertTrue(trailer.isCraneable());
    }


    @Test
    void ensureCanBeCreatedWithMinimumRequirements() {

        Trailer.newBuilder()
            .withNumberAndIdentification("MSKU1806510")
            .isReefer(false)
            .withType("XL")
            .withSize(15.5, LengthUnit.METRE)
            .isCraneable(true)
            .buildAndValidate();
    }


    @Test
    void ensureConditionCanBeSetAsLoadingUnitCondition() {

        Trailer trailer = Trailer.newBuilder()
                .withNumberAndIdentification("MSKU1806510")
                .isReefer(false)
                .withType("XL")
                .withSize(15.5, LengthUnit.METRE)
                .isCraneable(true)
                .withCondition(LoadingUnitCondition.OK)
                .buildAndValidate();

        assertEquals("OK", trailer.getCondition());
    }


    @Test
    void ensureCanBeCopied() {

        Trailer trailer = Trailer.newBuilder()
                .withNumberAndIdentification("MSKU1806510")
                .withWeightBruttoMax(14082.331, MassUnit.KILOGRAM)
                .withWeightNettoMax(10000.0, MassUnit.KILOGRAM)
                .withWeightTare(4082.331, MassUnit.KILOGRAM)
                .withCondition("i.O.")
                .isReefer(false)
                .withOperator("Contargo")
                .withType("XL")
                .withSize(15.5, LengthUnit.METRE)
                .isCraneable(true)
                .buildAndValidate();

        Trailer copiedTrailer = Trailer.newBuilder(trailer).buildAndValidate();

        assertEquals("MSKU1806510", copiedTrailer.getIdentification());
        assertEquals("MSKU1806510", copiedTrailer.getNumber());
        assertEquals(LoadingUnitCategory.TRAILER, copiedTrailer.getCategory());
        assertNotNull(copiedTrailer.getWeight());
        assertEquals(14082.331, copiedTrailer.getWeightBruttoMax().getValue().doubleValue());
        assertEquals(10000.0, copiedTrailer.getWeightNettoMax().getValue().doubleValue());
        assertEquals(4082.331, copiedTrailer.getWeightTare().getValue().doubleValue());
        assertEquals("i.O.", copiedTrailer.getCondition());
        assertFalse(copiedTrailer.isReefer());
        assertEquals("Contargo", copiedTrailer.getOperator());
        assertEquals("XL", copiedTrailer.getType());

        assertEquals(15.5, copiedTrailer.getSize().getValue().doubleValue());
        assertTrue(copiedTrailer.isCraneable());
    }


    @Test
    void ensureSpecialCharactersInNumberAreIgnored() {

        Trailer trailer = Trailer.newBuilder()
                .withNumberAndIdentification("MSKU 180651-0")
                .isReefer(false)
                .withType("XL")
                .withSize(15.5, LengthUnit.METRE)
                .isCraneable(true)
                .buildAndValidate();

        assertEquals("MSKU1806510", trailer.getNumber());
        assertEquals("MSKU1806510", trailer.getIdentification());
    }


    @Test
    void ensureSizeCanBeSetInFoot() {

        Trailer trailer = Trailer.newBuilder()
                .withNumberAndIdentification("MSKU1806510")
                .isReefer(false)
                .withType("XL")
                .isCraneable(true)
                .withSize(50.853, LengthUnit.FOOT)
                .buildAndValidate();

        assertEquals(15.5, trailer.getSize().getValue().doubleValue(), 0.1);
        assertEquals("m", trailer.getSize().getUnit().toString());
    }


    @Test
    void ensureWeightCanBeSetInTons() {

        Trailer trailer = Trailer.newBuilder()
                .withNumberAndIdentification("MSKU1806510")
                .isReefer(false)
                .withType("XL")
                .isCraneable(true)
                .withSize(15.5, LengthUnit.METRE)
                .withWeightBruttoMax(14.082, MassUnit.TON)
                .withWeightNettoMax(10.000, MassUnit.TON)
                .withWeightTare(4.082, MassUnit.TON)
                .buildAndValidate();

        assertEquals(14082.0, trailer.getWeightBruttoMax().getValue().doubleValue(), 0.1);
        assertEquals(10000.0, trailer.getWeightNettoMax().getValue().doubleValue(), 0.1);
        assertEquals(4082.0, trailer.getWeightTare().getValue().doubleValue(), 0.1);

        assertEquals("kg", trailer.getWeightBruttoMax().getUnit().toString());
        assertEquals("kg", trailer.getWeightNettoMax().getUnit().toString());
        assertEquals("kg", trailer.getWeightTare().getUnit().toString());
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class,
            () ->
                Trailer.newBuilder()
                    .isReefer(false)
                    .withType("XL")
                    .withSize(15.5, LengthUnit.METRE)
                    .isCraneable(true)
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                Trailer.newBuilder()
                    .withNumberAndIdentification("MSKU1806510")
                    .isReefer(false)
                    .withSize(15.5, LengthUnit.METRE)
                    .isCraneable(true)
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                Trailer.newBuilder()
                    .withNumberAndIdentification("MSKU1806510")
                    .isReefer(false)
                    .withType("XL")
                    .isCraneable(true)
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                Trailer.newBuilder()
                    .withNumberAndIdentification("MSKU1806510")
                    .isReefer(false)
                    .withType("XL")
                    .withSize(15.5, LengthUnit.METRE)
                    .buildAndValidate());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        Trailer trailer = Trailer.newBuilder()
                .withNumberAndIdentification("MSKU1806510")
                .withWeightBruttoMax(70.0, MassUnit.KILOGRAM)
                .withWeightNettoMax(65.0, MassUnit.KILOGRAM)
                .withWeightTare(70.0, MassUnit.KILOGRAM)
                .withCondition("i.O.")
                .isReefer(false)
                .withOperator("Contargo")
                .withType("XL")
                .withSize(8.53, LengthUnit.METRE)
                .isCraneable(true)
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(trailer);

        Trailer deserialize = mapper.readValue(jsonString, Trailer.class);

        assertEquals("MSKU1806510", deserialize.getIdentification());
        assertEquals("MSKU1806510", deserialize.getNumber());
        assertEquals(LoadingUnitCategory.TRAILER, deserialize.getCategory());
        assertNotNull(deserialize.getWeight());
        assertEquals(70, deserialize.getWeightBruttoMax().getValue().doubleValue());
        assertEquals(65, deserialize.getWeightNettoMax().getValue().doubleValue());
        assertEquals(70, deserialize.getWeightTare().getValue().doubleValue());
        assertEquals("i.O.", deserialize.getCondition());
        assertFalse(deserialize.isReefer());
        assertEquals("Contargo", deserialize.getOperator());
        assertEquals("XL", deserialize.getType());
    }
}
