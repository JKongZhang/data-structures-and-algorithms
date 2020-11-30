package me.jkong.ds.queue;

import me.jkong.ds.list.LinkedList;

/**
 * 基于双向链表实现队列
 *
 * @author Laba Zhang
 */
public class QueueByLinkedList<E> implements Queue<E>{
    protected LinkedList<E> data = new LinkedList<>();

    @Override
    public void enQueue(E e) {
        data.add(e);
    }

    @Override
    public E deQueue() {
        return data.remove(0);
    }

    @Override
    public E front() {
        return data.get(0);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }


    @Override
    public void clear() {
        data.clear();
    }

}
