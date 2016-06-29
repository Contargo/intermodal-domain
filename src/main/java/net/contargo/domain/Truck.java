package net.contargo.domain;

/**
 * A lorry or other type of heavy goods vehicle (HGV).
 *
 * <p>These vehicles carry out transportation tasks along the existing road-network. They are often required to begin or
 * complete a transportation order, due to their door-to-door capability (or loading bay to loading bay). Most commonly
 * a {@link Truck} is part of a {@link Fleet}.</p>
 *
 * <p>In german {@link LKW}.</p>
 *
 * @author  Olle Törnström - toernstroem@synyx.de
 * @see  Fleet
 */
public interface Truck {
}

/**
 * Der {@link LKW} bedient als flexibler, schneller Partner die Fläche im Nahverkehr. Dabei wird er vor allem für die
 * "erste" bzw. "letzte Meile" bei einem Transport verwendet.
 */
interface LKW {
}
