package api.masterData.loadingUnit;

/**
 * Physical transport unit which can include wares and goods.
 *
 * <p>DIGIT_name: Ladeeinheit</p>
 *
 * <p>DIGIT_english: loading unit</p>
 *
 * <p>DIGIT_abbreviation: LE</p>
 *
 * <p>DIGIT_abbreviation_english: LU</p>
 *
 * <p>DIGIT_definition: Physische Transporteinheit, die Waren und Güter umschließen kann.</p>
 *
 * <p>DIGIT_definition_english: Physical transport unit which can include wares and goods.</p>
 *
 * <p>DIGIT_annotation: Spezielle Ladeeinheiten des Kombinierten Verkehrs sind
 * {@link api.masterData.loadingUnit.Container}, {@link api.masterData.loadingUnit.SwapBody Wechselbehälter},
 * {@link api.masterData.loadingUnit.Trailer Sattelauflieger}.</p>
 *
 * <p>DIGIT_annotation_english: Loading units in combined traffic are {@link api.masterData.loadingUnit.Container},
 * {@link api.masterData.loadingUnit.SwapBody} and {@link api.masterData.loadingUnit.Trailer}.</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public abstract class LoadingUnit {

    /**
     * e.g. BIC, ILU, SOC.
     */
    private String identification;

    /**
     * BIC, ILU (4 characters, 7 digits).
     */
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

    /**
     * german examples: in Ordnung (i.O.), schadhaft.
     */
    private String condition;

    /**
     * Is Loading Unit refrigerated?
     */
    private boolean reefer;

    /**
     * Name of {@link api.masterData.Operator}.
     */
    private String operator;
}
