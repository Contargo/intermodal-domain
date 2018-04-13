package api.masterData.vessel;

import api.masterData.meansOfTransport.MeansOfTransport;

import api.masterData.operator.Operator;


/**
 * A ship build to drive on seas and oceans.
 *
 * <p>DIGIT_name: Seeschiff</p>
 *
 * <p>DIGIT_english: vessel</p>
 *
 * <p>DIGIT_definition: Schiff, das zur Fahrt auf Meeren und Ozeanen konzipiert ist.</p>
 *
 * <p>DIGIT_definition_english: A ship build to drive on seas and oceans.</p>
 *
 * <p>DIGIT_annotation: Für diese API sind Schiffe relevant, die Ladeeinheiten des Kombinierten Verkehrs transportieren
 * können.</p>
 *
 * <p>DIGIT_annotation_english: In this API only vessels which can transport loading units of combined traffic are
 * relevant.</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Vessel extends MeansOfTransport {

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
