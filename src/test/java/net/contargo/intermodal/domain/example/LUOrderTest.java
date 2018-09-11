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
        seals.add(Seal.newBuilder().withNumber("01234").withType("some seal type").build());
        seals.add(Seal.newBuilder().withNumber("46789").withType("another seal type").build());

        LUOrder loadingUnitLUOrder = LUOrder.newBuilder()
                .withLoadingUnit(TestDataCreator.createContainer())
                .withReference("1658583")
                .withWeightBrutto(23300.0, MassUnit.KILOGRAM)
                .withWeightNetto(21000.0, MassUnit.KILOGRAM)
                .withWeightTare(2300.0, MassUnit.KILOGRAM)
                .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                .withWasteIndication(TestDataCreator.createWaste())
                .withSetTemperature(-5, TemperatureUnit.CELSIUS)
                .withOperator(TestDataCreator.createOperator())
                .withClient(TestDataCreator.createOperator())
                .withDirection(Direction.EXPORT)
                .withCustoms(TestDataCreator.createCustoms())
                .withGoods("food")
                .isEmpty(false)
                .withSeals(seals)
                .buildAndValidate();

        assertNotNull(loadingUnitLUOrder.getLoadingUnit());
        assertEquals("1658583", loadingUnitLUOrder.getReference());
        assertEquals(23300.0, loadingUnitLUOrder.getWeightBrutto().getValue().doubleValue());
        assertEquals(21000.0, loadingUnitLUOrder.getWeightNetto().getValue().doubleValue());
        assertEquals(2300.0, loadingUnitLUOrder.getWeightTare().getValue().doubleValue());
        assertNotNull(loadingUnitLUOrder.getDangerousGoodsIndication());
        assertNotNull(loadingUnitLUOrder.getWasteIndication());
        assertEquals(-5, loadingUnitLUOrder.getSetTemperature().getValue().doubleValue());
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
    void ensureCanBeCreatedWithAllInformationWithStepBuilder() {

        List<Seal> seals = new ArrayList<>();
        seals.add(Seal.newBuilder().withNumber("01234").withType("some seal type").build());
        seals.add(Seal.newBuilder().withNumber("46789").withType("another seal type").build());

        LUOrder loadingUnitLUOrder = LUOrder.newStepBuilder()
                .withLoadingUnit(TestDataCreator.createContainer())
                .withWeightBrutto(23300.0, MassUnit.KILOGRAM)
                .withWeightNetto(21000.0, MassUnit.KILOGRAM)
                .withWeightTare(2300.0, MassUnit.KILOGRAM)
                .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                .withWasteIndication(TestDataCreator.createWaste())
                .withReference("1658583")
                .withSetTemperature(-5, TemperatureUnit.CELSIUS)
                .withOperator(TestDataCreator.createOperator())
                .withClient(TestDataCreator.createOperator())
                .withDirection(Direction.EXPORT)
                .withCustoms(TestDataCreator.createCustoms())
                .withGoods("food")
                .isEmpty(false)
                .withSeals(seals)
                .buildAndValidate();

        assertNotNull(loadingUnitLUOrder.getLoadingUnit());
        assertEquals("1658583", loadingUnitLUOrder.getReference());
        assertEquals(23300.0, loadingUnitLUOrder.getWeightBrutto().getValue().doubleValue());
        assertEquals(21000.0, loadingUnitLUOrder.getWeightNetto().getValue().doubleValue());
        assertEquals(2300.0, loadingUnitLUOrder.getWeightTare().getValue().doubleValue());
        assertNotNull(loadingUnitLUOrder.getDangerousGoodsIndication());
        assertNotNull(loadingUnitLUOrder.getWasteIndication());
        assertEquals(-5, loadingUnitLUOrder.getSetTemperature().getValue().doubleValue());
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

        LUOrder.newBuilder()
            .withLoadingUnit(TestDataCreator.createContainer())
            .withWeightBrutto(23300.0, MassUnit.KILOGRAM)
            .withWeightNetto(21000.0, MassUnit.KILOGRAM)
            .withWeightTare(2300.0, MassUnit.KILOGRAM)
            .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
            .withWasteIndication(TestDataCreator.createWaste())
            .buildAndValidate();
    }


    @Test
    void ensureCanBeCreatedWithMinimumRequirementsWithStepBuilder() {

        LUOrder.newStepBuilder()
            .withLoadingUnit(TestDataCreator.createContainer())
            .withWeightBrutto(23300.0, MassUnit.KILOGRAM)
            .withWeightNetto(21000.0, MassUnit.KILOGRAM)
            .withWeightTare(2300.0, MassUnit.KILOGRAM)
            .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
            .withWasteIndication(TestDataCreator.createWaste())
            .buildAndValidate();
    }


    @Test
    void ensureCanBeCopied() {

        List<Seal> seals = new ArrayList<>();
        seals.add(Seal.newBuilder().withNumber("01234").withType("some seal type").build());
        seals.add(Seal.newBuilder().withNumber("46789").withType("another seal type").build());

        LUOrder loadingUnitLUOrder = LUOrder.newBuilder()
                .withLoadingUnit(TestDataCreator.createContainer())
                .withReference("1658583")
                .withWeightBrutto(23300.0, MassUnit.KILOGRAM)
                .withWeightNetto(21000.0, MassUnit.KILOGRAM)
                .withWeightTare(2300.0, MassUnit.KILOGRAM)
                .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                .withWasteIndication(TestDataCreator.createWaste())
                .withSetTemperature(-5, TemperatureUnit.CELSIUS)
                .withOperator(TestDataCreator.createOperator())
                .withClient(TestDataCreator.createOperator())
                .withDirection(Direction.EXPORT)
                .withCustoms(TestDataCreator.createCustoms())
                .withGoods("food")
                .isEmpty(false)
                .withSeals(seals)
                .buildAndValidate();

        LUOrder copiedLuOrder = LUOrder.newBuilder(loadingUnitLUOrder).buildAndValidate();

        assertNotNull(copiedLuOrder.getLoadingUnit());
        assertEquals("1658583", copiedLuOrder.getReference());
        assertEquals(23300.0, copiedLuOrder.getWeightBrutto().getValue().doubleValue());
        assertEquals(21000.0, copiedLuOrder.getWeightNetto().getValue().doubleValue());
        assertEquals(2300.0, copiedLuOrder.getWeightTare().getValue().doubleValue());
        assertNotNull(copiedLuOrder.getDangerousGoodsIndication());
        assertNotNull(copiedLuOrder.getWasteIndication());
        assertEquals(-5, copiedLuOrder.getSetTemperature().getValue().doubleValue());
        assertNotNull(copiedLuOrder.getOperator());
        assertNotNull(copiedLuOrder.getClient());
        assertEquals(Direction.EXPORT, copiedLuOrder.getDirection());
        assertNotNull(copiedLuOrder.getCustoms());
        assertEquals("food", copiedLuOrder.getGoods());
        assertFalse(copiedLuOrder.isEmpty());
        assertNotNull(copiedLuOrder.getSeals());
        assertEquals(2, copiedLuOrder.getSeals().size());
        assertEquals("some seal type", copiedLuOrder.getSeals().get(0).getType());
        assertEquals("01234", copiedLuOrder.getSeals().get(0).getNumber());
    }


    @Test
    void ensureWeightCanBeSetInTons() {

        LUOrder luOrder = LUOrder.newBuilder()
                .withLoadingUnit(TestDataCreator.createContainer())
                .withWeightBrutto(23.3, MassUnit.TON)
                .withWeightNetto(21.0, MassUnit.TON)
                .withWeightTare(2.3, MassUnit.TON)
                .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                .withWasteIndication(TestDataCreator.createWaste())
                .buildAndValidate();

        assertEquals(23300.0, luOrder.getWeightBrutto().getValue().doubleValue(), 0.1);
        assertEquals(21000.0, luOrder.getWeightNetto().getValue().doubleValue(), 0.1);
        assertEquals(2300.0, luOrder.getWeightTare().getValue().doubleValue(), 0.1);

        assertEquals("kg", luOrder.getWeightBrutto().getUnit().toString());
        assertEquals("kg", luOrder.getWeightNetto().getUnit().toString());
        assertEquals("kg", luOrder.getWeightTare().getUnit().toString());

        LUOrder luOrderStep = LUOrder.newStepBuilder()
                .withLoadingUnit(TestDataCreator.createContainer())
                .withWeightBrutto(23.3, MassUnit.TON)
                .withWeightNetto(21.0, MassUnit.TON)
                .withWeightTare(2.3, MassUnit.TON)
                .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                .withWasteIndication(TestDataCreator.createWaste())
                .buildAndValidate();

        assertEquals(23300.0, luOrderStep.getWeightBrutto().getValue().doubleValue(), 0.1);
        assertEquals(21000.0, luOrderStep.getWeightNetto().getValue().doubleValue(), 0.1);
        assertEquals(2300.0, luOrderStep.getWeightTare().getValue().doubleValue(), 0.1);

        assertEquals("kg", luOrderStep.getWeightBrutto().getUnit().toString());
        assertEquals("kg", luOrderStep.getWeightNetto().getUnit().toString());
        assertEquals("kg", luOrderStep.getWeightTare().getUnit().toString());
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class,
            () ->
                LUOrder.newBuilder()
                    .withReference("1658583")
                    .withWeightBrutto(23300.0, MassUnit.KILOGRAM)
                    .withWeightNetto(21000.0, MassUnit.KILOGRAM)
                    .withWeightTare(2300.0, MassUnit.KILOGRAM)
                    .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                    .withWasteIndication(TestDataCreator.createWaste())
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                LUOrder.newBuilder()
                    .withLoadingUnit(TestDataCreator.createContainer())
                    .withReference("1658583")
                    .withWeightNetto(21000.0, MassUnit.KILOGRAM)
                    .withWeightTare(2300.0, MassUnit.KILOGRAM)
                    .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                    .withWasteIndication(TestDataCreator.createWaste())
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                LUOrder.newBuilder()
                    .withLoadingUnit(TestDataCreator.createContainer())
                    .withReference("1658583")
                    .withWeightBrutto(23300.0, MassUnit.KILOGRAM)
                    .withWeightTare(2300.0, MassUnit.KILOGRAM)
                    .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                    .withWasteIndication(TestDataCreator.createWaste())
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                LUOrder.newBuilder()
                    .withLoadingUnit(TestDataCreator.createContainer())
                    .withReference("1658583")
                    .withWeightBrutto(23300.0, MassUnit.KILOGRAM)
                    .withWeightNetto(21000.0, MassUnit.KILOGRAM)
                    .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                    .withWasteIndication(TestDataCreator.createWaste())
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                LUOrder.newBuilder()
                    .withLoadingUnit(TestDataCreator.createContainer())
                    .withReference("1658583")
                    .withWeightBrutto(23300.0, MassUnit.KILOGRAM)
                    .withWeightNetto(21000.0, MassUnit.KILOGRAM)
                    .withWeightTare(2300.0, MassUnit.KILOGRAM)
                    .withWasteIndication(TestDataCreator.createWaste())
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                LUOrder.newBuilder()
                    .withLoadingUnit(TestDataCreator.createContainer())
                    .withReference("1658583")
                    .withWeightBrutto(23300.0, MassUnit.KILOGRAM)
                    .withWeightNetto(21000.0, MassUnit.KILOGRAM)
                    .withWeightTare(2300.0, MassUnit.KILOGRAM)
                    .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                    .buildAndValidate());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        List<Seal> seals = new ArrayList<>();
        seals.add(Seal.newBuilder().withNumber("01234").withType("some seal type").build());
        seals.add(Seal.newBuilder().withNumber("46789").withType("another seal type").build());

        LUOrder loadingUnitLUOrder = LUOrder.newBuilder()
                .withLoadingUnit(TestDataCreator.createContainer())
                .withReference("1658583")
                .withWeightBrutto(23300.0, MassUnit.KILOGRAM)
                .withWeightNetto(21000.0, MassUnit.KILOGRAM)
                .withWeightTare(2300.0, MassUnit.KILOGRAM)
                .withDangerousGoodsIndication(TestDataCreator.createDangerousGoods())
                .withWasteIndication(TestDataCreator.createWaste())
                .withSetTemperature(-5, TemperatureUnit.CELSIUS)
                .withOperator(TestDataCreator.createOperator())
                .withClient(TestDataCreator.createOperator())
                .withDirection(Direction.EXPORT)
                .withCustoms(TestDataCreator.createCustoms())
                .withGoods("food")
                .isEmpty(false)
                .withSeals(seals)
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(loadingUnitLUOrder);

        LUOrder deserialize = mapper.readValue(jsonString, LUOrder.class);

        assertNotNull(deserialize.getLoadingUnit());
        assertEquals("1658583", deserialize.getReference());
        assertEquals(23300.0, deserialize.getWeightBrutto().getValue().doubleValue());
        assertEquals(21000.0, deserialize.getWeightNetto().getValue().doubleValue());
        assertEquals(2300.0, deserialize.getWeightTare().getValue().doubleValue());
        assertNotNull(deserialize.getDangerousGoodsIndication());
        assertNotNull(deserialize.getWasteIndication());
        assertEquals(-5, deserialize.getSetTemperature().getValue().doubleValue());
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
    }
}
