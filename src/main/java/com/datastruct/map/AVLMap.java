package com.datastruct.map;

import com.datastruct.avltree.AVLTree;

public class AVLMap<K extends Comparable<K>, V> implements Map<K, V> {

    private AVLTree<K, V> avl;

    public AVLMap() {
        this.avl = new AVLTree();
    }

    @Override
    public void add(K key, V value) {
        this.avl.add(key, value);
    }

    @Override
    public void set(K key, V value) {
        avl.set(key, value);
    }

    @Override
    public boolean contains(K key) {
        return avl.contains(key);
    }

    @Override
    public V get(K key) {
        return avl.get(key);
    }

    @Override
    public V remove(K key) {
        return avl.remove(key);
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }
}
