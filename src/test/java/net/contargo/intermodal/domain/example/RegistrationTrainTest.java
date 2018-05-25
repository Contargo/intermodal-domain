package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.DangerousGoods;
import net.contargo.intermodal.domain.Operator;
import net.contargo.intermodal.domain.RegistrationTrain;

import org.junit.jupiter.api.Test;

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
                .withTotalLength(120.0)
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
        assertEquals(120.0, registrationTrain.getTotalLength().doubleValue());
        assertEquals(10, registrationTrain.getWaggonQuantity().intValue());
        assertNotNull(registrationTrain.getDangerousGoodsIndication());
        assertEquals(10, registrationTrain.getVolumeToDischarge().intValue());
        assertEquals(8, registrationTrain.getVolumeToLoad().intValue());
        assertEquals("12345", registrationTrain.getTrainPaths());
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
                    .withTotalLength(120.0)
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
                    .withTotalLength(120.0)
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
                    .withTotalLength(120.0)
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
                    .withTotalLength(120.0)
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
                    .withTotalLength(120.0)
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
                    .withTotalLength(120.0)
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
                    .withTotalLength(120.0)
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
                    .withTotalLength(120.0)
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
                    .withTotalLength(120.0)
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
                    .withTotalLength(120.0)
                    .withWaggonQuantity(10)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToDischarge(10)
                    .withVolumeToLoad(8)
                    .buildAndValidate());
    }
}
