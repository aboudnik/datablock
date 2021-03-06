package org.boudnik.builder;

/**
 * @author Alexandre_Boudnik
 * @since 03/15/18 18:02
 */
public class Inventory extends Dimensional {

    @Override
    public String type() {
        return "inventory";
    }

    public Inventory(Dimension... dimensions) {
        super(dimensions);
    }
}
