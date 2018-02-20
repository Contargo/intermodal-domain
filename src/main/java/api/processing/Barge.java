package api.processing;

public class Barge {

// TODO - type: siehe Daten zu @Binnenschiff (Key: MMSI, ENI)
    private Binnenschiff bargeMD;

// TODO - type: yyyy-MM-dd'T'HH:mm:ss.SSSX
    private Object eTA;

// TODO - type: yyyy-MM-dd'T'HH:mm:ss.SSSX
    private Object eTD;

// TODO - type: {1} siehe Daten zu @Schiffsführer
    private Schiffsführer skipperMD;

// TODO - type: {1-n} siehe Daten zu @Person
    private Person passengerMD;

    private int reeferConnections;

// TODO - type:
    private Object dangerousGoodsIndication;

// TODO - type:
    private Object cone;

// TODO - type: Eignung, falls [Abfertigung.Barge.Kegel] > 0
    private Object aDNR;

// TODO - type: {1-n}, siehe Daten zu @LE.Auftrag
    private LE.Auftrag loadingListLUOrderPD;

// TODO - type: Bay/Row/Tier
    private Object loadingListStoragePosition;

// TODO - type: inkl. Zolldokumente, Reefer, GG, etc. (siehe LE)
    private Object manifest;
}
