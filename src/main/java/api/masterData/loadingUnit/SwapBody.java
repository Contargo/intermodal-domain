package api.masterData.loadingUnit;

/**
 * {@link api.masterData.loadingUnit.LoadingUnit} intended for the transport of goods, optimized with regard to the
 * dimensions of road vehicles and equipped with gripping edges for the transfer between means of transport, usually
 * between road/rail transport.
 *
 * <p>DIGIT_name: Wechselbrücke</p>
 *
 * <p>DIGIT_english: swap body</p>
 *
 * <p>DIGIT_synonym: Wechselbehälter, Wechselaufbau</p>
 *
 * <p>DIGIT_definition: Für den Gütertransport bestimmter Behälter, der im Hinblick auf die Abmessungen von
 * Straßenfahrzeugen optimiert wurde und mit Greifkanten für den Umschlag zwischen den Verkehrsmitteln, in der Regel
 * der Verkehrsträger Straße-Schiene, ausgestattet ist.</p>
 *
 * <p>Loading unit intended for the transport of goods, optimized with regard to the dimensions of road vehicles and
 * equipped with gripping edges for the transfer between means of transport, usually between road/rail transport.</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
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
