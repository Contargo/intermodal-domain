package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Chassis;
import net.contargo.intermodal.domain.Driver;
import net.contargo.intermodal.domain.LUOrder;
import net.contargo.intermodal.domain.RegistrationVehicle;
import net.contargo.intermodal.domain.Truck;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class RegistrationVehicleTest {

    @Test
    void ensureCanBeCreatedWithAllInformation() {

        RegistrationVehicle registrationVehicle = RegistrationVehicle.newBuilder()
                .withTruck(new Truck())
                .withChassis(new Chassis())
                .withDriver(new Driver())
                .withHaulierClient("haulier client")
                .withHaulierRealizing("haulier realizing")
                .withDeliveryTime(Instant.parse("2018-05-14T12:30:00Z"))
                .withLuOrder(new LUOrder())
                .buildAndValidate();

        assertNotNull(registrationVehicle.getTruck());
        assertNotNull(registrationVehicle.getChassis());
        assertNotNull(registrationVehicle.getDriver());
        assertEquals("haulier client", registrationVehicle.getHaulierClient());
        assertEquals("haulier realizing", registrationVehicle.getHaulierRealizing());
        assertEquals("2018-05-14T12:30:00Z", registrationVehicle.getDeliveryTime().toString());
        assertNotNull(registrationVehicle.getLuOrder());
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class,
            () ->
                RegistrationVehicle.newBuilder()
                    .withChassis(new Chassis())
                    .withDriver(new Driver())
                    .withHaulierClient("haulier client")
                    .withHaulierRealizing("haulier realizing")
                    .withDeliveryTime(Instant.parse("2018-05-14T12:30:00Z"))
                    .withLuOrder(new LUOrder())
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                RegistrationVehicle.newBuilder()
                    .withTruck(new Truck())
                    .withChassis(new Chassis())
                    .withHaulierClient("haulier client")
                    .withHaulierRealizing("haulier realizing")
                    .withDeliveryTime(Instant.parse("2018-05-14T12:30:00Z"))
                    .withLuOrder(new LUOrder())
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                RegistrationVehicle.newBuilder()
                    .withTruck(new Truck())
                    .withChassis(new Chassis())
                    .withDriver(new Driver())
                    .withHaulierRealizing("haulier realizing")
                    .withDeliveryTime(Instant.parse("2018-05-14T12:30:00Z"))
                    .withLuOrder(new LUOrder())
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                RegistrationVehicle.newBuilder()
                    .withTruck(new Truck())
                    .withChassis(new Chassis())
                    .withDriver(new Driver())
                    .withHaulierClient("haulier client")
                    .withDeliveryTime(Instant.parse("2018-05-14T12:30:00Z"))
                    .withLuOrder(new LUOrder())
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationVehicle.newBuilder()
                    .withTruck(new Truck())
                    .withChassis(new Chassis())
                    .withDriver(new Driver())
                    .withHaulierClient("haulier client")
                    .withHaulierRealizing("haulier realizing")
                    .withLuOrder(new LUOrder())
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationVehicle.newBuilder()
                    .withTruck(new Truck())
                    .withChassis(new Chassis())
                    .withDriver(new Driver())
                    .withHaulierClient("haulier client")
                    .withHaulierRealizing("haulier realizing")
                    .withDeliveryTime(Instant.parse("2018-05-14T12:30:00Z"))
                    .buildAndValidate());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        RegistrationVehicle registrationVehicle = RegistrationVehicle.newBuilder()
                .withTruck(new Truck())
                .withChassis(new Chassis())
                .withDriver(new Driver())
                .withHaulierClient("haulier client")
                .withHaulierRealizing("haulier realizing")
                .withDeliveryTime(Instant.parse("2018-05-14T12:30:00Z"))
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
        assertEquals("2018-05-14T12:30:00Z", deserialize.getDeliveryTime().toString());
        assertNotNull(deserialize.getLuOrder());
    }
}
