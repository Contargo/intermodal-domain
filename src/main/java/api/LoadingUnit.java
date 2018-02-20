package api;

public abstract class LoadingUnit {

// TODO - type: BIC, ILU - vier Buchstaben sieben arabische Ziffern
    private Object number;

// TODO - type: drei Buchstaben
    private Object owner;

// TODO - type: ein Buchstabe Produktgruppenschlüssel/LE-Typ
    private Object typecode;

// TODO - type: sechs arabische Ziffern
    private Object serial;

// TODO - type: eine arabische Ziffer
    private Object digit;

// TODO - type: Container, Wechselbrücke, Sattelauflieger
    private Object type;

    private double weightBruttoMax;

    private double weightNettoMax;

    private double weightTara;

// TODO - type: i.O., schadhaft,…
    private Object condition;

    private boolean reefer;

// TODO - type: Name
    private Object operator;
}
