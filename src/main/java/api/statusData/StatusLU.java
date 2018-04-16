package api.statusData;

/**
 * Status of loading unit for communication flow of intermodal freight transport.
 *
 * <p>DIGIT_name: Ladeeinheitenstatus</p>
 *
 * <p>DIGIT_english: loading unit status</p>
 *
 * <p>DIGIT_definition: Ladeeinheitenstatus für den Informationsfluss in der intermodalen Kette. Über den
 * Ladeeinheitenstatus und den {@link api.statusData.MeansOfTransportationStatus Verkehrsmittelstatus} kann ein
 * reibungsloser Austausch zwischen den Akteuren sichergestellt werden. Prinzipiell sollten die beiden Status als Paket
 * verstanden werden. Die Kerndaten sind jeweils immer gleich und werden durch den jeweiligen Status konkretisiert.
 * Dabei gibt es zwei Blöcke pro Statuspaket. Zum einen die Identifikation des Handelnden inklusive
 * Begleitinformationen und zum anderen die Konkretisierung was genau zu welchem Zeitpunkt passiert.
 * Begleitinformationen bei der Ladeeinheit betreffen beispielsweise den Auftrag.</p>
 *
 * <p>DIGIT_definition_english: Status of means of transport for communication flow of intermodal freight transport.
 * The loading unit status and {@link api.statusData.MeansOfTransportationStatus means of transportation status} ensure
 * a fluent exchange between actors. Both statuses should be seen as package. Their core data is similar and is
 * concretized by their status. There are two blocks per status package. On one hand the identification of the doer on
 * the other hand the schedule of the different operational steps.</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class StatusLU {

    /**
     * LU free and MoT present.
     *
     * <p>DIGIT_name: Verladebereit</p>
     *
     * <p>DIGIT_definition: Ladeeinheit ist bereit für den Umschlag/ die Kranung.</p>
     */
    private boolean readyForLoading;

    /**
     * Loaded on MoT.
     *
     * <p>DIGIT_name: Verladen</p>
     *
     * <p>DIGIT_definition: Ladeeinheit ist umgeschlagen & befindet sich auf dem VM.</p>
     */
    private boolean loaded;

    /**
     * Ready for going out.
     *
     * <p>DIGIT_name: Ausgangskontrolle</p>
     *
     * <p>DIGIT_definition: Ladeeinheit ist gesichtet und befindet sich auf dem VM.</p>
     */
    private boolean inspectionOut;

    /**
     * LU out confirmed.
     *
     * <p>DIGIT_name: Ausgegangen</p>
     *
     * <p>DIGIT_definition: Ladeeinheit ist verladen & hat Umschlagpunkt verlassen.</p>
     */
    private boolean out;

    /**
     * Ready for going in.
     *
     * <p>DIGIT_name: Eingangskontrolle</p>
     *
     * <p>DIGIT_definition: LE gesichtet, auf VM mit dem Umschlagpunkt erreicht wurde.</p>
     */
    private boolean inspectionIn;

    /**
     * LU in confirmed.
     *
     * <p>DIGIT_name: Eingegangen</p>
     *
     * <p>DIGIT_definition: Ladeeinheit ist auf VM im Umschlagbereich.</p>
     */
    private boolean in;

    /**
     * LU free and MoT present.
     *
     * <p>DIGIT_name: Entladebereit</p>
     *
     * <p>DIGIT_definition: LE auf VM und im Umschlagbereich bereit zum Entladen.</p>
     */
    private boolean readyForUnloading;

    /**
     * LU in.
     *
     * <p>DIGIT_name: Entladen</p>
     *
     * <p>DIGIT_definition: LE vom VM heruntergenommen, befindet sich im Umschlagpunkt.</p>
     */
    private boolean unloaded;
}
