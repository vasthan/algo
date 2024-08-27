package com.datastruct.linkedlist;

/**
 * @author 拓破
 */
public class LinkedList2<E> {

    private ListNode dummyHead;
    private int size;

    public LinkedList2() {
        this.dummyHead = new ListNode();
        this.size = 0;
    }

    // 链表头部添加元素
    public void addFirst(E e) {
        add(0, e);
    }

    // 链表尾部添加元素
    public void addLast(E e) {
        add(size, e);
    }

    // 链表指定位置添加元素
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("invalid index");
        }
        // 找到待插入位置的前一个元素
        ListNode pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new ListNode(e, pre.next);
        size++;
    }

    // 获取指定位置的元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("invalid index");
        }
        ListNode cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("invalid index");
        }
        ListNode cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e) {
        ListNode cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    // 删除指定位置的元素
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("invalid index");
        }
        // 找到待删除元素的前一个节点
        ListNode pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode delNode = pre.next;
        pre.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    public E removeFist() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private class ListNode {
        E e;
        ListNode next;

        public ListNode() {
        }

        public ListNode(E e) {
            this.e = e;
        }

        public ListNode(E e, ListNode next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e == null ? null : e.toString();
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (ListNode cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur).append("->");
        }
        res.append("null");
        return res.toString();
    }
}
