package com.geek.algo;

/**
 * 链表实现的栈
 */
public class LinkedStack<T> {
    // 栈顶元素，链表的表头
    private Node<T> first;

    private int n;

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(T item) {
        Node<T> oldFirst = first;

        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T item = first.item;
        first = first.next;
        n--;
        return item;
    }

    private class Node<T> {
        T item;
        Node next;
    }

    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack();

        for (int i = 1; i <= 10; i++) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}
