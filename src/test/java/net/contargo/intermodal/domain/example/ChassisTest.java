package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Chassis;
import net.contargo.intermodal.domain.LengthUnit;
import net.contargo.intermodal.domain.MassUnit;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.time.Instant;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class ChassisTest {

    @Test
    void ensureCanBeCreated() {

        Chassis chassis = Chassis.newBuilder()
                .withNumberPlate("DU CO 1782")
                .withMot(Instant.parse("2020-05-22T00:00:00Z"))
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
        assertEquals("2020-05-22T00:00:00Z", chassis.getMot().toString());
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
    void ensureCanBeCopied() {

        Chassis chassis = Chassis.newBuilder()
                .withNumberPlate("DU CO 1782")
                .withMot(Instant.parse("2020-05-22T00:00:00Z"))
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

        Chassis copiedChassis = Chassis.newBuilder(chassis).buildAndValidate();

        assertEquals("DU CO 1782", copiedChassis.getNumberPlate());
        assertEquals("2020-05-22T00:00:00Z", copiedChassis.getMot().toString());
        assertEquals("Multichassis", copiedChassis.getType());
        assertEquals(2, copiedChassis.getAxles().intValue());
        assertEquals(4.0, copiedChassis.getSize().getValue().doubleValue());
        assertEquals(1.0, copiedChassis.getHeight().getValue().doubleValue());
        assertTrue(copiedChassis.getEuAuthorization());
        assertTrue(copiedChassis.getSt());
        assertTrue(copiedChassis.getSuitabilityDangerousGoods());
        assertTrue(copiedChassis.getSuitabilityWaste());
        assertTrue(copiedChassis.getSuitabilityReefer());
        assertNotNull(copiedChassis.getWeight());
        assertEquals(500.0, copiedChassis.getWeightTare().getValue().doubleValue());
    }


    @Test
    void ensureMeasurementsCanBeSetInFoot() {

        Chassis chassis = Chassis.newBuilder()
                .withMot(Instant.parse("2020-05-22T00:00:00Z"))
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

        Chassis chassis = Chassis.newBuilder()
                .withNumberPlate("DU CO 1782")
                .withMot(Instant.parse("2020-05-22T00:00:00Z"))
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

        assertEquals("DU CO 1782", deserialize.getNumberPlate());
        assertEquals("2020-05-22T00:00:00Z", deserialize.getMot().toString());
        assertEquals("Multichassis", deserialize.getType());
        assertEquals(2, deserialize.getAxles().intValue());
        assertEquals(4.0, deserialize.getSize().getValue().doubleValue());
        assertEquals(1.0, deserialize.getHeight().getValue().doubleValue());
        assertTrue(deserialize.getEuAuthorization());
        assertTrue(deserialize.getSt());
        assertTrue(deserialize.getSuitabilityDangerousGoods());
        assertTrue(deserialize.getSuitabilityWaste());
        assertTrue(deserialize.getSuitabilityReefer());
        assertNotNull(deserialize.getWeight());
        assertEquals(500.0, deserialize.getWeightTare().getValue().doubleValue());
    }
}
