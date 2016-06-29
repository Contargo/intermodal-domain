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

/**
 * Eine Teilstrecke ist die Strecke, die ein Verkehrsmittel von einem fest definierten Startpunkt zu einem fest
 * definierten Endpunkt zurücklegt. Eine Teilstrecke ist in dem Sinne minimal, als dass es keine Haltepunkte zwischen
 * Startpunkt und Endpunkt gibt. Zu einer Teilstrecke gehören unter anderem Informationen über die beteiligten Standorte
 * (Start, Ziel), den transportierten Container und das transportierende Verkehrsmittel. Jede Teilstrecke kann eindeutig
 * einer Position eines Auftrags zugeordnet werden. Im zeitlichen Verlauf existiert eine Teilstrecke in den
 * verschiedenen Phasen der Auftragsdurchführung in verschiedenen Zuständen, je nachdem ob sie in Planung ist, oder sich
 * in oder nach der Durchführung befindet.
 */
interface Teilstrecke {
}
