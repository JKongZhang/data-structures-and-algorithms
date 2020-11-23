package me.jkong.ds.list;

/**
 * List 抽象类
 *
 * @author Laba Zhang
 */
public abstract class AbstractList<E> implements List<E> {
    /**
     * 元素的数量
     */
    protected int size;
    
    /**
     * 元素的数量
     *
     * @return size
     */
    @Override
    public int size() {
        return size;
    }
    
    /**
     * 是否为空
     *
     * @return true: ArrayList is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * 是否包含某个元素
     *
     * @param element 待验证元素
     * @return true: ArrayList contains this element
     */
    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }
    
    /**
     * 添加元素到尾部
     *
     * @param element 待插入元素
     */
    @Override
    public void add(E element) {
        add(size, element);
    }
    
    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
        }
    }
    
    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
        }
    }
}
