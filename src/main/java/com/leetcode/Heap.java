package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 最大堆
 * @author 拓破
 */
public class Heap<E extends Comparable<E>> {

    private List<E> data;

    public Heap() {
        this.data = new ArrayList<>();
    }

    // 向堆中添加元素
    public void add(E e) {
        if (e == null) {
            throw new NullPointerException("e cannot be null");
        }
        data.add(e);
        siftUp(data.size() - 1);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 删除堆中最大元素
    public E remove() {
        if (data.isEmpty()) {
            throw new RuntimeException("can not remove element from a empty heap");
        }
        E max = data.get(0);
        swap(data, 0, data.size() - 1);
        data.remove(data.size() - 1);
        siftDown(0);
        return max;
    }

    // 获取父节点的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index " + index + " has no parent");
        }
        return (index - 1) / 2;
    }

    // 获取左孩子的索引
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // 获取右孩子的索引
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // 索引k维值的元素上浮
    private void siftUp(int k) {
        if (k == 0) {
            return;
        }
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0) {
            swap(data, k, parent(k));
            k = parent(k);
        }
    }

    // 索引k位置的元素下沉
    private void siftDown(int k) {
        while (leftChild(k) < data.size()) { // 当k有孩子节点的时候
            // 定义j为左右子节点中较大的节点对应的索引
            int j = leftChild(k);
            int rightChild = j + 1;
            if (rightChild < data.size() && data.get(j).compareTo(data.get(rightChild)) < 0) {
                j = rightChild;
            }
            // 比价k和j处的元素大小
            if (data.get(k).compareTo(data.get(j)) > 0) {
                break;
            }
            swap(data, k, j);
            k = j;
        }
    }

    private void swap(List<E> data, int i, int j) {
        E e = data.get(i);
        data.set(i, data.get(j));
        data.set(j, e);
    }

    public static void main(String[] args) {
        Random r = new Random();
        Heap<Integer> heap = new Heap<>();
        for (int i = 0; i < 20; i++) {
            heap.add(r.nextInt(100));
        }
        while (!heap.isEmpty()) {
            System.out.println(heap.remove());
        }
    }
}
