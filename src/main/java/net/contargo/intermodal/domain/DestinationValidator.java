package net.contargo.intermodal.domain;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;


/**
 * Validator to check whether the minimum requirements of a {@link Destination} are fulfilled.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */

@Documented
@Constraint(validatedBy = DestinationValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@interface DestinationConstraint {

    String message() default "Designation invalid";


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};
}

public class DestinationValidator implements ConstraintValidator<DestinationConstraint, Destination> {

    public DestinationValidator() {

        // for testing
    }

    @Override
    public boolean isValid(Destination destination, ConstraintValidatorContext context) {

        return destination != null && destination.getLocation() != null
            && destination.getLocation().getDesignation() != null;
    }
}
