package org.boudnik.builder;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Alexandre_Boudnik
 * @since 03/15/18 17:19
 */
public class Sales implements Resource {
    @Override
    public String type() {
        return "sales";
    }

    @Override
    public Set<Resource> prerequisites() {
        return dimensions().stream().map(new Function<Dimension, Resource>() {
            @Override
            public Resource apply(Dimension dimension) {
                return null;
            }
        }).onClose(new Runnable() {
            @Override
            public void run() {

            }
        }).collect(Collectors.toSet());
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
