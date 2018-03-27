package org.boudnik.builder;

/**
 * @author Alexandre_Boudnik
 * @since 03/20/18 11:46
 */
public class Stores extends Dimensional {
    @Override
    public String type() {
        return "stores";
    }

    public Stores(Dimension... dimensions) {
        super(dimensions);
    }
}
