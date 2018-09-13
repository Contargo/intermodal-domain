package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Seaport;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class SeaportTest {

    @Test
    void ensureCanBeCreated() {

        Seaport.newBuilder().withName("DEDUI").buildAndValidate();
    }


    @Test
    void ensureCanBeCopied() {

        Seaport seaport = Seaport.newBuilder().withName("DEDUI").buildAndValidate();
        Seaport copiedSeaport = Seaport.newBuilder(seaport).buildAndValidate();

        assertEquals("DEDUI", copiedSeaport.getName());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        Seaport seaport = Seaport.newBuilder().withName("DEDUI").buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(seaport);

        Seaport deserialize = mapper.readValue(jsonString, Seaport.class);

        assertEquals("DEDUI", deserialize.getName());
    }
}
