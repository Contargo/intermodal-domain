package net.contargo.domain;

/**
 * A port or harbor - an important junction in trans-shipment logistics.
 *
 * <p>In our domain, since we're generally concerned with multi-modal transportation on route <em>to</em> a
 * {@link Seaport}, it is the destination or staring point of a transportation order. Contargo does not, themselves,
 * carry out overseas transportation, nor do they have any sea going vessels.</p>
 *
 * <p>In german {@link Seehafen}.</p>
 *
 * @author  Olle Törnström - toernstroem@synyx.de
 */
public interface Seaport {
}

/**
 * An einem Seehafen werden Container auf ein Seeschiff zum Transport auf den Seeweg verladen oder von einem Seeschiff
 * entladen.
 */
interface Seehafen {
}
