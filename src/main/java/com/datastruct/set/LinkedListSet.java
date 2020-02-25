package com.datastruct.set;

import com.datastruct.linkedlist.LinkedList;

/**
 * 基于链表实现的Set
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> data;

    public LinkedListSet() {
        this.data = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!contains(e)) {
            data.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        data.removeElement(e);
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        return data.contains(e);
    }
}
