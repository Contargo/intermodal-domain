package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Address;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class AddressTest {

    @Test
    void ensureCanBeCreated() {

        Address address = Address.newBuilder()
                .withStreet("Gartenstraße 67")
                .withLocationPostalCode("76135")
                .withLocationCity("Karlsruhe")
                .withCountryName("Germany")
                .withCountryCode("DE")
                .buildAndValidate();

        assertEquals("Gartenstraße 67", address.getStreet());
        assertEquals("76135", address.getLocationPostalCode());
        assertEquals("Karlsruhe", address.getLocationCity());
        assertEquals("Germany", address.getCountryName());
        assertEquals("DE", address.getCountryCode());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        Address address = Address.newBuilder()
                .withStreet("Gartenstraße 67")
                .withLocationPostalCode("76135")
                .withLocationCity("Karlsruhe")
                .withCountryName("Germany")
                .withCountryCode("DE")
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(address);

        Address deserialize = mapper.readValue(jsonString, Address.class);

        assertEquals("Gartenstraße 67", deserialize.getStreet());
        assertEquals("76135", deserialize.getLocationPostalCode());
        assertEquals("Karlsruhe", deserialize.getLocationCity());
        assertEquals("Germany", deserialize.getCountryName());
        assertEquals("DE", deserialize.getCountryCode());
    }
}
