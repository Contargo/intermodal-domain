package net.contargo.intermodal.domain;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;


/**
 * Validator to check whether the minimum requirements of the location of a {@link Destination} are fulfilled.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */

public class DestinationLocationValidator implements ConstraintValidator<DestinationLocationConstraint, Location> {

    public DestinationLocationValidator() {

        // OK
    }

    @Override
    public boolean isValid(Location value, ConstraintValidatorContext context) {

        return value != null && value.getDesignation() != null;
    }
}

@Documented
@Constraint(validatedBy = DestinationLocationValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@interface DestinationLocationConstraint {

    String message() default "Location invalid";


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};
}
