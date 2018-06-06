package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Chassis;
import net.contargo.intermodal.domain.LengthUnit;
import net.contargo.intermodal.domain.MassUnit;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class ChassisTest {

    @Test
    void ensureCanBeCreated() {

        Chassis chassis = Chassis.Builder.newChassis()
                .withNumberPlate("DU CO 1782")
                .withMot(2020, 5, 22)
                .withType("Multichassis")
                .withAxles(2)
                .withSize(4.0, LengthUnit.METRE)
                .withHeight(1.0, LengthUnit.METRE)
                .withEuAuthorization(true)
                .withSt(true)
                .withSuitabilityDangerousGoods(true)
                .withSuitabilityWaste(true)
                .withSuitabilityReefer(true)
                .withWeightTare(500.0, MassUnit.KILOGRAM)
                .buildAndValidate();

        assertEquals("DU CO 1782", chassis.getNumberPlate());
        assertEquals("2020-05-22T00:00:00", chassis.getMot());
        assertEquals("Multichassis", chassis.getType());
        assertEquals(2, chassis.getAxles().intValue());
        assertEquals(4.0, chassis.getSize().getValue().doubleValue());
        assertEquals(1.0, chassis.getHeight().getValue().doubleValue());
        assertTrue(chassis.getEuAuthorization());
        assertTrue(chassis.getSt());
        assertTrue(chassis.getSuitabilityDangerousGoods());
        assertTrue(chassis.getSuitabilityWaste());
        assertTrue(chassis.getSuitabilityReefer());
        assertNotNull(chassis.getWeight());
        assertEquals(500.0, chassis.getWeightTare().getValue().doubleValue());
    }


    @Test
    void ensureMeasurementsCanBeSetInFoot() {

        Chassis chassis = Chassis.Builder.newChassis()
                .withMot(2020, 5, 22)
                .withSize(13.12, LengthUnit.FOOT)
                .withHeight(3.28, LengthUnit.FOOT)
                .withWeightTare(0.5, MassUnit.TON)
                .buildAndValidate();

        assertEquals(4.0, chassis.getSize().getValue().doubleValue(), 0.1);
        assertEquals(1.0, chassis.getHeight().getValue().doubleValue(), 0.1);
        assertEquals(1.0, chassis.getWeightTare().getValue().doubleValue(), 500);
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        Chassis chassis = Chassis.Builder.newChassis()
                .withNumberPlate("DU CO 1782")
                .withMot(2020, 5, 22)
                .withType("Multichassis")
                .withAxles(2)
                .withSize(4.0, LengthUnit.METRE)
                .withHeight(1.0, LengthUnit.METRE)
                .withEuAuthorization(true)
                .withSt(true)
                .withSuitabilityDangerousGoods(true)
                .withSuitabilityWaste(true)
                .withSuitabilityReefer(true)
                .withWeightTare(500.0, MassUnit.KILOGRAM)
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(chassis);

        Chassis deserialize = mapper.readValue(jsonString, Chassis.class);

        assertEquals("DU CO 1782", chassis.getNumberPlate());
        assertEquals("2020-05-22T00:00:00", chassis.getMot());
        assertEquals("Multichassis", chassis.getType());
        assertEquals(2, chassis.getAxles().intValue());
        assertEquals(4.0, chassis.getSize().getValue().doubleValue());
        assertEquals(1.0, chassis.getHeight().getValue().doubleValue());
        assertTrue(chassis.getEuAuthorization());
        assertTrue(chassis.getSt());
        assertTrue(chassis.getSuitabilityDangerousGoods());
        assertTrue(chassis.getSuitabilityWaste());
        assertTrue(chassis.getSuitabilityReefer());
        assertNotNull(chassis.getWeight());
        assertEquals(500.0, chassis.getWeightTare().getValue().doubleValue());
    }
}
