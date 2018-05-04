package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.loadingUnit.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


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

        Assertions.assertEquals("CSQU3054383", swapBody.getIdentification());
        Assertions.assertEquals("CSQU3054383", swapBody.getNumber());
        Assertions.assertEquals(LoadingUnitCategory.SWAP_BODY, swapBody.getCategory());
        Assertions.assertEquals(70, swapBody.getWeightBruttoMax().doubleValue());
        Assertions.assertEquals(65, swapBody.getWeightNettoMax().doubleValue());
        Assertions.assertEquals(70, swapBody.getWeightTara().doubleValue());
        Assertions.assertEquals("i.O.", swapBody.getCondition());
        Assertions.assertFalse(swapBody.isReefer());
        Assertions.assertEquals("Contargo", swapBody.getOperator());
        Assertions.assertEquals("Open Top", swapBody.getType());
        Assertions.assertEquals(6.5, swapBody.getSize().doubleValue());
        Assertions.assertTrue(swapBody.isStackable());

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

        Assertions.assertEquals("CSQU3054383", container.getIdentification());
        Assertions.assertEquals("CSQU3054383", container.getNumber());
        Assertions.assertEquals(LoadingUnitCategory.CONTAINER, container.getCategory());
        Assertions.assertEquals(70, container.getWeightBruttoMax().doubleValue());
        Assertions.assertEquals(65, container.getWeightNettoMax().doubleValue());
        Assertions.assertEquals(70, container.getWeightTara().doubleValue());
        Assertions.assertEquals("i.O.", container.getCondition());
        Assertions.assertFalse(container.isReefer());
        Assertions.assertEquals("Contargo", container.getOperator());
        Assertions.assertEquals("20G0", container.getSizeType());
        Assertions.assertEquals("Open Top", container.getType());
        Assertions.assertEquals(6, container.getSize().doubleValue());

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

        Assertions.assertEquals("CSQU3054383", trailer.getIdentification());
        Assertions.assertEquals("CSQU3054383", trailer.getNumber());
        Assertions.assertEquals(LoadingUnitCategory.TRAILER, trailer.getCategory());
        Assertions.assertEquals(70, trailer.getWeightBruttoMax().doubleValue());
        Assertions.assertEquals(65, trailer.getWeightNettoMax().doubleValue());
        Assertions.assertEquals(70, trailer.getWeightTara().doubleValue());
        Assertions.assertEquals("i.O.", trailer.getCondition());
        Assertions.assertFalse(trailer.isReefer());
        Assertions.assertEquals("Contargo", trailer.getOperator());
        Assertions.assertEquals("XL", trailer.getType());

        Assertions.assertEquals(6, trailer.getSize().doubleValue());
        Assertions.assertTrue(trailer.isCraneable());

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

        Assertions.assertEquals(5, violations.size(), "5 attributes should be mandatory for SwapBody.");
        Assertions.assertThrows(IllegalStateException.class,
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

        Assertions.assertEquals(5, violations.size(), "5 attributes should be mandatory for Container.");
        Assertions.assertThrows(IllegalStateException.class,
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

        Assertions.assertEquals(5, violations.size(), "5 attributes should be mandatory for Trailer.");
        Assertions.assertThrows(IllegalStateException.class,
            () -> {
                if (!violations.isEmpty()) {
                    String message = String.format("Object is invalid: %s mandatory attributes are missing",
                            violations.size());
                    throw new IllegalStateException(message);
                }
            });
    }
}
