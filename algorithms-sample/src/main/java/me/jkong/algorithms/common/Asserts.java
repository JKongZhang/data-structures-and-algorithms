package me.jkong.algorithms.common;

/**
 * assert tool
 *
 * @author other
 */
public class Asserts {
    public static void test(boolean value) {
        try {
            if (!value) {
                throw new Exception("not pass!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
