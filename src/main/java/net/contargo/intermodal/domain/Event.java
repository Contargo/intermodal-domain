package net.contargo.intermodal.domain;

/**
 * A happening, pertaining to some business occasion, typically posted by a component of the system that is published
 * into the open messaging domain, not being addressed to a specific recipient.
 *
 * <p>In german {@link Ereignis}</p>
 *
 * @author  Olle Törnström - toernstroem@synyx.de
 * @source  Contargo Domain
 */
public interface Event {
}

/**
 * Ereignisse sind spezielle Benachrichtigungen, welche zwischen System versendet werden. z.B. Broker -&gt; DCC. Sie
 * haben kein definiertes einheitliches Format. Sie werden nicht über den Message-Service verarbeitet. Sollen
 * Nutzer/Rollen über diese Ereignisse informiert werden, so müssen die einzelnen Systeme Nachrichten an die Nutzer
 * versenden.
 */
interface Ereignis {
}
