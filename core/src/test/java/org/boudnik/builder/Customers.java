package org.boudnik.builder;

/**
 * @author Alexandre_Boudnik
 * @since 03/16/18 11:51
 */
public class Customers extends Dimensional {
    @Override
    public String type() {
        return "customers";
    }

    public Customers(Dimension... dimensions) {
        super(dimensions);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
