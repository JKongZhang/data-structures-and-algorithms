package me.jkong.common.utils;

/**
 * 方法执行时间统计
 *
 * @author JKong
 */
public class TimeUtils {
    /**
     * 统计时间
     *
     * @param title 任务名称
     * @param task  需要被执行的时间统计的任务
     */
    public static void count(String title, Task task) {
        if (task == null) {
            return;
        }
        title = (title == null) ? "" : ("【" + title + "】");
        System.out.println(title);
        long begin = System.currentTimeMillis();
        task.execute();
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - begin) + "毫秒");
        System.out.println("-------------------------------------");
    }
    
    public interface Task {
        /**
         * 需要被执行的任务
         */
        void execute();
    }
}
