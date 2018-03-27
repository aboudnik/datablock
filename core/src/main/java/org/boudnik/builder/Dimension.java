package org.boudnik.builder;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Alexandre_Boudnik
 * @since 03/26/18 14:52
 */
public class Dimension {
    private final String key;
    private final Limit limit;

    public Dimension(String key, Limit limit) {
        this.key = key;
        this.limit = limit;
    }

    public Dimension(String key, Object limit) {
        this(key, new Limit.Value(limit));
    }

    public Dimension(String key, Comparable low, Comparable high) {
        this(key, new Limit.Range(low, high));
    }

    public Dimension(String key, Object... set) {
        this(key, new Limit.Set(set));
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return key + '=' + limit;
    }

    private interface Limit {

        class Value implements Limit {
            private final Object limit;

            Value(Object limit) {
                this.limit = limit;
            }

            @Override
            public String toString() {
                return String.valueOf(limit);
            }
        }

        class Range implements Limit {
            private final Comparable low;
            private final Comparable high;

            Range(Comparable low, Comparable high) {
                this.low = low;
                this.high = high;
            }

            @Override
            public String toString() {
                return "{" + low + ", " + high + '}';
            }
        }

        class Set implements Limit {
            private final java.util.Set set;

            Set(Object... set) {
                this.set = new HashSet<>(Arrays.asList(set));
            }

            @Override
            public String toString() {
                return "Set{" +
                        "set=" + set +
                        '}';
            }
        }
    }
}