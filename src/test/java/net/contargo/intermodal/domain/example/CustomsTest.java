package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.Customs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class CustomsTest {

    @Test
    void ensureCanBeCreated() {

        Customs customs = Customs.Builder.newCustoms()
                .withCustomProcess("T1")
                .withCustomDocumentNumber("16DE1234...")
                .withSeal(false)
                .buildAndValidate();

        assertEquals("T1", customs.getCustomProcess());
        assertEquals("16DE1234...", customs.getCustomDocumentNumber());
        assertFalse(customs.getSeal());
    }
}
