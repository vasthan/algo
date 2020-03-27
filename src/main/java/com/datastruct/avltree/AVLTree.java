package com.datastruct.avltree;

import com.datastruct.map.Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 基于二分搜索树实现的map
 */
public class AVLTree<K extends Comparable, V> implements Map<K, V> {

    private class Node {
        K key;
        V value;
        Node left;
        Node right;
        int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
            this.height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        this.root = null;
        this.size = 0;
    }

    // 判断当前的树是不是一棵二分搜索树
    public boolean isBST() {
        List<K> keys = new ArrayList<>();
        // 进行一次中序遍历，结果如果是有序的，则是一个BST
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(Node node, List<K> keys) {
        if (node == null) {
            return;
        }
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    // 判断当前的树是不是平衡的
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void add(K key, V value) {
        root = add(root , key, value);
    }

    // 在以node为根的二分搜索树中添加元素(key, value)，返回新的二分搜索树的根，递归算法
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }

        // 更新节点的高度
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // 维护树的平衡
        int balanceFactor = getBalanceFactor(node);

        // LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            // 意味着以node为根的子树整体向左倾斜，需要进行右旋转平衡
            return rightRotate(node);
        }

        // RR
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            // 意味着以node为根的子树整体向右倾斜，需要进行左旋转平衡
            return leftRotate(node);
        }

        // LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            // 先对node.left进行左旋转，转换成LL
            node.left = leftRotate(node.left);
            // 再对node进行右旋转
            return rightRotate(node);
        }

        // RL
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            // 同理，先转成RR，再进行左旋转
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    private Node rightRotate(Node y) {
        Node x = y.left;
        y.left = x.right;
        x.right = y;

        // 更新高度 T1、T2、T3、T4的高度不变
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node leftRotate(Node y) {
        Node x = y.right;
        y.right = x.left;
        x.left = y;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (node != null) {
            node.value = value;
        } else {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        } else {
            return null;
        }
    }

    // 在以node为根的二分搜索树中删除key对应的节点，返回新的的二分搜索树的根
    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            Node successor = getMin(node);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    // 查找以node为根的二分搜索树中的最小节点
    private Node getMin(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return getMin(node.left);
        }
    }

    // 删除以node为根的二分搜索树的最小节点，并返回新的二分搜索树的根
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    // 在以node为根的二分搜索树中查找key的节点
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        } else {
            return node;
        }
    }

    // 获取节点的高度
    private int getHeight(Node node) {
        return node == null ? 0 : node.height;
    }

    // 获取节点的平衡因子
    private int getBalanceFactor(Node node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }
}
