package me.jkong.ds.queue;

/**
 * test queue by stack
 *
 * @author Laba Zhang
 */
class QueueByStackTest {
    public static void main(String[] args) {

        QueueByStack<Integer> queue = new QueueByStack<>();
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