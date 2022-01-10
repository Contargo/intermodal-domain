package net.contargo.intermodal.domain;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import java.util.List;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;


/**
 * Validator to check whether the minimum requirements of the location of a {@link Stop} are fulfilled.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */

public class StopLocationValidator implements ConstraintValidator<StopLocationConstraint, List<Location>> {

    @Override
    public boolean isValid(List<Location> value, ConstraintValidatorContext context) {

        return value != null && !value.isEmpty() && value.stream().noneMatch(location ->
                    location == null || location.getCity() == null || location.getDesignation() == null);
    }
}

@Documented
@Constraint(validatedBy = StopLocationValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@interface StopLocationConstraint {

    String message() default "Location invalid";


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};
}
