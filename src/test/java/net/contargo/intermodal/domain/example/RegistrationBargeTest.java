package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.Barge;
import net.contargo.intermodal.domain.DangerousGoods;
import net.contargo.intermodal.domain.RegistrationBarge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class RegistrationBargeTest {

    @Test
    void ensureCanBeCreated() {

        RegistrationBarge registrationBarge = RegistrationBarge.Builder.newRegistrationBarge()
                .withBarge(new Barge())
                .withEta(2018, 5, 14, 11, 0)
                .withEtd(2018, 5, 14, 12, 0)
                .withDangerousGoodsIndication(new DangerousGoods())
                .withVolumeToDischarge(24)
                .withVolumeToLoad(24)
                .buildAndValidate();

        assertNotNull(registrationBarge.getBarge());
        assertEquals("2018-05-14T11:00:00.000Z", registrationBarge.getEta());
        assertEquals("2018-05-14T12:00:00.000Z", registrationBarge.getEtd());
        assertNotNull(registrationBarge.getDangerousGoodsIndication());
        assertEquals(24, registrationBarge.getVolumeToLoad().intValue());
        assertEquals(24, registrationBarge.getVolumeToDischarge().intValue());
    }


    @Test
    void ensureMissingMandatoryInformationIsDetected() {

        assertThrows(IllegalStateException.class,
            () -> {
                RegistrationBarge.Builder.newRegistrationBarge()
                    .withEta(2018, 5, 14, 11, 0)
                    .withEtd(2018, 5, 14, 12, 0)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToDischarge(24)
                    .withVolumeToLoad(24)
                    .buildAndValidate();
            });
        assertThrows(IllegalStateException.class,
            () -> {
                RegistrationBarge.Builder.newRegistrationBarge()
                    .withBarge(new Barge())
                    .withEtd(2018, 5, 14, 12, 0)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToDischarge(24)
                    .withVolumeToLoad(24)
                    .buildAndValidate();
            });
        assertThrows(IllegalStateException.class,
            () -> {
                RegistrationBarge.Builder.newRegistrationBarge()
                    .withBarge(new Barge())
                    .withEta(2018, 5, 14, 11, 0)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToDischarge(24)
                    .withVolumeToLoad(24)
                    .buildAndValidate();
            });
        assertThrows(IllegalStateException.class,
            () -> {
                RegistrationBarge.Builder.newRegistrationBarge()
                    .withBarge(new Barge())
                    .withEta(2018, 5, 14, 11, 0)
                    .withEtd(2018, 5, 14, 12, 0)
                    .withVolumeToDischarge(24)
                    .withVolumeToLoad(24)
                    .buildAndValidate();
            });
        assertThrows(IllegalStateException.class,
            () -> {
                RegistrationBarge.Builder.newRegistrationBarge()
                    .withBarge(new Barge())
                    .withEta(2018, 5, 14, 11, 0)
                    .withEtd(2018, 5, 14, 12, 0)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToLoad(24)
                    .buildAndValidate();
            });
        assertThrows(IllegalStateException.class,
            () -> {
                RegistrationBarge.Builder.newRegistrationBarge()
                    .withBarge(new Barge())
                    .withEta(2018, 5, 14, 11, 0)
                    .withEtd(2018, 5, 14, 12, 0)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToDischarge(24)
                    .buildAndValidate();
            });
    }
}
