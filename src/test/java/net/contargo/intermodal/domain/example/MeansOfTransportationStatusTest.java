package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.MeansOfTransportationStatus;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class MeansOfTransportationStatusTest {

    @Test
    void ensureCanBeCreated() {

        MeansOfTransportationStatus meansOfTransportationStatus = MeansOfTransportationStatus.Builder
            .newMeansOfTransportationStatus()
                .withAtd(2018, 5, 11, 6, 0)
                .withEta(2018, 5, 11, 12, 30)
                .withAta(2018, 5, 11, 6, 5)
                .withHandlingStart(2018, 5, 11, 6, 30)
                .withHandlingEnd(2018, 5, 11, 6, 35)
                .withWaggonTechnicalInspection(1)
                .buildAndValidate();

        assertEquals("2018-05-11T06:00:00", meansOfTransportationStatus.getAtd());
        assertEquals("2018-05-11T12:30:00", meansOfTransportationStatus.getEta());
        assertEquals("2018-05-11T06:05:00", meansOfTransportationStatus.getAta());
        assertEquals("2018-05-11T06:30:00", meansOfTransportationStatus.getHandlingStart());
        assertEquals("2018-05-11T06:35:00", meansOfTransportationStatus.getHandlingEnd());
        assertEquals(1, meansOfTransportationStatus.getWaggonTechnicalInspection().intValue());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        MeansOfTransportationStatus meansOfTransportationStatus = MeansOfTransportationStatus.Builder
            .newMeansOfTransportationStatus()
                .withAtd(2018, 5, 11, 6, 0)
                .withEta(2018, 5, 11, 12, 30)
                .withAta(2018, 5, 11, 6, 5)
                .withHandlingStart(2018, 5, 11, 6, 30)
                .withHandlingEnd(2018, 5, 11, 6, 35)
                .withWaggonTechnicalInspection(1)
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(meansOfTransportationStatus);

        MeansOfTransportationStatus deserialize = mapper.readValue(jsonString, MeansOfTransportationStatus.class);

        assertEquals("2018-05-11T06:00:00", deserialize.getAtd());
        assertEquals("2018-05-11T12:30:00", deserialize.getEta());
        assertEquals("2018-05-11T06:05:00", deserialize.getAta());
        assertEquals("2018-05-11T06:30:00", deserialize.getHandlingStart());
        assertEquals("2018-05-11T06:35:00", deserialize.getHandlingEnd());
        assertEquals(1, deserialize.getWaggonTechnicalInspection().intValue());

        System.out.print(meansOfTransportationStatus.toString());
    }
}
