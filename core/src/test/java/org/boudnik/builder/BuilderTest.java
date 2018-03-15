package org.boudnik.builder;

import org.junit.Before;
import org.junit.Test;

import static org.boudnik.builder.Resource.Helper.*;
import static org.junit.Assert.*;

/**
 * @author Alexandre_Boudnik
 * @since 03/15/18 13:32
 */
public class BuilderTest {

    private Builder builder;
    private Resource independentInventory;
    private Resource independentCustomers;

    @Before
    public void setUp() {
        builder = Builder.instance();
        assertNotNull(builder);
        independentInventory = builder.build("independentInventory", dimensions(), prerequisites());
        independentCustomers = builder.build("independentCustomers", dimensions(), prerequisites());
    }

    @Test
    public void buildNoDependencies() {
        Resource sales = builder.build(
                "sales",
                dimensions(new Dimension<>("department", 42)),
                prerequisites());
        assertNotNull(sales);
        assertTrue(sales.prerequisites().isEmpty());
        assertFalse(sales.dimensions().isEmpty());
        assertTrue(sales.isSatisfied());
    }

    @Test
    public void build() {
        Resource sales = builder.build(
                "sales",
                dimensions(new Dimension<>("month", "2016-12-01"), new Dimension<>("department", 42)),
                prerequisites(independentCustomers, independentInventory));
        assertNotNull(sales);
        assertFalse(sales.prerequisites().isEmpty());
        assertFalse(sales.dimensions().isEmpty());
//        assertTrue(sales.isSatisfied());
    }

}