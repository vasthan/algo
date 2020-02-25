package com.datastruct.map;

public interface Map<K, V> {

    void add(K key, V value);
    void set(K key, V value);
    boolean contains(K key);
    V get(K key);
    V remove(K key);
    boolean isEmpty();
    int getSize();
}
