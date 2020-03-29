package com.datastruct.hashtable;

import java.util.TreeMap;

/**
 * 哈希表
 * @param <K>   键
 * @param <V>   值
 */
public class HashTable<K, V> {
    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static final int initCapacity = 7;

    private TreeMap<K, V>[] table;
    private int capacity;
    private int size;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.table = new TreeMap[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(initCapacity);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(K key) {
        return table[hash(key)].containsKey(key);
    }

    public void put(K key, V value) {
        TreeMap<K, V> map = table[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;
            if (size >= capacity * upperTol) {
                resize(2 * capacity);
            }
        }
    }

    public V get(K key) {
        return table[hash(key)].get(key);
    }

    public V remove(K key) {
        TreeMap<K, V> map = table[hash(key)];
        V ret = null;
        if (map.containsKey(key)) {
            size--;
            ret = map.remove(key);
            if (size < capacity * lowerTol && capacity / 2 >= initCapacity) {
                resize(capacity / 2);
            }
        }
        return ret;
    }

    private void resize(int newCapacity) {
        TreeMap<K, V>[] newTable = new TreeMap[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            newTable[i] = new TreeMap<>();
        }
        // rehash
        capacity = newCapacity;
        for (int i = 0; i < table.length; i++) {
            for (K key : table[i].keySet()) {
                newTable[hash(key)].put(key, table[i].get(key));
            }
        }
        table = newTable;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }
}
