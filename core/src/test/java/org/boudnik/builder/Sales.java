package org.boudnik.builder;

import java.util.*;

/**
 * @author Alexandre_Boudnik
 * @since 03/15/18 17:19
 */
public class Sales extends Dimensional {

    public static final String STATE = "state";
    public static final String DEPARTMENT = "department";
    public static final String DATE = "month";

    @Override
    public String type() {
        return "sales";
    }

    public Sales(Dimension... dimensions) {
        super(dimensions);
    }

    @Override
    public Set<String> names() {
        return new HashSet<>(Arrays.asList(STATE, DEPARTMENT, DATE));
    }

    @Override
    public Set<Resource> prerequisites() {
        Dimensions dimensions = dimensions();

        return new HashSet<>(Arrays.asList(
                new Inventory(
                        dimensions.get(DEPARTMENT)
                ),
                new Customers(
                        dimensions.get(DEPARTMENT),
                        dimensions.get("quarter")
                )
        ));
    }

    @Override
    public Object build() {
//        Set<Resource> prerequisites = prerequisites();
//        prerequisites.add(new Resource() {
//            @Override
//            public String type() {
//                return null;
//            }
//        })
//
        return null;
    }
}
