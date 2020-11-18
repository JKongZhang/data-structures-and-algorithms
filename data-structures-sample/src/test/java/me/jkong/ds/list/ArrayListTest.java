package me.jkong.ds.list;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * ArrayList Test
 *
 * @author JKong
 * @version v0.0.1
 * @date 2020/10/3 10:27.
 */
class ArrayListTest {
    
    private static ArrayList<Integer> list;
    
    @BeforeEach
    void setUp() {
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
    }
    
    @Test
    void clear() {
        list.clear();
        Assertions.assertTrue(list.isEmpty());
    }
    
    @Test
    void size() {
        Assertions.assertEquals(list.size(), 5);
    }
    
    @Test
    void isEmpty() {
        Assertions.assertFalse(list.isEmpty());
        clear();
        Assertions.assertTrue(list.isEmpty());
    }
    
    @Test
    void contains() {
        Assertions.assertTrue(list.contains(3));
        Assertions.assertFalse(list.contains(9));
    }
    
    @Test
    void add() {
        list.add(6);
        Assertions.assertTrue(list.contains(6));
    }
    
    @Test
    void get() {
        Assertions.assertEquals(list.get(0), 1);
        Assertions.assertEquals(list.get(4), 5);
    }
    
    @Test
    void set() {
        list.set(0, 0);
        Assertions.assertEquals(list.get(0), 0);
    }
    
    @Test
    void testAdd() {
        list.add(0, 0);
        Assertions.assertEquals(list.get(0), 0);
        Assertions.assertEquals(list.get(1), 1);
    }
    
    @Test
    void remove() {
        list.remove(4);
        Assertions.assertEquals(list.size(), 4);
        list.remove(2);
        Assertions.assertEquals(list.get(2), 4);
    }
    
    @Test
    void indexOf() {
        Assertions.assertEquals(list.indexOf(2), 1);
        Assertions.assertEquals(list.indexOf(9), -1);
    }
    
    @Test
    void testToString() {
        Assertions.assertEquals(list.toString(), "Size = 5, [1, 2, 3, 4, 5]");
    }
}