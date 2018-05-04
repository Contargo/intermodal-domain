package net.contargo.intermodal.domain.example;

import net.contargo.intermodal.domain.Container;
import net.contargo.intermodal.domain.Location;
import net.contargo.intermodal.domain.Site;
import net.contargo.intermodal.domain.Terminal;


/**
 * This is an example of referential use of the declared tagging interfaces.
 *
 * <p>By simply linking to the {@link Terminal}, {@link Site} or {@link Location} types, we can create a navigable
 * reference documentation, that is easy to use for developers. Since almost all IDE and modern Java editors support
 * type lookup, developers may navigation the referred types using their favorite tools.</p>
 *
 * @author  Olle Törnström - toernstroem@synyx.de
 * @since  0.0.1
 */
public class Example {

    /**
     * Optionally, the tagging interfaces may be used as actual markers on types that adhere to the classification - or
     * perhaps directly implement the type.
     *
     * <p>This would also yield the benefit of a more generalized reasoning across applications and solutions, about
     * how they map to the core domain aspects.</p>
     *
     * @author  Olle Törnström - toernstroem@synyx.de
     * @since  0.0.1
     */
    public class Unit implements Container {

        // OK
    }
}
