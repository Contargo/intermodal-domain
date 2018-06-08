package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Operator;
import net.contargo.intermodal.domain.Vessel;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class VesselTest {

    @Test
    void ensureCanBeCreated() {

        Vessel vessel = Vessel.newBuilder()
                .withName("My Vessel")
                .withMmsi("021112345")
                .withImo("050XXXXX")
                .withOperator(new Operator())
                .buildAndValidate();

        assertEquals("My Vessel", vessel.getName());
        assertEquals("021112345", vessel.getMmsi());
        assertEquals("050XXXXX", vessel.getImo());
        assertNotNull(vessel.getOperator());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        Vessel vessel = Vessel.newBuilder()
                .withName("My Vessel")
                .withMmsi("021112345")
                .withImo("050XXXXX")
                .withOperator(new Operator())
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(vessel);

        Vessel deserialize = mapper.readValue(jsonString, Vessel.class);

        assertEquals("My Vessel", deserialize.getName());
        assertEquals("021112345", deserialize.getMmsi());
        assertEquals("050XXXXX", deserialize.getImo());
        assertNotNull(deserialize.getOperator());
    }
}
