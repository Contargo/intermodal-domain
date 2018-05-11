package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.loadingUnit.*;

import org.junit.jupiter.api.Test;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Contains examples of the creation and validation of all loading unit types.
 *
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

        assertEquals("CSQU3054383", swapBody.getIdentification());
        assertEquals("CSQU3054383", swapBody.getNumber());
        assertEquals(LoadingUnitCategory.SWAP_BODY, swapBody.getCategory());
        assertEquals(70, swapBody.getWeightBruttoMax().doubleValue());
        assertEquals(65, swapBody.getWeightNettoMax().doubleValue());
        assertEquals(70, swapBody.getWeightTara().doubleValue());
        assertEquals("i.O.", swapBody.getCondition());
        assertFalse(swapBody.isReefer());
        assertEquals("Contargo", swapBody.getOperator());
        assertEquals("Open Top", swapBody.getType());
        assertEquals(6.5, swapBody.getSize().doubleValue());
        assertTrue(swapBody.isStackable());

        // Check if valid
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<SwapBody>> violations = validator.validate(swapBody);

        if (!violations.isEmpty()) {
            String message = String.format("Object is invalid: %s mandatory attributes are missing",
                    violations.size());
            throw new IllegalStateException(message);
        }
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

        assertEquals("CSQU3054383", container.getIdentification());
        assertEquals("CSQU3054383", container.getNumber());
        assertEquals(LoadingUnitCategory.CONTAINER, container.getCategory());
        assertEquals(70, container.getWeightBruttoMax().doubleValue());
        assertEquals(65, container.getWeightNettoMax().doubleValue());
        assertEquals(70, container.getWeightTara().doubleValue());
        assertEquals("i.O.", container.getCondition());
        assertFalse(container.isReefer());
        assertEquals("Contargo", container.getOperator());
        assertEquals("20G0", container.getSizeType());
        assertEquals("Open Top", container.getType());
        assertEquals(6, container.getSize().doubleValue());

        // Check if valid
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Container>> violations = validator.validate(container);

        if (!violations.isEmpty()) {
            String message = String.format("Object is invalid: %s mandatory attributes are missing",
                    violations.size());
            throw new IllegalStateException(message);
        }
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

        assertEquals("CSQU3054383", trailer.getIdentification());
        assertEquals("CSQU3054383", trailer.getNumber());
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

        // Check if valid
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Trailer>> violations = validator.validate(trailer);

        if (!violations.isEmpty()) {
            String message = String.format("Object is invalid: %s mandatory attributes are missing",
                    violations.size());
            throw new IllegalStateException(message);
        }
    }


    @Test
    void ensureSwapBodyCanBeValidated() {

        SwapBody swapBody = new SwapBody();

        // Check if valid
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<SwapBody>> violations = validator.validate(swapBody);

        assertEquals(5, violations.size(), "5 attributes should be mandatory for SwapBody.");
        assertThrows(IllegalStateException.class,
            () -> {
                if (!violations.isEmpty()) {
                    String message = String.format("Object is invalid: %s mandatory attributes are missing",
                            violations.size());
                    throw new IllegalStateException(message);
                }
            });
    }


    @Test
    void ensureContainerCanBeValidated() {

        Container container = new Container();

        // Check if valid
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Container>> violations = validator.validate(container);

        assertEquals(5, violations.size(), "5 attributes should be mandatory for Container.");
        assertThrows(IllegalStateException.class,
            () -> {
                if (!violations.isEmpty()) {
                    String message = String.format("Object is invalid: %s mandatory attributes are missing",
                            violations.size());
                    throw new IllegalStateException(message);
                }
            });
    }


    @Test
    void ensureTrailerCanBeValidated() {

        Trailer trailer = new Trailer();

        // Check if valid
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Trailer>> violations = validator.validate(trailer);

        assertEquals(5, violations.size(), "5 attributes should be mandatory for Trailer.");
        assertThrows(IllegalStateException.class,
            () -> {
                if (!violations.isEmpty()) {
                    String message = String.format("Object is invalid: %s mandatory attributes are missing",
                            violations.size());
                    throw new IllegalStateException(message);
                }
            });
    }
}
