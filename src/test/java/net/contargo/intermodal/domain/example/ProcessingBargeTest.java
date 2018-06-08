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
                .withBarge(new Barge())
                .withEta(Instant.parse("2018-05-14T11:00:00Z"))
                .withEtd(Instant.parse("2018-05-14T12:00:00Z"))
                .withSkipper(new Skipper())
                .withPassenger(Arrays.asList(new Skipper(), new Skipper()))
                .withReeferConnections(12)
                .withCone(Cone.ONE)
                .withAdnr(Instant.parse("2020-06-01T12:00:00Z"))
                .withLuOrder(new LUOrder(), StoragePosition.TIER)
                .withLuOrder(new LUOrder(), StoragePosition.ROW)
                .withLuOrder(new LUOrder(), StoragePosition.BAY)
                .buildAndValidate();

        assertNotNull(processingBarge.getBarge());
        assertEquals("2018-05-14T11:00:00Z", processingBarge.getEta().toString());
        assertEquals("2018-05-14T12:00:00Z", processingBarge.getEtd().toString());
        assertNotNull(processingBarge.getSkipper());
        assertEquals(2, processingBarge.getPassenger().size());
        assertEquals(12, processingBarge.getReeferConnections().intValue());
        assertEquals(Cone.ONE, processingBarge.getCone());
        assertEquals("2020-06-01T12:00:00Z", processingBarge.getAdnr().toString());
        assertEquals(3, processingBarge.getLoadingList().size());
        assertEquals(StoragePosition.TIER, processingBarge.getLoadingList().get(0).getStoragePosition());
        assertNotNull(processingBarge.getLoadingList().get(0).getLuOrder());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        ProcessingBarge processingBarge = ProcessingBarge.newBuilder()
                .withBarge(new Barge())
                .withEta(Instant.parse("2018-05-14T11:00:00Z"))
                .withEtd(Instant.parse("2018-05-14T12:00:00Z"))
                .withSkipper(new Skipper())
                .withPassenger(Arrays.asList(new Skipper(), new Skipper()))
                .withReeferConnections(12)
                .withCone(Cone.ONE)
                .withAdnr(Instant.parse("2020-06-01T12:00:00Z"))
                .withLuOrder(new LUOrder(), StoragePosition.TIER)
                .withLuOrder(new LUOrder(), StoragePosition.ROW)
                .withLuOrder(new LUOrder(), StoragePosition.BAY)
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
        assertEquals("2020-06-01T12:00:00Z", deserialize.getAdnr().toString());
        assertEquals(3, deserialize.getLoadingList().size());
        assertEquals(StoragePosition.TIER, deserialize.getLoadingList().get(0).getStoragePosition());
        assertNotNull(deserialize.getLoadingList().get(0).getLuOrder());
    }
}
