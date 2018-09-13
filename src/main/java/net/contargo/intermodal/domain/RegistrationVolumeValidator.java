package net.contargo.intermodal.domain;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;


/**
 * Validator to check whether the minimum requirements of the volume of a registration of a
 * {@link RegistrationBarge barge} or {@link RegistrationTrain train} are fulfilled.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class RegistrationVolumeValidator implements ConstraintValidator<RegistrationVolumeConstraint, Volume> {

    public RegistrationVolumeValidator() {

        // for testing
    }

    @Override
    public boolean isValid(Volume volume, ConstraintValidatorContext context) {

        return volume.getToDischarge() != null && volume.getToLoad() != null;
    }
}

@Documented
@Constraint(validatedBy = RegistrationVolumeValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@interface RegistrationVolumeConstraint {

    String message() default "Volume invalid";


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};
}
