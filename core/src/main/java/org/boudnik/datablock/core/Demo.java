package org.boudnik.datablock.core;

import java.util.function.Supplier;

/**
 * @author Alexandre_Boudnik
 * @since 02/20/2018
 */
public class Demo {
    public static void main(String[] args) {
        Supplier<BlockFactory> shapeFactory = BlockFactory::new;

        shapeFactory.get().getShape("circle").draw();
        shapeFactory.get().getShape("rectangle").draw();
    }
}
