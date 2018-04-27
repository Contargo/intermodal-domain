package digit.domain.statusData;

/**
 * Status of loading unit for communication flow of intermodal freight transport.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Ladeeinheitenstatus
 * @name_english  loading unit status
 * @definition_german  Ladeeinheitenstatus für den Informationsfluss in der intermodalen Kette. Über den
 *                     Ladeeinheitenstatus und den
 *                     {@link digit.domain.statusData.MeansOfTransportationStatus Verkehrsmittelstatus} kann ein
 *                     reibungsloser Austausch zwischen den Akteuren sichergestellt werden. Prinzipiell sollten die
 *                     beiden Status als Paket verstanden werden. Die Kerndaten sind jeweils immer gleich und werden
 *                     durch den jeweiligen Status konkretisiert. Dabei gibt es zwei Blöcke pro Statuspaket. Zum einen
 *                     die Identifikation des Handelnden inklusive Begleitinformationen und zum anderen die
 *                     Konkretisierung was genau zu welchem Zeitpunkt passiert. Begleitinformationen bei der
 *                     Ladeeinheit betreffen beispielsweise den Auftrag.
 * @definition_english  Status of means of transport for communication flow of intermodal freight transport. The
 *                      loading unit status and
 *                      {@link digit.domain.statusData.MeansOfTransportationStatus means of transportation status}
 *                      ensure a fluent exchange between actors. Both statuses should be seen as package. Their core
 *                      data is similar and is concretized by their status. There are two blocks per status package. On
 *                      one hand the identification of the doer on the other hand the schedule of the different
 *                      operational steps.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class StatusLU {

    /**
     * {@link digit.domain.masterData.loadingUnit.LoadingUnit LU} free and
     * {@link digit.domain.masterData.meansOfTransport.MeansOfTransport MoT} present.
     *
     * @name_german  Verladebereit
     * @definition_german  {@link digit.domain.masterData.loadingUnit.LoadingUnit Ladeeinheit} ist bereit für den
     *                     Umschlag/ die Kranung.
     */
    private boolean readyForLoading;

    /**
     * Loaded on {@link digit.domain.masterData.meansOfTransport.MeansOfTransport MoT}.
     *
     * @name_german  Verladen
     * @definition_german  {@link digit.domain.masterData.loadingUnit.LoadingUnit Ladeeinheit} ist umgeschlagen und
     *                     befindet sich auf dem {@link digit.domain.masterData.meansOfTransport.MeansOfTransport VM}.
     */
    private boolean loaded;

    /**
     * Ready for going out.
     *
     * @name_german  Ausgangskontrolle
     * @definition_german  {@link digit.domain.masterData.loadingUnit.LoadingUnit Ladeeinheit} ist gesichtet und
     *                     befindet sich auf dem {@link digit.domain.masterData.meansOfTransport.MeansOfTransport VM}.
     */
    private boolean inspectionOut;

    /**
     * {@link digit.domain.masterData.loadingUnit.LoadingUnit LU} out confirmed.
     *
     * @name_german  Ausgegangen
     * @definition_german  {@link digit.domain.masterData.loadingUnit.LoadingUnit Ladeeinheit} ist verladen und hat
     *                     Umschlagpunkt verlassen.
     */
    private boolean out;

    /**
     * Ready for going in.
     *
     * @name_german  Eingangskontrolle
     * @definition_german  {@link digit.domain.masterData.loadingUnit.LoadingUnit Ladeeinheit} gesichtet, auf
     *                     {@link digit.domain.masterData.meansOfTransport.MeansOfTransport VM} mit dem Umschlagpunkt
     *                     erreicht wurde.
     */
    private boolean inspectionIn;

    /**
     * {@link digit.domain.masterData.loadingUnit.LoadingUnit LU} in confirmed.
     *
     * @name_german  Eingegangen
     * @definition_german  {@link digit.domain.masterData.loadingUnit.LoadingUnit Ladeeinheit} ist auf
     *                     {@link digit.domain.masterData.meansOfTransport.MeansOfTransport VM} im Umschlagbereich.
     */
    private boolean in;

    /**
     * {@link digit.domain.masterData.loadingUnit.LoadingUnit LU} free and
     * {@link digit.domain.masterData.meansOfTransport.MeansOfTransport MoT} present.
     *
     * @name_german  Entladebereit
     * @definition_german  {@link digit.domain.masterData.loadingUnit.LoadingUnit Ladeeinheit} auf
     *                     {@link digit.domain.masterData.meansOfTransport.MeansOfTransport VM} und im Umschlagbereich
     *                     bereit zum Entladen.
     */
    private boolean readyForUnloading;

    /**
     * {@link digit.domain.masterData.loadingUnit.LoadingUnit LU} in.
     *
     * @name_german  Entladen
     * @definition_german  {@link digit.domain.masterData.loadingUnit.LoadingUnit Ladeeinheit} vom
     *                     {@link digit.domain.masterData.meansOfTransport.MeansOfTransport VM} heruntergenommen,
     *                     befindet sich im Umschlagpunkt.
     */
    private boolean unloaded;
}
