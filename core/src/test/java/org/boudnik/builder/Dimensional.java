package org.boudnik.builder;

import java.util.Map;

/**
 * @author Alexandre_Boudnik
 * @since 03/16/18 11:54
 */
public abstract class Dimensional implements Resource {
    private final Map<String, Object> dimensions;

    public Dimensional(Map<String, Object> dimensions) {
        this.dimensions = dimensions;
    }


    @Override
    public Map<String, Object> dimensions() {
        return dimensions;
    }

    @Override
    public String toString() {
        return type() + "{" + dimensions() + "->" + prerequisites() + '}';
    }
}
