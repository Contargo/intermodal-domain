package api.transport;

public class Order {

    // TODO - type:
    private Object reference;

    // TODO - type: siehe Daten zu @Operator
    private Operator clientMd;

    // TODO - type: siehe Daten zu @Operator
    private Operator billRecipient;

    // TODO
    private Object luOrderPd;

    // TODO
    private Object transportDirection;

    // TODO
    private Object transportPickUpLocationCity;

    // TODO
    private Object transportPickUpLocationDesignation;

    // TODO
    private Object transportPickUpLocationType;

    // TODO
    private boolean transportPickUpLuEmpty;

    // TODO - type:
    private Object transportPickUpUnitReference;

    // TODO
    private Object transportPickUpBillingReference;

    // TODO - type: siehe Daten zu @Operator
    private Operator transportPickUpUnitOperatorMd;

    // TODO - type: DateTime ISO 8601 inkl. UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX. Beispiel:2017-06-13T13:00:00.000Z)
    private Object transportPickUpEarliest;

    // TODO - type: DateTime ISO 8601 inkl. UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX. Beispiel:2017-06-13T13:00:00.000Z)
    private Object transportPickUpLatest;

    // TODO - type: Means of Transport
    private Object transportPickUpMot;

    // TODO - type: Loading Place, Sea-Terminal, Hinterland-Terminal
    private Object transportDropOffLocationCity;

    // TODO - type: {1}
    private Object transportDropOffLocationDesignation;

    // TODO
    private Object transportDropOffLocationType;

    // TODO - type: Ja / nein
    private Object transportDropOffUnitEmpty;

    // TODO - type:
    private Object transportDropOffUnitReference;

    // TODO - type:
    private Object transportDropOffBillingReference;

    // TODO - type: siehe Daten zu @Operator
    private Operator transportDropOffUnitOperatorMd;

    // TODO - type: ug+
    private Object transportDropOffEarliest;

    // TODO - type: DateTime ISO 8601 inkl. UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX. Beispiel:2017-06-13T13:00:00.000Z) Ggf.synonym zu „Closing“
    private Object transportDropOffLatest;

    // TODO - type: Means of Transport
    private Object transportDropOffMot;

    // TODO - type: {1-n} (auch Multistops etc.)
    private Object transportStopLocation;

    // TODO - type: {1-n} (auch Multistops etc.)
    private Object transportStopLocationCity;

    // TODO - type: {1-n} (auch Multistops etc.)
    private Object transportStopLocationDesignation;

    // TODO - type: Loading Place, Sea-Terminal, Hinterland-Terminal, Zollstop, Verwiegung etc.
    private Object transportStopLocationType;

    // TODO - type:
    private Object transportStopSequence;

    // TODO - type: DateTime ISO 8601 inkl. UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX. Beispiel:2017-06-13T13:00:00.000Z)
    private Object transportStopEarliest;

    // TODO - type: DateTime ISO 8601 inkl. UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX. Beispiel:2017-06-13T13:00:00.000Z)
    private Object transportStopLatest;

    // TODO - type:
    private Object transportStopReference;

    // TODO - type: Means of Transport
    private Object transportStopMot;

    // TODO - type:
    private Object destinationVessel;

    // TODO - type:
    private Object destinationSeaportName;

    // TODO - type:
    private Object destinationLocationDesignation;

    // TODO - type:
    private Object destinationCountryCode;

    // TODO - type:
    private Object destinationLocationCity;
}
