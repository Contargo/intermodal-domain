package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class OrderTest {

    @Test
    void ensureCanBeCreated() {

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
                .withStops(Arrays.asList(new Stop(), new Stop(), new Stop()))
                .withDestinationVessel(new Vessel())
                .withDestinationCountryCode("DE")
                .withDestinationLocation("Koblenz", "Terminal Koblenz")
                .buildAndValidate();

        assertEquals("54642887", order.getReference());
        assertNotNull(order.getClient());
        assertNotNull(order.getBillRecipient());
        assertNotNull(order.getOrderForLoadingUnit());

        // Pick Up
        assertEquals("Ludwigshafen", order.getTransport().getPickUp().getLocation().getCity());
        assertEquals("hinterland terminal", order.getTransport().getPickUp().getLocation().getType());
        assertEquals("Terminal Ludwigshafen", order.getTransport().getPickUp().getLocation().getDesignation());
        assertEquals("12345", order.getTransport().getPickUp().getLoadingUnit().getReference());
        assertFalse(order.getTransport().getPickUp().getLoadingUnit().isEmpty());
        assertEquals("20568097", order.getTransport().getPickUp().getBillingReference());
        assertNotNull(order.getTransport().getPickUp().getLoadingUnit().getOperator());
        assertEquals("2018-05-14T11:00:00.000Z", order.getTransport().getPickUp().getEarliest());
        assertEquals("2018-05-14T11:30:00.000Z", order.getTransport().getPickUp().getLatest());
        assertNotNull(order.getTransport().getPickUp().getMot());

        // Drop Off
        assertEquals("Koblenz", order.getTransport().getDropOff().getLocation().getCity());
        assertEquals("hinterland terminal", order.getTransport().getDropOff().getLocation().getType());
        assertEquals("Terminal Koblenz", order.getTransport().getDropOff().getLocation().getDesignation());
        assertEquals("63876846", order.getTransport().getDropOff().getLoadingUnit().getReference());
        assertFalse(order.getTransport().getDropOff().getLoadingUnit().isEmpty());
        assertEquals("98690", order.getTransport().getDropOff().getBillingReference());
        assertEquals("2018-05-14T14:00:00.000Z", order.getTransport().getDropOff().getEarliest());
        assertEquals("2018-05-14T14:15:00.000Z", order.getTransport().getDropOff().getLatest());
        assertNotNull(order.getTransport().getDropOff().getMot());

        assertEquals(3, order.getTransport().getStops().size());
        assertNotNull(order.getDestination().getVessel());
        assertEquals("DE", order.getDestination().getCountryCode());
        assertEquals("Koblenz", order.getDestination().getLocation().getCity());
        assertEquals("Terminal Koblenz", order.getDestination().getLocation().getDesignation());
    }


    @Test
    void ensureMissingMandatoryInformationIsDetected() {
    }
}
