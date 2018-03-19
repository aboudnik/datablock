package org.boudnik.builder;

import java.util.Map;

/**
 * @author Alexandre_Boudnik
 * @since 03/15/18 18:02
 */
public class Inventory extends Dimensional {

    public Inventory(Map<String, Object> dimensions) {
        super(dimensions);
    }

    @Override
    public String type() {
        return "inventory";
    }
}
