package api.statusData;

/**
 * Status of loading unit for communication flow of intermodal freight transport.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @DIGIT_name  Ladeeinheitenstatus
 * @DIGIT_english  loading unit status
 * @DIGIT_definition  Ladeeinheitenstatus für den Informationsfluss in der intermodalen Kette. Über den
 *                    Ladeeinheitenstatus und den
 *                    {@link api.statusData.MeansOfTransportationStatus Verkehrsmittelstatus} kann ein reibungsloser
 *                    Austausch zwischen den Akteuren sichergestellt werden. Prinzipiell sollten die beiden Status als
 *                    Paket verstanden werden. Die Kerndaten sind jeweils immer gleich und werden durch den jeweiligen
 *                    Status konkretisiert. Dabei gibt es zwei Blöcke pro Statuspaket. Zum einen die Identifikation des
 *                    Handelnden inklusive Begleitinformationen und zum anderen die Konkretisierung was genau zu
 *                    welchem Zeitpunkt passiert. Begleitinformationen bei der Ladeeinheit betreffen beispielsweise den
 *                    Auftrag.
 * @DIGIT_definition_english  Status of means of transport for communication flow of intermodal freight transport. The
 *                            loading unit status and
 *                            {@link api.statusData.MeansOfTransportationStatus means of transportation status} ensure
 *                            a fluent exchange between actors. Both statuses should be seen as package. Their core
 *                            data is similar and is concretized by their status. There are two blocks per status
 *                            package. On one hand the identification of the doer on the other hand the schedule of the
 *                            different operational steps.
 */
public class StatusLU {

    /**
     * LU free and MoT present.
     *
     * @DIGIT_name  Verladebereit
     * @DIGIT_definition  Ladeeinheit ist bereit für den Umschlag/ die Kranung.
     */
    private boolean readyForLoading;

    /**
     * Loaded on MoT.
     *
     * @DIGIT_name  Verladen
     * @DIGIT_definition  Ladeeinheit ist umgeschlagen und befindet sich auf dem VM.
     */
    private boolean loaded;

    /**
     * Ready for going out.
     *
     * @DIGIT_name  Ausgangskontrolle
     * @DIGIT_definition  Ladeeinheit ist gesichtet und befindet sich auf dem VM.
     */
    private boolean inspectionOut;

    /**
     * LU out confirmed.
     *
     * @DIGIT_name  Ausgegangen
     * @DIGIT_definition  Ladeeinheit ist verladen und hat Umschlagpunkt verlassen.
     */
    private boolean out;

    /**
     * Ready for going in.
     *
     * @DIGIT_name  Eingangskontrolle
     * @DIGIT_definition  LE gesichtet, auf VM mit dem Umschlagpunkt erreicht wurde.
     */
    private boolean inspectionIn;

    /**
     * LU in confirmed.
     *
     * @DIGIT_name  Eingegangen
     * @DIGIT_definition  Ladeeinheit ist auf VM im Umschlagbereich.
     */
    private boolean in;

    /**
     * LU free and MoT present.
     *
     * @DIGIT_name  Entladebereit
     * @DIGIT_definition  LE auf VM und im Umschlagbereich bereit zum Entladen.
     */
    private boolean readyForUnloading;

    /**
     * LU in.
     *
     * @DIGIT_name  Entladen
     * @DIGIT_definition  LE vom VM heruntergenommen, befindet sich im Umschlagpunkt.
     */
    private boolean unloaded;
}
