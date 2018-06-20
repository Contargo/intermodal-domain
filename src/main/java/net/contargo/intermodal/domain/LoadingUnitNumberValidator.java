package net.contargo.intermodal.domain;

import java.lang.annotation.*;

import java.util.Optional;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import static net.contargo.intermodal.domain.LoadingUnitNumber.isValidBIC;


/**
 * Validator to check whether the number or identifier of a {@link LoadingUnit} is valid.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class LoadingUnitNumberValidator implements ConstraintValidator<LoadingUnitNumberConstraint, String> {

    public LoadingUnitNumberValidator() {

        // OK
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return value != null && isValidBIC(value);
    }
}

@Documented
@Constraint(validatedBy = LoadingUnitNumberValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@interface LoadingUnitNumberConstraint {

    String message() default "Invalid loading unit number.";


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};
}
