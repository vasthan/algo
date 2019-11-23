package com.adc.stack;

/**
 * 定容栈简单实现
 * 完整实现 {@link ResizingArrayStack}
 * @param <T>
 */
public class FixedCapacityStack<T> {
    private T[] a;
    private int count;

    public FixedCapacityStack(int capacity) {
        this.a = (T[]) new Object[capacity];
    }

    public int capacity() {
        return a.length;
    }

    public boolean push(T item) {
        if (count == capacity()) {
            return false;
        }
        a[count++] = item;
        return true;
    }

    public T pop() {
        if (count == 0) {
            return null;
        }
        return a[--count];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }
}
