package me.jkong.ds.list;

/**
 * 链表数据结构
 *
 * @author Laba Zhang
 */
public class SingleLinkedListVirtualHead<E> extends AbstractList<E> {
    private Node<E> first;
    
    public SingleLinkedListVirtualHead() {
        this.first = new Node<E>(null, null);
    }
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        
        Node<E> prev = index == 0 ? first : node(index - 1);
        prev.next = new Node<E>(element, prev.next);
        
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
        
        Node<E> prev = index == 0 ? first : node(index - 1);
        Node<E> node = prev.next;
        prev.next = node.next;
        size--;
        return node.element;
    }
    @Override
    public void clear() {
        first = null;
        size = 0;
    }
    
    private Node<E> node(int index) {
        rangeCheck(index);
        
        Node<E> node = first.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        Node<E> node = first.next;
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
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}
