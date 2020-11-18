package me.jkong.ds;

/**
 * list 接口
 *
 * @author Laba Zhang
 */
public interface List<E> {
    static final int ELEMENT_NOT_FOUND = -1;
    
    /**
     * 添加元素到尾部
     *
     * @param element 元素
     */
    void add(E element);
    
    /**
     * 在index位置插入一个元素
     *
     * @param index   下标
     * @param element 元素
     */
    void add(int index, E element);
    
    /**
     * 设置index位置的元素
     *
     * @param index   下标
     * @param element 元素
     * @return 原来的元素ֵ
     */
    E set(int index, E element);
    
    /**
     * 获取index位置的元素
     *
     * @param index 下标
     * @return 元素
     */
    E get(int index);
    
    /**
     * 是否包含某个元素
     *
     * @param element 元素
     * @return true：存在
     */
    boolean contains(E element);
    
    /**
     * 查看元素的索引
     *
     * @param element
     * @return
     */
    int indexOf(E element);
    
    /**
     * 元素的数量
     *
     * @return 元素长度
     */
    int size();
    
    /**
     * 是否为空
     *
     * @return true：容器为空
     */
    boolean isEmpty();
    
    /**
     * 删除index位置的元素
     *
     * @param index 下标
     * @return 被删除的元素
     */
    E remove(int index);
    
    /**
     * 清除所有元素
     */
    void clear();
}
