package me.jkong.ds.queue;

import me.jkong.ds.stack.StackByArrayList;

/**
 * 基于双向链表实现队列
 *
 * @author Laba Zhang
 */
public class QueueByStack<E> {
    private StackByArrayList<E> inStack = new StackByArrayList<>();
    private StackByArrayList<E> outStack = new StackByArrayList<>();

    public void enQueue(E e) {
        inStack.push(e);
    }

    public E deQueue() {
        moveData();
        return outStack.pop();
    }

    public E front() {
        moveData();
        return outStack.peek();
    }

    private void moveData() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    public int size() {
        return inStack.size() + outStack.size();
    }

    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public void clear() {
        inStack = new StackByArrayList<>();
        outStack = new StackByArrayList<>();
    }

}
