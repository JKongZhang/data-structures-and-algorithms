package me.jkong.ds.queue;

import me.jkong.ds.list.LinkedList;

/**
 * 基于双向链表实现队列
 *
 * @author Laba Zhang
 */
public class QueueByLinkedList<E> {
    private LinkedList<E> data = new LinkedList<>();

    public void enQueue(E e) {
        data.add(e);
    }

    public E deQueue() {
        return data.remove(0);
    }

    public E front() {
        return data.get(0);
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }


    public void clear() {
        data.clear();
    }

}
