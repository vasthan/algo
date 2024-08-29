package com.leetcode;

import java.util.*;

/**
 * 添加元素
 * 查找元素
 * 删除元素
 * 遍历树
 *
 * @author 拓破
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private class Node {
        E e;
        Node left;
        Node right;

        public Node(E e) {
            this.e = e;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    // 向BST中插入元素e
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 在以node为根的二分搜索树中插入元素e，返回插入元素后的新二分搜索树的根节点
     */
    private Node add(Node node, E e) {
        if (node == null) {
            this.size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            // e小于node，递归往左子树上插入
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            // e大于node，递归往右子树上插入
            node.right = add(node.right, e);
        }
        // e等于node，啥也不干
        return node;
    }

    // 查看BST是否包含元素e
    public boolean contains(E e) {
        return contains(this.root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        int c = e.compareTo(node.e);
        if (c == 0) {
            return true;
        } else if (c < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    // 获取二分搜索树中的最小元素
    public E minimum() {
        if (root == null) {
            return null;
        }
        return minimum(root).e;
    }

    // 寻找以node为根节点的二分搜索树中的最小节点
    private Node minimum(Node node) {
        return node.left == null ? node : minimum(node.left);
    }

    // 获取二分搜索树中的最大元素
    public E maximum() {
        if (root == null) {
            return null;
        }
        return maximum(root).e;
    }

    // 寻找以node为根节点的二分搜索树中的最大节点
    private Node maximum(Node node) {
        return node.right == null ? node : maximum(node.right);
    }

    // 删除并返回二分搜索树中的最小元素
    public E removeMin() {
        E min = minimum();
        root = removeMin(root);
        return min;
    }

    // 删除以node为根的二分搜索树中的最小节点，返回新的二分搜索树的根
    private Node removeMin(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            // 删除node
            Node right = node.right;
            node.right = null;
            size--;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    // 删除并返回二分搜索树中的最大元素
    public E removeMax() {
        E max = maximum();
        root = removeMax(root);
        return max;
    }

    // 删除以node为根的二分搜索树中的最大节点，返回新的二分搜索树的根
    private Node removeMax(Node node) {
        if (node == null) {
            return null;
        }

        // 找到最右边的节点，即最大节点
        if (node.right == null) {
            Node left = node.left;
            node.left = null;
            size--;
            return left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    // 删除二分搜索树中的元素
    public void removeElement(E e) {
        root = removeElement(root, e);
    }

    // 在以node为根节点的二分搜索树中删除e，返回新的二分搜索树的根节点
    private Node removeElement(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) == 0) {
            // 如果左子树为空，直接返回右子树
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            }
            // 如果右子树为空，直接返回左子树
            if (node.right == null) {
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            }
            // 左右子树都不为空
            // 1.删除并返回右子树的最小节点
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        } else if (e.compareTo(node.e) < 0) {
            node.left = removeElement(node.left, e);
        } else {
            node.right = removeElement(node.right, e);
        }
        return node;
    }


    // 前序遍历
    public void preOrder() {
        preOrder(root);
    }

    // 前序遍历非递归实现
    public void preOrderNR() {
        // 使用一个栈模拟递归
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    // 中序遍历
    public void inOrder() {
        inOrder(root);
    }

    // 后序遍历
    public void postOrder() {
        postOrder(root);
    }

    // 层序遍历-BFS
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            bst.add(r.nextInt(100));
        }

        bst.add(77);
//        bst.preOrder();
//        bst.preOrderNR();

        bst.levelOrder();

        bst.removeElement(77);
        System.out.println();
        bst.levelOrder();
    }

}
