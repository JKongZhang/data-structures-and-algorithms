package me.jkong.algorithms.union;

/**
 * Quick Union
 *
 * @author laba zhang
 */
public class UnionFindWithQuickUnion extends UnionFind {

    public UnionFindWithQuickUnion(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        return 0;
    }

    /**
     * 左边跟随右边，即找到左边的parent，然后将左边的parent节点的parent，修改为右边的parent的节点的parent值。
     *
     * @param v1 left
     * @param v2 right
     */
    @Override
    public void union(int v1, int v2) {

    }
}
