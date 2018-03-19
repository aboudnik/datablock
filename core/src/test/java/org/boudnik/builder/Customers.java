package org.boudnik.builder;

import java.util.Map;
import java.util.Set;

/**
 * @author Alexandre_Boudnik
 * @since 03/16/18 11:51
 */
public class Customers extends Dimensional {
    @Override
    public String type() {
        return "customers";
    }

    public Customers(Map<String, Object>dimensions) {
        super(dimensions);
    }
}
