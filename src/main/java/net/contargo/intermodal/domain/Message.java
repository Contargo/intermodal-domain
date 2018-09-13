package net.contargo.intermodal.domain;

/**
 * A textual message directed explicitly to some user or group.
 *
 * <p>In german {@link Nachricht}</p>
 *
 * @author  Olle Törnström - toernstroem@synyx.de
 * @source  Contargo Domain
 */
public interface Message {
}

/**
 * Hierbei handelt es sich um eine Nachricht, welche von einem Sender zu einen oder mehreren Empfänger gesendet wurde.
 * Als Empfänger können derzeit Nutzer oder Rollen verwendet werden. Nachrichten werden im Message-Service gespeichert
 * und den einzelnen Nutzer zur Verfügung gestellt.
 */
interface Nachricht {
}
