package net.contargo.intermodal.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;


/**
 * Validator to check if the minimum requirements of an Object are fulfilled.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class Validator {

    static void validate(Object object) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        javax.validation.Validator validator = factory.getValidator();

        List<String> violations = new ArrayList<>();
        validator.validate(object).forEach(violation -> {
            if (!violation.getConstraintDescriptor().getAnnotation().toString().contains("NotNull")) {
                violations.add(violation.getMessage());
            } else {
                violations.add(violation.getPropertyPath().toString());
            }
        });

        if (!violations.isEmpty()) {
            String message = String.format(
                    "Invalid Object %s: The following attributes have to be set to fulfill the minimum requirement: %s.",
                    object.getClass().getName(), String.join(", ", violations));
            throw new IllegalStateException(message);
        }
    }
}
