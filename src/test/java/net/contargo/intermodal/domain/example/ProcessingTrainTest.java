package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.LUOrder;
import net.contargo.intermodal.domain.ProcessingTrain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class ProcessingTrainTest {

    @Test
    void ensureCanBeCreated() {

        ProcessingTrain processingTrain = ProcessingTrain.Builder.newProcessingTrain()
                .withTrainTitel("My Train")
                .withLoadingListWaggon(new ArrayList<>())
                .withLoadingListWaggonType(Arrays.asList("SGNRS", "SGNRS", "SGNRS"))
                .withLoadingListWaggonId(Arrays.asList("5468", "5467", "5479"))
                .withLoadingListWaggonRanking(Arrays.asList(1, 2, 3))
                .withLoadingListWaggonLoadingPositionLuOrder(Arrays.asList(new LUOrder(), new LUOrder(),
                            new LUOrder()))
                .withTerminalEta(2018, 5, 14, 11, 0)
                .withTerminalEtd(2018, 5, 14, 13, 0)
                .withShuntingYardEta(2018, 5, 14, 12, 0)
                .withShunter("a shunter")
                .withTrainPaths("12345")
                .buildAndValidate();

        assertEquals("My Train", processingTrain.getTrainTitel());
        assertEquals(3, processingTrain.getLoadingListWaggonType().size());
        assertEquals(3, processingTrain.getLoadingListWaggonId().size());
        assertEquals(3, processingTrain.getLoadingListWaggonRanking().size());
        assertEquals(3, processingTrain.getLoadingListWaggonLoadingPositionLuOrder().size());
        assertEquals("2018-05-14T11:00:00.000Z", processingTrain.getTerminalEta());
        assertEquals("2018-05-14T13:00:00.000Z", processingTrain.getTerminalEtd());
        assertEquals("2018-05-14T12:00:00.000Z", processingTrain.getShuntingYardEta());
        assertEquals("a shunter", processingTrain.getShunter());
        assertEquals("12345", processingTrain.getTrainPaths());
    }
}
