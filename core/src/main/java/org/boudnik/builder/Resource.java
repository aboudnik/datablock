package org.boudnik.builder;

import java.util.*;

/**
 * @author Alexandre_Boudnik
 * @since 03/15/18 13:30
 */
public interface Resource {

    String type();

    /**
     * It does nothing
     * @return null
     */
    default Object build() {
        return null;
    }

    default Map dimensions() {
        return Collections.emptyMap();
    }

    default Set<Resource> prerequisites() {
        return Collections.emptySet();
    }

    default boolean isReady() {
        return false;
    }

    default boolean isSatisfied() {
        boolean ready = true;
        for (Resource resource : prerequisites()) {
            ready &= resource.isReady();
        }
        return ready;
    }
}
