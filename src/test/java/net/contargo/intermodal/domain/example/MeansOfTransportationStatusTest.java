package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.MeansOfTransportationStatus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class MeansOfTransportationStatusTest {

    @Test
    void canBeCreated() {

        MeansOfTransportationStatus meansOfTransportationStatus = MeansOfTransportationStatus.Builder
            .newMeansOfTransportationStatus()
                .withAtd(2018, 5, 11, 6, 0)
                .withEta(2018, 5, 11, 12, 30)
                .withAta(2018, 5, 11, 6, 5)
                .withHandlingStart(true)
                .withHandlingEnd(false)
                .withWaggonTechnicalInspection(1)
                .buildAndValidate();

        assertEquals("2018-05-11T06:00:00.000Z", meansOfTransportationStatus.getAtd());
        assertEquals("2018-05-11T12:30:00.000Z", meansOfTransportationStatus.getEta());
        assertEquals("2018-05-11T06:05:00.000Z", meansOfTransportationStatus.getAta());
        assertTrue(meansOfTransportationStatus.getHandlingStart());
        assertFalse(meansOfTransportationStatus.getHandlingEnd());
        assertEquals(1, meansOfTransportationStatus.getWaggonTechnicalInspection().intValue());
    }
}
