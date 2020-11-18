package me.jkong.ds.complexity.time;

import me.jkong.common.utils.TimeUtils;

/**
 * 斐波那契数列（Fibonacci sequence），又称黄金分割数列、
 * 因数学家莱昂纳多·斐波那契（Leonardoda Fibonacci）以兔子繁殖为例子而引入，故又称为“兔子数列”，指
 * 的是这样一个数列：0、1、1、2、3、5、8、13、21、34、……
 * 在数学上，斐波那契数列以如下被以递推的方法定义：F(0)=0，F(1)=1，F(2)=1, F(n)=F(n - 1)+F(n - 2)（n ≥ 3，n ∈ N*）
 *
 * @author Laba Zhang
 */
public class FibonacciSequence {
    
    public static void main(String[] args) {
        System.out.println(fibInRecursion(5));
        System.out.println(fibInForeach(5));
        
        // 时间统计
        TimeUtils.count("fibInForeach", new TimeUtils.Task() {
            public void execute() {
                fibInForeach(40);
            }
        });
        TimeUtils.count("fibInRecursion", new TimeUtils.Task() {
            public void execute() {
                fibInRecursion(40);
            }
        });
    }
    
    /**
     * 使用for循环的方式实现斐波那契数列
     *
     * 时间复杂度：O(n)
     *
     * @param n 指定下标
     * @return 指定位置的值
     */
    private static int fibInForeach(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must greater than 0");
        }
        if (n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            int sumTmp;
            sumTmp = first + second;
            first = second;
            second = sumTmp;
        }
        return second;
    }
    
    /**
     * 使用递归方式实现斐波那契数列
     *
     * 时间复杂度：O(2^n)
     *
     * @param n 指定下标
     * @return 指定下标的数值
     */
    private static int fibInRecursion(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must greater than 0");
        }
        if (n <= 1) {
            return n;
        }
        return fibInRecursion(n - 1) + fibInRecursion(n - 2);
    }
}
