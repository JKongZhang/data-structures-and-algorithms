package me.jkong.ds.stack;

/**
 * stack test
 *
 * @author Laba Zhang
 */
class StackByArrayListTest {

    public static void main(String[] args) {

        StackByArrayList<Integer> stack = new StackByArrayList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}