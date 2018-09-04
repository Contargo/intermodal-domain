package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Barge;
import net.contargo.intermodal.domain.Location;
import net.contargo.intermodal.domain.Stop;
import net.contargo.intermodal.domain.TestDataCreator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class StopTest {

    private Location terminalKoblenz;
    private Location terminalLudwigshafen;

    @BeforeEach
    void setUp() {

        terminalKoblenz = Location.newBuilder()
                .withCity("Koblenz")
                .withDesignation("Terminal Koblenz")
                .withType("terminal")
                .buildAndValidate();

        terminalLudwigshafen = Location.newBuilder()
                .withCity("Ludwigshafen")
                .withDesignation("Terminal Ludwigshafen")
                .withType("terminal")
                .buildAndValidate();
    }


    @Test
    void ensureCanBeCreatedWithAllInformation() {

        Stop stop = Stop.newBuilder()
                .withLocation(terminalKoblenz)
                .withLocation(terminalLudwigshafen)
                .withSequence(1)
                .withEarliest(Instant.parse("2018-05-14T11:00:00Z"))
                .withLatest(Instant.parse("2018-05-14T12:00:00Z"))
                .withReference("1234567")
                .withBillingReference("894738")
                .withMeansOfTransport(TestDataCreator.createBarge())
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

        Stop.newBuilder().withLocation(terminalKoblenz).buildAndValidate();
    }


    @Test
    void ensureCanBeCopied() {

        Stop stop = Stop.newBuilder()
                .withLocation(terminalKoblenz)
                .withLocation(terminalLudwigshafen)
                .withSequence(1)
                .withEarliest(Instant.parse("2018-05-14T11:00:00Z"))
                .withLatest(Instant.parse("2018-05-14T12:00:00Z"))
                .withReference("1234567")
                .withBillingReference("894738")
                .withMeansOfTransport(TestDataCreator.createBarge())
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
            () ->
                Stop.newBuilder()
                    .withLocation(Location.newBuilder().withDesignation("Terminal Koblenz").buildAndValidate())
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                Stop.newBuilder()
                    .withLocation(Location.newBuilder().withCity("Koblenz").buildAndValidate())
                    .buildAndValidate());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        Stop stop = Stop.newBuilder()
                .withLocation(terminalKoblenz)
                .withLocation(terminalLudwigshafen)
                .withSequence(1)
                .withEarliest(Instant.parse("2018-05-14T11:00:00Z"))
                .withLatest(Instant.parse("2018-05-14T12:00:00Z"))
                .withReference("1234567")
                .withBillingReference("894738")
                .withMeansOfTransport(TestDataCreator.createBarge())
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
