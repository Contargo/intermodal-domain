package net.contargo.intermodal.domain;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;


/**
 * Validator to check whether the minimum requirements of the location of a {@link Destination} are fulfilled.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
@Documented
@Constraint(validatedBy = DestinationLocationValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@interface DestinationLocationConstraint {

    String message() default "Location invalid";


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};
}

public class DestinationLocationValidator implements ConstraintValidator<TransportConstraint, Location> {

    public DestinationLocationValidator() {

        // OK
    }

    @Override
    public boolean isValid(Location value, ConstraintValidatorContext context) {

        return value != null && value.getDesignation() != null;
    }
}
