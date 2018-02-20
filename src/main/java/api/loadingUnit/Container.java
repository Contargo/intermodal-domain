package api.loadingUnit;

/**
 * Container for the transport of goods for the change of another mean of transport.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Container extends LoadingUnit {

    // TODO - type: ISO Conatiner Size Type nach ISO 6346
    private String sizeType;

    // TODO - type: High Cube, Tank, Open Top, Bulk, Flat Rack
    private String type;

    /**
     * in feet.
     */
    private double size;
}
