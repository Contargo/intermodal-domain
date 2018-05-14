package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.LUOrder;
import net.contargo.intermodal.domain.ProcessingTrain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class ProcessingTrainTest {

    @Test
    void ensureCanBeCreated() {

        ProcessingTrain processingTrain = ProcessingTrain.Builder.newProcessingTrain()
                .withTrainTitle("My Train")
                .withWaggon("SGNRS", "789784", 1, Arrays.asList(new LUOrder()))
                .withWaggon("SGNRS", "54789", 2, Arrays.asList(new LUOrder()))
                .withWaggon("SGNRS", "24568", 3, Arrays.asList(new LUOrder(), new LUOrder()))
                .withTerminalEta(2018, 5, 14, 11, 0)
                .withTerminalEtd(2018, 5, 14, 13, 0)
                .withShuntingYardEta(2018, 5, 14, 12, 0)
                .withShunter("a shunter")
                .withTrainPaths("12345")
                .buildAndValidate();

        assertEquals("My Train", processingTrain.getTrainTitle());
        assertEquals(3, processingTrain.getLoadingList().size());
        assertEquals("789784", processingTrain.getLoadingList().get(0).getId());
        assertEquals("54789", processingTrain.getLoadingList().get(1).getId());
        assertEquals("24568", processingTrain.getLoadingList().get(2).getId());
        assertEquals(2, processingTrain.getLoadingList().get(2).getLoadingPosition().size());
        assertEquals("2018-05-14T11:00:00.000Z", processingTrain.getTerminalEta());
        assertEquals("2018-05-14T13:00:00.000Z", processingTrain.getTerminalEtd());
        assertEquals("2018-05-14T12:00:00.000Z", processingTrain.getShuntingYardEta());
        assertEquals("a shunter", processingTrain.getShunter());
        assertEquals("12345", processingTrain.getTrainPaths());
    }
}
