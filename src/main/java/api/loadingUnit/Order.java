package api.loadingUnit;

public class Order {

    // TODO - type: ?
    private Object reference;

    private LoadingUnit loadingUnit;

    private double weightBrutto;

    private double weightNetto;

    private double weightTara;

    // TODO - type: ja / nein --> Aktion bei ja
    private boolean dangerousGoodsIndication;

    // TODO - type: ja / nein --> Aktion bei ja
    private boolean wasteIndication;

    private int setTemperature;

    private Operator operator;

    private Operator client;

    private Direction direction;

    private Customs customs;

    // TODO - type: ?
    private Object goods;

    // TODO- type: ?
    private boolean empty;

    // TODO - type: {1-n}?
    private Object seal;

    // TODO - type: ?
    private Object sealType;

    // TODO - type: ?
    private Object sealNumber;
}
