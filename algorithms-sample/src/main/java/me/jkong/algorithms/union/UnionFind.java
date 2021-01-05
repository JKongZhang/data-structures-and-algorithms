package me.jkong.algorithms.union;

/**
 * 并查集抽象
 *
 * @author laba zhang
 */
public abstract class UnionFind {

    protected int[] parents;

    public UnionFind(int capacity) {
        parents = new int[capacity];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }

    /**
     * 查找所在集合
     *
     * @param v v
     * @return parent index
     */
    public abstract int find(int v);

    /**
     * 检查 v1 v2 是否属于同一个集合
     *
     * @param v1 v1
     * @param v2 v2
     * @return true: same
     */
    public boolean isSame(int v1, int v2) {
        return find(v1) == find(v2);
    }

    /**
     * 合并集合
     *
     * @param v1 v1
     * @param v2 v2
     */
    public abstract void union(int v1, int v2);

    protected void rangeCheck(int v) {
        if (v < 0 || v >= parents.length) {
            throw new IllegalArgumentException("v is out of bound!");
        }
    }
}
