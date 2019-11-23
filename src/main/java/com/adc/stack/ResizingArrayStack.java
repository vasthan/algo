package com.adc.stack;

import java.util.Iterator;

/**
 * 数组实现可动态调整大小的栈
 * 防止对象游离
 * 可迭代
 */
public class ResizingArrayStack<T> implements Iterable{

    /**
     * 存放栈元素
     */
    private T[] a = (T[]) new Object[10];

    /**
     * 元素个数
     */
    private int n;

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void push(T item) {
        if (n == a.length) {
            resize(a.length * 2);
        }
        a[n++] = item;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T item = a[--n];
        // 即时回收不可触达对象，避免内存泄漏
        a[n] = null;
        if (n <= a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    private void resize(int length) {
        T[] tmp = (T[]) new Object[length];
        for (int i = 0; i < n; i++) {
            tmp[i] = a[i];
        }
        a = tmp;
    }

    /**
     * 支持foreach方式迭代
     */
    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    /**
     * 私有内部类，对外部隐藏迭代实现
     */
    private class ReverseArrayIterator implements Iterator<T> {

        private int i = n;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return a[--i];
        }
    }


    public static void main(String[] args) {

        ResizingArrayStack<String> stack = new ResizingArrayStack();
        for (int i = 0; i < 10; i++) {
            stack.push("hello:" + i);
        }

//        while (!stack.isEmpty()) {
//            System.out.println(stack.pop());
//        }

        Iterator iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
