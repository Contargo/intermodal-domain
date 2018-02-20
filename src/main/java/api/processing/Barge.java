package api.processing;

public class Barge {

    // TODO - type: siehe Daten zu @Binnenschiff (Key: MMSI, ENI)
    private Binnenschiff bargeMD;

    // TODO - type: yyyy-MM-dd'T'HH:mm:ss.SSSX
    private Object eta;

    // TODO - type: yyyy-MM-dd'T'HH:mm:ss.SSSX
    private Object etd;

    // TODO - type: {1} siehe Daten zu @Schiffsführer
    private Schiffsführer skipperMd;

    // TODO - type: {1-n} siehe Daten zu @Person
    private Person passengerMd;

    private int reeferConnections;

    // TODO - type:
    private Object cone;

    // TODO - type: Eignung, falls [Abfertigung.Barge.Kegel] > 0
    private Object adnr;

    // TODO - type: {1-n}, siehe Daten zu @LE.Auftrag
    private LE.Auftrag loadingListLUOrderPd;

    // TODO - type: Bay/Row/Tier
    private Object loadingListStoragePosition;
}
