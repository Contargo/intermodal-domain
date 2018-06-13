package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Barge;
import net.contargo.intermodal.domain.DropOff;
import net.contargo.intermodal.domain.Operator;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class DropOffTest {

    @Test
    void ensureCanBeCreatedWithAllInformation() {

        DropOff dropOff = DropOff.newBuilder()
                .withLocation("Duisburg", "Terminal Duisburg", "terminal")
                .withLoadingUnit("63876846", false)
                .withLoadingUnitOperator(new Operator())
                .withBillingReference("98690")
                .withEarliest(Instant.parse("2018-05-14T14:00:00Z"))
                .withLatest(Instant.parse("2018-05-14T14:15:00Z"))
                .withMeansOfTransport(new Barge())
                .buildAndValidate();

        assertEquals("Duisburg", dropOff.getLocation().getCity());
        assertEquals("Terminal Duisburg", dropOff.getLocation().getDesignation());
        assertEquals("terminal", dropOff.getLocation().getType());
        assertEquals("63876846", dropOff.getLoadingUnit().getReference());
        assertFalse(dropOff.getLoadingUnit().getEmpty());
        assertEquals("98690", dropOff.getBillingReference());
        assertNotNull(dropOff.getLoadingUnit().getOperator());
        assertEquals("2018-05-14T14:00:00Z", dropOff.getEarliest().toString());
        assertEquals("2018-05-14T14:15:00Z", dropOff.getLatest().toString());
        assertNotNull(dropOff.getMot());
    }


    @Test
    void ensureCanBeCreatedWithMinimumRequirements() {

        DropOff.newBuilder()
            .withLocation("Duisburg", "Terminal Duisburg")
            .withMeansOfTransport(new Barge())
            .buildAndValidate();
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class,
            () ->
                DropOff.newBuilder()
                    .withLocation(null, "Terminal Duisburg")
                    .withMeansOfTransport(new Barge())
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                DropOff.newBuilder()
                    .withLocation("Duisburg", null)
                    .withMeansOfTransport(new Barge())
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () -> DropOff.newBuilder().withLocation("Duisburg", "Terminal Duisburg").buildAndValidate());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        DropOff dropOff = DropOff.newBuilder()
                .withLocation("Duisburg", "Terminal Duisburg", "terminal")
                .withLoadingUnit("63876846", false)
                .withLoadingUnitOperator(new Operator())
                .withBillingReference("98690")
                .withEarliest(Instant.parse("2018-05-14T14:00:00Z"))
                .withLatest(Instant.parse("2018-05-14T14:15:00Z"))
                .withMeansOfTransport(new Barge())
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(dropOff);

        DropOff deserialize = mapper.readValue(jsonString, DropOff.class);

        assertEquals("Duisburg", deserialize.getLocation().getCity());
        assertEquals("Terminal Duisburg", deserialize.getLocation().getDesignation());
        assertEquals("terminal", deserialize.getLocation().getType());
        assertEquals("63876846", deserialize.getLoadingUnit().getReference());
        assertFalse(deserialize.getLoadingUnit().getEmpty());
        assertEquals("98690", deserialize.getBillingReference());
        assertNotNull(deserialize.getLoadingUnit().getOperator());
        assertEquals("2018-05-14T14:00:00Z", deserialize.getEarliest().toString());
        assertEquals("2018-05-14T14:15:00Z", deserialize.getLatest().toString());
        assertNotNull(deserialize.getMot());
    }
}
