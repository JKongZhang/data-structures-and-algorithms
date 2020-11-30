package me.jkong.ds.queue;

/**
 * 双端队列
 *
 * @author Laba Zhang
 */
public interface Deque<E> {
    /**
     * 从对头入队
     *
     * @param e e
     */
    void enQueueFront(E e);

    /**
     * 从队尾出队
     *
     * @return e
     */
    E deQueueEnd();
}
