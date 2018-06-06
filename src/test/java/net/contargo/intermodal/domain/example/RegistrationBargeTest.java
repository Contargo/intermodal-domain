package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Barge;
import net.contargo.intermodal.domain.DangerousGoods;
import net.contargo.intermodal.domain.RegistrationBarge;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class RegistrationBargeTest {

    @Test
    void ensureCanBeCreatedWithAllInformation() {

        RegistrationBarge registrationBarge = RegistrationBarge.Builder.newRegistrationBarge()
                .withBarge(new Barge())
                .withEta(Instant.parse("2018-05-14T11:00:00Z"))
                .withEtd(Instant.parse("2018-05-14T12:00:00Z"))
                .withDangerousGoodsIndication(new DangerousGoods())
                .withVolumeToDischarge(24)
                .withVolumeToLoad(24)
                .buildAndValidate();

        assertNotNull(registrationBarge.getBarge());
        assertEquals("2018-05-14T11:00:00Z", registrationBarge.getEta().toString());
        assertEquals("2018-05-14T12:00:00Z", registrationBarge.getEtd().toString());
        assertNotNull(registrationBarge.getDangerousGoodsIndication());
        assertEquals(24, registrationBarge.getVolumeToLoad().intValue());
        assertEquals(24, registrationBarge.getVolumeToDischarge().intValue());
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class,
            () ->
                RegistrationBarge.Builder.newRegistrationBarge()
                    .withEta(Instant.parse("2018-05-14T11:00:00Z"))
                    .withEtd(Instant.parse("2018-05-14T12:00:00Z"))
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToDischarge(24)
                    .withVolumeToLoad(24)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationBarge.Builder.newRegistrationBarge()
                    .withBarge(new Barge())
                    .withEtd(Instant.parse("2018-05-14T12:00:00Z"))
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToDischarge(24)
                    .withVolumeToLoad(24)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationBarge.Builder.newRegistrationBarge()
                    .withBarge(new Barge())
                    .withEta(Instant.parse("2018-05-14T11:00:00Z"))
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToDischarge(24)
                    .withVolumeToLoad(24)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationBarge.Builder.newRegistrationBarge()
                    .withBarge(new Barge())
                    .withEta(Instant.parse("2018-05-14T11:00:00Z"))
                    .withEtd(Instant.parse("2018-05-14T12:00:00Z"))
                    .withVolumeToDischarge(24)
                    .withVolumeToLoad(24)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationBarge.Builder.newRegistrationBarge()
                    .withBarge(new Barge())
                    .withEta(Instant.parse("2018-05-14T11:00:00Z"))
                    .withEtd(Instant.parse("2018-05-14T12:00:00Z"))
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToLoad(24)
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                RegistrationBarge.Builder.newRegistrationBarge()
                    .withBarge(new Barge())
                    .withEta(Instant.parse("2018-05-14T11:00:00Z"))
                    .withEtd(Instant.parse("2018-05-14T12:00:00Z"))
                    .withDangerousGoodsIndication(new DangerousGoods())
                    .withVolumeToDischarge(24)
                    .buildAndValidate());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        RegistrationBarge registrationBarge = RegistrationBarge.Builder.newRegistrationBarge()
                .withBarge(new Barge())
                .withEta(Instant.parse("2018-05-14T11:00:00Z"))
                .withEtd(Instant.parse("2018-05-14T12:00:00Z"))
                .withDangerousGoodsIndication(new DangerousGoods())
                .withVolumeToDischarge(24)
                .withVolumeToLoad(24)
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(registrationBarge);

        RegistrationBarge deserialize = mapper.readValue(jsonString, RegistrationBarge.class);

        assertNotNull(deserialize.getBarge());
        assertEquals("2018-05-14T11:00:00Z", deserialize.getEta().toString());
        assertEquals("2018-05-14T12:00:00Z", deserialize.getEtd().toString());
        assertNotNull(deserialize.getDangerousGoodsIndication());
        assertEquals(24, deserialize.getVolumeToLoad().intValue());
        assertEquals(24, deserialize.getVolumeToDischarge().intValue());
    }
}
