package me.jkong.ds.queue;

/**
 * test queue by linked list
 *
 * @author Laba Zhang
 */
class QueueByLinkedListTest {

    public static void main(String[] args) {

        QueueByLinkedList<Integer> queue = new QueueByLinkedList<>();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);

        while (!queue.isEmpty()) {
            System.out.println(queue.deQueue());
        }
    }
}