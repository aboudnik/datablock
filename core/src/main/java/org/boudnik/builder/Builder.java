package org.boudnik.builder;

/**
 * @author Alexandre_Boudnik
 * @since 03/15/18 13:29
 */
public class Builder {

    public static Builder instance() {
        return new Builder();
    }

    public <T extends Resource> T build(T resource) {
        return resource;
    }
}
