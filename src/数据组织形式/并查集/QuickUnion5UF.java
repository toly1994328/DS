package 数据组织形式.并查集;

import base.IUF;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/25 0025:11:15
 * 邮箱：1981462002@qq.com
 * 说明：快速合并并查集优化
 */
public class QuickUnion5UF implements IUF {
    private int[] parent;
    /**
     * 以rank[i]为根的集合元素个数
     */
    private int[] rank;

    public QuickUnion5UF(int size) {
        parent = new int[size];
        rank = new int[size];
        //每个节点都是一颗树
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
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
        //按照深度来连接
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
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
        if (p != parent[p]) {
            //路径压缩
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }


    @Override
    public int size() {
        return parent.length;
    }
}
