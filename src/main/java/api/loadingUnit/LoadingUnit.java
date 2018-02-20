package api.loadingUnit;

public abstract class LoadingUnit {

    // TODO - type: BIC;ILU;SOC;Sonstiges
    private String identification;

    // TODO - type: BIC, ILU - vier Buchstaben sieben arabische Ziffern
    private String number;

    private LoadingUnitCategory category;

    private double weightBruttoMax;

    private double weightNettoMax;

    private double weightTara;

    // TODO - type: i.O., schadhaft,…
    private String condition;

    private boolean reefer;

    private String operator;
}
