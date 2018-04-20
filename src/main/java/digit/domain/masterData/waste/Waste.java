package digit.domain.masterData.waste;

/**
 * Substances or objects that their owner disposes of, wants to dispose of or has to dispose of.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @DIGIT_name  Abfall
 * @DIGIT_english  waste
 * @DIGIT_definition  Stoffe oder Gegenstände, die ihr Besitzer entsorgt, entsorgen will oder entsorgen muss. (@see
 *                    Regelwerk Abfall – Kreislaufwirtschaftsgesetz (KrWG): Gesetz zur Förderung der
 *                    Kreislaufwirtschaft und Sicherung der umweltverträglichen Bewirtschaftung von Abfällen)
 * @DIGIT_definition_english  Substances or objects that their owner disposes of, wants to dispose of or has to dispose
 *                            of. (@see Regelwerk Abfall – Kreislaufwirtschaftsgesetz (KrWG): Gesetz zur Förderung der
 *                            Kreislaufwirtschaft und Sicherung der umweltverträglichen Bewirtschaftung von Abfällen)
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
