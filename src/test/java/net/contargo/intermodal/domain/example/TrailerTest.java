package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.LengthUnit;
import net.contargo.intermodal.domain.LoadingUnitCategory;
import net.contargo.intermodal.domain.MassUnit;
import net.contargo.intermodal.domain.Trailer;

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
                .withIdentification("OOOCSSSSSS")
                .withNumber("OOOCSSSSSS")
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

        assertEquals("OOOCSSSSSS", trailer.getIdentification());
        assertEquals("OOOCSSSSSS", trailer.getNumber());
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
            .withNumber("OOOCSSSSSS")
            .isReefer(false)
            .withType("XL")
            .withSize(15.5, LengthUnit.METRE)
            .isCraneable(true)
            .buildAndValidate();
    }


    @Test
    void ensureSizeCanBeSetInFoot() {

        Trailer trailer = Trailer.newBuilder()
                .withNumber("OOOCSSSSSS")
                .isReefer(false)
                .withType("XL")
                .isCraneable(true)
                .withSize(50.853, LengthUnit.FOOT)
                .buildAndValidate();

        assertEquals(15.5, trailer.getSize().getValue().doubleValue(), 0.1);
    }


    @Test
    void ensureWeightCanBeSetInTons() {

        Trailer trailer = Trailer.newBuilder()
                .withNumber("OOOCSSSSSS")
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
                    .withNumber("OOOCSSSSSS")
                    .withType("XL")
                    .withSize(15.5, LengthUnit.METRE)
                    .isCraneable(true)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                Trailer.newBuilder()
                    .withNumber("OOOCSSSSSS")
                    .isReefer(false)
                    .withSize(15.5, LengthUnit.METRE)
                    .isCraneable(true)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                Trailer.newBuilder()
                    .withNumber("OOOCSSSSSS")
                    .isReefer(false)
                    .withType("XL")
                    .isCraneable(true)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                Trailer.newBuilder()
                    .withNumber("OOOCSSSSSS")
                    .isReefer(false)
                    .withType("XL")
                    .withSize(15.5, LengthUnit.METRE)
                    .buildAndValidate());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        Trailer trailer = Trailer.newBuilder()
                .withIdentification("OOOCSSSSSS")
                .withNumber("OOOCSSSSSS")
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

        assertEquals("OOOCSSSSSS", deserialize.getIdentification());
        assertEquals("OOOCSSSSSS", deserialize.getNumber());
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
