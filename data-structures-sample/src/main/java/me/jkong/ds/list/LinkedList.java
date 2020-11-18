package me.jkong.ds.list;

/**
 * 链表数据结构
 *
 * @author Laba Zhang
 */
public class LinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private Node<E> last;
    
    /**
     * 添加元素时需要注意4种情况：
     * 1. 在两节点之间添加元素
     * 2. 在 index = 0 位置添加
     * 3. 在 index = size 位置添加
     * 4. 当 size = 0 时 添加
     *
     * @param index   下标
     * @param element 元素
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        
        // solve index == size
        if (index == size) {
            Node<E> oldLast = this.last;
            last = new Node<>(oldLast, element, null);
            // solve size == 0
            if (size == 0) {
                first = last;
            } else {
                oldLast.next = last;
            }
        } else {
            Node<E> node = node(index);
            Node<E> prev = node.prev;
            Node<E> newNode = new Node<E>(prev, element, node);
            node.prev = newNode;
            // solve index == 0
            if (prev == null) {
                first = newNode;
            } else {
                prev.next = newNode;
            }
        }
        
        
        size++;
    }
    
    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }
    
    @Override
    public E get(int index) {
        return node(index).element;
    }
    
    @Override
    public int indexOf(E element) {
        // 因为elements中可能存在null值，因此需要对null值做特殊处理
        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }
    
    @Override
    public E remove(int index) {
        rangeCheck(index);
        
        Node<E> node = first;
        if (index == 0) {
            first = first.next;
        } else {
            Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = node.next;
        }
        size--;
        return node.element;
    }
    
    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }
    
    private Node<E> node(int index) {
        rangeCheck(index);
        if (index < (size >> 1)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
        
    }
    
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Size = ").append(size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(node.element);
            node = node.next;
        }
        string.append("]");
        return string.toString();
    }
    
    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;
        
        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }
}
