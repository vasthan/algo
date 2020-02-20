package com.datastruct.linkedlist.problems.leetcode203_remove_linked_list_elements;


/**
 * 使用虚拟头节点简化代码逻辑
 * 注：为了代码简洁，这个解法中没有对删除的节点（loitering object）进行内存回收（把被删除节点的next指针设置为null）
 */
public class Solution2 {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        head = new Solution2().removeElements(head, 6);
        System.out.println(head);
    }
}
