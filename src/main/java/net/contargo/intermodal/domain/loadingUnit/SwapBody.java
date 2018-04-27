package net.contargo.intermodal.domain.loadingUnit;

/**
 * {@link net.contargo.intermodal.domain.loadingUnit.LoadingUnit} intended for the transport of goods, optimized with
 * regard to the dimensions of road vehicles and equipped with gripping edges for the transfer between means of
 * transport, usually between road/rail transport.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Wechselbrücke
 * @name_english  swap body
 * @synonym_german  Wechselbehälter, Wechselaufbau
 * @definition_german  Für den Gütertransport bestimmter Behälter, der im Hinblick auf die Abmessungen von
 *                     Straßenfahrzeugen optimiert wurde und mit Greifkanten für den Umschlag zwischen den
 *                     Verkehrsmitteln, in der Regel der Verkehrsträger Straße-Schiene, ausgestattet ist.
 * @definition_english  Loading unit intended for the transport of goods, optimized with regard to the dimensions of
 *                      road vehicles and equipped with gripping edges for the transfer between means of transport,
 *                      usually between road and rail transport.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class SwapBody extends LoadingUnit {

    /**
     * e.g. Klasse A, Klasse C (C715, C745, C765, C782), Open Top
     */
    private String type;

    /**
     * in foot.
     */
    private double size;

    private boolean stackable;
}
