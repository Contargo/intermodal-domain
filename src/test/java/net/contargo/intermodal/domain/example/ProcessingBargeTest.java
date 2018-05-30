package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class ProcessingBargeTest {

    @Test
    void ensureCanBeCreated() {

        ProcessingBarge processingBarge = ProcessingBarge.Builder.newProcessingBarge()
                .withBarge(new Barge())
                .withEta(2018, 5, 14, 11, 0)
                .withEtd(2018, 5, 14, 12, 0)
                .withSkipper(new Skipper())
                .withPassenger(Arrays.asList(new Skipper(), new Skipper()))
                .withReeferConnections(12)
                .withCone(Cone.ONE)
                .withAdnr(true)
                .withLuOrder(new LUOrder(), StoragePosition.TIER)
                .withLuOrder(new LUOrder(), StoragePosition.ROW)
                .withLuOrder(new LUOrder(), StoragePosition.BAY)
                .buildAndValidate();

        assertNotNull(processingBarge.getBarge());
        assertEquals("2018-05-14T11:00:00", processingBarge.getEta());
        assertEquals("2018-05-14T12:00:00", processingBarge.getEtd());
        assertNotNull(processingBarge.getSkipper());
        assertEquals(2, processingBarge.getPassenger().size());
        assertEquals(12, processingBarge.getReeferConnections().intValue());
        assertEquals(Cone.ONE, processingBarge.getCone());
        assertTrue(processingBarge.getAdnr());
        assertEquals(3, processingBarge.getLoadingList().size());
        assertEquals(StoragePosition.TIER, processingBarge.getLoadingList().get(0).getStoragePosition());
        assertNotNull(processingBarge.getLoadingList().get(0).getLuOrder());
    }
}
