package me.jkong.ds.queue;

/**
 * 循环队列
 *
 * @author Laba Zhang
 */
public class CircleQueueByArray<E> implements Queue<E> {
    private int front;
    private int size;
    private E[] data;
    private static final int DEFAULT_CAPACITY = 10;

    public CircleQueueByArray(int size) {
        this.front = 0;
        this.data = (E[]) new Object[size];
    }

    public CircleQueueByArray() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void enQueue(E e) {
        ensureCapacity(size + 1);
        data[(front + size()) % data.length] = e;
        size++;
    }

    private void ensureCapacity(int capacity) {
        int oldCa = data.length;
        if (oldCa >= capacity) {
            return;
        }
        // 扩容
        int newCa = oldCa + (oldCa >> 1);
        E[] newData = (E[]) new Object[newCa];
        // 搬移数据
        for (int i = 0; i < data.length; i++) {
            // 由于是循环数组，需要使用 (front + 1) % data.length
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
    }

    @Override
    public E deQueue() {
        E old = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return old;
    }

    @Override
    public E front() {
        return data[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[index(i)] = null;
        }
        front = 0;
        size = 0;
    }

    private int index(int index) {
        index += front;
        return index - (data.length > index ? 0 : data.length);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("capacity=").append(data.length)
                .append(" size=").append(size)
                .append(" front=").append(front)
                .append(", [");
        for (int i = 0; i < data.length; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(data[i]);
        }
        string.append("]");
        return string.toString();
    }
}
