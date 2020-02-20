package com.datastruct.linkedlist.problems.leetcode203_remove_linked_list_elements;


/**
 * 递归方式删除链表元素
 */
public class Solution3 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode res = new Solution3().removeElements(new ListNode(nums), 6);
        System.out.println(res);
    }
}
