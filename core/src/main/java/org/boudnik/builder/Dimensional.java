package org.boudnik.builder;

import java.util.Collections;
import java.util.Set;

/**
 * @author Alexandre_Boudnik
 * @since 03/16/18 11:54
 */
public abstract class Dimensional implements Resource {
    private final Dimensions dimensions;

    public Set<String> names() {
        return Collections.emptySet();
    }

    public Dimensional(Dimension... dimensions) {
        this(new Dimensions(dimensions));
    }

    public Dimensional(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public Dimensions dimensions() {
        return dimensions;
    }

    @Override
    public String toString() {
        return type() + dimensions + "<-" + prerequisites();
    }
}
