package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Container;
import net.contargo.intermodal.domain.EnvironmentBadge;
import net.contargo.intermodal.domain.MassUnit;
import net.contargo.intermodal.domain.Truck;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class TruckTest {

    @Test
    void ensureCanBeCreated() {

        Truck truck = Truck.Builder.newTruck()
                .withNumberPlate("DU CO 1782")
                .withCountryCode("DE")
                .withMot(2020, 5, 22)
                .withEnvironmentBadge(EnvironmentBadge.GREEN)
                .withType("refrigerator truck")
                .withEuAuthorization(true)
                .withST(true)
                .withSuitabilityDangerousGoods(false)
                .withSuitabilityWaste(false)
                .withWeightTara(40000.0, MassUnit.KILOGRAM)
                .buildAndValidate();

        assertEquals("DU CO 1782", truck.getNumberPlate());
        assertEquals("DE", truck.getCountryCode());
        assertEquals("2020-05-22T00:00:00", truck.getMot());
        assertEquals(EnvironmentBadge.GREEN, truck.getEnvironmentBadge());
        assertEquals("refrigerator truck", truck.getType());
        assertTrue(truck.getEuAuthorization());
        assertTrue(truck.getSt());
        assertFalse(truck.getSuitabilityDangerousGoods());
        assertFalse(truck.getSuitabilityWaste());
        assertEquals(40000.0, truck.getWeightTara().getValue().doubleValue());
    }


    @Test
    void ensureWeightCanBeSetInTon() {

        Truck truck = Truck.Builder.newTruck()
                .withNumberPlate("DU CO 1782")
                .withCountryCode("DE")
                .withMot(2020, 5, 22)
                .withEnvironmentBadge(EnvironmentBadge.GREEN)
                .withType("refrigerator truck")
                .withEuAuthorization(true)
                .withST(true)
                .withSuitabilityDangerousGoods(false)
                .withSuitabilityWaste(false)
                .withWeightTara(40.0, MassUnit.TON)
                .buildAndValidate();

        assertEquals(40000.0, truck.getWeightTara().getValue().doubleValue(), 0.1);
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        Truck truck = Truck.Builder.newTruck()
                .withNumberPlate("DU CO 1782")
                .withCountryCode("DE")
                .withMot(2020, 5, 22)
                .withEnvironmentBadge(EnvironmentBadge.GREEN)
                .withType("refrigerator truck")
                .withEuAuthorization(true)
                .withST(true)
                .withSuitabilityDangerousGoods(false)
                .withSuitabilityWaste(false)
                .withWeightTara(40000.0, MassUnit.KILOGRAM)
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(truck);

        Truck deserialize = mapper.readValue(jsonString, Truck.class);

        assertEquals("DU CO 1782", deserialize.getNumberPlate());
        assertEquals("DE", deserialize.getCountryCode());
        assertEquals("2020-05-22T00:00:00", deserialize.getMot());
        assertEquals(EnvironmentBadge.GREEN, deserialize.getEnvironmentBadge());
        assertEquals("refrigerator truck", deserialize.getType());
        assertTrue(deserialize.getEuAuthorization());
        assertTrue(deserialize.getSt());
        assertFalse(deserialize.getSuitabilityDangerousGoods());
        assertFalse(deserialize.getSuitabilityWaste());
        assertEquals(40000.0, deserialize.getWeightTara().getValue().doubleValue());
    }
}
