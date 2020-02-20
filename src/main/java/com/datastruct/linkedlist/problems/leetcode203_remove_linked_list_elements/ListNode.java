package com.datastruct.linkedlist.problems.leetcode203_remove_linked_list_elements;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    // 为辅助测试leetcode代码
    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr is empty.");
        }

        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            res.append(cur.val).append("-->");
            cur = cur.next;
        }
        res.append("null");
        return res.toString();
    }
}