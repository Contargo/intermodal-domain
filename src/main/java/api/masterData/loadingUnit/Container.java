package api.masterData.loadingUnit;

/**
 * Container for the transport of goods for the change of another mean of transport.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Container extends LoadingUnit {

    /**
     * ISO 6346 Container Size Type e.g. 20G0 for GENERAL PURPOSE CONTAINERS
     */
    private String sizeType;

    // TODO - textuelle beschreibung zu size type?
    private String type;

    /**
     * in foot.
     */
    private double size;
}
