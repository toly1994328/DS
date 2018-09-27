package 数据组织形式.并查集;

import base.IUF;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/25 0025:11:15
 * 邮箱：1981462002@qq.com
 * 说明：快速合并并查集优化
 */
public class QuickUnion2UF implements IUF {
    private int[] parent;
    /**
     * 以treeSize[i]为根的集合元素个数
     */
    private int[] treeSize;

    public QuickUnion2UF(int size) {
        parent = new int[size];
        treeSize = new int[size];
        //每个节点都是一颗树
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            treeSize[i] = 1;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionEl(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (treeSize[pRoot] < treeSize[qRoot]) {
            parent[pRoot] = qRoot;
            treeSize[qRoot] += treeSize[pRoot];
        } else {
            parent[qRoot] = pRoot;
            treeSize[pRoot] += treeSize[qRoot];
        }
    }

    /**
     * 查找元素p所对应的集合编号
     *
     * @param p 元素
     * @return p所对应的集合编号
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    @Override
    public int size() {
        return parent.length;
    }
}
