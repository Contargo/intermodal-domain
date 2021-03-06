package net.contargo.intermodal.domain;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;


/**
 * Validator to check whether the minimum requirements of the weight of a {@link LUOrder} are fulfilled.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class LUOrderWeightValidator implements ConstraintValidator<LUOrderWeightConstraint, Weight> {

    public LUOrderWeightValidator() {

        // for testing
    }

    @Override
    public boolean isValid(Weight weight, ConstraintValidatorContext context) {

        return weight.getBrutto() != null && weight.getNetto() != null && weight.getTare() != null;
    }
}

@Documented
@Constraint(validatedBy = LUOrderWeightValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@interface LUOrderWeightConstraint {

    String message() default "LU Order weight invalid";


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};
}
