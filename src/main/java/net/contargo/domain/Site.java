package net.contargo.domain;

/**
 * Describing a property of a physical company location - or its <i>modality</i>, with regards to the logistic
 * capability it provides.
 *
 * <p>Site information generally describes either a {@link Terminal}, {@link Seaport} or a {@link LoadingPlace}, not
 * because of its {@link Location}, but because of it's function in a given context - for example in a business
 * event.</p>
 *
 * <p>In german {@link Standortart}.</p>
 *
 * @author  Olle Törnström - toernstroem@synyx.de
 * @see  Terminal
 * @see  Seaport
 * @see  LoadingPlace
 * @see  Location
 */
public interface Site {
}

interface Standortart {
}
