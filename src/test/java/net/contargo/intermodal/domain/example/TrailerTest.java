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

        Trailer trailer = Trailer.Builder.newTrailer()
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

        assertEquals("OOOCSSSSSS", trailer.getIdentification());
        assertEquals("OOOCSSSSSS", trailer.getNumber());
        assertEquals(LoadingUnitCategory.TRAILER, trailer.getCategory());
        assertNotNull(trailer.getWeight());
        assertEquals(70, trailer.getWeightBruttoMax().getValue().doubleValue());
        assertEquals(65, trailer.getWeightNettoMax().getValue().doubleValue());
        assertEquals(70, trailer.getWeightTare().getValue().doubleValue());
        assertEquals("i.O.", trailer.getCondition());
        assertFalse(trailer.isReefer());
        assertEquals("Contargo", trailer.getOperator());
        assertEquals("XL", trailer.getType());

        assertEquals(8.53, trailer.getSize().getValue().doubleValue());
        assertTrue(trailer.isCraneable());
    }


    @Test
    void ensureCanBeCreatedWithMinimumRequirements() {

        Trailer.Builder.newTrailer()
            .withNumber("OOOCSSSSSS")
            .isReefer(false)
            .withType("XL")
            .withSize(6.0, LengthUnit.METRE)
            .isCraneable(true)
            .buildAndValidate();
    }


    @Test
    void ensureSizeCanBeSetInMetre() {

        Trailer trailer = Trailer.Builder.newTrailer()
                .withNumber("OOOCSSSSSS")
                .isReefer(false)
                .withType("XL")
                .isCraneable(true)
                .withSize(28.0, LengthUnit.FOOT)
                .buildAndValidate();

        assertEquals(8.53, trailer.getSize().getValue().doubleValue(), 0.1);
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class,
            () ->
                Trailer.Builder.newTrailer()
                    .isReefer(false)
                    .withType("XL")
                    .withSize(8.53, LengthUnit.METRE)
                    .isCraneable(true)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                Trailer.Builder.newTrailer()
                    .withNumber("OOOCSSSSSS")
                    .withType("XL")
                    .withSize(8.53, LengthUnit.METRE)
                    .isCraneable(true)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                Trailer.Builder.newTrailer()
                    .withNumber("OOOCSSSSSS")
                    .isReefer(false)
                    .withSize(8.53, LengthUnit.METRE)
                    .isCraneable(true)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                Trailer.Builder.newTrailer()
                    .withNumber("OOOCSSSSSS")
                    .isReefer(false)
                    .withType("XL")
                    .isCraneable(true)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                Trailer.Builder.newTrailer()
                    .withNumber("OOOCSSSSSS")
                    .isReefer(false)
                    .withType("XL")
                    .withSize(8.53, LengthUnit.METRE)
                    .buildAndValidate());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        Trailer trailer = Trailer.Builder.newTrailer()
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
