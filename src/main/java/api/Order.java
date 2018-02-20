package api;

public class Order {

// TODO - type: 
private Object reference;

// TODO - type: siehe Daten zu @Operator
private Operator auftraggeberMD;

// TODO - type: siehe Daten zu @Operator
private Operator rechnungsempfngerMD;

// TODO - type: {1}, siehe Daten zu @Container-Order
private Container-Order unitContainerOrderPD;

// TODO - type: 
private Object unitWare;

// TODO - type: Import, Export
private Object transportDirection;

// TODO - type: {1}
private Object transportPickUpLocationName;

// TODO - type: Loading Place, Sea-Terminal, Hinterland-Terminal 
private Object transportPickUpLocationType;

// TODO - type: Ja / nein
private Object transportPickUpUnitEmpty;

// TODO - type: 
private Object transportPickUpUnitReference;

// TODO - type: siehe Daten zu @Operator
private Operator transportPickUpUnitOperatorMD;

// TODO - type: DateTime ISO 8601 inkl. UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX.
Beispiel: 2017-06-13T13:00:00.000Z)
private Object transportPickUpEarliest;

// TODO - type: DateTime ISO 8601 inkl. UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX.
Beispiel: 2017-06-13T13:00:00.000Z)
private Object transportPickUpLatest;

// TODO - type: Means of Transport
private Object transportPickUpmot;

// TODO - type: Loading Place, Sea-Terminal, Hinterland-Terminal 
private Object transportDropOffLocationType;

// TODO - type: {1}
private Object transportDropOffLocationName;

// TODO - type: Ja / nein
private Object transportDropOffUnitEmpty;

// TODO - type: 
private Object transportDropOffUnitReference;

// TODO - type: siehe Daten zu @Operator
private Operator transportDropOffUnitOperatorMD;

// TODO - type: ug+
private Object transportDropOffEarliest;

// TODO - type: DateTime ISO 8601 inkl. UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX.
Beispiel: 2017-06-13T13:00:00.000Z)
Ggf. synonym zu „Closing“
private Object transportDropOffLatest;

// TODO - type: Means of Transport
private Object transportDropOffmot;

// TODO - type: {1-n} (auch Multistops etc.)
private Object transportStopLocationName;

// TODO - type: Loading Place, Sea-Terminal, Hinterland-Terminal, Zollstop, Verwiegung etc.
private Object transportStopLocationType;

// TODO - type: 
private Object transportStopSequence;

// TODO - type: DateTime ISO 8601 inkl. UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX.
Beispiel: 2017-06-13T13:00:00.000Z)
private Object transportStopEarliest;

// TODO - type: DateTime ISO 8601 inkl. UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX.
Beispiel: 2017-06-13T13:00:00.000Z)
private Object transportStopLatest;

// TODO - type: 
private Object transportStopReference;

// TODO - type: Means of Transport
private Object transportStopmot;

// TODO - type: 
private Object destinationVessel;

// TODO - type: 
private Object destinationSeaportName;

// TODO - type: 
private Object destinationLocationName;

// TODO - type: 
private Object destinationLocationCountry;

// TODO - type: 
private Object destinationLocationCity;

}