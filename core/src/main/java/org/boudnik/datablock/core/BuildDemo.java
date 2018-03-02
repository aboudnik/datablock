package org.boudnik.datablock.core;

import java.util.function.Supplier;

/**
 * @author Alexandre_Boudnik
 * @since 02/20/2018
 */
public class BuildDemo {
    public static void main(String[] args) {
        Supplier<Build> naive = () -> n -> {
            long rv = 0L;
            for (long i = 1; i <= n; ++i) {
                rv += i;
            }
            return rv;
        };
        Supplier<Build> gauss = () -> n -> (n * (n + 1)) / 2;

        System.out.println(naive.get().rebuild(100));
        System.out.println(gauss.get().rebuild(100));
    }
}
