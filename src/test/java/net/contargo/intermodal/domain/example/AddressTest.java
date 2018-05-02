package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.Address;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class AddressTest {

    @Test
    void ensureAddressCanBeCreated() {

        Address address = new Address().withStreet("Gartenstraße 67")
                .withLocationPostalCode("76135")
                .withLocationCity("Karlsruhe")
                .withCountryName("Germany")
                .withCountryCode("DE");

        Assertions.assertEquals("Gartenstraße 67", address.getStreet());
        Assertions.assertEquals("76135", address.getLocationPostalCode());
        Assertions.assertEquals("Karlsruhe", address.getLocationCity());
        Assertions.assertEquals("Germany", address.getCountryName());
        Assertions.assertEquals("DE", address.getCountryCode());
    }
}
