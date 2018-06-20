package net.contargo.intermodal.domain;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;


/**
 * Validator to check whether the minimum requirements of the location of a {@link PickUp} and {@link DropOff} are
 * fulfilled.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class LocationValidator implements ConstraintValidator<TransportConstraint, Location> {

    public LocationValidator() {

        // OK
    }

    @Override
    public boolean isValid(Location value, ConstraintValidatorContext context) {

        return value != null && value.getDesignation() != null && value.getCity() != null;
    }
}

@Documented
@Constraint(validatedBy = LocationValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@interface LocationConstraint {

    String message() default "Location invalid";


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};
}
