package org.boudnik.builder;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * @author Alexandre_Boudnik
 * @since 03/15/18 13:30
 */
public interface Resource {
    abstract class Helper {
        static Resource alwaysReady(String type) {
            return new Resource() {
                @Override
                public String type() {
                    return type;
                }

                @Override
                public boolean isReady() {
                    return true;
                }
            };
        }

        @NotNull
        static Set<Dimension> dimensions(Dimension... dimensions) {
            return new HashSet<>(Arrays.asList(dimensions));
        }

        @NotNull
        static Set<Resource> prerequisites(Resource... resources) {
            return new HashSet<>(Arrays.asList(resources));
        }
    }


    String type();

    /**
     * It does nothing
     * @return null
     */
    default Object build() {
        return null;
    }

    default Set<Dimension> dimensions() {
        return Collections.emptySet();
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
