package net.contargo.intermodal.domain;

/**
 * Different types of identification for a {@link LoadingUnit}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @definition_german  Mögliche Identifikatoren für eine Ladeeinheit:
 *
 *                     <p>- BIC (Bureau International des Containers):<br>
 *                     Eigentümercode für ISO-Container, der vom Bureau Internationale de Containers et du Transport
 *                     Intermodal (B.I.C.) mit Sitz in Paris auf Wunsch des Eigentümers oder Operators nach der
 *                     Internationalen Norm DIN EN ISO 6346 zugeordnet wird</p>
 *
 *                     <p>- ILU (intermodale Ladeeinheit):<br>
 *                     Code, der auf Basis der Europäischen Norm DIN EN 13044-1 für alle Behälter des intermodalen
 *                     Verkehrs, die nicht dem ISO-Standard entsprechen, vergeben wird</p>
 *
 *                     <p>- SOC (shipper owned container):<br>
 *                     Container im Eigentum eines Versenders ohne eindeutige Identifizierung durch einen BIC-Code</p>
 *
 *                     <p>- Sonstige</p>
 * @definition_english  Possible identifications for a loading unit:
 *
 *                      <p>- BIC (Bureau International des Containers)</p>
 *
 *                      <p>- ILU (intermodale Ladeeinheit)</p>
 *
 *                      <p>- SOC (shipper owned container)</p>
 *
 *                      <p>- other</p>
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public enum LoadingUnitIdentification {

    BIC,
    ILU,
    SOC,
    OTHER
}
