package api.masterData.loadingUnit;

/**
 * Physical transport unit which can include wares and goods.
 *
 * <p>In german Ladeeinheit</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public abstract class LoadingUnit {

    // TODO - type: BIC;ILU;SOC;Sonstiges
    private String identification;

    // TODO - type: BIC, ILU - vier Buchstaben sieben arabische Ziffern
    private String number;

    private LoadingUnitCategory category;

    /**
     * in kg.
     */
    private double weightBruttoMax;

    /**
     * in kg.
     */
    private double weightNettoMax;

    /**
     * in kg.
     */
    private double weightTara;

    // TODO - type: i.O., schadhaft,…
    private String condition;

    private boolean reefer;

    private String operator;
}
