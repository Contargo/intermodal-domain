package api.loadingUnit;

/**
 * Loading unit intended for the transport of goods, optimized with regard to the dimensions of road vehicles and
 * equipped with gripping edges for the transfer between means of transport (usually between road/rail transport).
 *
 * <p>In german Wechselbrücke</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class SwapBody extends LoadingUnit {

    // TODO - type: Klasse A, Klasse C (C715, C745, C765, C782), Open Top
    private String type;

    /**
     * in feet.
     */
    private double size;

    private boolean stackable;
}
