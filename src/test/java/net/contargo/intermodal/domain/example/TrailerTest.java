package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.LoadingUnitCategory;
import net.contargo.intermodal.domain.Trailer;

import org.junit.jupiter.api.Test;

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
                .withWeightBruttoMax(70.0)
                .withWeightNettoMax(65.0)
                .withWeightTara(70.0)
                .withCondition("i.O.")
                .isReefer(false)
                .withOperator("Contargo")
                .withType("XL")
                .withSize(6.0)
                .isCraneable(true)
                .buildAndValidate();

        assertEquals("OOOCSSSSSS", trailer.getIdentification());
        assertEquals("OOOCSSSSSS", trailer.getNumber());
        assertEquals(LoadingUnitCategory.TRAILER, trailer.getCategory());
        assertEquals(70, trailer.getWeightBruttoMax().doubleValue());
        assertEquals(65, trailer.getWeightNettoMax().doubleValue());
        assertEquals(70, trailer.getWeightTara().doubleValue());
        assertEquals("i.O.", trailer.getCondition());
        assertFalse(trailer.isReefer());
        assertEquals("Contargo", trailer.getOperator());
        assertEquals("XL", trailer.getType());

        assertEquals(6, trailer.getSize().doubleValue());
        assertTrue(trailer.isCraneable());
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class,
            () ->
                Trailer.Builder.newTrailer()
                    .withIdentification("OOOCSSSSSS")
                    .withWeightBruttoMax(70.0)
                    .withWeightNettoMax(65.0)
                    .withWeightTara(70.0)
                    .withCondition("i.O.")
                    .isReefer(false)
                    .withOperator("Contargo")
                    .withType("XL")
                    .withSize(6.0)
                    .isCraneable(true)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                Trailer.Builder.newTrailer()
                    .withIdentification("OOOCSSSSSS")
                    .withNumber("OOOCSSSSSS")
                    .withWeightBruttoMax(70.0)
                    .withWeightNettoMax(65.0)
                    .withWeightTara(70.0)
                    .withCondition("i.O.")
                    .withOperator("Contargo")
                    .withType("XL")
                    .withSize(6.0)
                    .isCraneable(true)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                Trailer.Builder.newTrailer()
                    .withIdentification("OOOCSSSSSS")
                    .withNumber("OOOCSSSSSS")
                    .withWeightBruttoMax(70.0)
                    .withWeightNettoMax(65.0)
                    .withWeightTara(70.0)
                    .withCondition("i.O.")
                    .isReefer(false)
                    .withOperator("Contargo")
                    .withSize(6.0)
                    .isCraneable(true)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                Trailer.Builder.newTrailer()
                    .withIdentification("OOOCSSSSSS")
                    .withNumber("OOOCSSSSSS")
                    .withWeightBruttoMax(70.0)
                    .withWeightNettoMax(65.0)
                    .withWeightTara(70.0)
                    .withCondition("i.O.")
                    .isReefer(false)
                    .withOperator("Contargo")
                    .withType("XL")
                    .isCraneable(true)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                Trailer.Builder.newTrailer()
                    .withIdentification("OOOCSSSSSS")
                    .withNumber("OOOCSSSSSS")
                    .withWeightBruttoMax(70.0)
                    .withWeightNettoMax(65.0)
                    .withWeightTara(70.0)
                    .withCondition("i.O.")
                    .isReefer(false)
                    .withOperator("Contargo")
                    .withType("XL")
                    .withSize(6.0)
                    .buildAndValidate());
    }
}
