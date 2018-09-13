package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.DangerousGoods;
import net.contargo.intermodal.domain.TunnelRestrictionCode;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class DangerousGoodsTest {

    @Test
    void ensureCanBeCreatedWithAllInformation() {

        DangerousGoods dangerousGoods = DangerousGoods.newBuilder()
                .withUnNumber("1005")
                .withMaterial("Ammoniak")
                .withDangerNote(true)
                .withPackagingGroup("VG II")
                .withPackages(8)
                .withTotalQuantity("1000 l")
                .withTunnelRestrictionCode(TunnelRestrictionCode.NONE)
                .withMandatoryRouting("Mandatory Routing?")
                .withLimitedQuantity(false)
                .withMarinePollutants(true)
                .buildAndValidate();

        assertEquals("1005", dangerousGoods.getUnNumber());
        assertEquals("Ammoniak", dangerousGoods.getMaterial());
        assertTrue(dangerousGoods.getDangerNote());
        assertEquals("VG II", dangerousGoods.getPackagingGroup());
        assertEquals("1000 l", dangerousGoods.getTotalQuantity());
        assertEquals(TunnelRestrictionCode.NONE, dangerousGoods.getTunnelRestrictionCode());
        assertEquals("Mandatory Routing?", dangerousGoods.getMandatoryRouting());
        assertFalse(dangerousGoods.getLimitedQuantity());
        assertTrue(dangerousGoods.getMarinePollutants());
    }


    @Test
    void ensureCanBeCreatedWithAllInformationWithStepBuilder() {

        DangerousGoods dangerousGoods = DangerousGoods.newStepBuilder()
                .withUnNumber("1005")
                .withMaterial("Ammoniak")
                .withDangerNote(true)
                .withPackagingGroup("VG II")
                .withPackages(8)
                .withTotalQuantity("1000 l")
                .withTunnelRestrictionCode(TunnelRestrictionCode.NONE)
                .withMandatoryRouting("Mandatory Routing?")
                .withLimitedQuantity(false)
                .withMarinePollutants(true)
                .buildAndValidate();

        assertEquals("1005", dangerousGoods.getUnNumber());
        assertEquals("Ammoniak", dangerousGoods.getMaterial());
        assertTrue(dangerousGoods.getDangerNote());
        assertEquals("VG II", dangerousGoods.getPackagingGroup());
        assertEquals("1000 l", dangerousGoods.getTotalQuantity());
        assertEquals(TunnelRestrictionCode.NONE, dangerousGoods.getTunnelRestrictionCode());
        assertEquals("Mandatory Routing?", dangerousGoods.getMandatoryRouting());
        assertFalse(dangerousGoods.getLimitedQuantity());
        assertTrue(dangerousGoods.getMarinePollutants());
    }


    @Test
    void ensureCanBeCreatedWithMinimumRequirements() {

        DangerousGoods.newBuilder().withUnNumber("1005").buildAndValidate();
    }


    @Test
    void ensureCanBeCopied() {

        DangerousGoods dangerousGoods = DangerousGoods.newBuilder()
                .withUnNumber("1005")
                .withMaterial("Ammoniak")
                .withDangerNote(true)
                .withPackagingGroup("VG II")
                .withPackages(8)
                .withTotalQuantity("1000 l")
                .withTunnelRestrictionCode(TunnelRestrictionCode.NONE)
                .withMandatoryRouting("Mandatory Routing?")
                .withLimitedQuantity(false)
                .withMarinePollutants(true)
                .buildAndValidate();

        DangerousGoods copiedDangerousGoods = DangerousGoods.newBuilder(dangerousGoods).buildAndValidate();

        assertEquals("1005", copiedDangerousGoods.getUnNumber());
        assertEquals("Ammoniak", copiedDangerousGoods.getMaterial());
        assertTrue(copiedDangerousGoods.getDangerNote());
        assertEquals("VG II", copiedDangerousGoods.getPackagingGroup());
        assertEquals("1000 l", copiedDangerousGoods.getTotalQuantity());
        assertEquals(TunnelRestrictionCode.NONE, copiedDangerousGoods.getTunnelRestrictionCode());
        assertEquals("Mandatory Routing?", copiedDangerousGoods.getMandatoryRouting());
        assertFalse(copiedDangerousGoods.getLimitedQuantity());
        assertTrue(copiedDangerousGoods.getMarinePollutants());
    }


    @Test
    void ensureDangerousGoodsCanBeValidated() {

        assertThrows(IllegalStateException.class, () -> DangerousGoods.newBuilder().buildAndValidate());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        DangerousGoods dangerousGoods = DangerousGoods.newBuilder()
                .withUnNumber("1005")
                .withMaterial("Ammoniak")
                .withDangerNote(true)
                .withPackagingGroup("VG II")
                .withPackages(8)
                .withTotalQuantity("1000 l")
                .withTunnelRestrictionCode(TunnelRestrictionCode.NONE)
                .withMandatoryRouting("Mandatory Routing?")
                .withLimitedQuantity(false)
                .withMarinePollutants(true)
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(dangerousGoods);

        DangerousGoods deserialize = mapper.readValue(jsonString, DangerousGoods.class);

        assertEquals("1005", deserialize.getUnNumber());
        assertEquals("Ammoniak", deserialize.getMaterial());
        assertTrue(deserialize.getDangerNote());
        assertEquals("VG II", deserialize.getPackagingGroup());
        assertEquals("1000 l", deserialize.getTotalQuantity());
        assertEquals(TunnelRestrictionCode.NONE, deserialize.getTunnelRestrictionCode());
        assertEquals("Mandatory Routing?", deserialize.getMandatoryRouting());
        assertFalse(deserialize.getLimitedQuantity());
        assertTrue(deserialize.getMarinePollutants());
    }
}
