package org.boudnik.builder;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * @author Alexandre_Boudnik
 * @since 03/15/18 13:32
 */
public class BuilderTest {

    private Builder builder;

    @Before
    public void setUp() {
        builder = Builder.instance();
        assertNotNull(builder);
    }

    @Test
    public void buildNoDependencies() {
        Stores stores = builder.build(
                new Stores(
                        new Dimension("department", 42)
                ));
        assertNotNull(stores);
        assertFalse(stores.dimensions().isEmpty());
        assertTrue(stores.prerequisites().isEmpty());
        assertTrue(stores.isSatisfied());
    }

    @Test
    public void build() {
        Sales sales = builder.build(
                new Sales(
                        new Dimension("date", LocalDate.of(2018, 1, 26)),
                        new Dimension("quarter", LocalDate.of(2018, 1, 1), LocalDate.of(2018, 3, 31)),
                        new Dimension("department", 42)
                )
        );
        assertNotNull(sales);
        assertFalse(sales.dimensions().isEmpty());
        assertFalse(sales.prerequisites().isEmpty());
        assertFalse(sales.isSatisfied());
        System.out.println("sales = " + sales);
    }
}