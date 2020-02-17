package com.datastruct.queue;

public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E getHead();

    int getSize();

    boolean isEmpty();
}
