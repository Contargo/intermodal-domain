package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.RegistrationBarge;
import net.contargo.intermodal.domain.TestDataCreator;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class RegistrationBargeTest {

    @Test
    void ensureCanBeCreatedWithAllInformation() {

        RegistrationBarge registrationBarge = RegistrationBarge.newBuilder()
                .withBarge(TestDataCreator.createBarge())
                .withEstimatedTimeOfArrival(Instant.parse("2018-05-14T11:00:00Z"))
                .withEstimatedTimeOfDeparture(Instant.parse("2018-05-14T12:00:00Z"))
                .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                .withVolumeToDischarge(24)
                .withVolumeToLoad(24)
                .buildAndValidate();

        assertNotNull(registrationBarge.getBarge());
        assertEquals("2018-05-14T11:00:00Z", registrationBarge.getEstimatedTimeOfArrival().toString());
        assertEquals("2018-05-14T12:00:00Z", registrationBarge.getEstimatedTimeOfDepature().toString());
        assertNotNull(registrationBarge.getDangerousGoodsIndication());
        assertEquals(24, registrationBarge.getVolumeToLoad().intValue());
        assertEquals(24, registrationBarge.getVolumeToDischarge().intValue());
    }


    @Test
    void ensureCanBeCreatedWithAllInformationWithStepBuilder() {

        RegistrationBarge registrationBarge = RegistrationBarge.newStepBuilder()
                .withBarge(TestDataCreator.createBarge())
                .withEstimatedTimeOfArrival(Instant.parse("2018-05-14T11:00:00Z"))
                .withEstimatedTimeOfDeparture(Instant.parse("2018-05-14T12:00:00Z"))
                .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                .withVolumeToDischarge(24)
                .withVolumeToLoad(24)
                .buildAndValidate();

        assertNotNull(registrationBarge.getBarge());
        assertEquals("2018-05-14T11:00:00Z", registrationBarge.getEstimatedTimeOfArrival().toString());
        assertEquals("2018-05-14T12:00:00Z", registrationBarge.getEstimatedTimeOfDepature().toString());
        assertNotNull(registrationBarge.getDangerousGoodsIndication());
        assertEquals(24, registrationBarge.getVolumeToLoad().intValue());
        assertEquals(24, registrationBarge.getVolumeToDischarge().intValue());
    }


    @Test
    void ensureCanBeCreatedWithMinimumRequirements() {

        RegistrationBarge.newBuilder()
            .withBarge(TestDataCreator.createBarge())
            .withEstimatedTimeOfArrival(Instant.parse("2018-05-14T11:00:00Z"))
            .withEstimatedTimeOfDeparture(Instant.parse("2018-05-14T12:00:00Z"))
            .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
            .withVolumeToDischarge(24)
            .withVolumeToLoad(24)
            .buildAndValidate();
    }


    @Test
    void ensureCanBeCopied() {

        RegistrationBarge registrationBarge = RegistrationBarge.newBuilder()
                .withBarge(TestDataCreator.createBarge())
                .withEstimatedTimeOfArrival(Instant.parse("2018-05-14T11:00:00Z"))
                .withEstimatedTimeOfDeparture(Instant.parse("2018-05-14T12:00:00Z"))
                .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                .withVolumeToDischarge(24)
                .withVolumeToLoad(24)
                .buildAndValidate();

        RegistrationBarge copiedRegistrationBarge = RegistrationBarge.newBuilder(registrationBarge).buildAndValidate();

        assertNotNull(copiedRegistrationBarge.getBarge());
        assertEquals("2018-05-14T11:00:00Z", copiedRegistrationBarge.getEstimatedTimeOfArrival().toString());
        assertEquals("2018-05-14T12:00:00Z", copiedRegistrationBarge.getEstimatedTimeOfDepature().toString());
        assertNotNull(copiedRegistrationBarge.getDangerousGoodsIndication());
        assertEquals(24, copiedRegistrationBarge.getVolumeToLoad().intValue());
        assertEquals(24, copiedRegistrationBarge.getVolumeToDischarge().intValue());
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class,
            () ->
                RegistrationBarge.newBuilder()
                    .withEstimatedTimeOfArrival(Instant.parse("2018-05-14T11:00:00Z"))
                    .withEstimatedTimeOfDeparture(Instant.parse("2018-05-14T12:00:00Z"))
                    .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                    .withVolumeToDischarge(24)
                    .withVolumeToLoad(24)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationBarge.newBuilder()
                    .withBarge(TestDataCreator.createBarge())
                    .withEstimatedTimeOfDeparture(Instant.parse("2018-05-14T12:00:00Z"))
                    .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                    .withVolumeToDischarge(24)
                    .withVolumeToLoad(24)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationBarge.newBuilder()
                    .withBarge(TestDataCreator.createBarge())
                    .withEstimatedTimeOfArrival(Instant.parse("2018-05-14T11:00:00Z"))
                    .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                    .withVolumeToDischarge(24)
                    .withVolumeToLoad(24)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationBarge.newBuilder()
                    .withBarge(TestDataCreator.createBarge())
                    .withEstimatedTimeOfArrival(Instant.parse("2018-05-14T11:00:00Z"))
                    .withEstimatedTimeOfDeparture(Instant.parse("2018-05-14T12:00:00Z"))
                    .withVolumeToDischarge(24)
                    .withVolumeToLoad(24)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationBarge.newBuilder()
                    .withBarge(TestDataCreator.createBarge())
                    .withEstimatedTimeOfArrival(Instant.parse("2018-05-14T11:00:00Z"))
                    .withEstimatedTimeOfDeparture(Instant.parse("2018-05-14T12:00:00Z"))
                    .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                    .withVolumeToLoad(24)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationBarge.newBuilder()
                    .withBarge(TestDataCreator.createBarge())
                    .withEstimatedTimeOfArrival(Instant.parse("2018-05-14T11:00:00Z"))
                    .withEstimatedTimeOfDeparture(Instant.parse("2018-05-14T12:00:00Z"))
                    .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                    .withVolumeToDischarge(24)
                    .buildAndValidate());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        RegistrationBarge registrationBarge = RegistrationBarge.newBuilder()
                .withBarge(TestDataCreator.createBarge())
                .withEstimatedTimeOfArrival(Instant.parse("2018-05-14T11:00:00Z"))
                .withEstimatedTimeOfDeparture(Instant.parse("2018-05-14T12:00:00Z"))
                .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                .withVolumeToDischarge(24)
                .withVolumeToLoad(24)
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(registrationBarge);

        RegistrationBarge deserialize = mapper.readValue(jsonString, RegistrationBarge.class);

        assertNotNull(deserialize.getBarge());
        assertEquals("2018-05-14T11:00:00Z", deserialize.getEstimatedTimeOfArrival().toString());
        assertEquals("2018-05-14T12:00:00Z", deserialize.getEstimatedTimeOfDepature().toString());
        assertNotNull(deserialize.getDangerousGoodsIndication());
        assertEquals(24, deserialize.getVolumeToLoad().intValue());
        assertEquals(24, deserialize.getVolumeToDischarge().intValue());
    }
}
