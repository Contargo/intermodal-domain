package net.contargo.intermodal.domain;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;


/**
 * MinimumRequirementValidator to check if the minimum requirements of an Object are fulfilled.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class MinimumRequirementValidator {

    /**
     * Checks if an object fulfills its minimum requirement as specified by DIGIT. Throws IllegalStateException if
     * object is invalid.
     *
     * @param  object
     */
    static void validate(Object object) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        javax.validation.Validator validator = factory.getValidator();

        List<String> violations = new ArrayList<>();
        validator.validate(object).stream().filter(violation ->
                    !violation.getConstraintDescriptor()
                    .getAnnotation()
                    .toString()
                    .contains("LoadingUnitNumberConstraint")).forEach(violation -> {
            if (!violation.getConstraintDescriptor().getAnnotation().toString().contains("NotNull")) {
                violations.add(violation.getMessage());
            } else {
                violations.add(violation.getPropertyPath().toString());
            }
        });

        if (!violations.isEmpty()) {
            String message = String.format(
                    "Invalid Object %s: The following conditions have to be true to fulfill the minimum requirement: %s.",
                    object.getClass().getName(), String.join(", ", violations));
            throw new IllegalStateException(message);
        }
    }
}
