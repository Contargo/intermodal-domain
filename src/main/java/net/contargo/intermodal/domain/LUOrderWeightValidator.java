package net.contargo.intermodal.domain;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */

@Documented
@Constraint(validatedBy = LUOrderWeightValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@interface LUOrderWeightConstraint {

    String message() default "LU Order weight invalid";


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};
}

public class LUOrderWeightValidator implements ConstraintValidator<LUOrderWeightConstraint, Weight> {

    public LUOrderWeightValidator() {

        // for testing
    }

    @Override
    public boolean isValid(Weight weight, ConstraintValidatorContext context) {

        return weight.getBrutto() != null && weight.getNetto() != null && weight.getTara() != null;
    }
}
