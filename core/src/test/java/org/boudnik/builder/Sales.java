package org.boudnik.builder;

import java.util.*;

/**
 * @author Alexandre_Boudnik
 * @since 03/15/18 17:19
 */
public class Sales extends Dimensional {

    public static final String DEPARTMENT = "department";
    public static final String DATE = "month";

    public Sales(Map<String, Object> dimensions) {
        super(dimensions);
    }

    @Override
    public String type() {
        return "sales";
    }

    @Override
    public Set<Resource> prerequisites() {
        Map<String, Object> dimensions = dimensions();

        Map<String, Object> inventory = new HashMap<>();
        inventory.put(DEPARTMENT, dimensions.get(DEPARTMENT));

        Map<String, Object> customers = new HashMap<>();
        customers.put(DEPARTMENT, dimensions.get(DEPARTMENT));
        customers.put(DATE, dimensions.get(DATE));

        return new HashSet<>(Arrays.asList(
                new Inventory(inventory),
                new Customers(customers)
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
