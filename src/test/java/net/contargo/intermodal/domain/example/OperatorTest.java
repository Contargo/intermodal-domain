package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Address;
import net.contargo.intermodal.domain.Operator;
import net.contargo.intermodal.domain.TestDataCreator;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Contains examples of the creation and validation of {@link net.contargo.intermodal.domain.Operator}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class OperatorTest {

    @Test
    void ensureCanBeCreated() {

        Operator operator = Operator.newBuilder()
                .withName("Contargo")
                .withLegalForm("GmbH & Co. KG")
                .withAddress(TestDataCreator.createAddress())
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


    @Test
    void ensureCanBeCopied() {

        Operator operator = Operator.newBuilder()
                .withName("Contargo")
                .withLegalForm("GmbH & Co. KG")
                .withAddress(TestDataCreator.createAddress())
                .withVatId("DE999999999")
                .withTin("5FFF0BBBBUUUP")
                .withInsurance("Some Insurance")
                .buildAndValidate();

        Operator copiedOperator = Operator.newBuilder(operator).buildAndValidate();

        assertEquals("Contargo", copiedOperator.getName());
        assertEquals("GmbH & Co. KG", copiedOperator.getLegalForm());
        assertEquals("5FFF0BBBBUUUP", copiedOperator.getTin());
        assertEquals("DE999999999", copiedOperator.getVatId());
        assertEquals("Some Insurance", copiedOperator.getInsurance());
        assertNotNull(copiedOperator.getAddress());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        Operator operator = Operator.newBuilder()
                .withName("Contargo")
                .withLegalForm("GmbH & Co. KG")
                .withAddress(TestDataCreator.createAddress())
                .withVatId("DE999999999")
                .withTin("5FFF0BBBBUUUP")
                .withInsurance("Some Insurance")
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(operator);

        Operator deserialize = mapper.readValue(jsonString, Operator.class);

        assertEquals("Contargo", deserialize.getName());
        assertEquals("GmbH & Co. KG", deserialize.getLegalForm());
        assertEquals("5FFF0BBBBUUUP", deserialize.getTin());
        assertEquals("DE999999999", deserialize.getVatId());
        assertEquals("Some Insurance", deserialize.getInsurance());
        assertNotNull(deserialize.getAddress());
    }
}
