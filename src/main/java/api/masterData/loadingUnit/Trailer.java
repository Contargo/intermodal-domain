package api.masterData.loadingUnit;

/**
 * Trailer vehicle which has no front axle, so a substantial part of its total weight is transferred to a tractor unit.
 *
 * <p>In german Sattelanhänger</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Trailer extends LoadingUnit {

    // TODO - type: XL, …
    private Object type;

    /**
     * in meters.
     */
    private double size;

    private boolean craneable;
}
