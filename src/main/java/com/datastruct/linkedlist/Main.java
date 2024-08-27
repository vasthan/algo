package com.datastruct.linkedlist;

import com.datastruct.linkedlist.problems.leetcode203_remove_linked_list_elements.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {
//
//        LinkedList2<Integer> linkedList = new LinkedList2<>();
//
//        for (int i = 0; i < 5; i++) {
//            linkedList.addLast(i);
//            System.out.println(linkedList);
//        }
//
//        linkedList.addFirst(-2);
//        System.out.println(linkedList);
//        linkedList.add(1, -1);
//        System.out.println(linkedList);
//
//        linkedList.remove(2);
//        System.out.println(linkedList);
//
//        linkedList.removeFist();
//        System.out.println(linkedList);
//
//        linkedList.removeLast();
//        System.out.println(linkedList);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());

    }
}
