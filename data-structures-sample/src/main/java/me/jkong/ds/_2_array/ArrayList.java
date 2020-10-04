package me.jkong.ds._2_array;

/**
 * 基于数组实现动态数组
 *
 * @author JKong
 * @version v0.0.1
 * @date 2020/10/3 10:08.
 */
public class ArrayList<E> {
    
    /**
     * 元素的数量
     */
    private int size;
    
    /**
     * 所有的元素
     */
    private E[] elements;
    
    private static final int DEFAULT_CAPACITY = 16;
    private static final int ELEMENT_NOT_FOUND = -1;
    
    public ArrayList(int capaticy) {
        capaticy = Math.max(capaticy, DEFAULT_CAPACITY);
        elements = (E[]) new Object[capaticy];
    }
    
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }
    
    /**
     * 清除所有元素
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
    
    /**
     * 元素的数量
     *
     * @return size
     */
    public int size() {
        return size;
    }
    
    /**
     * 是否为空
     *
     * @return true: ArrayList is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * 是否包含某个元素
     *
     * @param element 待验证元素
     * @return true: ArrayList contains this element
     */
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }
    
    /**
     * 添加元素到尾部
     *
     * @param element 待插入元素
     */
    public void add(E element) {
        add(size, element);
    }
    
    /**
     * 在index位置插入一个元素
     *
     * @param index   下标
     * @param element 待插入的元素
     */
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        
        ensureCapacity(size + 1);
        
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }
    
    /**
     * 获取index位置的元素
     *
     * @param index 返回指定下标的数据
     * @return element value
     */
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }
    
    /**
     * 设置index位置的元素
     *
     * @param index   下标
     * @param element 待更新的元素
     * @return 原来的元素ֵ
     */
    public E set(int index, E element) {
        rangeCheck(index);
        
        E old = elements[index];
        elements[index] = element;
        return old;
    }
    
    
    /**
     * 删除index位置的元素
     *
     * @param index 下标
     * @return 被移除的数据
     */
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        elements[--size] = null;
        
        // 当剩余数据达到1/4时，将容量缩小为1/2，目的是为了减少复杂度震荡。
        if (size == getCapacity() / 4 && getCapacity() > DEFAULT_CAPACITY) {
            resize(getCapacity() / 2);
        }
        return old;
    }
    
    private int getCapacity() {
        return elements.length;
    }
    
    /**
     * 查看元素的索引
     *
     * @param element 待查验的元素
     * @return 元素所在的第一个下标
     */
    public int indexOf(E element) {
        // 因为elements中可能存在null值，因此需要对null值做特殊处理
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }
    
    
    @Override
    public String toString() {
        // size=3, [99, 88, 77]
        StringBuilder string = new StringBuilder();
        string.append("Size = ").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }
    
    /**
     * 保证要有capacity的容量
     *
     * @param capacity 目前元素数量
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) {
            return;
        }
        
        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        resize(newCapacity);
    }
    
    private void resize(int capacity) {
        E[] newElements = (E[]) new Object[capacity];
        // 此处建议使用 System.arraycopy()，效率更高
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }
    
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
        }
    }
    
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
        }
    }
}
