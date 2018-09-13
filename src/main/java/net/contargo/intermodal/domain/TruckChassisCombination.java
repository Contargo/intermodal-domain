package net.contargo.intermodal.domain;

/**
 * Combination of a {@link Truck} and a {@link Chassis}. This class is used to have a representation that combines them
 * to a {@link MeansOfTransport}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @source  Contargo specific
 */
public class TruckChassisCombination implements MeansOfTransport {

    private Truck truck;
    private Chassis chassis;

    /**
     * Creates a new builder for {@link TruckChassisCombination}.
     *
     * @return  new builder
     */
    public static Builder newBuilder() {

        return new Builder();
    }


    /**
     * Creates a new builder with the values of another {@link TruckChassisCombination}.
     *
     * @param  truckChassisCombination  that should be copied.
     *
     * @return  new builder with values of given truckChassisCombination.
     */
    public static Builder newBuilder(TruckChassisCombination truckChassisCombination) {

        return new Builder().withChassis(truckChassisCombination.getChassis())
            .withTruck(truckChassisCombination.getTruck());
    }


    public Chassis getChassis() {

        return chassis;
    }


    public Truck getTruck() {

        return truck;
    }

    public static final class Builder {

        private Truck truck;
        private Chassis chassis;

        private Builder() {
        }

        public Builder withTruck(Truck truck) {

            this.truck = truck;

            return this;
        }


        public Builder withChassis(Chassis chassis) {

            this.chassis = chassis;

            return this;
        }


        /**
         * Builds {@link TruckChassisCombination} without input validation.
         *
         * @return  new {@link TruckChassisCombination} with attributes specified in {@link Builder}
         */
        public TruckChassisCombination build() {

            TruckChassisCombination truckChassisCombination = new TruckChassisCombination();
            truckChassisCombination.truck = this.truck;
            truckChassisCombination.chassis = this.chassis;

            return truckChassisCombination;
        }


        /**
         * Validates the input and builds {@link TruckChassisCombination}. Throws IllegalStateException if input
         * doesn't fulfill the minimum requirement of {@link TruckChassisCombination}.
         *
         * @return  new {@link TruckChassisCombination} with attributes specified in {@link Builder}
         */
        public TruckChassisCombination buildAndValidate() {

            TruckChassisCombination truckChassisCombination = this.build();

            MinimumRequirementValidator.validate(truckChassisCombination);

            return truckChassisCombination;
        }
    }
}
