package api.lu;

public class Order {

// TODO - type:
    private Object reference;

// TODO - type: siehe Daten zu @Ladeeinheit (Key: LU.Number)
    private Ladeeinheit lUMD;

    private double weightBrutto;

    private double weightNetto;

    private double weightTara;

// TODO - type: ja / nein --> Aktion bei ja
    private Object dangerousGoodsIndication;

// TODO - type: ja / nein --> Aktion bei ja
    private Object wasteIndication;

// TODO - type: °C
    private Object setTemperature;

// TODO - type: siehe Daten zu @Operator (Key: Ust.-ID)
    private Operator operatorMD;

// TODO - type: siehe Daten zu @Operator (Key: Ust.-ID)
    private Operator clientMD;

// TODO - type: anliefern / abholen
    private Object direction;

// TODO - type: Verknüpfung zu Zolldaten?
    private Object mRN;

// TODO - type: {1-n}
    private Object seal;

// TODO - type:
    private Object sealType;

// TODO - type:
    private Object sealNumber;
}
