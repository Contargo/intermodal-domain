package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Barge;
import net.contargo.intermodal.domain.DangerousGoods;
import net.contargo.intermodal.domain.RegistrationBarge;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class RegistrationBargeTest {

    @Test
    void ensureCanBeCreatedWithAllInformation() {

        RegistrationBarge registrationBarge = RegistrationBarge.Builder.newRegistrationBarge()
                .withBarge(new Barge())
                .withEta(2018, 5, 14, 11, 0)
                .withEtd(2018, 5, 14, 12, 0)
                .withDangerousGoodsIndication(new DangerousGoods())
                .withVolumeToDischarge(24)
                .withVolumeToLoad(24)
                .buildAndValidate();

        assertNotNull(registrationBarge.getBarge());
        assertEquals("2018-05-14T11:00:00", registrationBarge.getEta());
        assertEquals("2018-05-14T12:00:00", registrationBarge.getEtd());
        assertNotNull(registrationBarge.getDangerousGoodsIndication());
        assertEquals(24, registrationBarge.getVolumeToLoad().intValue());
        assertEquals(24, registrationBarge.getVolumeToDischarge().intValue());
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class,
            () ->
                RegistrationBarge.Builder.newRegistrationBarge()
                    .withEta(2018, 5, 14, 11, 0)
                    .withEtd(2018, 5, 14, 12, 0)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToDischarge(24)
                    .withVolumeToLoad(24)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationBarge.Builder.newRegistrationBarge()
                    .withBarge(new Barge())
                    .withEtd(2018, 5, 14, 12, 0)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToDischarge(24)
                    .withVolumeToLoad(24)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationBarge.Builder.newRegistrationBarge()
                    .withBarge(new Barge())
                    .withEta(2018, 5, 14, 11, 0)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToDischarge(24)
                    .withVolumeToLoad(24)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationBarge.Builder.newRegistrationBarge()
                    .withBarge(new Barge())
                    .withEta(2018, 5, 14, 11, 0)
                    .withEtd(2018, 5, 14, 12, 0)
                    .withVolumeToDischarge(24)
                    .withVolumeToLoad(24)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationBarge.Builder.newRegistrationBarge()
                    .withBarge(new Barge())
                    .withEta(2018, 5, 14, 11, 0)
                    .withEtd(2018, 5, 14, 12, 0)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToLoad(24)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationBarge.Builder.newRegistrationBarge()
                    .withBarge(new Barge())
                    .withEta(2018, 5, 14, 11, 0)
                    .withEtd(2018, 5, 14, 12, 0)
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToDischarge(24)
                    .buildAndValidate());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        RegistrationBarge registrationBarge = RegistrationBarge.Builder.newRegistrationBarge()
                .withBarge(new Barge())
                .withEta(2018, 5, 14, 11, 0)
                .withEtd(2018, 5, 14, 12, 0)
                .withDangerousGoodsIndication(new DangerousGoods())
                .withVolumeToDischarge(24)
                .withVolumeToLoad(24)
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(registrationBarge);

        RegistrationBarge deserialize = mapper.readValue(jsonString, RegistrationBarge.class);

        assertNotNull(deserialize.getBarge());
        assertEquals("2018-05-14T11:00:00", deserialize.getEta());
        assertEquals("2018-05-14T12:00:00", deserialize.getEtd());
        assertNotNull(deserialize.getDangerousGoodsIndication());
        assertEquals(24, deserialize.getVolumeToLoad().intValue());
        assertEquals(24, deserialize.getVolumeToDischarge().intValue());
    }
}
