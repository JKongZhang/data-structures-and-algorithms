package me.jkong.ds.stack;

import me.jkong.ds.list.ArrayList;

/**
 * stack
 * {@link java.util.Stack}
 *
 * @author Laba Zhang
 */
public class StackByArrayList<E> {

    private final ArrayList<E> data = new ArrayList<>();

    public void push(E e) {
        data.add(e);
    }

    public E pop() {
        return data.remove(data.size() - 1);
    }

    public E peek() {
        return data.get(data.size() - 1);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int size() {
        return data.size();
    }
}
