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
                .withAtd(Instant.parse("2018-05-11T06:00:00Z"))
                .withEta(Instant.parse("2018-05-11T12:30:00Z"))
                .withAta(Instant.parse("2018-05-11T06:05:00Z"))
                .withHandlingStart(Instant.parse("2018-05-11T06:30:00Z"))
                .withHandlingEnd(Instant.parse("2018-05-11T06:35:00Z"))
                .withWaggonTechnicalInspection(1)
                .buildAndValidate();

        assertEquals("2018-05-11T06:00:00Z", meansOfTransportationStatus.getAtd().toString());
        assertEquals("2018-05-11T12:30:00Z", meansOfTransportationStatus.getEta().toString());
        assertEquals("2018-05-11T06:05:00Z", meansOfTransportationStatus.getAta().toString());
        assertEquals("2018-05-11T06:30:00Z", meansOfTransportationStatus.getHandlingStart().toString());
        assertEquals("2018-05-11T06:35:00Z", meansOfTransportationStatus.getHandlingEnd().toString());
        assertEquals(1, meansOfTransportationStatus.getWaggonTechnicalInspection().intValue());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        MeansOfTransportationStatus meansOfTransportationStatus = MeansOfTransportationStatus.newBuilder()
                .withAtd(Instant.parse("2018-05-11T06:00:00Z"))
                .withEta(Instant.parse("2018-05-11T12:30:00Z"))
                .withAta(Instant.parse("2018-05-11T06:05:00Z"))
                .withHandlingStart(Instant.parse("2018-05-11T06:30:00Z"))
                .withHandlingEnd(Instant.parse("2018-05-11T06:35:00Z"))
                .withWaggonTechnicalInspection(1)
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(meansOfTransportationStatus);

        MeansOfTransportationStatus deserialize = mapper.readValue(jsonString, MeansOfTransportationStatus.class);

        assertEquals("2018-05-11T06:00:00Z", deserialize.getAtd().toString());
        assertEquals("2018-05-11T12:30:00Z", deserialize.getEta().toString());
        assertEquals("2018-05-11T06:05:00Z", deserialize.getAta().toString());
        assertEquals("2018-05-11T06:30:00Z", deserialize.getHandlingStart().toString());
        assertEquals("2018-05-11T06:35:00Z", deserialize.getHandlingEnd().toString());
        assertEquals(1, deserialize.getWaggonTechnicalInspection().intValue());
    }
}
