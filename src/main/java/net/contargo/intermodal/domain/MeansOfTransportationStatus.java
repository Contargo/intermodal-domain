package net.contargo.intermodal.domain;

import java.util.Date;


/**
 * Status of means of transport for communication flow of intermodal freight transport.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Verkehrsmittelstatus
 * @name_english  means of transportation status
 * @definition_german  Verkehrsmittelstatus für den Informationsfluss in der intermodalen Kette. Über den
 *                     Verkehrsmittelstatus und den {@link StatusLU Ladeeinheitenstatus} kann ein reibungsloser
 *                     Austausch zwischen den Akteuren sichergestellt werden. Prinzipiell sollten die beiden Status als
 *                     Paket verstanden werden. Die Kerndaten sind jeweils immer gleich und werden durch den jeweiligen
 *                     Status konkretisiert. Dabei gibt es zwei Blöcke pro Statuspaket. Zum einen die Identifikation
 *                     des Handelnden inklusive Begleitinformationen und zum anderen die Konkretisierung was genau zu
 *                     welchem Zeitpunkt passiert. Begleitinformationen beim Verkehrsmittel betreffen die
 *                     Transportrelation.
 * @definition_english  Status of means of transport for communication flow of intermodal freight transport. The means
 *                      of transportation status and {@link StatusLU loading unit status} ensure a fluent exchange
 *                      between actors. Both statuses should be seen as package. Their core data is similar and is
 *                      concretized by their status. There are two blocks per status package. On one hand the
 *                      identification of the doer on the other hand the schedule of the different operational steps.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class MeansOfTransportationStatus {

    /**
     * Actual Time of Departure of the {@link net.contargo.intermodal.domain.meansOfTransport.MeansOfTransport MoT} at
     * the handling point (Format: ISO 8601 inclusive UTC).
     *
     * @name_german  Abfahrt
     * @definition_german  Tatsächliche Abfahrt des
     *                     {@link net.contargo.intermodal.domain.meansOfTransport.MeansOfTransport VM} beim Verlassen
     *                     des Umschlagpunktes.
     */
    private Date atd;

    /**
     * Estimated Time of Arrival of the {@link net.contargo.intermodal.domain.meansOfTransport.MeansOfTransport MoT} at
     * the handling point (Format: ISO 8601 inclusive UTC).
     *
     * @name_german  Avisiert
     * @definition_german  Geplante Ankunft des
     *                     {@link net.contargo.intermodal.domain.meansOfTransport.MeansOfTransport VM} am
     *                     Umschlagpunkt.
     */
    private Date eta;

    /**
     * Actual Time of Arrival of the {@link net.contargo.intermodal.domain.meansOfTransport.MeansOfTransport MoT} at
     * the handling point (Format: ISO 8601 inclusive UTC).
     *
     * @name_german  Ankunft
     * @definition_german  Tatsächliche Ankunft des
     *                     {@link net.contargo.intermodal.domain.meansOfTransport.MeansOfTransport VM} am
     *                     Umschlagpunkt.
     */
    private Date ata;

    /**
     * {@link net.contargo.intermodal.domain.meansOfTransport.MeansOfTransport MoT} is ready for handling of the
     * {@link net.contargo.intermodal.domain.loadingUnit.LoadingUnit LU} (Format: ISO 8601 inclusive UTC).
     *
     * @name_german  Bereitstellung
     * @synonym_german  Bearbeitungsstart
     * @abbreviation_german  BS
     * @definition_german  {@link net.contargo.intermodal.domain.meansOfTransport.MeansOfTransport VM} ist bereit für
     *                     den Umschlag der {@link net.contargo.intermodal.domain.loadingUnit.LoadingUnit LE} („erste
     *                     Kranung“).
     */
    private Date handlingStart;

    /**
     * {@link net.contargo.intermodal.domain.meansOfTransport.MeansOfTransport MoT} is loaded, end of loading process
     * (Format: ISO 8601 inclusive UTC).
     *
     * @name_german  Bearbeitungsende
     * @synonym_german  Ladeschluss
     * @abbreviation_german  BE
     * @definition_german  {@link net.contargo.intermodal.domain.meansOfTransport.MeansOfTransport VM} beladen, Ende
     *                     Verladung erreicht („letzte Kranung“).
     */
    private Date handlingEnd;

    /**
     * Safety control of the loaded waggons.
     *
     * @name_german  Wagentechnische Untersuchung
     * @abbreviation_german  WTU
     * @definition_german  Kontrolle der Betriebssicherheit der Waggons mit Ladung.
     */
    private Integer waggonTechnicalInspection;
}
