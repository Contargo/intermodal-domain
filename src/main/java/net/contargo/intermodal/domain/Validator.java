package net.contargo.intermodal.domain;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class Validator {

    static void validate(Object object) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        javax.validation.Validator validator = factory.getValidator();

        List<String> violations = new ArrayList<>();
        validator.validate(object).forEach(violation -> violations.add(violation.getPropertyPath().toString()));

        if (!violations.isEmpty()) {
            String message = String.format(
                    "Invalid Object %s: The following attributes have to be set to fulfill the minimum requirement: %s.",
                    object.getClass().getName(), String.join(", ", violations));
            throw new IllegalStateException(message);
        }
    }
}
