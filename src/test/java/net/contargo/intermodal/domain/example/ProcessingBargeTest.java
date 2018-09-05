package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.time.Instant;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class ProcessingBargeTest {

    @Test
    void ensureCanBeCreated() {

        ProcessingBarge processingBarge = ProcessingBarge.newBuilder()
                .withBarge(TestDataCreator.createBarge())
                .withEta(Instant.parse("2018-05-14T11:00:00Z"))
                .withEtd(Instant.parse("2018-05-14T12:00:00Z"))
                .withSkipper(TestDataCreator.createSkipper())
                .withPassengers(Arrays.asList(TestDataCreator.createPassenger(), TestDataCreator.createPassenger()))
                .withReeferConnections(12)
                .withCone(Cone.ONE)
                .withAdnr(true)
                .withLuOrder(TestDataCreator.createLUOrder(), "0010302")
                .withLuOrder(TestDataCreator.createLUOrder(), "0010304")
                .withLuOrder(TestDataCreator.createLUOrder(), "0010306")
                .buildAndValidate();

        assertNotNull(processingBarge.getBarge());
        assertEquals("2018-05-14T11:00:00Z", processingBarge.getEta().toString());
        assertEquals("2018-05-14T12:00:00Z", processingBarge.getEtd().toString());
        assertNotNull(processingBarge.getSkipper());
        assertEquals(2, processingBarge.getPassenger().size());
        assertEquals(12, processingBarge.getReeferConnections().intValue());
        assertEquals(Cone.ONE, processingBarge.getCone());
        assertTrue(processingBarge.getAdnr());
        assertEquals(3, processingBarge.getLoadingList().size());
        assertEquals("0010302", processingBarge.getLoadingList().get(0).getStoragePosition());
        assertNotNull(processingBarge.getLoadingList().get(0).getLuOrder());
    }


    @Test
    void ensureCanBeCopied() {

        ProcessingBarge processingBarge = ProcessingBarge.newBuilder()
                .withBarge(TestDataCreator.createBarge())
                .withEta(Instant.parse("2018-05-14T11:00:00Z"))
                .withEtd(Instant.parse("2018-05-14T12:00:00Z"))
                .withSkipper(TestDataCreator.createSkipper())
                .withPassengers(Arrays.asList(TestDataCreator.createPassenger(), TestDataCreator.createPassenger()))
                .withReeferConnections(12)
                .withCone(Cone.ONE)
                .withAdnr(true)
                .withLuOrder(TestDataCreator.createLUOrder(), "0010302")
                .withLuOrder(TestDataCreator.createLUOrder(), "0010304")
                .withLuOrder(TestDataCreator.createLUOrder(), "0010306")
                .buildAndValidate();

        ProcessingBarge copiedProcessingBarge = ProcessingBarge.newBuilder(processingBarge).buildAndValidate();

        assertNotNull(copiedProcessingBarge.getBarge());
        assertEquals("2018-05-14T11:00:00Z", copiedProcessingBarge.getEta().toString());
        assertEquals("2018-05-14T12:00:00Z", copiedProcessingBarge.getEtd().toString());
        assertNotNull(copiedProcessingBarge.getSkipper());
        assertEquals(2, copiedProcessingBarge.getPassenger().size());
        assertEquals(12, copiedProcessingBarge.getReeferConnections().intValue());
        assertEquals(Cone.ONE, copiedProcessingBarge.getCone());
        assertTrue(copiedProcessingBarge.getAdnr());
        assertEquals(3, copiedProcessingBarge.getLoadingList().size());
        assertEquals("0010302", copiedProcessingBarge.getLoadingList().get(0).getStoragePosition());
        assertNotNull(copiedProcessingBarge.getLoadingList().get(0).getLuOrder());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        ProcessingBarge processingBarge = ProcessingBarge.newBuilder()
                .withBarge(TestDataCreator.createBarge())
                .withEta(Instant.parse("2018-05-14T11:00:00Z"))
                .withEtd(Instant.parse("2018-05-14T12:00:00Z"))
                .withSkipper(TestDataCreator.createSkipper())
                .withPassengers(Arrays.asList(TestDataCreator.createSkipper(), TestDataCreator.createSkipper()))
                .withReeferConnections(12)
                .withCone(Cone.ONE)
                .withAdnr(true)
                .withLuOrder(TestDataCreator.createLUOrder(), "0010302")
                .withLuOrder(TestDataCreator.createLUOrder(), "0010304")
                .withLuOrder(TestDataCreator.createLUOrder(), "0010306")
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(processingBarge);

        ProcessingBarge deserialize = mapper.readValue(jsonString, ProcessingBarge.class);

        assertNotNull(deserialize.getBarge());
        assertEquals("2018-05-14T11:00:00Z", deserialize.getEta().toString());
        assertEquals("2018-05-14T12:00:00Z", deserialize.getEtd().toString());
        assertNotNull(deserialize.getSkipper());
        assertEquals(2, deserialize.getPassenger().size());
        assertEquals(12, deserialize.getReeferConnections().intValue());
        assertEquals(Cone.ONE, deserialize.getCone());
        assertTrue(deserialize.getAdnr());
        assertEquals(3, deserialize.getLoadingList().size());
        assertEquals("0010302", deserialize.getLoadingList().get(0).getStoragePosition());
        assertNotNull(deserialize.getLoadingList().get(0).getLuOrder());
    }
}
