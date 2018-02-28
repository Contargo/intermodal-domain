package api.masterData.loadingUnit;

/**
 * Loading unit intended for the transport of goods, optimized with regard to the dimensions of road vehicles and
 * equipped with gripping edges for the transfer between means of transport (usually between road/rail transport).
 *
 * <p>In german Wechselbrücke</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class SwapBody extends LoadingUnit {

    private String type;

    /**
     * in foot.
     */
    private double size;

    private boolean stackable;
}
