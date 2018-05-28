package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.DangerousGoods;
import net.contargo.intermodal.domain.TunnelRestrictionCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class DangerousGoodsTest {

    @Test
    void ensureCanBeCreatedWithAllInformation() {

        DangerousGoods dangerousGoods = DangerousGoods.Builder.newDangerousGoods()
                .withUnNumber("1005")
                .withMaterial("Ammoniak")
                .hasDangerNote(true)
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

        DangerousGoods.Builder.newDangerousGoods().withUnNumber("1005").buildAndValidate();
    }


    @Test
    void ensureDangerousGoodsCanBeValidated() {

        assertThrows(IllegalStateException.class, () -> DangerousGoods.Builder.newDangerousGoods().buildAndValidate());
    }
}
