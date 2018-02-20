package api.registration;

public class Vehicle {

// TODO - type: siehe Daten zu @Truck (Key: Kennzeichen)
private Truck truckMD;

// TODO - type: siehe Daten zu @Chassis (Key: Kennzeichen)
private Chassis chassisMD;

// TODO - type: siehe Daten zu @Fahrer (Key: Führerscheinnummer)
private Fahrer driverMD;

// TODO - type: (vgl. §7 c GüKG) („Sofa“) 
private Object fuhrunternehmerAuftraggebenderFU;

// TODO - type: (vgl. §7 c GüKG) („Sub“)
private Object fuhrunternehmerDurchfhrenderFU;

// TODO - type: (request)
private Object deliverytime;

// TODO - type: siehe Daten zu @LE-Order
private LE-Order lUOrderPD;

}