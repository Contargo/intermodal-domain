package api.loadingUnit;

public abstract class LoadingUnit {

    // TODO
    private Object identification;

    // TODO - type: BIC, ILU - vier Buchstaben sieben arabische Ziffern
    private Object number;

    // TODO - type: Container, Wechselbrücke, Sattelauflieger
    private Object category;

    private double weightBruttoMax;

    private double weightNettoMax;

    private double weightTara;

    // TODO - type: i.O., schadhaft,…
    private Object condition;

    private boolean reefer;

    // TODO - type: Name
    private Object operator;
}
