package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Customs;
import net.contargo.intermodal.domain.Seal;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class CustomsTest {

    @Test
    void ensureCanBeCreated() {

        Customs customs = Customs.newBuilder()
                .withCustomProcess("T1")
                .withCustomDocumentNumber("16DE1234...")
                .withSeal(Seal.newBuilder().withNumber("42").withType("some seal type").build())
                .buildAndValidate();

        assertEquals("T1", customs.getCustomProcess());
        assertEquals("16DE1234...", customs.getCustomDocumentNumber());
        assertEquals("42", customs.getSeal().getNumber());
        assertEquals("some seal type", customs.getSeal().getType());
    }


    @Test
    void ensureCanBeCopied() {

        Customs customs = Customs.newBuilder()
                .withCustomProcess("T1")
                .withCustomDocumentNumber("16DE1234...")
                .withSeal(Seal.newBuilder().withNumber("42").withType("some seal type").build())
                .buildAndValidate();

        Customs copiedCustoms = Customs.newBuilder(customs).buildAndValidate();

        assertEquals("T1", copiedCustoms.getCustomProcess());
        assertEquals("16DE1234...", copiedCustoms.getCustomDocumentNumber());
        assertEquals("42", copiedCustoms.getSeal().getNumber());
        assertEquals("some seal type", copiedCustoms.getSeal().getType());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        Customs customs = Customs.newBuilder()
                .withCustomProcess("T1")
                .withCustomDocumentNumber("16DE1234...")
                .withSeal(Seal.newBuilder().withNumber("42").withType("some seal type").build())
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(customs);

        Customs deserialize = mapper.readValue(jsonString, Customs.class);

        assertEquals("T1", deserialize.getCustomProcess());
        assertEquals("16DE1234...", deserialize.getCustomDocumentNumber());
        assertEquals("42", deserialize.getSeal().getNumber());
        assertEquals("some seal type", deserialize.getSeal().getType());
    }
}
