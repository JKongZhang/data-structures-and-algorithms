package me.jkong.algorithms.union;

/**
 * Quick Find
 *
 * @author laba zhang
 */
public class UnionFindWithQuickFind extends UnionFind {

    public UnionFindWithQuickFind(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        return parents[v];
    }

    /**
     * 合并集合
     * 左边跟随右边，即将左边集合的所有的元素都修改为右边集合的parent
     *
     * @param v1 v1
     * @param v2 v2
     */
    @Override
    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) {
            return;
        }
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == p1) {
                parents[i] = p2;
            }

        }
    }
}
