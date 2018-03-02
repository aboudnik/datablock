package org.boudnik.datablock.core;

/**
 * @author Alexandre_Boudnik
 * @since 02/13/2018
 */
public interface Limit {
    public class Value implements Limit {
        private final Object limit;

        public Value(Object limit) {
            this.limit = limit;
        }
    }

    public class Range implements Limit {
        private final Comparable low;
        private final Comparable high;

        public Range(Comparable low, Comparable high) {
            this.low = low;
            this.high = high;
        }
    }

    public class Set implements Limit {
        private final java.util.Set set;

        public Set(java.util.Set set) {
            this.set = set;
        }
    }
}
