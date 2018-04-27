package net.contargo.intermodal.domain.meansOfTransport;

import net.contargo.intermodal.domain.Operator;
import net.contargo.intermodal.domain.meansOfTransport.MeansOfTransport;


/**
 * A ship build to drive on seas and oceans.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Seeschiff
 * @name_english  vessel
 * @definition_german  Schiff, das zur Fahrt auf Meeren und Ozeanen konzipiert ist.
 * @definition_english  A ship build to drive on seas and oceans.
 * @note_german  Für diese API sind Schiffe relevant, die Ladeeinheiten des Kombinierten Verkehrs transportieren
 *               können.
 * @note_english  In this API only vessels which can transport loading units of combined traffic are relevant.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Vessel implements MeansOfTransport {

    private String name;

    /**
     * Maritime Mobile Service Identity (9 digits).
     */
    private int mmsi;

    /**
     * International Maritime Organization (IMO plus 7 digits).
     */
    private String imo;

    private Operator operator;
}
