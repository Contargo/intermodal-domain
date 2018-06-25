package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Barge;
import net.contargo.intermodal.domain.Stop;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class StopTest {

    @Test
    void ensureCanBeCreatedWithAllInformation() {

        Stop stop = Stop.newBuilder()
                .withLocation("Koblenz", "Terminal Koblenz", "terminal")
                .withLocation("Ludwigshafen", "Terminal Ludwigshafen", "terminal")
                .withSequence(1)
                .withEarliest(Instant.parse("2018-05-14T11:00:00Z"))
                .withLatest(Instant.parse("2018-05-14T12:00:00Z"))
                .withReference("1234567")
                .withBillingReference("894738")
                .withMeansOfTransport(new Barge())
                .buildAndValidate();

        assertEquals(2, stop.getLocations().size());
        assertEquals("Koblenz", stop.getLocations().get(0).getCity());
        assertEquals("Terminal Koblenz", stop.getLocations().get(0).getDesignation());
        assertEquals("terminal", stop.getLocations().get(0).getType());
        assertEquals(1, stop.getSequence().intValue());
        assertEquals("2018-05-14T11:00:00Z", stop.getEarliest().toString());
        assertEquals("2018-05-14T12:00:00Z", stop.getLatest().toString());
        assertEquals("1234567", stop.getReference());
        assertEquals("894738", stop.getBillingReference());
        assertNotNull(stop.getMot());
    }


    @Test
    void ensureCanBeCreatedWithMinimumRequirements() {

        Stop.newBuilder().withLocation("Koblenz", "Terminal Koblenz", "terminal").buildAndValidate();
    }


    @Test
    void ensureCanBeCopied() {

        Stop stop = Stop.newBuilder()
                .withLocation("Koblenz", "Terminal Koblenz", "terminal")
                .withLocation("Ludwigshafen", "Terminal Ludwigshafen", "terminal")
                .withSequence(1)
                .withEarliest(Instant.parse("2018-05-14T11:00:00Z"))
                .withLatest(Instant.parse("2018-05-14T12:00:00Z"))
                .withReference("1234567")
                .withBillingReference("894738")
                .withMeansOfTransport(new Barge())
                .buildAndValidate();

        Stop copiedStop = Stop.newBuilder(stop).buildAndValidate();

        assertEquals(2, copiedStop.getLocations().size());
        assertEquals("Koblenz", copiedStop.getLocations().get(0).getCity());
        assertEquals("Terminal Koblenz", copiedStop.getLocations().get(0).getDesignation());
        assertEquals("terminal", copiedStop.getLocations().get(0).getType());
        assertEquals(1, copiedStop.getSequence().intValue());
        assertEquals("2018-05-14T11:00:00Z", copiedStop.getEarliest().toString());
        assertEquals("2018-05-14T12:00:00Z", copiedStop.getLatest().toString());
        assertEquals("1234567", copiedStop.getReference());
        assertEquals("894738", copiedStop.getBillingReference());
        assertNotNull(copiedStop.getMot());
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class, () -> Stop.newBuilder().buildAndValidate());
        assertThrows(IllegalStateException.class,
            () -> Stop.newBuilder().withLocation(null, "Terminal Koblenz").buildAndValidate());
        assertThrows(IllegalStateException.class,
            () -> Stop.newBuilder().withLocation("Koblenz", null).buildAndValidate());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        Stop stop = Stop.newBuilder()
                .withLocation("Koblenz", "Terminal Koblenz", "terminal")
                .withLocation("Ludwigshafen", "Terminal Ludwigshafen", "terminal")
                .withSequence(1)
                .withEarliest(Instant.parse("2018-05-14T11:00:00Z"))
                .withLatest(Instant.parse("2018-05-14T12:00:00Z"))
                .withReference("1234567")
                .withBillingReference("894738")
                .withMeansOfTransport(new Barge())
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(stop);

        Stop deserialize = mapper.readValue(jsonString, Stop.class);

        assertEquals(2, deserialize.getLocations().size());
        assertEquals("Koblenz", deserialize.getLocations().get(0).getCity());
        assertEquals("Terminal Koblenz", deserialize.getLocations().get(0).getDesignation());
        assertEquals("terminal", deserialize.getLocations().get(0).getType());
        assertEquals(1, deserialize.getSequence().intValue());
        assertEquals("2018-05-14T11:00:00Z", deserialize.getEarliest().toString());
        assertEquals("2018-05-14T12:00:00Z", deserialize.getLatest().toString());
        assertEquals("1234567", deserialize.getReference());
        assertEquals("894738", deserialize.getBillingReference());
        assertNotNull(deserialize.getMot());
    }
}
