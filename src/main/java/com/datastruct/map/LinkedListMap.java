package com.datastruct.map;

/**
 * 基于链表实现的map
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node {
        K key;
        V value;
        Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key + " : " + value;
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            } else {
                cur = cur.next;
            }
        }
        return null;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            // 添加
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            // 覆盖
            node.value = value;
        }
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException("key doesn't exists.");
        }
        node.value = value;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public V remove(K key) {
        Node cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.key.equals(key)) {
                break;
            }
            cur = cur.next;
        }

        if (cur.next != null) {
            Node delNode = cur.next;
            cur.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        throw new IllegalArgumentException("key doesn't exists.");

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }
}
