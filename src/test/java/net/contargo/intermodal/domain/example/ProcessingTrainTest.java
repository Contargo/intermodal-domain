package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.LUOrder;
import net.contargo.intermodal.domain.ProcessingTrain;
import net.contargo.intermodal.domain.TestDataCreator;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.time.Instant;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class ProcessingTrainTest {

    @Test
    void ensureCanBeCreated() {

        ProcessingTrain processingTrain = ProcessingTrain.newBuilder()
                .withTrainTitle("My Train")
                .withWaggon("SGNRS", "789784", 1, Arrays.asList(TestDataCreator.createLUOrder()))
                .withWaggon("SGNRS", "54789", 2, Arrays.asList(TestDataCreator.createLUOrder()))
                .withWaggon("SGNRS", "24568", 3,
                        Arrays.asList(TestDataCreator.createLUOrder(), TestDataCreator.createLUOrder()))
                .withTerminalEta(Instant.parse("2018-05-14T11:00:00Z"))
                .withTerminalEtd(Instant.parse("2018-05-14T13:00:00Z"))
                .withShuntingYardEta(Instant.parse("2018-05-14T12:00:00Z"))
                .withShunter("a shunter")
                .withTrainPaths("12345")
                .buildAndValidate();

        assertEquals("My Train", processingTrain.getTrainTitle());
        assertEquals(3, processingTrain.getLoadingList().size());
        assertEquals("789784", processingTrain.getLoadingList().get(0).getId());
        assertEquals("54789", processingTrain.getLoadingList().get(1).getId());
        assertEquals("24568", processingTrain.getLoadingList().get(2).getId());
        assertEquals(2, processingTrain.getLoadingList().get(2).getLoadingPositions().size());
        assertEquals("2018-05-14T11:00:00Z", processingTrain.getTerminalEta().toString());
        assertEquals("2018-05-14T13:00:00Z", processingTrain.getTerminalEtd().toString());
        assertEquals("2018-05-14T12:00:00Z", processingTrain.getShuntingYardEta().toString());
        assertEquals("a shunter", processingTrain.getShunter());
        assertEquals("12345", processingTrain.getTrainPaths());
    }


    @Test
    void ensureCanBeCopied() {

        ProcessingTrain processingTrain = ProcessingTrain.newBuilder()
                .withTrainTitle("My Train")
                .withWaggon("SGNRS", "789784", 1, Arrays.asList(TestDataCreator.createLUOrder()))
                .withWaggon("SGNRS", "54789", 2, Arrays.asList(TestDataCreator.createLUOrder()))
                .withWaggon("SGNRS", "24568", 3,
                        Arrays.asList(TestDataCreator.createLUOrder(), TestDataCreator.createLUOrder()))
                .withTerminalEta(Instant.parse("2018-05-14T11:00:00Z"))
                .withTerminalEtd(Instant.parse("2018-05-14T13:00:00Z"))
                .withShuntingYardEta(Instant.parse("2018-05-14T12:00:00Z"))
                .withShunter("a shunter")
                .withTrainPaths("12345")
                .buildAndValidate();

        ProcessingTrain copiedProcessingTrain = ProcessingTrain.newBuilder(processingTrain).buildAndValidate();

        assertEquals("My Train", copiedProcessingTrain.getTrainTitle());
        assertEquals(3, copiedProcessingTrain.getLoadingList().size());
        assertEquals("789784", copiedProcessingTrain.getLoadingList().get(0).getId());
        assertEquals("54789", copiedProcessingTrain.getLoadingList().get(1).getId());
        assertEquals("24568", copiedProcessingTrain.getLoadingList().get(2).getId());
        assertEquals(2, copiedProcessingTrain.getLoadingList().get(2).getLoadingPositions().size());
        assertEquals("2018-05-14T11:00:00Z", copiedProcessingTrain.getTerminalEta().toString());
        assertEquals("2018-05-14T13:00:00Z", copiedProcessingTrain.getTerminalEtd().toString());
        assertEquals("2018-05-14T12:00:00Z", copiedProcessingTrain.getShuntingYardEta().toString());
        assertEquals("a shunter", copiedProcessingTrain.getShunter());
        assertEquals("12345", copiedProcessingTrain.getTrainPaths());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        ProcessingTrain processingTrain = ProcessingTrain.newBuilder()
                .withTrainTitle("My Train")
                .withWaggon("SGNRS", "789784", 1, Arrays.asList(TestDataCreator.createLUOrder()))
                .withWaggon("SGNRS", "54789", 2, Arrays.asList(TestDataCreator.createLUOrder()))
                .withWaggon("SGNRS", "24568", 3,
                        Arrays.asList(TestDataCreator.createLUOrder(), TestDataCreator.createLUOrder()))
                .withTerminalEta(Instant.parse("2018-05-14T11:00:00Z"))
                .withTerminalEtd(Instant.parse("2018-05-14T13:00:00Z"))
                .withShuntingYardEta(Instant.parse("2018-05-14T12:00:00Z"))
                .withShunter("a shunter")
                .withTrainPaths("12345")
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(processingTrain);

        ProcessingTrain deserialize = mapper.readValue(jsonString, ProcessingTrain.class);

        assertEquals("My Train", deserialize.getTrainTitle());
        assertEquals(3, deserialize.getLoadingList().size());
        assertEquals("789784", deserialize.getLoadingList().get(0).getId());
        assertEquals("54789", deserialize.getLoadingList().get(1).getId());
        assertEquals("24568", deserialize.getLoadingList().get(2).getId());
        assertEquals(2, deserialize.getLoadingList().get(2).getLoadingPositions().size());
        assertEquals("2018-05-14T11:00:00Z", deserialize.getTerminalEta().toString());
        assertEquals("2018-05-14T13:00:00Z", deserialize.getTerminalEtd().toString());
        assertEquals("2018-05-14T12:00:00Z", deserialize.getShuntingYardEta().toString());
        assertEquals("a shunter", deserialize.getShunter());
        assertEquals("12345", deserialize.getTrainPaths());
    }
}
