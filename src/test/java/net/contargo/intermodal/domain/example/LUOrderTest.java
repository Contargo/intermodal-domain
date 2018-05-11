package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.Customs;
import net.contargo.intermodal.domain.DangerousGoods;
import net.contargo.intermodal.domain.Direction;
import net.contargo.intermodal.domain.LUOrder;
import net.contargo.intermodal.domain.Operator;
import net.contargo.intermodal.domain.Waste;
import net.contargo.intermodal.domain.loadingUnit.Container;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class LUOrderTest {

    @Test
    void ensureCanBeCreated() {

        LUOrder loadingUnitLUOrder = LUOrder.Builder.newOrder()
                .withLoadingUnit(new Container())
                .withReference("1658583")
                .withWeightBrutto(16.0)
                .withWeightNetto(14.0)
                .withWeightTara(16.0)
                .withDangerousGoodsIndication(new DangerousGoods())
                .withWasteIndication(new Waste())
                .withSetTemperature(32)
                .withOperator(new Operator())
                .withClient(new Operator())
                .withDirection(Direction.EXPORT)
                .withCustoms(new Customs())
                .withGoods("food")
                .isEmpty(false)
                .withSeal(new ArrayList<String>())
                .withSealType("some seal type")
                .withSealNumber("42")
                .build();

        assertNotNull(loadingUnitLUOrder.getLoadingUnit());
        assertEquals("1658583", loadingUnitLUOrder.getReference());
        assertEquals(16, loadingUnitLUOrder.getWeightBrutto().doubleValue());
        assertEquals(14, loadingUnitLUOrder.getWeightNetto().doubleValue());
        assertEquals(16, loadingUnitLUOrder.getWeightTara().doubleValue());
        assertNotNull(loadingUnitLUOrder.getDangerousGoodsIndication());
        assertNotNull(loadingUnitLUOrder.getWasteIndication());
        assertEquals(32, loadingUnitLUOrder.getSetTemperature().doubleValue());
        assertNotNull(loadingUnitLUOrder.getOperator());
        assertNotNull(loadingUnitLUOrder.getClient());
        assertEquals(Direction.EXPORT, loadingUnitLUOrder.getDirection());
        assertNotNull(loadingUnitLUOrder.getCustoms());
        assertEquals("food", loadingUnitLUOrder.getGoods());
        assertFalse(loadingUnitLUOrder.isEmpty());
        assertNotNull(loadingUnitLUOrder.getSeal());
        assertEquals("some seal type", loadingUnitLUOrder.getSealType());
        assertEquals("42", loadingUnitLUOrder.getSealNumber());
    }


    @Test
    void ensureMissingMandatoryInformationIsDetected() {

        assertThrows(IllegalStateException.class,
            () -> {
                LUOrder.Builder.newOrder()
                    .withReference("1658583")
                    .withWeightBrutto(16.0)
                    .withWeightNetto(14.0)
                    .withWeightTara(16.0)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withWasteIndication(new Waste())
                    .withSetTemperature(32)
                    .withOperator(new Operator())
                    .withClient(new Operator())
                    .withDirection(Direction.EXPORT)
                    .withCustoms(new Customs())
                    .withGoods("food")
                    .isEmpty(false)
                    .withSeal(new ArrayList<String>())
                    .withSealType("some seal type")
                    .withSealNumber("42")
                    .buildAndValidate();
            });

        assertThrows(IllegalStateException.class,
            () -> {
                LUOrder.Builder.newOrder()
                    .withLoadingUnit(new Container())
                    .withReference("1658583")
                    .withWeightNetto(14.0)
                    .withWeightTara(16.0)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withWasteIndication(new Waste())
                    .withSetTemperature(32)
                    .withOperator(new Operator())
                    .withClient(new Operator())
                    .withDirection(Direction.EXPORT)
                    .withCustoms(new Customs())
                    .withGoods("food")
                    .isEmpty(false)
                    .withSeal(new ArrayList<String>())
                    .withSealType("some seal type")
                    .withSealNumber("42")
                    .buildAndValidate();
            });
        assertThrows(IllegalStateException.class,
            () -> {
                LUOrder.Builder.newOrder()
                    .withLoadingUnit(new Container())
                    .withReference("1658583")
                    .withWeightBrutto(16.0)
                    .withWeightTara(16.0)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withWasteIndication(new Waste())
                    .withSetTemperature(32)
                    .withOperator(new Operator())
                    .withClient(new Operator())
                    .withDirection(Direction.EXPORT)
                    .withCustoms(new Customs())
                    .withGoods("food")
                    .isEmpty(false)
                    .withSeal(new ArrayList<String>())
                    .withSealType("some seal type")
                    .withSealNumber("42")
                    .buildAndValidate();
            });
        assertThrows(IllegalStateException.class,
            () -> {
                LUOrder.Builder.newOrder()
                    .withLoadingUnit(new Container())
                    .withReference("1658583")
                    .withWeightBrutto(16.0)
                    .withWeightNetto(14.0)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withWasteIndication(new Waste())
                    .withSetTemperature(32)
                    .withOperator(new Operator())
                    .withClient(new Operator())
                    .withDirection(Direction.EXPORT)
                    .withCustoms(new Customs())
                    .withGoods("food")
                    .isEmpty(false)
                    .withSeal(new ArrayList<String>())
                    .withSealType("some seal type")
                    .withSealNumber("42")
                    .buildAndValidate();
            });
        assertThrows(IllegalStateException.class,
            () -> {
                LUOrder.Builder.newOrder()
                    .withLoadingUnit(new Container())
                    .withReference("1658583")
                    .withWeightBrutto(16.0)
                    .withWeightNetto(14.0)
                    .withWeightTara(16.0)
                    .withWasteIndication(new Waste())
                    .withSetTemperature(32)
                    .withOperator(new Operator())
                    .withClient(new Operator())
                    .withDirection(Direction.EXPORT)
                    .withCustoms(new Customs())
                    .withGoods("food")
                    .isEmpty(false)
                    .withSeal(new ArrayList<String>())
                    .withSealType("some seal type")
                    .withSealNumber("42")
                    .buildAndValidate();
            });
        assertThrows(IllegalStateException.class,
            () -> {
                LUOrder.Builder.newOrder()
                    .withLoadingUnit(new Container())
                    .withReference("1658583")
                    .withWeightBrutto(16.0)
                    .withWeightNetto(14.0)
                    .withWeightTara(16.0)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withSetTemperature(32)
                    .withOperator(new Operator())
                    .withClient(new Operator())
                    .withDirection(Direction.EXPORT)
                    .withCustoms(new Customs())
                    .withGoods("food")
                    .isEmpty(false)
                    .withSeal(new ArrayList<String>())
                    .withSealType("some seal type")
                    .withSealNumber("42")
                    .buildAndValidate();
            });
    }
}
