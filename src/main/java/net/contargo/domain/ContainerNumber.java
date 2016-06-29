package net.contargo.domain;

/**
 * Each {@link Container} has a worldwide unique {@link ContainerNumber}.
 *
 * <p>Example: HLXU 123456-7</p>
 *
 * <p>Also in german: {@link Containernummer}.</p>
 *
 * <p>Further information: <a href="https://en.wikipedia.org/wiki/ISO_6346">ISO 6346 standard</a></p>
 *
 * @author  Aljona Murygina - murygina@synyx.de
 */
public interface ContainerNumber {
}

/**
 * Ein {@link Container} wird identifiziert durch seine weltweit eindeutige {@link Containernummer}. Diese ist deutlich
 * sichtbar am {@link Container} angebracht.
 *
 * <p>Sie besteht aus vier Standardbuchstaben, sechs Ziffern sowie einer aus allen 10 Zeichen und Stellen errechneten
 * Prüfziffer, die eine fehlerhafte Erfassung durch Zahlendreher nahezu ausschließt.</p>
 *
 * <p>Beispiel: HLXU 123456-7</p>
 *
 * <p>Weiterführende Information: <a href="https://en.wikipedia.org/wiki/ISO_6346">ISO 6346 Standard</a></p>
 */
interface Containernummer {
}
