package org.boudnik.builder;

import java.util.Set;

/**
 * @author Alexandre_Boudnik
 * @since 03/15/18 13:29
 */
public class Builder {

    public static Builder instance() {
        return new Builder();
    }

    public Resource build(String type, Recipe recipe, Set<Dimension> dimensions, Set<Resource> prerequisites) {
        return null;
    }
    public Resource build(String type, Set<Dimension> dimensions, Set<Resource> prerequisites) {
        return new Resource() {
            @Override
            public Set<Resource> prerequisites() {
                return prerequisites;
            }

            @Override
            public String type() {
                return type;
            }

            @Override
            public Set<Dimension> dimensions() {
                return dimensions;
            }
        };
    }
}
