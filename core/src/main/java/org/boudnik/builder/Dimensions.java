package org.boudnik.builder;

import java.util.*;

/**
 * @author Alexandre_Boudnik
 * @since 03/20/18 12:20
 */
public class Dimensions {
    private final List<Dimension> entries;

    public boolean isEmpty() {
        return entries.isEmpty();
    }

    @Override
    public String toString() {
        return String.valueOf(entries);
    }

    protected Set<String> keys() {
        return Collections.emptySet();
    }

    public Dimensions(Dimension... entries) {
        this(Arrays.asList(entries));
    }

    public Dimensions(List<Dimension> entries) {
        this.entries = entries;
    }

    Dimension get(String name) {
        for (Dimension entry : entries) {
             if(entry.getKey().equals(name))
                 return entry;
        }
        return null;
    }
}
