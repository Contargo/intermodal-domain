package net.contargo.domain;

/**
 * Defines the transportation from a well defined starting point or source to a end destination, performed by some means
 * of transportation.
 *
 * <p>A leg is a building-block, and can be used to describe trips and transportation orders of all sorts. Typically
 * several legs are completed during a transportation operation, and most often they are consolidated into a
 * transportation order. Tracking progress of a leg is an important piece of information. The beginning and completion
 * of a leg are two common system events.</p>
 *
 * <p>In german {@link Teilstrecke}.</p>
 *
 * @author  Olle Törnström - toernstroem@synyx.de
 */
public interface Leg {
}

interface Teilstrecke {
}
