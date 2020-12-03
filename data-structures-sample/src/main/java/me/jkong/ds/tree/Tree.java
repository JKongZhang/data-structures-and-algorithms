package me.jkong.ds.tree;

/**
 * tree operation
 *
 * @author Laba Zhang
 */
public interface Tree<E> {
    int size();

    boolean isEmpty();

    void clear();

    void add(E e);

    E remove(E e);

    boolean contains(E e);
}
