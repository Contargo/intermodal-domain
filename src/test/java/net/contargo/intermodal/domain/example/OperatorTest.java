package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.Address;
import net.contargo.intermodal.domain.Operator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Contains examples of the creation and validation of {@link net.contargo.intermodal.domain.Operator}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class OperatorTest {

    @Test
    void ensureCanBeCreated() {

        Operator operator = Operator.OperatorBuilder.newOperator()
                .withName("Contargo")
                .withLegalForm("GmbH & Co. KG")
                .withAddress(new Address())
                .withVatId("DE999999999")
                .withTin("5FFF0BBBBUUUP")
                .withInsurance("Some Insurance")
                .buildAndValidate();

        assertEquals("Contargo", operator.getName());
        assertEquals("GmbH & Co. KG", operator.getLegalForm());
        assertEquals("5FFF0BBBBUUUP", operator.getTin());
        assertEquals("DE999999999", operator.getVatId());
        assertEquals("Some Insurance", operator.getInsurance());
        assertNotNull(operator.getAddress());
    }
}
