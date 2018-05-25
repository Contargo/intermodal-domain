package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.Customs;
import net.contargo.intermodal.domain.Seal;

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
                .withSeal(Seal.Builder.newSeal().withNumber("42").withType("some seal type").build())
                .buildAndValidate();

        assertEquals("T1", customs.getCustomProcess());
        assertEquals("16DE1234...", customs.getCustomDocumentNumber());
        assertEquals("42", customs.getSeal().getNumber());
        assertEquals("some seal type", customs.getSeal().getType());
    }
}
