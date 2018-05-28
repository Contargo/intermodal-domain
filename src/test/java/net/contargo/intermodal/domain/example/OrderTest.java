package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.*;

import org.junit.jupiter.api.Test;

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
        stops.add(Stop.Builder.newStop().withLocation("Wörth", "Terminal Wörth").buildAndValidate());
        stops.add(Stop.Builder.newStop().withLocation("Ludwigshafen", "Terminal Ludwigshafen").buildAndValidate());

        Order order = Order.Builder.newOrder()
                .withReference("54642887")
                .withClient(new Operator())
                .withBillRecipient(new Operator())
                .withOrderForLoadingUnit(new LUOrder())
                .withPickUpLocation("Ludwigshafen", "Terminal Ludwigshafen", "hinterland terminal")
                .withLoadingUnitToPickUp("12345", false)
                .withBillingReferenceForPickUp("20568097")
                .withPickUpLoadingUnitOperator(new Operator())
                .withEarliestPickUp(2018, 5, 14, 11, 0)
                .withLatestPickUp(2018, 5, 14, 11, 30)
                .withPickUpMeansOfTransport(new Truck())
                .withDropOffLocation("Koblenz", "Terminal Koblenz", "hinterland terminal")
                .withLoadingUnitToDropOff("63876846", false)
                .withDropOffLoadingUnitOperator(new Operator())
                .withBillingReferenceForDropOff("98690")
                .withEarliestDropOff(2018, 5, 14, 14, 0)
                .withLatestDropOff(2018, 5, 14, 14, 15)
                .withDropOffMeansOfTransport(new Barge())
                .withStops(stops)
                .withDestinationVessel(new Vessel())
                .withDestinationCountryCode("DE")
                .withDestinationLocation("Koblenz", "Terminal Koblenz")
                .withDestinationSeaport("Koblenz")
                .buildAndValidate();

        assertEquals("54642887", order.getReference());
        assertNotNull(order.getClient());
        assertNotNull(order.getBillRecipient());
        assertNotNull(order.getOrderForLoadingUnit());

        // Pick Up
        assertEquals("Ludwigshafen", order.getPickUp().getLocation().getCity());
        assertEquals("hinterland terminal", order.getPickUp().getLocation().getType());
        assertEquals("Terminal Ludwigshafen", order.getPickUp().getLocation().getDesignation());
        assertEquals("12345", order.getPickUp().getLoadingUnit().getReference());
        assertFalse(order.getPickUp().getLoadingUnit().isEmpty());
        assertEquals("20568097", order.getPickUp().getBillingReference());
        assertNotNull(order.getPickUp().getLoadingUnit().getOperator());

        assertEquals("2018-05-14T11:00:00", order.getPickUp().getEarliest());
        assertEquals("2018-05-14T11:30:00", order.getPickUp().getLatest());
        assertNotNull(order.getPickUp().getMot());

        // Drop Off
        assertEquals("Koblenz", order.getDropOff().getLocation().getCity());
        assertEquals("hinterland terminal", order.getDropOff().getLocation().getType());
        assertEquals("Terminal Koblenz", order.getDropOff().getLocation().getDesignation());
        assertEquals("63876846", order.getDropOff().getLoadingUnit().getReference());
        assertFalse(order.getDropOff().getLoadingUnit().isEmpty());
        assertEquals("98690", order.getDropOff().getBillingReference());

        assertEquals("2018-05-14T14:00:00", order.getDropOff().getEarliest());
        assertEquals("2018-05-14T14:15:00", order.getDropOff().getLatest());
        assertNotNull(order.getDropOff().getMot());

        assertEquals(3, order.getStops().size());
        assertNotNull(order.getDestination().getVessel());
        assertEquals("DE", order.getDestination().getCountryCode());
        assertEquals("Koblenz", order.getDestination().getLocation().getCity());
        assertEquals("Terminal Koblenz", order.getDestination().getLocation().getDesignation());
    }


    @Test
    void ensureCanBeCreatedWithMinimumRequirements() {

        Stop stop = Stop.Builder.newStop().withLocation("Koblenz", "Terminal Koblenz").buildAndValidate();

        Order.Builder.newOrder()
            .withReference("54642887")
            .withOrderForLoadingUnit(new LUOrder())
            .withPickUpLocation("Ludwigshafen", "Terminal Ludwigshafen")
            .withEarliestPickUp(2018, 5, 14, 11, 0)
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
                    .withEarliestPickUp(2018, 5, 14, 11, 0)
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
                    .withEarliestPickUp(2018, 5, 14, 11, 0)
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
                    .withEarliestPickUp(2018, 5, 14, 11, 0)
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
                    .withEarliestPickUp(2018, 5, 14, 11, 0)
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
                    .withEarliestPickUp(2018, 5, 14, 11, 0)
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
                    .withEarliestPickUp(2018, 5, 14, 11, 0)
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
                    .withEarliestPickUp(2018, 5, 14, 11, 0)
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
                    .withEarliestPickUp(2018, 5, 14, 11, 0)
                    .withPickUpMeansOfTransport(new Truck())
                    .withDropOffLocation("Koblenz", "Terminal Koblenz")
                    .withDropOffMeansOfTransport(new Barge())
                    .withStops(Arrays.asList(new Stop(), new Stop()))
                    .buildAndValidate());
    }
}
