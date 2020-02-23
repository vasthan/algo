package com.datastruct.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二分搜索树BinarySearchTree
 */
public class BST<E extends Comparable<E>> {

    private class Node<E> {
        E e;
        Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 向二分搜索树中添加新的元素e
    public void add(E e) {
        root = add(root, e);
    }

    // 向以node为根的二分搜索树中添加元素e，递归算法
    // 返回以插入新节点后二分搜索树的根
    private Node add(Node<E> node, E e) {
        if (node == null) {
            size++;
            return new Node<>(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node<E> node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else {
            return true;
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    // 前序遍历以node为根的二分搜索树，递归算法
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 前序遍历的非递归实现 NR表示Non-Recursive
    public List<E> preOrderNR() {
        List<E> res = new ArrayList<>(size);
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<E> cur = stack.pop();
            res.add(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return res;
    }

    public void inOrder() {
        inOrder(root);
    }

    // 中序遍历以node为根的二分搜索树，递归算法
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 中序遍历非递归实现
    public List<E> inOrderNR() {
        List<E> res = new ArrayList<>(size);
        Stack<Node> stack = new Stack<>();
        Node<E> cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.e);
            cur = cur.right;
        }
        return res;
    }

    public void postOrder() {
        postOrder(root);
    }

    // 后序遍历以node为根的二分搜索树，递归算法
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    // 后序遍历非递归实现
    public List<E> postOrderNR() {
        List<E> res = new ArrayList<>(size);
        if (root == null) {
            return res;
        }

        Stack<Node> stack = new Stack<>();
        Stack<E> tmp = new Stack<>();
        stack.push(root);

        // 反向前序遍历（中 -> 右 -> 左），push到临时栈tmp中，再pop出栈就变成了（左 -> 右 -> 中）
        while (!stack.isEmpty()) {
            Node<E> cur = stack.pop();
            tmp.push(cur.e);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }

        while (!tmp.isEmpty()) {
            res.add(tmp.pop());
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0 , res);
        return res.toString();
    }

    // 前序遍历方式生成以node为根的二叉搜索树的字符串表示
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
        } else {
            res.append(generateDepthString(depth) + node.e + "\n");
            generateBSTString(node.left, depth + 1, res);
            generateBSTString(node.right, depth + 1, res);
        }
    }

    private String generateDepthString(int depth) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            str.append("--");
        }
        return str.toString();
    }
}
