package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.DangerousGoods;
import net.contargo.intermodal.domain.LengthUnit;
import net.contargo.intermodal.domain.Operator;
import net.contargo.intermodal.domain.RegistrationTrain;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class RegistrationTrainTest {

    @Test
    void ensureCanBeCreatedWithAllInformation() {

        RegistrationTrain registrationTrain = RegistrationTrain.Builder.newRegistrationTrain()
                .withTrainTitle("My Train")
                .withRailwayOperator(new Operator())
                .withOperator(new Operator())
                .withTerminalEta(2018, 5, 14, 11, 0)
                .withTerminalEtd(2018, 5, 14, 13, 0)
                .withShuntingYardEta(2018, 5, 14, 12, 0)
                .withShunter("a shunter")
                .withTotalLength(120.0, LengthUnit.METRE)
                .withWaggonQuantity(10)
                .withDangerousGoodsIndication(new DangerousGoods())
                .withVolumeToDischarge(10)
                .withVolumeToLoad(8)
                .withTrainPaths("12345")
                .buildAndValidate();

        assertEquals("My Train", registrationTrain.getTrainTitle());
        assertNotNull(registrationTrain.getRailwayOperator());
        assertNotNull(registrationTrain.getOperator());
        assertEquals("2018-05-14T11:00:00", registrationTrain.getTerminalEta());
        assertEquals("2018-05-14T13:00:00", registrationTrain.getTerminalEtd());
        assertEquals("2018-05-14T12:00:00", registrationTrain.getShuntingYardEta());
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

        RegistrationTrain.Builder.newRegistrationTrain()
            .withTrainTitle("My Train")
            .withRailwayOperator(new Operator())
            .withOperator(new Operator())
            .withTerminalEta(2018, 5, 14, 11, 0)
            .withTerminalEtd(2018, 5, 14, 13, 0)
            .withShuntingYardEta(2018, 5, 14, 12, 0)
            .withShunter("a shunter")
            .withTotalLength(120.0, LengthUnit.METRE)
            .withWaggonQuantity(10)
            .withDangerousGoodsIndication(new DangerousGoods())
            .withVolumeToDischarge(10)
            .withVolumeToLoad(8)
            .withTrainPaths("12345")
            .buildAndValidate();
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class,
            () ->
                RegistrationTrain.Builder.newRegistrationTrain()
                    .withRailwayOperator(new Operator())
                    .withOperator(new Operator())
                    .withTerminalEta(2018, 5, 14, 11, 0)
                    .withTerminalEtd(2018, 5, 14, 13, 0)
                    .withShuntingYardEta(2018, 5, 14, 12, 0)
                    .withShunter("a shunter")
                    .withTotalLength(120.0, LengthUnit.METRE)
                    .withWaggonQuantity(10)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToDischarge(10)
                    .withVolumeToLoad(8)
                    .withTrainPaths("12345")
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationTrain.Builder.newRegistrationTrain()
                    .withTrainTitle("My Train")
                    .withOperator(new Operator())
                    .withTerminalEta(2018, 5, 14, 11, 0)
                    .withTerminalEtd(2018, 5, 14, 13, 0)
                    .withShuntingYardEta(2018, 5, 14, 12, 0)
                    .withShunter("a shunter")
                    .withTotalLength(120.0, LengthUnit.METRE)
                    .withWaggonQuantity(10)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToDischarge(10)
                    .withVolumeToLoad(8)
                    .withTrainPaths("12345")
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationTrain.Builder.newRegistrationTrain()
                    .withTrainTitle("My Train")
                    .withRailwayOperator(new Operator())
                    .withOperator(new Operator())
                    .withTerminalEtd(2018, 5, 14, 13, 0)
                    .withShuntingYardEta(2018, 5, 14, 12, 0)
                    .withShunter("a shunter")
                    .withTotalLength(120.0, LengthUnit.METRE)
                    .withWaggonQuantity(10)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToDischarge(10)
                    .withVolumeToLoad(8)
                    .withTrainPaths("12345")
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationTrain.Builder.newRegistrationTrain()
                    .withTrainTitle("My Train")
                    .withRailwayOperator(new Operator())
                    .withOperator(new Operator())
                    .withTerminalEta(2018, 5, 14, 11, 0)
                    .withShuntingYardEta(2018, 5, 14, 12, 0)
                    .withShunter("a shunter")
                    .withTotalLength(120.0, LengthUnit.METRE)
                    .withWaggonQuantity(10)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToDischarge(10)
                    .withVolumeToLoad(8)
                    .withTrainPaths("12345")
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationTrain.Builder.newRegistrationTrain()
                    .withTrainTitle("My Train")
                    .withRailwayOperator(new Operator())
                    .withOperator(new Operator())
                    .withTerminalEta(2018, 5, 14, 11, 0)
                    .withTerminalEtd(2018, 5, 14, 13, 0)
                    .withShunter("a shunter")
                    .withTotalLength(120.0, LengthUnit.METRE)
                    .withWaggonQuantity(10)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToDischarge(10)
                    .withVolumeToLoad(8)
                    .withTrainPaths("12345")
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationTrain.Builder.newRegistrationTrain()
                    .withTrainTitle("My Train")
                    .withRailwayOperator(new Operator())
                    .withOperator(new Operator())
                    .withTerminalEta(2018, 5, 14, 11, 0)
                    .withTerminalEtd(2018, 5, 14, 13, 0)
                    .withShuntingYardEta(2018, 5, 14, 12, 0)
                    .withTotalLength(120.0, LengthUnit.METRE)
                    .withWaggonQuantity(10)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToDischarge(10)
                    .withVolumeToLoad(8)
                    .withTrainPaths("12345")
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationTrain.Builder.newRegistrationTrain()
                    .withTrainTitle("My Train")
                    .withRailwayOperator(new Operator())
                    .withOperator(new Operator())
                    .withTerminalEta(2018, 5, 14, 11, 0)
                    .withTerminalEtd(2018, 5, 14, 13, 0)
                    .withShuntingYardEta(2018, 5, 14, 12, 0)
                    .withShunter("a shunter")
                    .withWaggonQuantity(10)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToDischarge(10)
                    .withVolumeToLoad(8)
                    .withTrainPaths("12345")
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationTrain.Builder.newRegistrationTrain()
                    .withTrainTitle("My Train")
                    .withRailwayOperator(new Operator())
                    .withOperator(new Operator())
                    .withTerminalEta(2018, 5, 14, 11, 0)
                    .withTerminalEtd(2018, 5, 14, 13, 0)
                    .withShuntingYardEta(2018, 5, 14, 12, 0)
                    .withShunter("a shunter")
                    .withTotalLength(120.0, LengthUnit.METRE)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToDischarge(10)
                    .withVolumeToLoad(8)
                    .withTrainPaths("12345")
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationTrain.Builder.newRegistrationTrain()
                    .withTrainTitle("My Train")
                    .withRailwayOperator(new Operator())
                    .withOperator(new Operator())
                    .withTerminalEta(2018, 5, 14, 11, 0)
                    .withTerminalEtd(2018, 5, 14, 13, 0)
                    .withShuntingYardEta(2018, 5, 14, 12, 0)
                    .withShunter("a shunter")
                    .withTotalLength(120.0, LengthUnit.METRE)
                    .withWaggonQuantity(10)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToLoad(8)
                    .withTrainPaths("12345")
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationTrain.Builder.newRegistrationTrain()
                    .withTrainTitle("My Train")
                    .withRailwayOperator(new Operator())
                    .withOperator(new Operator())
                    .withTerminalEta(2018, 5, 14, 11, 0)
                    .withTerminalEtd(2018, 5, 14, 13, 0)
                    .withShuntingYardEta(2018, 5, 14, 12, 0)
                    .withShunter("a shunter")
                    .withTotalLength(120.0, LengthUnit.METRE)
                    .withWaggonQuantity(10)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToDischarge(10)
                    .withTrainPaths("12345")
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationTrain.Builder.newRegistrationTrain()
                    .withTrainTitle("My Train")
                    .withRailwayOperator(new Operator())
                    .withOperator(new Operator())
                    .withTerminalEta(2018, 5, 14, 11, 0)
                    .withTerminalEtd(2018, 5, 14, 13, 0)
                    .withShuntingYardEta(2018, 5, 14, 12, 0)
                    .withShunter("a shunter")
                    .withTotalLength(120.0, LengthUnit.METRE)
                    .withWaggonQuantity(10)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToDischarge(10)
                    .withVolumeToLoad(8)
                    .buildAndValidate());
    }


    @Test
    void ensureLengthCanBeSetInFoot() {

        RegistrationTrain registrationTrain = RegistrationTrain.Builder.newRegistrationTrain()
                .withTrainTitle("My Train")
                .withRailwayOperator(new Operator())
                .withOperator(new Operator())
                .withTerminalEta(2018, 5, 14, 11, 0)
                .withTerminalEtd(2018, 5, 14, 13, 0)
                .withShuntingYardEta(2018, 5, 14, 12, 0)
                .withShunter("a shunter")
                .withTotalLength(393.70, LengthUnit.FOOT)
                .withWaggonQuantity(10)
                .withDangerousGoodsIndication(new DangerousGoods())
                .withVolumeToDischarge(10)
                .withVolumeToLoad(8)
                .withTrainPaths("12345")
                .buildAndValidate();

        assertEquals(120, registrationTrain.getTotalLength().getValue().doubleValue(), 0.1);
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        RegistrationTrain registrationTrain = RegistrationTrain.Builder.newRegistrationTrain()
                .withTrainTitle("My Train")
                .withRailwayOperator(new Operator())
                .withOperator(new Operator())
                .withTerminalEta(2018, 5, 14, 11, 0)
                .withTerminalEtd(2018, 5, 14, 13, 0)
                .withShuntingYardEta(2018, 5, 14, 12, 0)
                .withShunter("a shunter")
                .withTotalLength(120.0, LengthUnit.METRE)
                .withWaggonQuantity(10)
                .withDangerousGoodsIndication(new DangerousGoods())
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
        assertEquals("2018-05-14T11:00:00", deserialize.getTerminalEta());
        assertEquals("2018-05-14T13:00:00", deserialize.getTerminalEtd());
        assertEquals("2018-05-14T12:00:00", deserialize.getShuntingYardEta());
        assertEquals("a shunter", deserialize.getShunter());
        assertEquals(120.0, deserialize.getTotalLength().getValue().doubleValue());
        assertEquals(10, deserialize.getWaggonQuantity().intValue());
        assertNotNull(deserialize.getDangerousGoodsIndication());
        assertEquals(10, deserialize.getVolumeToDischarge().intValue());
        assertEquals(8, deserialize.getVolumeToLoad().intValue());
        assertEquals("12345", deserialize.getTrainPaths());
    }
}
