package api.masterData.goods;

/**
 * <p>In german Gefahrgut</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class DangerousGoods {

    /**
     * 4 characters.
     */
    private String unNumber;

    private String material;

    private String dangerNote;

    private String packagingGroup;

    private int packages;

    // TODO - type: double/int? kg?
    private double totalQuantity;

    private TunnelRestrictionCode tunnelRestrictionCode;

    private String mandatoryRouting;

    private boolean limitedQuantity;

    private boolean marinePollutants;
}
