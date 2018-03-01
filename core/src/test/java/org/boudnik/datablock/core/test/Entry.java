package org.boudnik.datablock.core.test;

import org.boudnik.framework.OBJ;

/**
 * @author Alexandre_Boudnik
 * @since 03/01/18 14:20
 */
public class Entry implements OBJ<String> {
    private final String  url;

    public Entry(String url) {
        this.url = url;
    }

    @Override
    public String getKey() {
        return url;
    }
}
