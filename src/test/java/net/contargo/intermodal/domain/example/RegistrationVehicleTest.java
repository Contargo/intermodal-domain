package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Chassis;
import net.contargo.intermodal.domain.Driver;
import net.contargo.intermodal.domain.LUOrder;
import net.contargo.intermodal.domain.RegistrationVehicle;
import net.contargo.intermodal.domain.Truck;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class RegistrationVehicleTest {

    @Test
    void ensureCanBeCreatedWithAllInformation() {

        RegistrationVehicle registrationVehicle = RegistrationVehicle.Builder.newRegistrationVehicle()
                .withTruck(new Truck())
                .withChassis(new Chassis())
                .withDriver(new Driver())
                .withHaulierClient("haulier client")
                .withHaulierRealizing("haulier realizing")
                .withDeliveryTime(2018, 5, 14, 12, 30)
                .withLuOrder(new LUOrder())
                .buildAndValidate();

        assertNotNull(registrationVehicle.getTruck());
        assertNotNull(registrationVehicle.getChassis());
        assertNotNull(registrationVehicle.getDriver());
        assertEquals("haulier client", registrationVehicle.getHaulierClient());
        assertEquals("haulier realizing", registrationVehicle.getHaulierRealizing());
        assertEquals("2018-05-14T12:30:00", registrationVehicle.getDeliveryTime());
        assertNotNull(registrationVehicle.getLuOrder());
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class,
            () ->
                RegistrationVehicle.Builder.newRegistrationVehicle()
                    .withChassis(new Chassis())
                    .withDriver(new Driver())
                    .withHaulierClient("haulier client")
                    .withHaulierRealizing("haulier realizing")
                    .withDeliveryTime(2018, 5, 14, 12, 30)
                    .withLuOrder(new LUOrder())
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                RegistrationVehicle.Builder.newRegistrationVehicle()
                    .withTruck(new Truck())
                    .withChassis(new Chassis())
                    .withHaulierClient("haulier client")
                    .withHaulierRealizing("haulier realizing")
                    .withDeliveryTime(2018, 5, 14, 12, 30)
                    .withLuOrder(new LUOrder())
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                RegistrationVehicle.Builder.newRegistrationVehicle()
                    .withTruck(new Truck())
                    .withChassis(new Chassis())
                    .withDriver(new Driver())
                    .withHaulierRealizing("haulier realizing")
                    .withDeliveryTime(2018, 5, 14, 12, 30)
                    .withLuOrder(new LUOrder())
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                RegistrationVehicle.Builder.newRegistrationVehicle()
                    .withTruck(new Truck())
                    .withChassis(new Chassis())
                    .withDriver(new Driver())
                    .withHaulierClient("haulier client")
                    .withDeliveryTime(2018, 5, 14, 12, 30)
                    .withLuOrder(new LUOrder())
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationVehicle.Builder.newRegistrationVehicle()
                    .withTruck(new Truck())
                    .withChassis(new Chassis())
                    .withDriver(new Driver())
                    .withHaulierClient("haulier client")
                    .withHaulierRealizing("haulier realizing")
                    .withLuOrder(new LUOrder())
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationVehicle.Builder.newRegistrationVehicle()
                    .withTruck(new Truck())
                    .withChassis(new Chassis())
                    .withDriver(new Driver())
                    .withHaulierClient("haulier client")
                    .withHaulierRealizing("haulier realizing")
                    .withDeliveryTime(2018, 5, 14, 12, 30)
                    .buildAndValidate());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        RegistrationVehicle registrationVehicle = RegistrationVehicle.Builder.newRegistrationVehicle()
                .withTruck(new Truck())
                .withChassis(new Chassis())
                .withDriver(new Driver())
                .withHaulierClient("haulier client")
                .withHaulierRealizing("haulier realizing")
                .withDeliveryTime(2018, 5, 14, 12, 30)
                .withLuOrder(new LUOrder())
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(registrationVehicle);

        RegistrationVehicle deserialize = mapper.readValue(jsonString, RegistrationVehicle.class);

        assertNotNull(deserialize.getTruck());
        assertNotNull(deserialize.getChassis());
        assertNotNull(deserialize.getDriver());
        assertEquals("haulier client", deserialize.getHaulierClient());
        assertEquals("haulier realizing", deserialize.getHaulierRealizing());
        assertEquals("2018-05-14T12:30:00", deserialize.getDeliveryTime());
        assertNotNull(deserialize.getLuOrder());
    }
}
