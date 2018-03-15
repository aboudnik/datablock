package org.boudnik.builder;

import java.util.Map;

/**
 * @author Alexandre_Boudnik
 * @since 03/15/18 13:41
 */
public class Dimension<K, V> implements Map.Entry<K, V> {

    private final K key;
    private final V value;

    public Dimension(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        throw new NoSuchMethodError();
    }
}
