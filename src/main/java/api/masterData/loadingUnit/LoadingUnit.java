package api.masterData.loadingUnit;

import api.masterData.operator.Operator;


/**
 * Physical transport unit which can include wares and goods.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @DIGIT_name  Ladeeinheit
 * @DIGIT_english  loading unit
 * @DIGIT_abbreviation  LE
 * @DIGIT_abbreviation_english  LU
 * @DIGIT_definition  Physische Transporteinheit, die Waren und Güter umschließen kann.
 * @DIGIT_definition_english  Physical transport unit which can include wares and goods.
 * @DIGIT_annotation  Spezielle Ladeeinheiten des Kombinierten Verkehrs sind
 *                    {@link api.masterData.loadingUnit.Container},
 *                    {@link api.masterData.loadingUnit.SwapBody Wechselbehälter},
 *                    {@link api.masterData.loadingUnit.Trailer Sattelauflieger}.
 * @DIGIT_annotation_english  Loading units in combined traffic are {@link api.masterData.loadingUnit.Container},
 *                            {@link api.masterData.loadingUnit.SwapBody} and
 *                            {@link api.masterData.loadingUnit.Trailer}.
 */
public abstract class LoadingUnit {

    /**
     * e.g&#046; BIC, ILU, SOC.
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
     * german examples in Ordnung (i.O.), schadhaft.
     */
    private String condition;

    /**
     * Is Loading Unit refrigerated?
     */
    private boolean reefer;

    /**
     * Name of {@link Operator}.
     */
    private String operator;
}
