package digit.domain.masterData.loadingUnit;

/**
 * {@link digit.domain.masterData.loadingUnit.LoadingUnit} intended for the transport of goods, optimized with regard
 * to the dimensions of road vehicles and equipped with gripping edges for the transfer between means of transport,
 * usually between road/rail transport.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @DIGIT_name  Wechselbrücke
 * @DIGIT_name_english  swap body
 * @DIGIT_synonym  Wechselbehälter, Wechselaufbau
 * @DIGIT_definition  Für den Gütertransport bestimmter Behälter, der im Hinblick auf die Abmessungen von
 *                    Straßenfahrzeugen optimiert wurde und mit Greifkanten für den Umschlag zwischen den
 *                    Verkehrsmitteln, in der Regel der Verkehrsträger Straße-Schiene, ausgestattet ist.
 * @DIGIT_definition_english  Loading unit intended for the transport of goods, optimized with regard to the dimensions
 *                            of road vehicles and equipped with gripping edges for the transfer between means of
 *                            transport, usually between road and rail transport.
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
