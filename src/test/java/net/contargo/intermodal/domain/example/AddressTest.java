package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.Address;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class AddressTest {

    @Test
    void ensureAddressCanBeCreated() {

        Address address = Address.AddressBuilder.newAddress()
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
}
