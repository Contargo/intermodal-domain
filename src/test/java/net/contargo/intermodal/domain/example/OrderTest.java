package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.*;

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

    @Test
    void ensureCanBeCreatedWithAllInformation() {

        List<Stop> stops = new ArrayList<>();
        stops.add(Stop.Builder.newStop().withLocation("Koblenz", "Terminal Koblenz").buildAndValidate());
        stops.add(Stop.Builder.newStop().withLocation("Ludwigshafen", "Terminal Ludwigshafen").buildAndValidate());

        Order order = Order.Builder.newOrder()
                .withReference("54642887")
                .withClient(new Operator())
                .withBillRecipient(new Operator())
                .withOrderForLoadingUnit(new LUOrder())
                .withTransportDirection(Direction.EXPORT)
                .withPickUpLocation("Ludwigshafen", "Terminal Ludwigshafen", "hinterland terminal")
                .withLoadingUnitToPickUp("12345", false)
                .withBillingReferenceForPickUp("20568097")
                .withPickUpLoadingUnitOperator(new Operator())
                .withEarliestPickUp(Instant.parse("2018-05-14T11:00:00Z"))
                .withLatestPickUp(Instant.parse("2018-05-14T11:30:00Z"))
                .withPickUpMeansOfTransport(new Truck())
                .withDropOffLocation("Koblenz", "Terminal Koblenz", "hinterland terminal")
                .withLoadingUnitToDropOff("63876846", false)
                .withDropOffLoadingUnitOperator(new Operator())
                .withBillingReferenceForDropOff("98690")
                .withEarliestDropOff(Instant.parse("2018-05-14T14:00:00Z"))
                .withLatestDropOff(Instant.parse("2018-05-14T14:15:00Z"))
                .withDropOffMeansOfTransport(new Barge())
                .withStops(stops)
                .withDestinationVessel(new Vessel())
                .withDestinationCountryCode("DE")
                .withDestinationLocation("Duisburg", "Terminal Duisburg")
                .withDestinationSeaport("DEDUI")
                .buildAndValidate();

        assertEquals("54642887", order.getReference());
        assertNotNull(order.getClient());
        assertNotNull(order.getBillRecipient());
        assertNotNull(order.getLuOrder());
        assertEquals(Direction.EXPORT, order.getTransportDirection());

        // Pick Up
        assertEquals("Ludwigshafen", order.getPickUp().getLocation().getCity());
        assertEquals("hinterland terminal", order.getPickUp().getLocation().getType());
        assertEquals("Terminal Ludwigshafen", order.getPickUp().getLocation().getDesignation());
        assertEquals("12345", order.getPickUp().getLoadingUnit().getReference());
        assertFalse(order.getPickUp().getLoadingUnit().isEmpty());
        assertEquals("20568097", order.getPickUp().getBillingReference());
        assertNotNull(order.getPickUp().getLoadingUnit().getOperator());

        assertEquals("2018-05-14T11:00:00Z", order.getPickUp().getEarliest().toString());
        assertEquals("2018-05-14T11:30:00Z", order.getPickUp().getLatest().toString());
        assertNotNull(order.getPickUp().getMot());

        // Drop Off
        assertEquals("Koblenz", order.getDropOff().getLocation().getCity());
        assertEquals("hinterland terminal", order.getDropOff().getLocation().getType());
        assertEquals("Terminal Koblenz", order.getDropOff().getLocation().getDesignation());
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

        Stop stop = Stop.Builder.newStop().withLocation("Koblenz", "Terminal Koblenz").buildAndValidate();

        Order order = Order.Builder.newOrder()
                .withReference("54642887")
                .withOrderForLoadingUnit(new LUOrder())
                .withPickUpLocation("Ludwigshafen", "Terminal Ludwigshafen")
                .withEarliestPickUp(Instant.parse("2018-05-14T11:00:00Z"))
                .withPickUpMeansOfTransport(new Truck())
                .withDropOffLocation("Koblenz", "Terminal Koblenz")
                .withDropOffMeansOfTransport(new Barge())
                .withStops(Arrays.asList(stop))
                .withDestinationLocation("Terminal Koblenz")
                .buildAndValidate();
    }


    @Test
    void ensureMinimumRequirementIsChecked() {

        assertThrows(IllegalStateException.class,
            () ->
                Order.Builder.newOrder()
                    .withOrderForLoadingUnit(new LUOrder())
                    .withPickUpLocation("Ludwigshafen", "Terminal Ludwigshafen")
                    .withEarliestPickUp(Instant.parse("2018-05-14T11:00:00Z"))
                    .withPickUpMeansOfTransport(new Truck())
                    .withDropOffLocation("Koblenz", "Terminal Koblenz")
                    .withDropOffMeansOfTransport(new Barge())
                    .withStops(Arrays.asList(new Stop(), new Stop()))
                    .withDestinationLocation("Terminal Koblenz")
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                Order.Builder.newOrder()
                    .withReference("54642887")
                    .withPickUpLocation("Ludwigshafen", "Terminal Ludwigshafen")
                    .withEarliestPickUp(Instant.parse("2018-05-14T11:00:00Z"))
                    .withPickUpMeansOfTransport(new Truck())
                    .withDropOffLocation("Koblenz", "Terminal Koblenz")
                    .withDropOffMeansOfTransport(new Barge())
                    .withStops(Arrays.asList(new Stop(), new Stop()))
                    .withDestinationLocation("Terminal Koblenz")
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                Order.Builder.newOrder()
                    .withReference("54642887")
                    .withOrderForLoadingUnit(new LUOrder())
                    .withEarliestPickUp(Instant.parse("2018-05-14T11:00:00Z"))
                    .withPickUpMeansOfTransport(new Truck())
                    .withDropOffLocation("Koblenz", "Terminal Koblenz")
                    .withDropOffMeansOfTransport(new Barge())
                    .withStops(Arrays.asList(new Stop(), new Stop()))
                    .withDestinationLocation("Terminal Koblenz")
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                Order.Builder.newOrder()
                    .withReference("54642887")
                    .withOrderForLoadingUnit(new LUOrder())
                    .withPickUpLocation("Ludwigshafen", "Terminal Ludwigshafen")
                    .withPickUpMeansOfTransport(new Truck())
                    .withDropOffLocation("Koblenz", "Terminal Koblenz")
                    .withDropOffMeansOfTransport(new Barge())
                    .withStops(Arrays.asList(new Stop(), new Stop()))
                    .withDestinationLocation("Terminal Koblenz")
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                Order.Builder.newOrder()
                    .withReference("54642887")
                    .withOrderForLoadingUnit(new LUOrder())
                    .withPickUpLocation("Ludwigshafen", "Terminal Ludwigshafen")
                    .withEarliestPickUp(Instant.parse("2018-05-14T11:00:00Z"))
                    .withDropOffLocation("Koblenz", "Terminal Koblenz")
                    .withDropOffMeansOfTransport(new Barge())
                    .withStops(Arrays.asList(new Stop(), new Stop()))
                    .withDestinationLocation("Terminal Koblenz")
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                Order.Builder.newOrder()
                    .withReference("54642887")
                    .withOrderForLoadingUnit(new LUOrder())
                    .withPickUpLocation("Ludwigshafen", "Terminal Ludwigshafen")
                    .withEarliestPickUp(Instant.parse("2018-05-14T11:00:00Z"))
                    .withPickUpMeansOfTransport(new Truck())
                    .withDropOffMeansOfTransport(new Barge())
                    .withStops(Arrays.asList(new Stop(), new Stop()))
                    .withDestinationLocation("Terminal Koblenz")
                    .buildAndValidate());
        assertThrows(IllegalStateException.class,
            () ->
                Order.Builder.newOrder()
                    .withReference("54642887")
                    .withOrderForLoadingUnit(new LUOrder())
                    .withPickUpLocation("Ludwigshafen", "Terminal Ludwigshafen")
                    .withEarliestPickUp(Instant.parse("2018-05-14T11:00:00Z"))
                    .withPickUpMeansOfTransport(new Truck())
                    .withDropOffLocation("Koblenz", "Terminal Koblenz")
                    .withStops(Arrays.asList(new Stop(), new Stop()))
                    .withDestinationLocation("Terminal Koblenz")
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                Order.Builder.newOrder()
                    .withReference("54642887")
                    .withOrderForLoadingUnit(new LUOrder())
                    .withPickUpLocation("Ludwigshafen", "Terminal Ludwigshafen")
                    .withEarliestPickUp(Instant.parse("2018-05-14T11:00:00Z"))
                    .withPickUpMeansOfTransport(new Truck())
                    .withDropOffLocation("Koblenz", "Terminal Koblenz")
                    .withDropOffMeansOfTransport(new Barge())
                    .withDestinationLocation("Terminal Koblenz")
                    .buildAndValidate());

        assertThrows(IllegalStateException.class,
            () ->
                Order.Builder.newOrder()
                    .withReference("54642887")
                    .withOrderForLoadingUnit(new LUOrder())
                    .withPickUpLocation("Ludwigshafen", "Terminal Ludwigshafen")
                    .withEarliestPickUp(Instant.parse("2018-05-14T11:00:00Z"))
                    .withPickUpMeansOfTransport(new Truck())
                    .withDropOffLocation("Koblenz", "Terminal Koblenz")
                    .withDropOffMeansOfTransport(new Barge())
                    .withStops(Arrays.asList(new Stop(), new Stop()))
                    .buildAndValidate());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        List<Stop> stops = new ArrayList<>();
        stops.add(Stop.Builder.newStop().withLocation("Koblenz", "Terminal Koblenz", "terminal").buildAndValidate());
        stops.add(Stop.Builder.newStop()
            .withLocation("Ludwigshafen", "Terminal Ludwigshafen", "terminal")
            .buildAndValidate());

        Order order = Order.Builder.newOrder()
                .withReference("54642887")
                .withClient(new Operator())
                .withBillRecipient(new Operator())
                .withOrderForLoadingUnit(new LUOrder())
                .withTransportDirection(Direction.EXPORT)
                .withPickUpLocation("Ludwigshafen", "Terminal Ludwigshafen", "hinterland terminal")
                .withLoadingUnitToPickUp("12345", false)
                .withBillingReferenceForPickUp("20568097")
                .withPickUpLoadingUnitOperator(new Operator())
                .withEarliestPickUp(Instant.parse("2018-05-14T11:00:00Z"))
                .withLatestPickUp(Instant.parse("2018-05-14T11:30:00Z"))
                .withPickUpMeansOfTransport(new Truck())
                .withDropOffLocation("Duisburg", "Terminal Duisburg", "terminal")
                .withLoadingUnitToDropOff("63876846", false)
                .withDropOffLoadingUnitOperator(new Operator())
                .withBillingReferenceForDropOff("98690")
                .withEarliestDropOff(Instant.parse("2018-05-14T14:00:00Z"))
                .withLatestDropOff(Instant.parse("2018-05-14T14:15:00Z"))
                .withDropOffMeansOfTransport(new Barge())
                .withStops(stops)
                .withDestinationVessel(new Vessel())
                .withDestinationCountryCode("DE")
                .withDestinationLocation("Duisburg", "Terminal Duisburg")
                .withDestinationSeaport("DEDUI")
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(order);

        System.out.print(order.toString());

        Order deserialize = mapper.readValue(jsonString, Order.class);

        assertEquals("54642887", deserialize.getReference());
        assertNotNull(deserialize.getClient());
        assertNotNull(deserialize.getBillRecipient());
        assertNotNull(deserialize.getLuOrder());
        assertEquals(Direction.EXPORT, deserialize.getTransportDirection());

        // Pick Up
        assertEquals("Ludwigshafen", deserialize.getPickUp().getLocation().getCity());
        assertEquals("hinterland terminal", deserialize.getPickUp().getLocation().getType());
        assertEquals("Terminal Ludwigshafen", deserialize.getPickUp().getLocation().getDesignation());
        assertEquals("12345", deserialize.getPickUp().getLoadingUnit().getReference());
        assertFalse(deserialize.getPickUp().getLoadingUnit().isEmpty());
        assertEquals("20568097", deserialize.getPickUp().getBillingReference());
        assertNotNull(deserialize.getPickUp().getLoadingUnit().getOperator());

        assertEquals("2018-05-14T11:00:00Z", deserialize.getPickUp().getEarliest().toString());
        assertEquals("2018-05-14T11:30:00Z", deserialize.getPickUp().getLatest().toString());
        assertNotNull(deserialize.getPickUp().getMot());

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
