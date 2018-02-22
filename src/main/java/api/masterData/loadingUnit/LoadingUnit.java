package api.masterData.loadingUnit;

/**
 * Physical transport unit which can include wares and goods.
 *
 * <p>In german Ladeeinheit</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public abstract class LoadingUnit {

    private String identification;

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

    private String condition;

    private boolean reefer;

    private String operator;
}
