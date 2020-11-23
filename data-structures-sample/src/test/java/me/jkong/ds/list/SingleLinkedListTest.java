package me.jkong.ds.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 测试链表操作
 *
 * @author Laba Zhang
 */
class SingleLinkedListTest {
    
    private static List<Integer> list;
    
    @BeforeEach
    void setUp() {
        list = new SingleLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
    }
    
    @Test
    void add() {
        list.add(6);
        Assertions.assertTrue(list.contains(6));
        Assertions.assertEquals(list.size(), 6);
    }
    
    @Test
    void set() {
        list.set(0, 0);
        Assertions.assertEquals(list.get(0), 0);
    }
    
    @Test
    void get() {
        Assertions.assertEquals(list.get(0), 1);
        Assertions.assertEquals(list.get(4), 5);
    }
    
    @Test
    void indexOf() {
        Assertions.assertEquals(list.indexOf(2), 1);
        Assertions.assertEquals(list.indexOf(9), -1);
    }
    
    @Test
    void remove() {
        list.remove(4);
        Assertions.assertEquals(list.size(), 4);
        list.remove(2);
        Assertions.assertEquals(list.get(2), 4);
    }
    
    @Test
    void clear() {
        list.clear();
        Assertions.assertTrue(list.isEmpty());
    }
    
    @Test
    void testToString() {
        Assertions.assertEquals(list.toString(), "Size = 5, [1, 2, 3, 4, 5]");
    }
}