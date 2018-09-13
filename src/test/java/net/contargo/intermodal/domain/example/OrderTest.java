package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.time.Instant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class OrderTest {

    private Location terminalKoblenz;
    private Location terminalLudwigshafen;
    private Location terminalDuisburg;

    @BeforeEach
    void setUp() {

        terminalKoblenz = Location.newBuilder()
                .withCity("Koblenz")
                .withDesignation("Terminal Koblenz")
                .buildAndValidate();

        terminalLudwigshafen = Location.newBuilder()
                .withCity("Ludwigshafen")
                .withDesignation("Terminal Ludwigshafen")
                .withType("terminal")
                .buildAndValidate();

        terminalDuisburg = Location.newBuilder()
                .withCity("Duisburg")
                .withDesignation("Terminal Duisburg")
                .withType("terminal")
                .buildAndValidate();
    }


    @Test
    void ensureCanBeCreatedWithAllInformation() {

        List<Stop> stops = new ArrayList<>();
        stops.add(Stop.newBuilder().withLocation(terminalKoblenz).buildAndValidate());
        stops.add(Stop.newBuilder()
            .withLocation(
                    Location.newBuilder()
                        .withCity("Ludwigshafen")
                        .withDesignation("Terminal Ludwigshafen")
                        .buildAndValidate())
            .buildAndValidate());

        PickUp pickUp = PickUp.newBuilder()
                .withLocation(terminalLudwigshafen)
                .withLoadingUnit("12345", false)
                .withBillingReference("20568097")
                .withLoadingUnitOperator(TestDataCreator.createOperator())
                .withEarliest(Instant.parse("2018-05-14T11:00:00Z"))
                .withLatest(Instant.parse("2018-05-14T11:30:00Z"))
                .withMeansOfTransport(TestDataCreator.createBarge())
                .buildAndValidate();

        DropOff dropOff = DropOff.newBuilder()
                .withLocation(terminalDuisburg)
                .withLoadingUnit("63876846", false)
                .withLoadingUnitOperator(TestDataCreator.createOperator())
                .withBillingReference("98690")
                .withEarliest(Instant.parse("2018-05-14T14:00:00Z"))
                .withLatest(Instant.parse("2018-05-14T14:15:00Z"))
                .withMeansOfTransport(TestDataCreator.createBarge())
                .buildAndValidate();

        Destination destination = Destination.newBuilder()
                .withVessel(TestDataCreator.createVessel())
                .withCountryCode("DE")
                .withLocation(terminalDuisburg)
                .withSeaport(TestDataCreator.createSeaport())
                .buildAndValidate();

        Order order = Order.newBuilder()
                .withReference("54642887")
                .withClient(TestDataCreator.createOperator())
                .withBillRecipient(TestDataCreator.createOperator())
                .withOrderForLoadingUnit(TestDataCreator.createLUOrder())
                .withTransportDirection(Direction.EXPORT)
                .withTransportPickUp(pickUp)
                .withTransportDropOff(dropOff)
                .withStops(stops)
                .withDestination(destination)
                .buildAndValidate();

        assertEquals("54642887", order.getReference());
        assertNotNull(order.getClient());
        assertNotNull(order.getBillRecipient());
        assertNotNull(order.getLuOrder());
        assertEquals(Direction.EXPORT, order.getTransportDirection());

        // Pick Up
        assertEquals("Ludwigshafen", order.getPickUp().getLocation().getCity());
        assertEquals("terminal", order.getPickUp().getLocation().getType());
        assertEquals("Terminal Ludwigshafen", order.getPickUp().getLocation().getDesignation());
        assertEquals("12345", order.getPickUp().getLoadingUnit().getReference());
        assertFalse(order.getPickUp().getLoadingUnit().isEmpty());
        assertEquals("20568097", order.getPickUp().getBillingReference());
        assertNotNull(order.getPickUp().getLoadingUnit().getOperator());

        assertEquals("2018-05-14T11:00:00Z", order.getPickUp().getEarliest().toString());
        assertEquals("2018-05-14T11:30:00Z", order.getPickUp().getLatest().toString());
        assertNotNull(order.getPickUp().getMeansOfTransport());

        // Drop Off
        assertEquals("Duisburg", order.getDropOff().getLocation().getCity());
        assertEquals("terminal", order.getDropOff().getLocation().getType());
        assertEquals("Terminal Duisburg", order.getDropOff().getLocation().getDesignation());
        assertEquals("63876846", order.getDropOff().getLoadingUnit().getReference());
        assertFalse(order.getDropOff().getLoadingUnit().isEmpty());
        assertEquals("98690", order.getDropOff().getBillingReference());

        assertEquals("2018-05-14T14:00:00Z", order.getDropOff().getEarliest().toString());
        assertEquals("2018-05-14T14:15:00Z", order.getDropOff().getLatest().toString());
        assertNotNull(order.getDropOff().getMot());

        assertEquals(2, order.getStops().size());
        assertNotNull(order.getDestination().getVessel());
        assertEquals("DE", order.getDestination().getCountryCode());
        assertEquals("Duisburg", order.getDestination().getLocation().getCity());
        assertEquals("Terminal Duisburg", order.getDestination().getLocation().getDesignation());
        assertEquals("DEDUI", order.getDestination().getSeaportName());
    }


    @Test
    void ensureCanBeCreatedWithAllInformationWithStepBuilder() {

        List<Stop> stops = new ArrayList<>();
        stops.add(Stop.newBuilder().withLocation(terminalKoblenz).buildAndValidate());
        stops.add(Stop.newBuilder()
            .withLocation(
                    Location.newBuilder()
                        .withCity("Ludwigshafen")
                        .withDesignation("Terminal Ludwigshafen")
                        .buildAndValidate())
            .buildAndValidate());

        PickUp pickUp = PickUp.newBuilder()
                .withLocation(terminalLudwigshafen)
                .withLoadingUnit("12345", false)
                .withBillingReference("20568097")
                .withLoadingUnitOperator(TestDataCreator.createOperator())
                .withEarliest(Instant.parse("2018-05-14T11:00:00Z"))
                .withLatest(Instant.parse("2018-05-14T11:30:00Z"))
                .withMeansOfTransport(TestDataCreator.createBarge())
                .buildAndValidate();

        DropOff dropOff = DropOff.newBuilder()
                .withLocation(terminalDuisburg)
                .withLoadingUnit("63876846", false)
                .withLoadingUnitOperator(TestDataCreator.createOperator())
                .withBillingReference("98690")
                .withEarliest(Instant.parse("2018-05-14T14:00:00Z"))
                .withLatest(Instant.parse("2018-05-14T14:15:00Z"))
                .withMeansOfTransport(TestDataCreator.createBarge())
                .buildAndValidate();

        Destination destination = Destination.newBuilder()
                .withVessel(TestDataCreator.createVessel())
                .withCountryCode("DE")
                .withLocation(terminalDuisburg)
                .withSeaport(TestDataCreator.createSeaport())
                .buildAndValidate();

        Order order = Order.newStepBuilder()
                .withReference("54642887")
                .withOrdersForLoadingUnit(Arrays.asList(TestDataCreator.createLUOrder()))
                .withTransportPickUp(pickUp)
                .withTransportDropOff(dropOff)
                .withTransportStops(stops)
                .withDestination(destination)
                .withTransportDirection(Direction.EXPORT)
                .withClient(TestDataCreator.createOperator())
                .withBillRecipient(TestDataCreator.createOperator())
                .buildAndValidate();

        assertEquals("54642887", order.getReference());
        assertNotNull(order.getClient());
        assertNotNull(order.getBillRecipient());
        assertNotNull(order.getLuOrder());
        assertEquals(Direction.EXPORT, order.getTransportDirection());

        // Pick Up
        assertEquals("Ludwigshafen", order.getPickUp().getLocation().getCity());
        assertEquals("terminal", order.getPickUp().getLocation().getType());
        assertEquals("Terminal Ludwigshafen", order.getPickUp().getLocation().getDesignation());
        assertEquals("12345", order.getPickUp().getLoadingUnit().getReference());
        assertFalse(order.getPickUp().getLoadingUnit().isEmpty());
        assertEquals("20568097", order.getPickUp().getBillingReference());
        assertNotNull(order.getPickUp().getLoadingUnit().getOperator());

        assertEquals("2018-05-14T11:00:00Z", order.getPickUp().getEarliest().toString());
        assertEquals("2018-05-14T11:30:00Z", order.getPickUp().getLatest().toString());
        assertNotNull(order.getPickUp().getMeansOfTransport());

        // Drop Off
        assertEquals("Duisburg", order.getDropOff().getLocation().getCity());
        assertEquals("terminal", order.getDropOff().getLocation().getType());
        assertEquals("Terminal Duisburg", order.getDropOff().getLocation().getDesignation());
        assertEquals("63876846", order.getDropOff().getLoadingUnit().getReference());
        assertFalse(order.getDropOff().getLoadingUnit().isEmpty());
        assertEquals("98690", order.getDropOff().getBillingReference());

        assertEquals("2018-05-14T14:00:00Z", order.getDropOff().getEarliest().toString());
        assertEquals("2018-05-14T14:15:00Z", order.getDropOff().getLatest().toString());
        assertNotNull(order.getDropOff().getMot());

        assertEquals(2, order.getStops().size());
        assertNotNull(order.getDestination().getVessel());
        assertEquals("DE", order.getDestination().getCountryCode());
        assertEquals("Duisburg", order.getDestination().getLocation().getCity());
        assertEquals("Terminal Duisburg", order.getDestination().getLocation().getDesignation());
        assertEquals("DEDUI", order.getDestination().getSeaportName());
    }


    @Test
    void ensureCanBeCreatedWithMinimumRequirements() {

        PickUp pickUp = PickUp.newBuilder()
                .withLocation(terminalLudwigshafen)
                .withEarliest(Instant.parse("2018-05-14T11:00:00Z"))
                .withMeansOfTransport(TestDataCreator.createBarge())
                .buildAndValidate();

        DropOff dropOff = DropOff.newBuilder()
                .withLocation(terminalKoblenz)
                .withMeansOfTransport(TestDataCreator.createBarge())
                .buildAndValidate();

        Stop stop = Stop.newBuilder().withLocation(terminalKoblenz).buildAndValidate();

        Destination destination = Destination.newBuilder().withLocation(terminalKoblenz).buildAndValidate();

        Order order = Order.newBuilder()
                .withReference("54642887")
                .withOrderForLoadingUnit(TestDataCreator.createLUOrder())
                .withTransportPickUp(pickUp)
                .withTransportDropOff(dropOff)
                .withStops(Arrays.asList(stop))
                .withDestination(destination)
                .buildAndValidate();
    }


    @Test
    void ensureCanBeCopied() {

        List<Stop> stops = new ArrayList<>();
        stops.add(Stop.newBuilder().withLocation(terminalKoblenz).buildAndValidate());
        stops.add(Stop.newBuilder().withLocation(terminalLudwigshafen).buildAndValidate());

        PickUp pickUp = PickUp.newBuilder()
                .withLocation(terminalLudwigshafen)
                .withLoadingUnit("12345", false)
                .withBillingReference("20568097")
                .withLoadingUnitOperator(TestDataCreator.createOperator())
                .withEarliest(Instant.parse("2018-05-14T11:00:00Z"))
                .withLatest(Instant.parse("2018-05-14T11:30:00Z"))
                .withMeansOfTransport(TestDataCreator.createBarge())
                .buildAndValidate();

        DropOff dropOff = DropOff.newBuilder()
                .withLocation(terminalDuisburg)
                .withLoadingUnit("63876846", false)
                .withLoadingUnitOperator(TestDataCreator.createOperator())
                .withBillingReference("98690")
                .withEarliest(Instant.parse("2018-05-14T14:00:00Z"))
                .withLatest(Instant.parse("2018-05-14T14:15:00Z"))
                .withMeansOfTransport(TestDataCreator.createBarge())
                .buildAndValidate();

        Destination destination = Destination.newBuilder()
                .withVessel(TestDataCreator.createVessel())
                .withCountryCode("DE")
                .withLocation(terminalDuisburg)
                .withSeaport(TestDataCreator.createSeaport())
                .buildAndValidate();

        Order order = Order.newBuilder()
                .withReference("54642887")
                .withClient(TestDataCreator.createOperator())
                .withBillRecipient(TestDataCreator.createOperator())
                .withOrderForLoadingUnit(TestDataCreator.createLUOrder())
                .withTransportDirection(Direction.EXPORT)
                .withTransportPickUp(pickUp)
                .withTransportDropOff(dropOff)
                .withStops(stops)
                .withDestination(destination)
                .buildAndValidate();

        Order copiedOrder = Order.newBuilder(order).buildAndValidate();

        assertEquals("54642887", copiedOrder.getReference());
        assertNotNull(copiedOrder.getClient());
        assertNotNull(copiedOrder.getBillRecipient());
        assertNotNull(copiedOrder.getLuOrder());
        assertEquals(Direction.EXPORT, copiedOrder.getTransportDirection());

        // Pick Up
        assertEquals("Ludwigshafen", copiedOrder.getPickUp().getLocation().getCity());
        assertEquals("terminal", copiedOrder.getPickUp().getLocation().getType());
        assertEquals("Terminal Ludwigshafen", copiedOrder.getPickUp().getLocation().getDesignation());
        assertEquals("12345", copiedOrder.getPickUp().getLoadingUnit().getReference());
        assertFalse(copiedOrder.getPickUp().getLoadingUnit().isEmpty());
        assertEquals("20568097", copiedOrder.getPickUp().getBillingReference());
        assertNotNull(copiedOrder.getPickUp().getLoadingUnit().getOperator());

        assertEquals("2018-05-14T11:00:00Z", copiedOrder.getPickUp().getEarliest().toString());
        assertEquals("2018-05-14T11:30:00Z", copiedOrder.getPickUp().getLatest().toString());
        assertNotNull(order.getPickUp().getMeansOfTransport());

        // Drop Off
        assertEquals("Duisburg", copiedOrder.getDropOff().getLocation().getCity());
        assertEquals("terminal", copiedOrder.getDropOff().getLocation().getType());
        assertEquals("Terminal Duisburg", copiedOrder.getDropOff().getLocation().getDesignation());
        assertEquals("63876846", copiedOrder.getDropOff().getLoadingUnit().getReference());
        assertFalse(copiedOrder.getDropOff().getLoadingUnit().isEmpty());
        assertEquals("98690", copiedOrder.getDropOff().getBillingReference());

        assertEquals("2018-05-14T14:00:00Z", copiedOrder.getDropOff().getEarliest().toString());
        assertEquals("2018-05-14T14:15:00Z", copiedOrder.getDropOff().getLatest().toString());
        assertNotNull(order.getDropOff().getMot());

        assertEquals(2, copiedOrder.getStops().size());
        assertNotNull(copiedOrder.getDestination().getVessel());
        assertEquals("DE", copiedOrder.getDestination().getCountryCode());
        assertEquals("Duisburg", copiedOrder.getDestination().getLocation().getCity());
        assertEquals("Terminal Duisburg", copiedOrder.getDestination().getLocation().getDesignation());
        assertEquals("DEDUI", copiedOrder.getDestination().getSeaportName());
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        PickUp pickUp = PickUp.newBuilder()
                .withLocation(terminalLudwigshafen)
                .withEarliest(Instant.parse("2018-05-14T11:00:00Z"))
                .withMeansOfTransport(TestDataCreator.createBarge())
                .buildAndValidate();

        DropOff dropOff = DropOff.newBuilder()
                .withLocation(terminalKoblenz)
                .withMeansOfTransport(TestDataCreator.createBarge())
                .buildAndValidate();

        Destination destination = Destination.newBuilder().withLocation(terminalKoblenz).buildAndValidate();

        assertThrows(IllegalStateException.class,
            () ->
                Order.newBuilder()
                    .withOrderForLoadingUnit(TestDataCreator.createLUOrder())
                    .withTransportPickUp(pickUp)
                    .withTransportDropOff(dropOff)
                    .withStops(Arrays.asList(TestDataCreator.createStop(), TestDataCreator.createStop()))
                    .withDestination(destination)
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                Order.newBuilder()
                    .withReference("54642887")
                    .withTransportPickUp(pickUp)
                    .withTransportDropOff(dropOff)
                    .withStops(Arrays.asList(TestDataCreator.createStop(), TestDataCreator.createStop()))
                    .withDestination(destination)
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                Order.newBuilder()
                    .withReference("54642887")
                    .withOrderForLoadingUnit(TestDataCreator.createLUOrder())
                    .withTransportDropOff(dropOff)
                    .withStops(Arrays.asList(TestDataCreator.createStop(), TestDataCreator.createStop()))
                    .withDestination(destination)
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                Order.newBuilder()
                    .withReference("54642887")
                    .withOrderForLoadingUnit(TestDataCreator.createLUOrder())
                    .withTransportDropOff(dropOff)
                    .withStops(Arrays.asList(TestDataCreator.createStop(), TestDataCreator.createStop()))
                    .withDestination(destination)
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                Order.newBuilder()
                    .withReference("54642887")
                    .withOrderForLoadingUnit(TestDataCreator.createLUOrder())
                    .withTransportPickUp(pickUp)
                    .withTransportDropOff(dropOff)
                    .withDestination(destination)
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                Order.newBuilder()
                    .withReference("54642887")
                    .withOrderForLoadingUnit(TestDataCreator.createLUOrder())
                    .withTransportPickUp(pickUp)
                    .withTransportDropOff(dropOff)
                    .withStops(Arrays.asList(TestDataCreator.createStop(), TestDataCreator.createStop()))
                    .buildAndValidate());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        List<Stop> stops = new ArrayList<>();
        stops.add(Stop.newBuilder().withLocation(terminalKoblenz).buildAndValidate());
        stops.add(Stop.newBuilder().withLocation(terminalLudwigshafen).buildAndValidate());

        PickUp pickUp = PickUp.newBuilder()
                .withLocation(terminalLudwigshafen)
                .withLoadingUnit("12345", false)
                .withBillingReference("20568097")
                .withLoadingUnitOperator(TestDataCreator.createOperator())
                .withEarliest(Instant.parse("2018-05-14T11:00:00Z"))
                .withLatest(Instant.parse("2018-05-14T11:30:00Z"))
                .withMeansOfTransport(TestDataCreator.createTruckChassisCombination())
                .buildAndValidate();

        DropOff dropOff = DropOff.newBuilder()
                .withLocation(terminalDuisburg)
                .withLoadingUnit("63876846", false)
                .withLoadingUnitOperator(TestDataCreator.createOperator())
                .withBillingReference("98690")
                .withEarliest(Instant.parse("2018-05-14T14:00:00Z"))
                .withLatest(Instant.parse("2018-05-14T14:15:00Z"))
                .withMeansOfTransport(TestDataCreator.createTruckChassisCombination())
                .buildAndValidate();

        Destination destination = Destination.newBuilder()
                .withVessel(TestDataCreator.createVessel())
                .withCountryCode("DE")
                .withLocation(terminalDuisburg)
                .withSeaport(TestDataCreator.createSeaport())
                .buildAndValidate();

        Order order = Order.newBuilder()
                .withReference("54642887")
                .withClient(TestDataCreator.createOperator())
                .withBillRecipient(TestDataCreator.createOperator())
                .withOrderForLoadingUnit(TestDataCreator.createLUOrder())
                .withTransportDirection(Direction.EXPORT)
                .withTransportPickUp(pickUp)
                .withTransportDropOff(dropOff)
                .withStops(stops)
                .withDestination(destination)
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(order);

        Order deserialize = mapper.readValue(jsonString, Order.class);

        assertEquals("54642887", deserialize.getReference());
        assertNotNull(deserialize.getClient());
        assertNotNull(deserialize.getBillRecipient());
        assertNotNull(deserialize.getLuOrder());
        assertEquals(Direction.EXPORT, deserialize.getTransportDirection());

        // Pick Up
        assertEquals("Ludwigshafen", deserialize.getPickUp().getLocation().getCity());
        assertEquals("terminal", deserialize.getPickUp().getLocation().getType());
        assertEquals("Terminal Ludwigshafen", deserialize.getPickUp().getLocation().getDesignation());
        assertEquals("12345", deserialize.getPickUp().getLoadingUnit().getReference());
        assertFalse(deserialize.getPickUp().getLoadingUnit().isEmpty());
        assertEquals("20568097", deserialize.getPickUp().getBillingReference());
        assertNotNull(deserialize.getPickUp().getLoadingUnit().getOperator());

        assertEquals("2018-05-14T11:00:00Z", deserialize.getPickUp().getEarliest().toString());
        assertEquals("2018-05-14T11:30:00Z", deserialize.getPickUp().getLatest().toString());
        assertNotNull(deserialize.getPickUp().getMeansOfTransport());

        // Drop Off
        assertEquals("Duisburg", deserialize.getDropOff().getLocation().getCity());
        assertEquals("terminal", deserialize.getDropOff().getLocation().getType());
        assertEquals("Terminal Duisburg", deserialize.getDropOff().getLocation().getDesignation());
        assertEquals("63876846", deserialize.getDropOff().getLoadingUnit().getReference());
        assertFalse(deserialize.getDropOff().getLoadingUnit().isEmpty());
        assertEquals("98690", deserialize.getDropOff().getBillingReference());

        assertEquals("2018-05-14T14:00:00Z", deserialize.getDropOff().getEarliest().toString());
        assertEquals("2018-05-14T14:15:00Z", deserialize.getDropOff().getLatest().toString());
        assertNotNull(deserialize.getDropOff().getMot());

        assertEquals(2, deserialize.getStops().size());
        assertNotNull(deserialize.getDestination().getVessel());
        assertEquals("DE", deserialize.getDestination().getCountryCode());
        assertEquals("Duisburg", deserialize.getDestination().getLocation().getCity());
        assertEquals("Terminal Duisburg", deserialize.getDestination().getLocation().getDesignation());
        assertEquals("DEDUI", deserialize.getDestination().getSeaportName());
    }
}
