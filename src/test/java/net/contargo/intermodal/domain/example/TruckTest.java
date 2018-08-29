package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.EnvironmentBadge;
import net.contargo.intermodal.domain.MassUnit;
import net.contargo.intermodal.domain.Truck;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class TruckTest {

    @Test
    void ensureCanBeCreated() {

        Truck truck = Truck.newBuilder()
                .withNumberPlate("DU CO 1782")
                .withCountryCode("DE")
                .withMinistryOfTransportTest(Instant.parse("2020-05-22T00:00:00Z"))
                .withEnvironmentBadge(EnvironmentBadge.GREEN)
                .withType("refrigerator truck")
                .withEuAuthorization(true)
                .withST(true)
                .isSuitableForDangerousGoods(false)
                .isSuitableForWaste(false)
                .withWeightTare(40000.0, MassUnit.KILOGRAM)
                .buildAndValidate();

        assertEquals("DU CO 1782", truck.getNumberPlate());
        assertEquals("DE", truck.getCountryCode());
        assertEquals("2020-05-22T00:00:00Z", truck.getMot().toString());
        assertEquals(EnvironmentBadge.GREEN, truck.getEnvironmentBadge());
        assertEquals("refrigerator truck", truck.getType());
        assertTrue(truck.getEuAuthorization());
        assertTrue(truck.getSt());
        assertFalse(truck.getSuitabilityDangerousGoods());
        assertFalse(truck.getSuitabilityWaste());
        assertEquals(40000.0, truck.getWeightTare().getValue().doubleValue());
    }


    @Test
    void ensureCanBeCopied() {

        Truck truck = Truck.newBuilder()
                .withNumberPlate("DU CO 1782")
                .withCountryCode("DE")
                .withMinistryOfTransportTest(Instant.parse("2020-05-22T00:00:00Z"))
                .withEnvironmentBadge(EnvironmentBadge.GREEN)
                .withType("refrigerator truck")
                .withEuAuthorization(true)
                .withST(true)
                .isSuitableForDangerousGoods(false)
                .isSuitableForWaste(false)
                .withWeightTare(40000.0, MassUnit.KILOGRAM)
                .buildAndValidate();

        Truck copiedTruck = Truck.newBuilder(truck).buildAndValidate();

        assertEquals("DU CO 1782", copiedTruck.getNumberPlate());
        assertEquals("DE", copiedTruck.getCountryCode());
        assertEquals("2020-05-22T00:00:00Z", copiedTruck.getMot().toString());
        assertEquals(EnvironmentBadge.GREEN, copiedTruck.getEnvironmentBadge());
        assertEquals("refrigerator truck", copiedTruck.getType());
        assertTrue(copiedTruck.getEuAuthorization());
        assertTrue(copiedTruck.getSt());
        assertFalse(copiedTruck.getSuitabilityDangerousGoods());
        assertFalse(copiedTruck.getSuitabilityWaste());
        assertEquals(40000.0, copiedTruck.getWeightTare().getValue().doubleValue());
    }


    @Test
    void ensureWeightCanBeSetInTons() {

        Truck truck = Truck.newBuilder()
                .withNumberPlate("DU CO 1782")
                .withCountryCode("DE")
                .withMinistryOfTransportTest(Instant.parse("2020-05-22T00:00:00Z"))
                .withEnvironmentBadge(EnvironmentBadge.GREEN)
                .withType("refrigerator truck")
                .withEuAuthorization(true)
                .withST(true)
                .isSuitableForDangerousGoods(false)
                .isSuitableForWaste(false)
                .withWeightTare(40.0, MassUnit.TON)
                .buildAndValidate();

        assertEquals(40000.0, truck.getWeightTare().getValue().doubleValue(), 0.1);
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        Truck truck = Truck.newBuilder()
                .withNumberPlate("DU CO 1782")
                .withCountryCode("DE")
                .withMinistryOfTransportTest(Instant.parse("2020-05-22T00:00:00Z"))
                .withEnvironmentBadge(EnvironmentBadge.GREEN)
                .withType("refrigerator truck")
                .withEuAuthorization(true)
                .withST(true)
                .isSuitableForDangerousGoods(false)
                .isSuitableForWaste(false)
                .withWeightTare(40000.0, MassUnit.KILOGRAM)
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(truck);

        Truck deserialize = mapper.readValue(jsonString, Truck.class);

        assertEquals("DU CO 1782", deserialize.getNumberPlate());
        assertEquals("DE", deserialize.getCountryCode());
        assertEquals("2020-05-22T00:00:00Z", deserialize.getMot().toString());
        assertEquals(EnvironmentBadge.GREEN, deserialize.getEnvironmentBadge());
        assertEquals("refrigerator truck", deserialize.getType());
        assertTrue(deserialize.getEuAuthorization());
        assertTrue(deserialize.getSt());
        assertFalse(deserialize.getSuitabilityDangerousGoods());
        assertFalse(deserialize.getSuitabilityWaste());
        assertEquals(40000.0, deserialize.getWeightTare().getValue().doubleValue());
    }
}
