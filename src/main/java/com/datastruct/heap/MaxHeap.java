package com.datastruct.heap;

import com.datastruct.array.Array;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap() {
        this.data = new Array<>();
    }

    public MaxHeap(int capacity) {
        this.data = new Array<>(capacity);
    }

    // heapify堆化
    public MaxHeap(E[] arr) {
        this.data = new Array<>(arr);
        for (int i = parent(data.getSize() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int index) {
        if (index <= 0) {
            throw new IllegalArgumentException("Illegal index.");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return (index * 2) + 1;
    }

    private int rightChild(int index) {
        return (index * 2) + 2;
    }

    // 向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    // 从堆中提取出最大元素
    public E extractMax() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("head is empty");
        }
        E e = getMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return e;
    }

    public E getMax() {
        return data.getFirst();
    }

    // 上浮
    private void siftUp(int k) {
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    // 下沉
    private void siftDown(int k) {
        // 直到没有孩子节点
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j++;
            }
            if (data.get(k).compareTo(data.get(j)) > 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }
    
    public E replace(E e) {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Heap is empty");
        }
        E res = getMax();
        data.set(0, e);
        siftDown(0);
        return res;
    }
}
