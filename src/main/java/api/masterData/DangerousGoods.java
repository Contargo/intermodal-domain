package api.masterData;

/**
 * <p>In german Gefahrgut</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class DangerousGoods {

    /**
     * 4 digits.
     */
    private String unNumber;

    private String material;

    private String dangerNote;

    private String packagingGroup;

    private int packages;

    private int totalQuantity;

    private TunnelRestrictionCode tunnelRestrictionCode;

    // TODO
    private String mandatoryRouting;

    private boolean limitedQuantity;

    private boolean marinePollutants;
}
