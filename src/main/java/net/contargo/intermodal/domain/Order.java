package net.contargo.intermodal.domain;

import java.util.List;

import javax.validation.constraints.NotNull;


/**
 * Contains all data of an order.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Auftrag
 * @name_english  Order
 * @definition_german  Die komplex verknüpfte Klasse der Auftragsdaten bringt alle Daten zusammen, die zum Auftrag
 *                     gehören. Sie bildet somit eine wichtige Grundlage für die Planung und Durchführung intermodaler
 *                     Ketten nach der vorliegenden Spezifikation. Die Auftragsreferenz dient hierbei der eindeutigen
 *                     Identifizierung. Die vorliegende Gruppe unterscheidet sich deutlich zu ihren Vorgängern und ist
 *                     als komplexe Datenverknüpfung zu interpretieren. Sie kann in der Gesamtheit der relevanten
 *                     Transporteckdaten eine komplette Transportkette abbilden und bedient sich hierfür bei den zuvor
 *                     beschriebenen Datengruppen. Zunächst werden übergeordnete Auftragsdaten herangezogen.
 *                     Anschließend sind alle transportrelevanten Daten gesammelt und nach Informationen zu Abholung,
 *                     Anlieferung, Halt und Ziel geordnet.
 * @definition_english  This class combines all data of an Order. Therefore it is an important foundation for planning
 *                      and execution of intermodal chains in this specification. The order reference is used for clear
 *                      identification. This class differs much from the others and should be interpreted as complex
 *                      connection of data. It can be used to map a complete chain of transport with all of its
 *                      relevant data. It includes high level order data as well as data relevant for transport
 *                      organized by pick up, drop off, stop and destination.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Order {

    @NotNull(message = "reference is part of minimum requirement")
    private String reference;

    private Operator client;

    private Operator billRecipient;

    @NotNull(message = "luOrder is part of minimum requirement")
    private LUOrder luOrder;

    @NotNull(message = "transport is part of minimum requirement")
    @TransportConstraint(message = "must fulfill minimum requirements of transport")
    private Transport transport;

    @NotNull(message = "destination is part of minimum requirement")
    @DestinationConstraint(message = "must fulfill minimum requirements of designation")
    private Destination destination;

    public String getReference() {

        return reference;
    }


    public Operator getClient() {

        return client;
    }


    public Operator getBillRecipient() {

        return billRecipient;
    }


    public LUOrder getOrderForLoadingUnit() {

        return luOrder;
    }


    public Transport getTransport() {

        return transport;
    }


    public Transport.PickUp getPickUp() {

        return this.transport.getPickUp();
    }


    public Transport.DropOff getDropOff() {

        return this.transport.getDropOff();
    }


    public List<Stop> getStops() {

        return this.transport.getStops();
    }


    public Destination getDestination() {

        return destination;
    }

    public static final class Builder {

        private Destination destination = new Destination();
        private String reference;
        private Operator client;
        private Operator billRecipient;
        private LUOrder luOrder;
        private Transport transport = new Transport();

        private Builder() {
        }

        public static Builder newOrder() {

            return new Builder();
        }


        public Builder withReference(String reference) {

            this.reference = reference;

            return this;
        }


        public Builder withClient(Operator client) {

            this.client = client;

            return this;
        }


        public Builder withBillRecipient(Operator billRecipient) {

            this.billRecipient = billRecipient;

            return this;
        }


        public Builder withOrderForLoadingUnit(LUOrder luOrder) {

            this.luOrder = luOrder;

            return this;
        }


        public Builder withPickUpLocation(String city, String designation, String type) {

            this.transport.setPickUpLocation(city, designation, type);

            return this;
        }


        public Builder withPickUpLocation(String city, String designation) {

            this.transport.setPickUpLocation(city, designation);

            return this;
        }


        public Builder withEarliestPickUp(int year, int month, int day, int hour, int minute) {

            this.transport.setEarliestPickUp(year, month, day, hour, minute);

            return this;
        }


        public Builder withLatestPickUp(int year, int month, int day, int hour, int minute) {

            this.transport.setLatestPickUp(year, month, day, hour, minute);

            return this;
        }


        public Builder withPickUpMeansOfTransport(MeansOfTransport meansOfTransport) {

            this.transport.setPickUpMoT(meansOfTransport);

            return this;
        }


        public Builder withLoadingUnitToPickUp(String reference, Boolean isEmpty) {

            this.transport.setPickUpLoadingUnit(reference, isEmpty);

            return this;
        }


        public Builder withPickUpLoadingUnitOperator(Operator operator) {

            this.transport.setPickUpLoadingUnitOperator(operator);

            return this;
        }


        public Builder withBillingReferenceForPickUp(String billingReference) {

            this.transport.setPickUpBillingReference(billingReference);

            return this;
        }


        public Builder withDropOffLocation(String city, String designation, String type) {

            this.transport.setDropOffLocation(city, designation, type);

            return this;
        }


        public Builder withDropOffLocation(String city, String designation) {

            this.transport.setDropOffLocation(city, designation);

            return this;
        }


        public Builder withEarliestDropOff(int year, int month, int day, int hour, int minute) {

            this.transport.setEarliestDropOff(year, month, day, hour, minute);

            return this;
        }


        public Builder withLatestDropOff(int year, int month, int day, int hour, int minute) {

            this.transport.setLatestDropOff(year, month, day, hour, minute);

            return this;
        }


        public Builder withDropOffMeansOfTransport(MeansOfTransport meansOfTransport) {

            this.transport.setDropOffMoT(meansOfTransport);

            return this;
        }


        public Builder withLoadingUnitToDropOff(String reference, Boolean isEmpty) {

            this.transport.setDropOffLoadingUnit(reference, isEmpty);

            return this;
        }


        public Builder withDropOffLoadingUnitOperator(Operator operator) {

            this.transport.setDropOffLoadingUnitOperator(operator);

            return this;
        }


        public Builder withBillingReferenceForDropOff(String billingReference) {

            this.transport.setDropOffBillingReference(billingReference);

            return this;
        }


        public Builder withStop(Stop stop) {

            this.transport.addStop(stop);

            return this;
        }


        public Builder withStops(List<Stop> stops) {

            stops.forEach(stop -> this.transport.addStop(stop));

            return this;
        }


        public Builder withDestinationSeaport(String name) {

            destination.setSeaport(name);

            return this;
        }


        public Builder withDestinationVessel(Vessel vessel) {

            destination.setVessel(vessel);

            return this;
        }


        public Builder withDestinationLocation(String city, String designation) {

            destination.setLocation(city, designation);

            return this;
        }


        public Builder withDestinationLocation(String designation) {

            destination.setLocation(designation);

            return this;
        }


        public Builder withDestinationCountryCode(String countryCode) {

            destination.setCountry(countryCode);

            return this;
        }


        public Order build() {

            Order order = new Order();
            order.billRecipient = this.billRecipient;
            order.luOrder = this.luOrder;
            order.client = this.client;
            order.transport = this.transport;
            order.reference = this.reference;
            order.destination = this.destination;

            return order;
        }


        public Order buildAndValidate() {

            Order order = this.build();

            Validator.validate(order);

            return order;
        }
    }
}
