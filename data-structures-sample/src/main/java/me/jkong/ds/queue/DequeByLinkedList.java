package me.jkong.ds.queue;

/**
 * 双端队列
 *
 * @author Laba Zhang
 */
public class DequeByLinkedList<E> extends QueueByLinkedList<E> implements Deque<E> {

    @Override
    public void enQueueFront(E e) {
        data.add(0, e);
    }

    @Override
    public E deQueueEnd() {
        return data.remove(data.size() - 1);
    }

}
