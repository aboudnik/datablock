package org.boudnik.datablock.core;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author Alexandre_Boudnik
 * @since 02/20/2018
 */
public class BlockFactory {
    final static Map<String, Supplier<Block>> map = new HashMap<String, Supplier<Block>>() {{
        put("CIRCLE", Circle::new);
        put("RECTANGLE", Rectangle::new);
    }};

    public Block getShape(String shapeType) {
        Supplier<Block> shape = map.get(shapeType.toUpperCase());
        if (shape != null) {
            return shape.get();
        }
        throw new IllegalArgumentException("No such shape " + shapeType.toUpperCase());
    }
}
