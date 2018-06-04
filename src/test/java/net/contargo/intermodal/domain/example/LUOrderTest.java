package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;

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
                .withWeightBrutto(16.0, MassUnit.KILOGRAM)
                .withWeightNetto(14.0, MassUnit.KILOGRAM)
                .withWeightTara(16.0, MassUnit.KILOGRAM)
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
        assertEquals(16, loadingUnitLUOrder.getWeightBrutto().getValue().doubleValue());
        assertEquals(14, loadingUnitLUOrder.getWeightNetto().getValue().doubleValue());
        assertEquals(16, loadingUnitLUOrder.getWeightTara().getValue().doubleValue());
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
            .withWeightBrutto(30480.0, MassUnit.KILOGRAM)
            .withWeightNetto(28080.0, MassUnit.KILOGRAM)
            .withWeightTara(2400.0, MassUnit.KILOGRAM)
            .withDangerousGoodsIndication(new DangerousGoods())
            .withWasteIndication(new Waste())
            .buildAndValidate();
    }


    @Test
    void ensureWeightCanBeSetInTon() {

        LUOrder luOrder = LUOrder.Builder.newOrder()
                .withLoadingUnit(new Container())
                .withWeightBrutto(30.48, MassUnit.TON)
                .withWeightNetto(28.08, MassUnit.TON)
                .withWeightTara(2.4, MassUnit.TON)
                .withDangerousGoodsIndication(new DangerousGoods())
                .withWasteIndication(new Waste())
                .buildAndValidate();

        assertEquals(30480.0, luOrder.getWeightBrutto().getValue().doubleValue(), 0.1);
        assertEquals(28080.0, luOrder.getWeightNetto().getValue().doubleValue(), 0.1);
        assertEquals(2400.0, luOrder.getWeightTara().getValue().doubleValue(), 0.1);
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class,
            () ->
                LUOrder.Builder.newOrder()
                    .withReference("1658583")
                    .withWeightBrutto(30480.0, MassUnit.KILOGRAM)
                    .withWeightNetto(28080.0, MassUnit.KILOGRAM)
                    .withWeightTara(2400.0, MassUnit.KILOGRAM)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withWasteIndication(new Waste())
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                LUOrder.Builder.newOrder()
                    .withLoadingUnit(new Container())
                    .withReference("1658583")
                    .withWeightNetto(28080.0, MassUnit.KILOGRAM)
                    .withWeightTara(2400.0, MassUnit.KILOGRAM)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withWasteIndication(new Waste())
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                LUOrder.Builder.newOrder()
                    .withLoadingUnit(new Container())
                    .withReference("1658583")
                    .withWeightBrutto(30480.0, MassUnit.KILOGRAM)
                    .withWeightTara(2400.0, MassUnit.KILOGRAM)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withWasteIndication(new Waste())
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                LUOrder.Builder.newOrder()
                    .withLoadingUnit(new Container())
                    .withReference("1658583")
                    .withWeightBrutto(30480.0, MassUnit.KILOGRAM)
                    .withWeightNetto(28080.0, MassUnit.KILOGRAM)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withWasteIndication(new Waste())
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                LUOrder.Builder.newOrder()
                    .withLoadingUnit(new Container())
                    .withReference("1658583")
                    .withWeightBrutto(30480.0, MassUnit.KILOGRAM)
                    .withWeightNetto(28080.0, MassUnit.KILOGRAM)
                    .withWeightTara(2400.0, MassUnit.KILOGRAM)
                    .withWasteIndication(new Waste())
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                LUOrder.Builder.newOrder()
                    .withLoadingUnit(new Container())
                    .withReference("1658583")
                    .withWeightBrutto(30480.0, MassUnit.KILOGRAM)
                    .withWeightNetto(28080.0, MassUnit.KILOGRAM)
                    .withWeightTara(2400.0, MassUnit.KILOGRAM)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .buildAndValidate());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        List<Seal> seals = new ArrayList<>();
        seals.add(Seal.Builder.newSeal().withNumber("01234").withType("some seal type").build());
        seals.add(Seal.Builder.newSeal().withNumber("46789").withType("another seal type").build());

        LUOrder loadingUnitLUOrder = LUOrder.Builder.newOrder()
                .withLoadingUnit(new Container())
                .withReference("1658583")
                .withWeightBrutto(16.0, MassUnit.KILOGRAM)
                .withWeightNetto(14.0, MassUnit.KILOGRAM)
                .withWeightTara(16.0, MassUnit.KILOGRAM)
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

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(loadingUnitLUOrder);

        LUOrder deserialize = mapper.readValue(jsonString, LUOrder.class);

        assertNotNull(deserialize.getLoadingUnit());
        assertEquals("1658583", deserialize.getReference());
        assertEquals(16, deserialize.getWeightBrutto().getValue().doubleValue());
        assertEquals(14, deserialize.getWeightNetto().getValue().doubleValue());
        assertEquals(16, deserialize.getWeightTara().getValue().doubleValue());
        assertNotNull(deserialize.getDangerousGoodsIndication());
        assertNotNull(deserialize.getWasteIndication());
        assertEquals(32, deserialize.getSetTemperature().doubleValue());
        assertNotNull(deserialize.getOperator());
        assertNotNull(deserialize.getClient());
        assertEquals(Direction.EXPORT, deserialize.getDirection());
        assertNotNull(deserialize.getCustoms());
        assertEquals("food", deserialize.getGoods());
        assertFalse(deserialize.isEmpty());
        assertNotNull(deserialize.getSeals());
        assertEquals(2, deserialize.getSeals().size());
        assertEquals("some seal type", deserialize.getSeals().get(0).getType());
        assertEquals("01234", deserialize.getSeals().get(0).getNumber());

        System.out.print(loadingUnitLUOrder.toString());
    }
}
