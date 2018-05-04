package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.Customs;
import net.contargo.intermodal.domain.DangerousGoods;
import net.contargo.intermodal.domain.Operator;
import net.contargo.intermodal.domain.Waste;
import net.contargo.intermodal.domain.loadingUnit.Container;
import net.contargo.intermodal.domain.loadingUnit.Direction;
import net.contargo.intermodal.domain.loadingUnit.Order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class OrderTest {

    @Test
    void ensureOrderCanBeCreated() {

        Order loadingUnitOrder = Order.newBuilder()
                .withLoadingUnit(new Container())
                .withReference("1658583")
                .withWeightBrutto(16)
                .withWeightNetto(14)
                .withWeightTara(16)
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

        Assertions.assertNotNull(loadingUnitOrder.getLoadingUnit());
        Assertions.assertEquals("1658583", loadingUnitOrder.getReference());
        Assertions.assertEquals(16, loadingUnitOrder.getWeightBrutto().doubleValue());
        Assertions.assertEquals(14, loadingUnitOrder.getWeightNetto().doubleValue());
        Assertions.assertEquals(16, loadingUnitOrder.getWeightTara().doubleValue());
        Assertions.assertNotNull(loadingUnitOrder.getDangerousGoodsIndication());
        Assertions.assertNotNull(loadingUnitOrder.getWasteIndication());
        Assertions.assertEquals(32, loadingUnitOrder.getSetTemperature().doubleValue());
        Assertions.assertNotNull(loadingUnitOrder.getOperator());
        Assertions.assertNotNull(loadingUnitOrder.getClient());
        Assertions.assertEquals(Direction.EXPORT, loadingUnitOrder.getDirection());
        Assertions.assertNotNull(loadingUnitOrder.getCustoms());
        Assertions.assertEquals("food", loadingUnitOrder.getGoods());
        Assertions.assertFalse(loadingUnitOrder.isEmpty());
        Assertions.assertNotNull(loadingUnitOrder.getSeal());
        Assertions.assertEquals("some seal type", loadingUnitOrder.getSealType());
        Assertions.assertEquals("42", loadingUnitOrder.getSealNumber());
    }


    @Test
    void ensureMissingMandatoryInformationIsDetected() {

        assertThrows(IllegalStateException.class,
            () -> {
                Order.newBuilder()
                    .withWeightBrutto(16)
                    .withWeightNetto(14)
                    .withWeightTara(16)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withWasteIndication(new Waste())
                    .build();
            });

        assertThrows(IllegalStateException.class,
            () -> {
                Order.newBuilder()
                    .withLoadingUnit(new Container())
                    .withWeightNetto(14)
                    .withWeightTara(16)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withWasteIndication(new Waste())
                    .build();
            });
        assertThrows(IllegalStateException.class,
            () -> {
                Order.newBuilder()
                    .withLoadingUnit(new Container())
                    .withWeightBrutto(16)
                    .withWeightTara(16)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withWasteIndication(new Waste())
                    .build();
            });
        assertThrows(IllegalStateException.class,
            () -> {
                Order.newBuilder()
                    .withLoadingUnit(new Container())
                    .withWeightBrutto(16)
                    .withWeightNetto(14)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withWasteIndication(new Waste())
                    .build();
            });
        assertThrows(IllegalStateException.class,
            () -> {
                Order.newBuilder()
                    .withLoadingUnit(new Container())
                    .withWeightBrutto(16)
                    .withWeightNetto(14)
                    .withWeightTara(16)
                    .withWasteIndication(new Waste())
                    .build();
            });
        assertThrows(IllegalStateException.class,
            () -> {
                Order.newBuilder()
                    .withLoadingUnit(new Container())
                    .withWeightBrutto(16)
                    .withWeightNetto(14)
                    .withWeightTara(16)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .build();
            });
    }
}
