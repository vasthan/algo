package com.adc;

import lombok.Getter;
import lombok.Setter;

public class LRUCache<T> {

    @Getter
    @Setter
    private class Node<T> {
        private T data;
        private Node next;

        public Node() {
            this(null, null);
        }

        public Node(T data) {
            this(data, null);
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 头节点，哨兵 不存放数据
     */
    private Node<T> head;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.size = 0;
    }

    public void put(T data) {
        // 遍历链表，获取data对应的节点的前驱节点
        final Node preNode = findPre(data);
        if (preNode != null) {
            // 删除该节点
            delNext(preNode);
            // 放到链表头部
            putFirst(new Node(data));
        } else {
            if (size == capacity) {
                // 满了，删除尾部节点
                delLast();
            }
            putFirst(new Node(data));
        }
    }

    private void delLast() {
        if (size == 0) {
            return;
        }
        Node node = head;
        while (node.getNext().getNext() != null) {
            node = node.getNext();
        }
        node.setNext(null);
        size--;
    }

    private void putFirst(Node node) {
        node.setNext(head.getNext());
        head.setNext(node);
        size++;
    }


    private void delNext(Node preNode) {
        Node currentNode = preNode.getNext();
        preNode.setNext(currentNode.getNext());
        currentNode = null;
        size--;
    }

    private Node findPre(T data) {
        Node node = head;
        while (node != null) {
            if (node.getNext().getData().equals(data)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

}
