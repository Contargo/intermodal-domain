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
class RegistrationTrainTest {

    @Test
    void ensureCanBeCreatedWithAllInformation() {

        RegistrationTrain registrationTrain = RegistrationTrain.newBuilder()
                .withTrainTitle("My Train")
                .withRailwayOperator(TestDataCreator.createOperator())
                .withOperator(TestDataCreator.createOperator())
                .withTerminalEta(Instant.parse("2018-05-14T11:00:00Z"))
                .withTerminalEtd(Instant.parse("2018-05-14T13:00:00Z"))
                .withShuntingYardEta(Instant.parse("2018-05-14T12:00:00Z"))
                .withShunter("a shunter")
                .withTotalLength(120.0, LengthUnit.METRE)
                .withWaggonQuantity(10)
                .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                .withVolumeToDischarge(10)
                .withVolumeToLoad(8)
                .withTrainPaths("12345")
                .buildAndValidate();

        assertEquals("My Train", registrationTrain.getTrainTitle());
        assertNotNull(registrationTrain.getRailwayOperator());
        assertNotNull(registrationTrain.getOperator());
        assertEquals("2018-05-14T11:00:00Z", registrationTrain.getTerminalEta().toString());
        assertEquals("2018-05-14T13:00:00Z", registrationTrain.getTerminalEtd().toString());
        assertEquals("2018-05-14T12:00:00Z", registrationTrain.getShuntingYardEta().toString());
        assertEquals("a shunter", registrationTrain.getShunter());
        assertEquals(120.0, registrationTrain.getTotalLength().getValue().doubleValue());
        assertEquals(10, registrationTrain.getWaggonQuantity().intValue());
        assertNotNull(registrationTrain.getDangerousGoodsIndication());
        assertEquals(10, registrationTrain.getVolumeToDischarge().intValue());
        assertEquals(8, registrationTrain.getVolumeToLoad().intValue());
        assertEquals("12345", registrationTrain.getTrainPaths());
    }


    @Test
    void ensureCanBeCreatedWithAllInformationWithStepBuilder() {

        RegistrationTrain registrationTrain = RegistrationTrain.newStepBuilder()
                .withTrainTitle("My Train")
                .withRailwayOperator(TestDataCreator.createOperator())
                .withOperator(TestDataCreator.createOperator())
                .withTerminalEta(Instant.parse("2018-05-14T11:00:00Z"))
                .withTerminalEtd(Instant.parse("2018-05-14T13:00:00Z"))
                .withShuntingYardEta(Instant.parse("2018-05-14T12:00:00Z"))
                .withShunter("a shunter")
                .withTotalLength(120.0, LengthUnit.METRE)
                .withWaggonQuantity(10)
                .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                .withVolumeToDischarge(10)
                .withVolumeToLoad(8)
                .withTrainPaths("12345")
                .buildAndValidate();

        assertEquals("My Train", registrationTrain.getTrainTitle());
        assertNotNull(registrationTrain.getRailwayOperator());
        assertNotNull(registrationTrain.getOperator());
        assertEquals("2018-05-14T11:00:00Z", registrationTrain.getTerminalEta().toString());
        assertEquals("2018-05-14T13:00:00Z", registrationTrain.getTerminalEtd().toString());
        assertEquals("2018-05-14T12:00:00Z", registrationTrain.getShuntingYardEta().toString());
        assertEquals("a shunter", registrationTrain.getShunter());
        assertEquals(120.0, registrationTrain.getTotalLength().getValue().doubleValue());
        assertEquals(10, registrationTrain.getWaggonQuantity().intValue());
        assertNotNull(registrationTrain.getDangerousGoodsIndication());
        assertEquals(10, registrationTrain.getVolumeToDischarge().intValue());
        assertEquals(8, registrationTrain.getVolumeToLoad().intValue());
        assertEquals("12345", registrationTrain.getTrainPaths());
    }


    @Test
    void ensureCanBeCreatedWithMinimumRequirements() {

        RegistrationTrain.newBuilder()
            .withTrainTitle("My Train")
            .withRailwayOperator(TestDataCreator.createOperator())
            .withOperator(TestDataCreator.createOperator())
            .withTerminalEta(Instant.parse("2018-05-14T11:00:00Z"))
            .withTerminalEtd(Instant.parse("2018-05-14T13:00:00Z"))
            .withShuntingYardEta(Instant.parse("2018-05-14T12:00:00Z"))
            .withShunter("a shunter")
            .withTotalLength(120.0, LengthUnit.METRE)
            .withWaggonQuantity(10)
            .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
            .withVolumeToDischarge(10)
            .withVolumeToLoad(8)
            .withTrainPaths("12345")
            .buildAndValidate();
    }


