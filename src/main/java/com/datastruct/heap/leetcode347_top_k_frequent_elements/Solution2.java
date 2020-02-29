package com.datastruct.heap.leetcode347_top_k_frequent_elements;

import java.util.*;

public class Solution2 {

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
        // jdk中的PriorityQueue默认是最小堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Integer num : map.keySet()) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (map.get(num) > map.get(queue.peek())) {
                queue.remove();
                queue.add(num);
            }
        }

        List<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            list.add(queue.remove());
        }
        return list;
    }
}
