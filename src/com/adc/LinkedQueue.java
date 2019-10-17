package com.geek.algo;

public class LinkedQueue<T> {
    private class Node<T> {
        T item;
        Node next;
    }

    private Node<T> first;
    private Node<T> last;

    private int n;

    public void enQueue(T item) {
        Node<T> node = new Node<>();
        node.item = item;

        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        n++;
    }

    public T deQueue() {
        if (isEmpty()) {
            return null;
        }
        T item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        n--;
        return item;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.deQueue());
        }
    }
}
