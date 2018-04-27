package digit.domain.masterData.waste;

/**
 * Substances or objects that their owner disposes of, wants to dispose of or has to dispose of.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @DIGIT_name_german  Abfall
 * @DIGIT_name_english  waste
 * @DIGIT_definition_german  Stoffe oder Gegenstände, die ihr Besitzer entsorgt, entsorgen will oder entsorgen muss.
 *                           (@see Regelwerk Abfall – Kreislaufwirtschaftsgesetz (KrWG): Gesetz zur Förderung der
 *                           Kreislaufwirtschaft und Sicherung der umweltverträglichen Bewirtschaftung von Abfällen)
 * @DIGIT_definition_english  Substances or objects that their owner disposes of, wants to dispose of or has to dispose
 *                            of. (@see Regelwerk Abfall – Kreislaufwirtschaftsgesetz (KrWG): Gesetz zur Förderung der
 *                            Kreislaufwirtschaft und Sicherung der umweltverträglichen Bewirtschaftung von Abfällen)
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Waste {

    private String position;

    /**
     * <p>DIGIT_german: Abfallschlüsselnummer</p>
     *
     * <p>DIGIT_abbreviation: ASN</p>
     */
    private String keyID;

    /**
     * <p>DIGIT_german: Abfallverzeichnis-Verordnung</p>
     *
     * <p>DIGIT_abbreviation: AVV</p>
     */
    private String wasteRegulationNumber;

    private String receiptNumber;

    /**
     * in kg per position.
     */
    private double weightNetto;
}
