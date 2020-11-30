package me.jkong.ds.queue;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 测试双端队列
 *
 * @author Laba Zhang
 */
class DequeByLinkedListTest {


    public static void main(String[] args) {
        DequeByLinkedList<Integer> queue = new DequeByLinkedList<>();
        queue.enQueueFront(1);
        queue.enQueue(2);
        queue.enQueueFront(3);
        queue.enQueue(4);
        queue.enQueueFront(5);

        while (!queue.isEmpty()) {
            System.out.println(queue.deQueue());
        }
    }
}