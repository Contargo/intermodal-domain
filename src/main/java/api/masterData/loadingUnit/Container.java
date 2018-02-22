package api.masterData.loadingUnit;

/**
 * Container for the transport of goods for the change of another mean of transport.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Container extends LoadingUnit {

    private String sizeType;

    private String type;

    /**
     * in feet.
     */
    private double size;
}