    @Test
    void ensureCanBeCopied() {

        RegistrationTrain registrationTrain = RegistrationTrain.newBuilder()
                .withTrainTitle("My Train")
                .withRailwayOperator(TestDataCreator.createOperator())
                .withOperator(TestDataCreator.createOperator())
                .withTerminalEta(Instant.parse("2018-05-14T11:00:00Z"))
                .withTerminalEtd(Instant.parse("2018-05-14T13:00:00Z"))
                .withShuntingYardEta(Instant.parse("2018-05-14T12:00:00Z"))
                .withShunter("a shunter")
                .withTotalLength(120.0, LengthUnit.METRE)
                .withWaggonQuantity(10)
                .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                .withVolumeToDischarge(10)
                .withVolumeToLoad(8)
                .withTrainPaths("12345")
                .buildAndValidate();

        RegistrationTrain copiedRegistrationTrain = RegistrationTrain.newBuilder(registrationTrain).buildAndValidate();

        assertEquals("My Train", copiedRegistrationTrain.getTrainTitle());
        assertNotNull(copiedRegistrationTrain.getRailwayOperator());
        assertNotNull(copiedRegistrationTrain.getOperator());
        assertEquals("2018-05-14T11:00:00Z", copiedRegistrationTrain.getTerminalEta().toString());
        assertEquals("2018-05-14T13:00:00Z", copiedRegistrationTrain.getTerminalEtd().toString());
        assertEquals("2018-05-14T12:00:00Z", copiedRegistrationTrain.getShuntingYardEta().toString());
        assertEquals("a shunter", copiedRegistrationTrain.getShunter());
        assertEquals(120.0, copiedRegistrationTrain.getTotalLength().getValue().doubleValue());
        assertEquals(10, copiedRegistrationTrain.getWaggonQuantity().intValue());
        assertNotNull(copiedRegistrationTrain.getDangerousGoodsIndication());
        assertEquals(10, copiedRegistrationTrain.getVolumeToDischarge().intValue());
        assertEquals(8, copiedRegistrationTrain.getVolumeToLoad().intValue());
        assertEquals("12345", copiedRegistrationTrain.getTrainPaths());
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class,
            () ->
                RegistrationTrain.newBuilder()
                    .withRailwayOperator(TestDataCreator.createOperator())
                    .withOperator(TestDataCreator.createOperator())
                    .withTerminalEta(Instant.parse("2018-05-14T11:00:00Z"))
                    .withTerminalEtd(Instant.parse("2018-05-14T13:00:00Z"))
                    .withShuntingYardEta(Instant.parse("2018-05-14T12:00:00Z"))
                    .withShunter("a shunter")
                    .withTotalLength(120.0, LengthUnit.METRE)
                    .withWaggonQuantity(10)
                    .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                    .withVolumeToDischarge(10)
                    .withVolumeToLoad(8)
                    .withTrainPaths("12345")
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationTrain.newBuilder()
                    .withTrainTitle("My Train")
                    .withOperator(TestDataCreator.createOperator())
                    .withTerminalEta(Instant.parse("2018-05-14T11:00:00Z"))
                    .withTerminalEtd(Instant.parse("2018-05-14T13:00:00Z"))
                    .withShuntingYardEta(Instant.parse("2018-05-14T12:00:00Z"))
                    .withShunter("a shunter")
                    .withTotalLength(120.0, LengthUnit.METRE)
                    .withWaggonQuantity(10)
                    .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                    .withVolumeToDischarge(10)
                    .withVolumeToLoad(8)
                    .withTrainPaths("12345")
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationTrain.newBuilder()
                    .withTrainTitle("My Train")
                    .withRailwayOperator(TestDataCreator.createOperator())
                    .withOperator(TestDataCreator.createOperator())
                    .withTerminalEtd(Instant.parse("2018-05-14T13:00:00Z"))
                    .withShuntingYardEta(Instant.parse("2018-05-14T12:00:00Z"))
                    .withShunter("a shunter")
                    .withTotalLength(120.0, LengthUnit.METRE)
                    .withWaggonQuantity(10)
                    .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                    .withVolumeToDischarge(10)
                    .withVolumeToLoad(8)
                    .withTrainPaths("12345")
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationTrain.newBuilder()
                    .withTrainTitle("My Train")
                    .withRailwayOperator(TestDataCreator.createOperator())
                    .withOperator(TestDataCreator.createOperator())
                    .withTerminalEta(Instant.parse("2018-05-14T11:00:00Z"))
                    .withShuntingYardEta(Instant.parse("2018-05-14T12:00:00Z"))
                    .withShunter("a shunter")
                    .withTotalLength(120.0, LengthUnit.METRE)
                    .withWaggonQuantity(10)
                    .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                    .withVolumeToDischarge(10)
                    .withVolumeToLoad(8)
                    .withTrainPaths("12345")
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationTrain.newBuilder()
                    .withTrainTitle("My Train")
                    .withRailwayOperator(TestDataCreator.createOperator())
                    .withOperator(TestDataCreator.createOperator())
                    .withTerminalEta(Instant.parse("2018-05-14T11:00:00Z"))
                    .withTerminalEtd(Instant.parse("2018-05-14T13:00:00Z"))
                    .withShunter("a shunter")
                    .withTotalLength(120.0, LengthUnit.METRE)
                    .withWaggonQuantity(10)
                    .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                    .withVolumeToDischarge(10)
                    .withVolumeToLoad(8)
                    .withTrainPaths("12345")
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationTrain.newBuilder()
                    .withTrainTitle("My Train")
                    .withRailwayOperator(TestDataCreator.createOperator())
                    .withOperator(TestDataCreator.createOperator())
                    .withTerminalEta(Instant.parse("2018-05-14T11:00:00Z"))
                    .withTerminalEtd(Instant.parse("2018-05-14T13:00:00Z"))
                    .withShuntingYardEta(Instant.parse("2018-05-14T12:00:00Z"))
                    .withTotalLength(120.0, LengthUnit.METRE)
                    .withWaggonQuantity(10)
                    .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                    .withVolumeToDischarge(10)
                    .withVolumeToLoad(8)
                    .withTrainPaths("12345")
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationTrain.newBuilder()
                    .withTrainTitle("My Train")
                    .withRailwayOperator(TestDataCreator.createOperator())
                    .withOperator(TestDataCreator.createOperator())
                    .withTerminalEta(Instant.parse("2018-05-14T11:00:00Z"))
                    .withTerminalEtd(Instant.parse("2018-05-14T13:00:00Z"))
                    .withShuntingYardEta(Instant.parse("2018-05-14T12:00:00Z"))
                    .withShunter("a shunter")
                    .withWaggonQuantity(10)
                    .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                    .withVolumeToDischarge(10)
                    .withVolumeToLoad(8)
                    .withTrainPaths("12345")
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationTrain.newBuilder()
                    .withTrainTitle("My Train")
                    .withRailwayOperator(TestDataCreator.createOperator())
                    .withOperator(TestDataCreator.createOperator())
                    .withTerminalEta(Instant.parse("2018-05-14T11:00:00Z"))
                    .withTerminalEtd(Instant.parse("2018-05-14T13:00:00Z"))
                    .withShuntingYardEta(Instant.parse("2018-05-14T12:00:00Z"))
                    .withShunter("a shunter")
                    .withTotalLength(120.0, LengthUnit.METRE)
                    .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                    .withVolumeToDischarge(10)
                    .withVolumeToLoad(8)
                    .withTrainPaths("12345")
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationTrain.newBuilder()
                    .withTrainTitle("My Train")
                    .withRailwayOperator(TestDataCreator.createOperator())
                    .withOperator(TestDataCreator.createOperator())
                    .withTerminalEta(Instant.parse("2018-05-14T11:00:00Z"))
                    .withTerminalEtd(Instant.parse("2018-05-14T13:00:00Z"))
                    .withShuntingYardEta(Instant.parse("2018-05-14T12:00:00Z"))
                    .withShunter("a shunter")
                    .withTotalLength(120.0, LengthUnit.METRE)
                    .withWaggonQuantity(10)
                    .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                    .withVolumeToLoad(8)
                    .withTrainPaths("12345")
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationTrain.newBuilder()
                    .withTrainTitle("My Train")
                    .withRailwayOperator(TestDataCreator.createOperator())
                    .withOperator(TestDataCreator.createOperator())
                    .withTerminalEta(Instant.parse("2018-05-14T11:00:00Z"))
                    .withTerminalEtd(Instant.parse("2018-05-14T13:00:00Z"))
                    .withShuntingYardEta(Instant.parse("2018-05-14T12:00:00Z"))
                    .withShunter("a shunter")
                    .withTotalLength(120.0, LengthUnit.METRE)
                    .withWaggonQuantity(10)
                    .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                    .withVolumeToDischarge(10)
                    .withTrainPaths("12345")
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationTrain.newBuilder()
                    .withTrainTitle("My Train")
                    .withRailwayOperator(TestDataCreator.createOperator())
                    .withOperator(TestDataCreator.createOperator())
                    .withTerminalEta(Instant.parse("2018-05-14T11:00:00Z"))
                    .withTerminalEtd(Instant.parse("2018-05-14T13:00:00Z"))
                    .withShuntingYardEta(Instant.parse("2018-05-14T12:00:00Z"))
                    .withShunter("a shunter")
                    .withTotalLength(120.0, LengthUnit.METRE)
                    .withWaggonQuantity(10)
                    .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                    .withVolumeToDischarge(10)
                    .withVolumeToLoad(8)
                    .buildAndValidate());
    }


    @Test
    void ensureLengthCanBeSetInFoot() {

        RegistrationTrain registrationTrain = RegistrationTrain.newBuilder()
                .withTrainTitle("My Train")
                .withRailwayOperator(TestDataCreator.createOperator())
                .withOperator(TestDataCreator.createOperator())
                .withTerminalEta(Instant.parse("2018-05-14T11:00:00Z"))
                .withTerminalEtd(Instant.parse("2018-05-14T13:00:00Z"))
                .withShuntingYardEta(Instant.parse("2018-05-14T12:00:00Z"))
                .withShunter("a shunter")
                .withTotalLength(393.70, LengthUnit.FOOT)
                .withWaggonQuantity(10)
                .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                .withVolumeToDischarge(10)
                .withVolumeToLoad(8)
                .withTrainPaths("12345")
                .buildAndValidate();

        assertEquals(120, registrationTrain.getTotalLength().getValue().doubleValue(), 0.1);
        assertEquals("m", registrationTrain.getTotalLength().getUnit().toString());

        RegistrationTrain registrationTrainStep = RegistrationTrain.newStepBuilder()
                .withTrainTitle("My Train")
                .withRailwayOperator(TestDataCreator.createOperator())
                .withOperator(TestDataCreator.createOperator())
                .withTerminalEta(Instant.parse("2018-05-14T11:00:00Z"))
                .withTerminalEtd(Instant.parse("2018-05-14T13:00:00Z"))
                .withShuntingYardEta(Instant.parse("2018-05-14T12:00:00Z"))
                .withShunter("a shunter")
                .withTotalLength(393.70, LengthUnit.FOOT)
                .withWaggonQuantity(10)
                .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                .withVolumeToDischarge(10)
                .withVolumeToLoad(8)
                .withTrainPaths("12345")
                .buildAndValidate();

        assertEquals(120, registrationTrainStep.getTotalLength().getValue().doubleValue(), 0.1);
        assertEquals("m", registrationTrainStep.getTotalLength().getUnit().toString());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        RegistrationTrain registrationTrain = RegistrationTrain.newBuilder()
                .withTrainTitle("My Train")
                .withRailwayOperator(TestDataCreator.createOperator())
                .withOperator(TestDataCreator.createOperator())
                .withTerminalEta(Instant.parse("2018-05-14T11:00:00Z"))
                .withTerminalEtd(Instant.parse("2018-05-14T13:00:00Z"))
                .withShuntingYardEta(Instant.parse("2018-05-14T12:00:00Z"))
                .withShunter("a shunter")
                .withTotalLength(120.0, LengthUnit.METRE)
                .withWaggonQuantity(10)
                .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                .withVolumeToDischarge(10)
                .withVolumeToLoad(8)
                .withTrainPaths("12345")
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(registrationTrain);

        RegistrationTrain deserialize = mapper.readValue(jsonString, RegistrationTrain.class);

        assertEquals("My Train", deserialize.getTrainTitle());
        assertNotNull(deserialize.getRailwayOperator());
        assertNotNull(deserialize.getOperator());
        assertEquals("2018-05-14T11:00:00Z", deserialize.getTerminalEta().toString());
        assertEquals("2018-05-14T13:00:00Z", deserialize.getTerminalEtd().toString());
        assertEquals("2018-05-14T12:00:00Z", deserialize.getShuntingYardEta().toString());
        assertEquals("a shunter", deserialize.getShunter());
        assertEquals(120.0, deserialize.getTotalLength().getValue().doubleValue());
        assertEquals(10, deserialize.getWaggonQuantity().intValue());
        assertNotNull(deserialize.getDangerousGoodsIndication());
        assertEquals(10, deserialize.getVolumeToDischarge().intValue());
        assertEquals(8, deserialize.getVolumeToLoad().intValue());
        assertEquals("12345", deserialize.getTrainPaths());
    }
}
