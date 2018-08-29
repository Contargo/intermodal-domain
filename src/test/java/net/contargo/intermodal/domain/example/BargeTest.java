package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Barge;
import net.contargo.intermodal.domain.Operator;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static net.contargo.intermodal.domain.LengthUnit.FOOT;
import static net.contargo.intermodal.domain.LengthUnit.METRE;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class BargeTest {

    @Test
    void ensureCanBeCreated() {

        Barge barge = Barge.newBuilder()
                .withName("My Barge")
                .withMmsi("021112345")
                .withEni("050XXXXX")
                .withOperator(new Operator())
                .withLength(91.4, METRE)
                .withWidth(27.4, METRE)
                .withDraught(5.5, METRE)
                .withNumberOfBays(4)
                .withNumberOfRows(8)
                .withNumberOfTiers(2)
                .isSuitableForDangerousGoods(true)
                .withCapacityInTeu(200.0)
                .withCapacityInTons(3400.0)
                .buildAndValidate();

        assertEquals("My Barge", barge.getName());
        assertEquals("021112345", barge.getMmsi());
        assertEquals("050XXXXX", barge.getEni());
        assertNotNull(barge.getOperator());
        assertEquals(91.4, barge.getLengthValue().doubleValue());
        assertEquals(27.4, barge.getWidthValue().doubleValue());
        assertEquals(5.5, barge.getDraughtValue().doubleValue());
        assertEquals(4, barge.getBays().intValue());
        assertEquals(8, barge.getRows().intValue());
        assertEquals(2, barge.getTiers().intValue());
        assertTrue(barge.getSuitabilityDangerousGoods());
        assertEquals(200.0, barge.getCapacityTeu().doubleValue());
        assertEquals(3400.0, barge.getCapacityTons().doubleValue());
    }


    @Test
    void ensureCanBeCopied() {

        Barge barge = Barge.newBuilder()
                .withName("My Barge")
                .withMmsi("021112345")
                .withEni("050XXXXX")
                .withOperator(new Operator())
                .withLength(91.4, METRE)
                .withWidth(27.4, METRE)
                .withDraught(5.5, METRE)
                .withNumberOfBays(4)
                .withNumberOfRows(8)
                .withNumberOfTiers(2)
                .isSuitableForDangerousGoods(true)
                .withCapacityInTeu(200.0)
                .withCapacityInTons(3400.0)
                .buildAndValidate();

        Barge copiedBarge = Barge.newBuilder(barge).buildAndValidate();

        assertEquals("My Barge", copiedBarge.getName());
        assertEquals("021112345", copiedBarge.getMmsi());
        assertEquals("050XXXXX", copiedBarge.getEni());
        assertNotNull(copiedBarge.getOperator());
        assertEquals(91.4, copiedBarge.getLengthValue().doubleValue());
        assertEquals(27.4, copiedBarge.getWidthValue().doubleValue());
        assertEquals(5.5, copiedBarge.getDraughtValue().doubleValue());
        assertEquals(4, copiedBarge.getBays().intValue());
        assertEquals(8, copiedBarge.getRows().intValue());
        assertEquals(2, copiedBarge.getTiers().intValue());
        assertTrue(copiedBarge.getSuitabilityDangerousGoods());
        assertEquals(200.0, copiedBarge.getCapacityTeu().doubleValue());
        assertEquals(3400.0, copiedBarge.getCapacityTons().doubleValue());
    }


    @Test
    void ensureMeasurementsCanBeSetInFoot() {

        Barge barge = Barge.newBuilder()
                .withLength(300.0, FOOT)
                .withWidth(90.0, FOOT)
                .withDraught(18.0, FOOT)
                .buildAndValidate();

        assertEquals(91.4, barge.getLengthValue(), 0.1);
        assertEquals(27.4, barge.getWidthValue(), 0.1);
        assertEquals(5.5, barge.getDraughtValue(), 0.1);

        assertEquals("m", barge.getLength().getUnit().toString());
        assertEquals("m", barge.getWidth().getUnit().toString());
        assertEquals("m", barge.getDraught().getUnit().toString());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        Barge barge = Barge.newBuilder()
                .withName("My Barge")
                .withMmsi("021112345")
                .withEni("050XXXXX")
                .withOperator(new Operator())
                .withLength(91.4, METRE)
                .withWidth(27.4, METRE)
                .withDraught(5.5, METRE)
                .withNumberOfBays(4)
                .withNumberOfRows(8)
                .withNumberOfTiers(2)
                .isSuitableForDangerousGoods(true)
                .withCapacityInTeu(200.0)
                .withCapacityInTons(3400.0)
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(barge);

        Barge deserialize = mapper.readValue(jsonString, Barge.class);

        assertEquals("My Barge", deserialize.getName());
        assertEquals("021112345", deserialize.getMmsi());
        assertEquals("050XXXXX", deserialize.getEni());
        assertNotNull(deserialize.getOperator());
        assertEquals(91.4, deserialize.getLengthValue().doubleValue());
        assertEquals(27.4, deserialize.getWidthValue().doubleValue());
        assertEquals(5.5, deserialize.getDraughtValue().doubleValue());
        assertEquals(4, deserialize.getBays().intValue());
        assertEquals(8, deserialize.getRows().intValue());
        assertEquals(2, deserialize.getTiers().intValue());
        assertTrue(deserialize.getSuitabilityDangerousGoods());
        assertEquals(200.0, deserialize.getCapacityTeu().doubleValue());
        assertEquals(3400.0, deserialize.getCapacityTons().doubleValue());
    }
}
