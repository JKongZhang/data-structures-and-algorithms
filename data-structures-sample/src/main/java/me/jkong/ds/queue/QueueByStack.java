package me.jkong.ds.queue;

import me.jkong.ds.stack.StackByArrayList;

/**
 * 基于双向链表实现队列
 *
 * @author Laba Zhang
 */
public class QueueByStack<E> implements Queue<E>{
    private StackByArrayList<E> inStack = new StackByArrayList<>();
    private StackByArrayList<E> outStack = new StackByArrayList<>();

    @Override
    public void enQueue(E e) {
        inStack.push(e);
    }

    @Override
    public E deQueue() {
        moveData();
        return outStack.pop();
    }

    @Override
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

    @Override
    public int size() {
        return inStack.size() + outStack.size();
    }

    @Override
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    @Override
    public void clear() {
        inStack = new StackByArrayList<>();
        outStack = new StackByArrayList<>();
    }

}
