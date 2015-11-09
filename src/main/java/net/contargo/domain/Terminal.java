package net.contargo.domain;

/**
 * A station, or junction, along a transport route - typically along the inland (<em>hinterland</em>) waterways, rivers
 * or canals. Each {@link Terminal} is among other things specified by it's {@link Site} and {@link Location}.
 *
 * <p>A {@link Terminal} is in our domain very often an acting business unit and a subsidiary of the Contargo
 * corporation. This typically means that the {@link Terminal}, as a organizational unit, has an identity and is
 * referred to, not only as a geographical location, but also as an <i>actor</i> in the system. For example, business
 * events and messages typically stems from one of many {@link Terminal terminals} and roles or groups are also often
 * bound to a specific {@link Terminal}.</p>
 *
 * <p>In german {@link Hinterlandterminal}, but also simply {@link Terminal}.</p>
 *
 * @author  Olle Törnström - toernstroem@synyx.de
 */
public interface Terminal {
}

interface Hinterlandterminal {
}
