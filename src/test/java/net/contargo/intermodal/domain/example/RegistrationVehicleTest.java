package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.*;

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
                .withTruck(TestDataCreator.createTruck())
                .withChassis(TestDataCreator.createChassis())
                .withDriver(TestDataCreator.createDriver())
                .withHaulierClient("haulier client")
                .withHaulierRealizing("haulier realizing")
                .withDeliveryTime(Instant.parse("2018-05-14T12:30:00Z"))
                .withLuOrder(TestDataCreator.createLUOrder())
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
    void ensureCanBeCreatedWithMinimumRequirements() {

        RegistrationVehicle.newBuilder()
            .withTruck(TestDataCreator.createTruck())
            .withDriver(TestDataCreator.createDriver())
            .withHaulierClient("haulier client")
            .withHaulierRealizing("haulier realizing")
            .withDeliveryTime(Instant.parse("2018-05-14T12:30:00Z"))
            .withLuOrder(TestDataCreator.createLUOrder())
            .buildAndValidate();
    }


    @Test
    void ensureCanBeCopied() {

        RegistrationVehicle registrationVehicle = RegistrationVehicle.newBuilder()
                .withTruck(TestDataCreator.createTruck())
                .withChassis(TestDataCreator.createChassis())
                .withDriver(TestDataCreator.createDriver())
                .withHaulierClient("haulier client")
                .withHaulierRealizing("haulier realizing")
                .withDeliveryTime(Instant.parse("2018-05-14T12:30:00Z"))
                .withLuOrder(TestDataCreator.createLUOrder())
                .buildAndValidate();

        RegistrationVehicle copiedRegistrationVehicle = RegistrationVehicle.newBuilder(registrationVehicle)
                .buildAndValidate();

        assertNotNull(copiedRegistrationVehicle.getTruck());
        assertNotNull(copiedRegistrationVehicle.getChassis());
        assertNotNull(copiedRegistrationVehicle.getDriver());
        assertEquals("haulier client", copiedRegistrationVehicle.getHaulierClient());
        assertEquals("haulier realizing", copiedRegistrationVehicle.getHaulierRealizing());
        assertEquals("2018-05-14T12:30:00Z", copiedRegistrationVehicle.getDeliveryTime().toString());
        assertNotNull(copiedRegistrationVehicle.getLuOrder());
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class,
            () ->
                RegistrationVehicle.newBuilder()
                    .withDriver(TestDataCreator.createDriver())
                    .withHaulierClient("haulier client")
                    .withHaulierRealizing("haulier realizing")
                    .withDeliveryTime(Instant.parse("2018-05-14T12:30:00Z"))
                    .withLuOrder(TestDataCreator.createLUOrder())
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                RegistrationVehicle.newBuilder()
                    .withTruck(TestDataCreator.createTruck())
                    .withHaulierClient("haulier client")
                    .withHaulierRealizing("haulier realizing")
                    .withDeliveryTime(Instant.parse("2018-05-14T12:30:00Z"))
                    .withLuOrder(TestDataCreator.createLUOrder())
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                RegistrationVehicle.newBuilder()
                    .withTruck(TestDataCreator.createTruck())
                    .withDriver(TestDataCreator.createDriver())
                    .withHaulierRealizing("haulier realizing")
                    .withDeliveryTime(Instant.parse("2018-05-14T12:30:00Z"))
                    .withLuOrder(TestDataCreator.createLUOrder())
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                RegistrationVehicle.newBuilder()
                    .withTruck(TestDataCreator.createTruck())
                    .withDriver(TestDataCreator.createDriver())
                    .withHaulierClient("haulier client")
                    .withDeliveryTime(Instant.parse("2018-05-14T12:30:00Z"))
                    .withLuOrder(TestDataCreator.createLUOrder())
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationVehicle.newBuilder()
                    .withTruck(TestDataCreator.createTruck())
                    .withDriver(TestDataCreator.createDriver())
                    .withHaulierClient("haulier client")
                    .withHaulierRealizing("haulier realizing")
                    .withLuOrder(TestDataCreator.createLUOrder())
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationVehicle.newBuilder()
                    .withTruck(TestDataCreator.createTruck())
                    .withDriver(TestDataCreator.createDriver())
                    .withHaulierClient("haulier client")
                    .withHaulierRealizing("haulier realizing")
                    .withDeliveryTime(Instant.parse("2018-05-14T12:30:00Z"))
                    .buildAndValidate());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        RegistrationVehicle registrationVehicle = RegistrationVehicle.newBuilder()
                .withTruck(TestDataCreator.createTruck())
                .withChassis(TestDataCreator.createChassis())
                .withDriver(TestDataCreator.createDriver())
                .withHaulierClient("haulier client")
                .withHaulierRealizing("haulier realizing")
                .withDeliveryTime(Instant.parse("2018-05-14T12:30:00Z"))
                .withLuOrder(TestDataCreator.createLUOrder())
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
