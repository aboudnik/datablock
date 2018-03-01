package org.boudnik.datablock.core;

import org.boudnik.framework.Store;

/**
 * @author Alexandre_Boudnik
 * @since 02/13/2018
 */
public class Main {
    public static void main(String[] args) {
        Store instance = Store.instance();
        System.out.println("Main.main");
    }
}
