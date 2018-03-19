package org.boudnik.builder;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;

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
        Resource sales = builder.build(
                new Sales(new HashMap<String, Object>() {{
                    put("department", 42);
                }}));
        assertNotNull(sales);
        assertTrue(sales.prerequisites().isEmpty());
        assertFalse(sales.dimensions().isEmpty());
        assertTrue(sales.isSatisfied());
    }

    @Test
    public void build() {
        Resource sales = builder.build(
                new Sales(new HashMap<String, Object>() {{
                    put("date", LocalDate.of(2018, 1, 26));
                    put("department", 42);
                }}));
        assertNotNull(sales);
        assertFalse(sales.prerequisites().isEmpty());
        System.out.println("sales = " + sales);
        assertFalse(sales.dimensions().isEmpty());
    }
}