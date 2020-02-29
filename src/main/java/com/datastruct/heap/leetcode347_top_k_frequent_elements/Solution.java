package com.datastruct.heap.leetcode347_top_k_frequent_elements;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Solution {

    private class Array<E> {
        private E[] data;
        private int size;

        public Array(int capacity) {
            this.data = (E[]) new Object[capacity];
            this.size = 0;
        }

        public Array() {
            this(10);
        }

        public Array(E[] arr) {
            this.data = (E[]) new Object[arr.length];
            for (int i = 0; i < arr.length; i++) {
                this.data[i] = arr[i];
            }
            this.size = this.data.length;
        }

        public int getSize() {
            return size;
        }

        public int getCapacity() {
            return data.length;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        // 数组尾部添加元素
        public void addLast(E e) {
            add(size, e);
        }

        // 数组头部添加元素
        public void addFirst(E e) {
            add(0, e);
        }

        // 数组指定位置添加元素
        public void add(int index, E e) {
            if (index < 0 || index > size)
                throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size");

            if (size == data.length) {
                resize(2 * data.length);
            }

            for (int i = size - 1; i >= index; i--)
                data[i + 1] = data[i];

            data[index] = e;
            size++;
        }

        public E get(int index) {
            if (index < 0 || index >= size)
                throw new IllegalArgumentException("Get failed. Index is illegal.");
            return data[index];
        }

        public E getLast() {
            return get(size - 1);
        }

        public E getFirst() {
            return get(0);
        }

        // 设置数组指定索引位置的值，并返回之前的值
        public E set(int index, E e) {
            if (index < 0 || index >= size)
                throw new IllegalArgumentException("Get failed. Index is illegal.");
            E oldValue = data[index];
            data[index] = e;
            return oldValue;
        }

        public boolean contains(E e) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(e)) {
                    return true;
                }
            }
            return false;
        }

        // 查找数组某个值对应的索引，如果不存在，返回-1
        public int find(E e) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(e)) {
                    return i;
                }
            }
            return -1;
        }

        // 删除指定索引位置的元素
        public E remove(int index) {
            if (index < 0 || index >= size) {
                throw new IllegalArgumentException("Remove failed. Index is illegal.");
            }
            E oldValue = data[index];
            for (int i = index + 1; i < size; i++) {
                data[i - 1] = data[i];
            }
            size--;
            data[size] = null; //loitering object != memory leak
            if (data.length / 4 == size && data.length / 2 != 0) {
                resize(data.length / 2);
            }
            return oldValue;
        }

        public E removeFirst() {
            return remove(0);
        }

        public E removeLast() {
            return remove(size - 1);
        }

        public void removeElement(E e) {
            int index = find(e);
            if (index != -1) {
                remove(index);
            }
        }

        private void resize(int newCapacity) {
            E[] newData = (E[]) new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }

        public void swap(int i, int j) {
            E tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
        }

        @Override
        public String toString() {
            StringBuilder str = new StringBuilder();
            str.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
            str.append("[");
            for (int i = 0; i < size; i++) {
                str.append(data[i]);
                if (i != size - 1) {
                    str.append(", ");
                }
            }
            str.append("]");
            return str.toString();
        }
    }

    private class MaxHeap<E extends Comparable<E>> {

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

    private class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

        private MaxHeap<E> maxHeap;

        public PriorityQueue() {
            this.maxHeap = new MaxHeap<>();
        }

        @Override
        public void enqueue(E e) {
            maxHeap.add(e);
        }

        @Override
        public E dequeue() {
            return maxHeap.extractMax();
        }

        @Override
        public E getHead() {
            return maxHeap.getMax();
        }

        @Override
        public int getSize() {
            return maxHeap.size();
        }

        @Override
        public boolean isEmpty() {
            return maxHeap.isEmpty();
        }
    }

    private interface Queue<E> {

        void enqueue(E e);

        E dequeue();

        E getHead();

        int getSize();

        boolean isEmpty();
    }

    private class Freq implements Comparable<Freq>{
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (freq < another.freq) {
                return 1;
            } else if (freq > another.freq) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        // 统计频次，使用treemap
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // 维护一个优先级队列（最小堆，频次越小，优先级越高），保存频次最多的前k个数字
        PriorityQueue<Freq> queue = new PriorityQueue<>();
        for (Integer num : map.keySet()) {
            if (queue.getSize() < k) {
                queue.enqueue(new Freq(num, map.get(num)));
            } else if (map.get(num) > queue.getHead().freq) {
                queue.dequeue();
                queue.enqueue(new Freq(num, map.get(num)));
            }
        }

        List<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            list.add(queue.dequeue().e);
        }
        return list;
    }
}
