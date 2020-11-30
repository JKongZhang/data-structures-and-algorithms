package me.jkong.ds.queue;

/**
 * queue interface
 *
 * @author Laba Zhang
 */
public interface Queue<E> {
    /**
     * 入队
     *
     * @param e e
     */
    void enQueue(E e);

    /**
     * 出队
     *
     * @return e
     */
    E deQueue();

    /**
     * 头元素
     *
     * @return e
     */
    E front();

    /**
     * 队列大小
     *
     * @return size
     */
    int size();

    /**
     * 是否为空
     *
     * @return true: 空
     */
    boolean isEmpty();

    /**
     * 清空队列
     */
    void clear();
}

