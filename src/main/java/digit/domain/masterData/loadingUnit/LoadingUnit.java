package digit.domain.masterData.loadingUnit;

import digit.domain.masterData.operator.Operator;


/**
 * Physical transport unit which can include wares and goods.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Ladeeinheit
 * @name_english  loading unit
 * @abbreviation_german  LE
 * @abbreviation_english  LU
 * @definition_german  Physische Transporteinheit, die Waren und Güter umschließen kann.
 * @definition_english  Physical transport unit which can include wares and goods.
 * @note_german  Spezielle Ladeeinheiten des Kombinierten Verkehrs sind
 *               {@link digit.domain.masterData.loadingUnit.Container},
 *               {@link digit.domain.masterData.loadingUnit.SwapBody Wechselbehälter},
 *               {@link digit.domain.masterData.loadingUnit.Trailer Sattelauflieger}.
 * @note_english  Loading units in combined traffic are {@link digit.domain.masterData.loadingUnit.Container},
 *                {@link digit.domain.masterData.loadingUnit.SwapBody} and
 *                {@link digit.domain.masterData.loadingUnit.Trailer}.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
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
