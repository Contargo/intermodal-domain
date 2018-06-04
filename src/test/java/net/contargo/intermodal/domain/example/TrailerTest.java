package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.LoadingUnitCategory;
import net.contargo.intermodal.domain.MassUnit;
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
                .withWeightBruttoMax(70.0, MassUnit.KILOGRAM)
                .withWeightNettoMax(65.0, MassUnit.KILOGRAM)
                .withWeightTara(70.0, MassUnit.KILOGRAM)
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
        assertNotNull(trailer.getWeight());
        assertEquals(70, trailer.getWeightBruttoMax().getValue().doubleValue());
        assertEquals(65, trailer.getWeightNettoMax().getValue().doubleValue());
        assertEquals(70, trailer.getWeightTara().getValue().doubleValue());
        assertEquals("i.O.", trailer.getCondition());
        assertFalse(trailer.isReefer());
        assertEquals("Contargo", trailer.getOperator());
        assertEquals("XL", trailer.getType());

        assertEquals(6, trailer.getSize().doubleValue());
        assertTrue(trailer.isCraneable());
    }


    @Test
    void ensureCanBeCreatedWithMinimumRequirements() {

        Trailer.Builder.newTrailer()
            .withNumber("OOOCSSSSSS")
            .isReefer(false)
            .withType("XL")
            .withSize(6.0)
            .isCraneable(true)
            .buildAndValidate();
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class,
            () ->
                Trailer.Builder.newTrailer()
                    .isReefer(false)
                    .withType("XL")
                    .withSize(6.0)
                    .isCraneable(true)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                Trailer.Builder.newTrailer()
                    .withNumber("OOOCSSSSSS")
                    .withType("XL")
                    .withSize(6.0)
                    .isCraneable(true)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                Trailer.Builder.newTrailer()
                    .withNumber("OOOCSSSSSS")
                    .isReefer(false)
                    .withSize(6.0)
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
                    .withSize(6.0)
                    .buildAndValidate());
    }
}
