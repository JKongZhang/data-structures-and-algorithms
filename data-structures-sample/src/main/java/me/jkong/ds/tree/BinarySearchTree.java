package me.jkong.ds.tree;

import java.util.Comparator;

/**
 * 二分搜索树
 *
 * @author Laba Zhang
 */
@SuppressWarnings("unchecked")
public class BinarySearchTree<E> implements Tree<E> {
    private int size;

    private Node<E> root;

    private Comparator<E> comparator;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public void add(E e) {
        elementNotNullCheck(e);

        if (root == null) {
            root = new Node<>(e, null);
        }
        // root != null
        Node<E> node = root;
        while (true) {
            int com = compare(e, node.data);
            if (com > 0) {
                if (node.right == null) {
                    node.right = new Node<>(e, node);
                    break;
                }
                node = node.right;
            } else if (com < 0) {
                if (node.left == null) {
                    node.left = new Node<>(e, node);
                    break;
                }
                node = node.left;
            } else {
                // 相等情况
                return;
            }
        }
        size++;
    }

    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
    }

    private void elementNotNullCheck(E e) {
        if (e == null) {
            throw new IllegalArgumentException("element must not null");
        }
    }

    @Override
    public E remove(E e) {
        return null;
    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    private static class Node<E> {
        E data;
        Node<E> parent;
        Node<E> left;
        Node<E> right;

        public Node(E data, Node<E> parent) {
            this.data = data;
            this.parent = parent;
        }
    }
}
