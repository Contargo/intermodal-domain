package net.contargo.domain;

/**
 * System information that is published with the intent to be directed to a group or user, with the purpose of informing
 * or drawing attention to some system event.
 *
 * <p>In german {@link Benachrichtigung}.</p>
 *
 * @author  Olle Törnström - toernstroem@synyx.de
 */
public interface Notification {
}

/**
 * Dies sind einfache Benachrichtigungen an genau einen Nutzer. Für unseren Use-Case dienen sie dazu, einen Nutzer über
 * eine neue eingegangene Nachricht zu informieren. Sie beinhalten nicht den kompletten Nachrichten-Inhalt sondern, wenn
 * überhaupt, eine Übersicht über die ursprüngliche Nachricht (Hierbei muss die Lokalisierung beachtet werden). Diese
 * werden nach einer eingehenden Nachricht an die Nutzer versendet.
 */
interface Benachrichtigung {
}
