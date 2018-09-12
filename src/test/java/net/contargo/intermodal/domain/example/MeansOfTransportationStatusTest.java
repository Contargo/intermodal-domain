package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.MeansOfTransportationStatus;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class MeansOfTransportationStatusTest {

    @Test
    void ensureCanBeCreated() {

        MeansOfTransportationStatus meansOfTransportationStatus = MeansOfTransportationStatus.newBuilder()
                .withActualTimeOfDeparture(Instant.parse("2018-05-11T06:00:00Z"))
                .withEstimatedTimeOfArrival(Instant.parse("2018-05-11T12:30:00Z"))
                .withActualTimeOfArrival(Instant.parse("2018-05-11T06:05:00Z"))
                .withHandlingStart(Instant.parse("2018-05-11T06:30:00Z"))
                .withHandlingEnd(Instant.parse("2018-05-11T06:35:00Z"))
                .withWaggonTechnicalInspection(1)
                .buildAndValidate();

        assertEquals("2018-05-11T06:00:00Z", meansOfTransportationStatus.getActualTimeOfDeparture().toString());
        assertEquals("2018-05-11T12:30:00Z", meansOfTransportationStatus.getEstimatedTimeOfArrival().toString());
        assertEquals("2018-05-11T06:05:00Z", meansOfTransportationStatus.getActualTimeOfArrival().toString());
        assertEquals("2018-05-11T06:30:00Z", meansOfTransportationStatus.getHandlingStart().toString());
        assertEquals("2018-05-11T06:35:00Z", meansOfTransportationStatus.getHandlingEnd().toString());
        assertEquals(1, meansOfTransportationStatus.getWaggonTechnicalInspection().intValue());
    }


    @Test
    void ensureCanBeCopied() {

        MeansOfTransportationStatus meansOfTransportationStatus = MeansOfTransportationStatus.newBuilder()
                .withActualTimeOfDeparture(Instant.parse("2018-05-11T06:00:00Z"))
                .withEstimatedTimeOfArrival(Instant.parse("2018-05-11T12:30:00Z"))
                .withActualTimeOfArrival(Instant.parse("2018-05-11T06:05:00Z"))
                .withHandlingStart(Instant.parse("2018-05-11T06:30:00Z"))
                .withHandlingEnd(Instant.parse("2018-05-11T06:35:00Z"))
                .withWaggonTechnicalInspection(1)
                .buildAndValidate();

        MeansOfTransportationStatus copiedMeansOfTransportationStatus = MeansOfTransportationStatus.newBuilder(
                meansOfTransportationStatus)
                .buildAndValidate();

        assertEquals("2018-05-11T06:00:00Z", copiedMeansOfTransportationStatus.getActualTimeOfDeparture().toString());
        assertEquals("2018-05-11T12:30:00Z", copiedMeansOfTransportationStatus.getEstimatedTimeOfArrival().toString());
        assertEquals("2018-05-11T06:05:00Z", copiedMeansOfTransportationStatus.getActualTimeOfArrival().toString());
        assertEquals("2018-05-11T06:30:00Z", copiedMeansOfTransportationStatus.getHandlingStart().toString());
        assertEquals("2018-05-11T06:35:00Z", copiedMeansOfTransportationStatus.getHandlingEnd().toString());
        assertEquals(1, copiedMeansOfTransportationStatus.getWaggonTechnicalInspection().intValue());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        MeansOfTransportationStatus meansOfTransportationStatus = MeansOfTransportationStatus.newBuilder()
                .withActualTimeOfDeparture(Instant.parse("2018-05-11T06:00:00Z"))
                .withEstimatedTimeOfArrival(Instant.parse("2018-05-11T12:30:00Z"))
                .withActualTimeOfArrival(Instant.parse("2018-05-11T06:05:00Z"))
                .withHandlingStart(Instant.parse("2018-05-11T06:30:00Z"))
                .withHandlingEnd(Instant.parse("2018-05-11T06:35:00Z"))
                .withWaggonTechnicalInspection(1)
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(meansOfTransportationStatus);

        MeansOfTransportationStatus deserialize = mapper.readValue(jsonString, MeansOfTransportationStatus.class);

        assertEquals("2018-05-11T06:00:00Z", deserialize.getActualTimeOfDeparture().toString());
        assertEquals("2018-05-11T12:30:00Z", deserialize.getEstimatedTimeOfArrival().toString());
        assertEquals("2018-05-11T06:05:00Z", deserialize.getActualTimeOfArrival().toString());
        assertEquals("2018-05-11T06:30:00Z", deserialize.getHandlingStart().toString());
        assertEquals("2018-05-11T06:35:00Z", deserialize.getHandlingEnd().toString());
        assertEquals(1, deserialize.getWaggonTechnicalInspection().intValue());
    }
}
