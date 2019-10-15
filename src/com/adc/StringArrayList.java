package com.adc;

import java.util.Arrays;

/**
 * 数组
 */
public class StringArrayList {
    private String[] data;
    private int capacity;
    private int size;

    public StringArrayList(int capacity) {
        this.capacity = capacity;
        this.data = new String[capacity];
        this.size = 0;
    }

    public void add(String item) {
        if (size == capacity) {
            resize(capacity + (capacity >> 1));
        }
        data[size++] = item;
    }

    public String get(int index) {
        if (index < 0 || index >= capacity) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return data[index];
    }

    public void remove(String item) {
        for (int i = 0; i < size; i++) {
            if (data[i] == item) {
                while (i < size - 1) {
                    data[i] = data[i + 1];
                    i++;
                }
                data[--size] = null;
                break;
            }
        }
    }

    private void resize(int newCapacity) {
        String[] newData = new String[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
        capacity = newCapacity;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    public static void main(String[] args) {
        StringArrayList list = new StringArrayList(5);
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");

        System.out.println(list.get(5));
        list.remove("f");
        System.out.println(list);

        list.add("f");
        System.out.println(list);

        list.remove("c");
        System.out.println(list);
    }
}
