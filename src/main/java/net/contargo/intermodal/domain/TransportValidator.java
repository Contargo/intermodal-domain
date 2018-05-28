package net.contargo.intermodal.domain;

import java.lang.annotation.*;

import java.util.List;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;


/**
 * Validator to check whether the minimum requirements of the volume of a {@link Transport} are fulfilled.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */

@Documented
@Constraint(validatedBy = TransportValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@interface TransportConstraint {

    String message() default "Transport invalid";


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};
}

public class TransportValidator implements ConstraintValidator<TransportConstraint, Transport> {

    public TransportValidator() {

        // for testing
    }

    @Override
    public boolean isValid(Transport transport, ConstraintValidatorContext constraintValidatorContext) {

        return isValid(transport.getPickUp()) && isValid(transport.getDropOff()) && isValid(transport.getStops());
    }


    private boolean isValid(Transport.PickUp pickUp) {

        return pickUp != null && isValid(pickUp.getLocation()) && pickUp.getEarliest() != null
            && pickUp.getMot() != null;
    }


    private boolean isValid(Transport.DropOff dropOff) {

        return dropOff != null && isValid(dropOff.getLocation()) && dropOff.getMot() != null;
    }


    private boolean isValid(Location location) {

        return location != null && location.getCity() != null && location.getDesignation() != null;
    }


    private boolean isValid(List<Stop> stops) {

        return stops != null && stops.stream().noneMatch(stop -> stop.getLocation() == null)
            && stops.stream().flatMap(stop -> stop.getLocation().stream()).anyMatch(location ->
                    location.getCity() != null && location.getDesignation() != null);
    }
}
