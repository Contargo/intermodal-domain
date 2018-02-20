package api.loadingUnit;

/**
 * Describes the status of a {@link /src/main/java/api/loadingUnit/LoadingUnit.java}.
 *
 * <p>In german Ladeeinheitenstatus</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class StatusLU {

    /**
     * LU free and MoT present.
     */
    private boolean readyForLoading;

    /**
     * loaded on MoT.
     */
    private boolean loaded;

    /**
     * ready for going out.
     */
    private boolean inspectionOut;

    /**
     * LU out confirmed.
     */
    private boolean out;

    /**
     * Ready for going in.
     */
    private boolean inspectionIn;

    /**
     * LU in confirmed.
     */
    private boolean in;

    /**
     * LU free and MoT present.
     */
    private boolean readyForUnloading;

    private boolean unloaded;
}
