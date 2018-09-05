package net.contargo.intermodal.domain;

/**
 * Util class to create test data.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class TestDataCreator {

    private TestDataCreator() {

        // OK
    }

    /**
     * Creates a lu order with only minimum requirements.
     *
     * @return  simple {@link LUOrder} with minimum requirements
     */
    public static LUOrder createLUOrder() {

        return LUOrder.newBuilder()
            .withLoadingUnit(createContainer())
            .withWeightBrutto(30480.0, MassUnit.KILOGRAM)
            .withWeightNetto(28080.0, MassUnit.KILOGRAM)
            .withWeightTare(2400.0, MassUnit.KILOGRAM)
            .withDangerousGoodsIndication(createDangerousGoods())
            .withWasteIndication(createWaste())
            .buildAndValidate();
    }


    /**
     * Creates waste with only minimum requirements.
     *
     * @return  simple {@link Waste} with minimum requirements
     */
    public static Waste createWaste() {

        return Waste.newBuilder().withKeyID("03 03 01").buildAndValidate();
    }


    /**
     * Creates container with only minimum requirements.
     *
     * @return  simple {@link Container} with minimum requirements
     */
    public static Container createContainer() {

        return Container.newBuilder()
            .withNumberAndIdentification("MSKU1806510")
            .isReefer(false)
            .withSizeType("45G0")
            .withType("General purpose container (without ventilation)")
            .withSize(40.0, LengthUnit.FOOT)
            .buildAndValidate();
    }


    /**
     * Creates dangerous goods with only minimum requirements.
     *
     * @return  simple {@link DangerousGoods} with minimum requirements
     */
    public static DangerousGoods createDangerousGoods() {

        return DangerousGoods.newBuilder().withUnNumber("1005").buildAndValidate();
    }


    /**
     * Creates operator with only minimum requirements.
     *
     * @return  simple {@link Operator} with minimum requirements
     */
    public static Operator createOperator() {

        return Operator.newBuilder().buildAndValidate();
    }


    /**
     * Creates truck chassis combination with only minimum requirements.
     *
     * @return  simple {@link TruckChassisCombination} with minimum requirements
     */
    public static TruckChassisCombination createTruckChassisCombination() {

        return TruckChassisCombination.newBuilder()
            .withTruck(Truck.newBuilder().withCountryCode("DE").buildAndValidate())
            .withChassis(Chassis.newBuilder().withEuAuthorization(true).buildAndValidate())
            .buildAndValidate();
    }


    /**
     * Creates truck with only minimum requirements.
     *
     * @return  simple {@link Truck} with minimum requirements
     */
    public static Truck createTruck() {

        return Truck.newBuilder().buildAndValidate();
    }


    /**
     * Creates vessel with only minimum requirements.
     *
     * @return  simple {@link Vessel} with minimum requirements
     */
    public static Vessel createVessel() {

        return Vessel.newBuilder().buildAndValidate();
    }


    /**
     * Creates barge with only minimum requirements.
     *
     * @return  simple {@link Barge} with minimum requirements
     */
    public static Barge createBarge() {

        return Barge.newBuilder().buildAndValidate();
    }


    /**
     * Creates address with only minimum requirements.
     *
     * @return  simple {@link Address} with minimum requirements
     */
    public static Address createAddress() {

        return Address.newBuilder().buildAndValidate();
    }


    /**
     * Creates customs with only minimum requirements.
     *
     * @return  simple {@link Customs} with minimum requirements
     */
    public static Customs createCustoms() {

        return Customs.newBuilder().buildAndValidate();
    }


    /**
     * Creates seaport with only minimum requirements.
     *
     * @return  simple {@link Seaport} with minimum requirements
     */
    public static Seaport createSeaport() {

        return Seaport.newBuilder().withName("DEDUI").buildAndValidate();
    }


    /**
     * Creates stop with only minimum requirements.
     *
     * @return  simple {@link Stop} with minimum requirements
     */
    public static Stop createStop() {

        return Stop.newBuilder()
            .withLocation(Location.newBuilder()
                    .withCity("Koblenz")
                    .withDesignation("Terminal Koblenz")
                    .withType("terminal")
                    .buildAndValidate())
            .buildAndValidate();
    }


    /**
     * Creates driver with only minimum requirements.
     *
     * @return  simple {@link Driver} with minimum requirements
     */
    public static Driver createDriver() {

        return Driver.newBuilder().buildAndValidate();
    }


    /**
     * Creates chassis with only minimum requirements.
     *
     * @return  simple {@link Chassis} with minimum requirements
     */
    public static Chassis createChassis() {

        return Chassis.newBuilder().buildAndValidate();
    }


    /**
     * Creates skipper with only minimum requirements.
     *
     * @return  simple {@link Skipper} with minimum requirements
     */
    public static Skipper createSkipper() {

        return Skipper.newBuilder().buildAndValidate();
    }


    /**
     * Creates passenger with only minimum requirements.
     *
     * @return  simple {@link Passenger} with minimum requirements
     */
    public static Passenger createPassenger() {

        return Passenger.newBuilder().buildAndValidate();
    }


    /**
     * Creates coordinates with only minimum requirements.
     *
     * @return  simple {@link Coordinates} with minimum requirements
     */
    public static Coordinates createCoordinates() {

        return Coordinates.newBuilder().withLatitude(49.0594626).withLongitude(8.2966241).buildAndValidate();
    }
}
