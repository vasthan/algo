package com.datastruct.queue;

/**
 * 数组实现的循环队列：优化普通数组队列出队O(n)时间复杂度
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int size;
    private int head, tail;

    public LoopQueue(int capacity) {
        this.data = (E[]) new Object[capacity + 1];
        this.size = this.head = this.tail = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        if (isFull()) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty!");
        }
        E e = data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        size--;
        if (size <= getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return e;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + head) % data.length];
        }
        this.data = newData;
        this.head = 0;
        this.tail = size;
    }

    @Override
    public E getHead() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty!");
        }
        return data[head];
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % data.length == head;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("head: [");
        for (int i = head; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(",");
            }
        }
        res.append("] tail;").append(" capacity: ").append(getCapacity());
        return res.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            if (i % 3 == 2) {
                queue.dequeue();
            }
            System.out.println(queue);
        }
    }
}
