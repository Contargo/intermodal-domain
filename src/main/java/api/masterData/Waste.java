package api.masterData;

/**
 * Substances or objects that their owner disposes of, wants to dispose of or has to dispose of.
 *
 * <p>DIGIT_name: Abfall</p>
 *
 * <p>DIGIT_english: waste</p>
 *
 * <p>DIGIT_definition: Stoffe oder Gegenstände, die ihr Besitzer entsorgt, entsorgen will oder entsorgen muss. (@see
 * Regelwerk Abfall – Kreislaufwirtschaftsgesetz (KrWG): Gesetz zur Förderung der Kreislaufwirtschaft und Sicherung der
 * umweltverträglichen Bewirtschaftung von Abfällen)</p>
 *
 * <p>DIGIT_definition_english: Substances or objects that their owner disposes of, wants to dispose of or has to
 * dispose of. (@see Regelwerk Abfall – Kreislaufwirtschaftsgesetz (KrWG): Gesetz zur Förderung der Kreislaufwirtschaft
 * und Sicherung der umweltverträglichen Bewirtschaftung von Abfällen)</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
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
