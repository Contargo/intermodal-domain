package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.Customs;
import net.contargo.intermodal.domain.DangerousGoods;
import net.contargo.intermodal.domain.Operator;
import net.contargo.intermodal.domain.Waste;
import net.contargo.intermodal.domain.loadingUnit.Container;
import net.contargo.intermodal.domain.loadingUnit.Direction;
import net.contargo.intermodal.domain.loadingUnit.Order;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;

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
                .withClient(new Operator())
                .withClient(new Operator())
                .withDirection(Direction.EXPORT)
                .withCustoms(new Customs())
                .withGoods("motors")
                .isEmpty(false)
                .withSeal(new ArrayList<String>())
                .withSealType("some seal type")
                .withSealNumber("42")
                .build();
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
