package api.loadingUnit;

public class Order {

    // TODO - type:
    private Object reference;

    // TODO - type: siehe Daten zu @Ladeeinheit (Key: LU.Number)
    private Ladeeinheit lUMd;

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
    private Operator operatorMd;

    // TODO - type: siehe Daten zu @Operator (Key: Ust.-ID)
    private Operator clientMd;

    // TODO - type: anliefern / abholen
    private Object direction;

    // TODO
    private Object customs;

    // TODO
    private Object goods;

    // TODO
    private Object empty;

    // TODO - type: {1-n}
    private Object seal;

    // TODO - type:
    private Object sealType;

    // TODO - type:
    private Object sealNumber;
}
