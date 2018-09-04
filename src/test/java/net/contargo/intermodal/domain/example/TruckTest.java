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
                .withSafetyTest(true)
                .isSuitableForDangerousGoods(false)
                .isSuitableForWaste(false)
                .withWeightTare(40000.0, MassUnit.KILOGRAM)
                .buildAndValidate();

        assertEquals("DU CO 1782", truck.getNumberPlate());
        assertEquals("DE", truck.getCountryCode());
        assertEquals("2020-05-22T00:00:00Z", truck.getMinistryOfTransportTest().toString());
        assertEquals(EnvironmentBadge.GREEN, truck.getEnvironmentBadge());
        assertEquals("refrigerator truck", truck.getType());
        assertTrue(truck.getEuAuthorization());
        assertTrue(truck.getSafetyTest());
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
                .withSafetyTest(true)
                .isSuitableForDangerousGoods(false)
                .isSuitableForWaste(false)
                .withWeightTare(40000.0, MassUnit.KILOGRAM)
                .buildAndValidate();

        Truck copiedTruck = Truck.newBuilder(truck).buildAndValidate();

        assertEquals("DU CO 1782", copiedTruck.getNumberPlate());
        assertEquals("DE", copiedTruck.getCountryCode());
        assertEquals("2020-05-22T00:00:00Z", copiedTruck.getMinistryOfTransportTest().toString());
        assertEquals(EnvironmentBadge.GREEN, copiedTruck.getEnvironmentBadge());
        assertEquals("refrigerator truck", copiedTruck.getType());
        assertTrue(copiedTruck.getEuAuthorization());
        assertTrue(copiedTruck.getSafetyTest());
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
                .withSafetyTest(true)
                .isSuitableForDangerousGoods(false)
                .isSuitableForWaste(false)
                .withWeightTare(40.0, MassUnit.TON)
                .buildAndValidate();

        assertEquals(40000.0, truck.getWeightTare().getValue().doubleValue(), 0.1);
        assertEquals("kg", truck.getWeightTare().getUnit().toString());
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
                .withSafetyTest(true)
                .isSuitableForDangerousGoods(false)
                .isSuitableForWaste(false)
                .withWeightTare(40000.0, MassUnit.KILOGRAM)
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(truck);

        Truck deserialize = mapper.readValue(jsonString, Truck.class);

        assertEquals("DU CO 1782", deserialize.getNumberPlate());
        assertEquals("DE", deserialize.getCountryCode());
        assertEquals("2020-05-22T00:00:00Z", deserialize.getMinistryOfTransportTest().toString());
        assertEquals(EnvironmentBadge.GREEN, deserialize.getEnvironmentBadge());
        assertEquals("refrigerator truck", deserialize.getType());
        assertTrue(deserialize.getEuAuthorization());
        assertTrue(deserialize.getSafetyTest());
        assertFalse(deserialize.getSuitabilityDangerousGoods());
        assertFalse(deserialize.getSuitabilityWaste());
        assertEquals(40000.0, deserialize.getWeightTare().getValue().doubleValue());
    }
}
