package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class LUOrderTest {

    @Test
    void ensureCanBeCreatedWithAllInformation() {

        List<Seal> seals = new ArrayList<>();
        seals.add(Seal.Builder.newSeal().withNumber("01234").withType("some seal type").build());
        seals.add(Seal.Builder.newSeal().withNumber("46789").withType("another seal type").build());

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
                .withSeals(seals)
                .buildAndValidate();

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
        assertNotNull(loadingUnitLUOrder.getSeals());
        assertEquals(2, loadingUnitLUOrder.getSeals().size());
        assertEquals("some seal type", loadingUnitLUOrder.getSeals().get(0).getType());
        assertEquals("01234", loadingUnitLUOrder.getSeals().get(0).getNumber());
    }


    @Test
    void ensureCanBeCreatedWithMinimumRequirements() {

        LUOrder.Builder.newOrder()
            .withLoadingUnit(new Container())
            .withWeightBrutto(16.0)
            .withWeightNetto(14.0)
            .withWeightTara(16.0)
            .withDangerousGoodsIndication(new DangerousGoods())
            .withWasteIndication(new Waste())
            .buildAndValidate();
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class,
            () ->
                LUOrder.Builder.newOrder()
                    .withReference("1658583")
                    .withWeightBrutto(16.0)
                    .withWeightNetto(14.0)
                    .withWeightTara(16.0)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withWasteIndication(new Waste())
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                LUOrder.Builder.newOrder()
                    .withLoadingUnit(new Container())
                    .withReference("1658583")
                    .withWeightNetto(14.0)
                    .withWeightTara(16.0)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withWasteIndication(new Waste())
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                LUOrder.Builder.newOrder()
                    .withLoadingUnit(new Container())
                    .withReference("1658583")
                    .withWeightBrutto(16.0)
                    .withWeightTara(16.0)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withWasteIndication(new Waste())
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                LUOrder.Builder.newOrder()
                    .withLoadingUnit(new Container())
                    .withReference("1658583")
                    .withWeightBrutto(16.0)
                    .withWeightNetto(14.0)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withWasteIndication(new Waste())
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                LUOrder.Builder.newOrder()
                    .withLoadingUnit(new Container())
                    .withReference("1658583")
                    .withWeightBrutto(16.0)
                    .withWeightNetto(14.0)
                    .withWeightTara(16.0)
                    .withWasteIndication(new Waste())
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                LUOrder.Builder.newOrder()
                    .withLoadingUnit(new Container())
                    .withReference("1658583")
                    .withWeightBrutto(16.0)
                    .withWeightNetto(14.0)
                    .withWeightTara(16.0)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .buildAndValidate());
    }
}
