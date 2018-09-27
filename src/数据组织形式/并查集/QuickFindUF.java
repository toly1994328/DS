package 数据组织形式.并查集;

import base.IUF;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/25 0025:11:15
 * 邮箱：1981462002@qq.com
 * 说明：快速查询并查集
 */
public class QuickFindUF implements IUF {

    private int[] id;

    public QuickFindUF(int size) {
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {

        return find(p) == find(q);
    }

    @Override
    public void unionEl(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
    }

    /**
     * 查找元素p所对应的集合编号
     *
     * @param p 元素
     * @return p所对应的集合编号
     */
    private int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        return id[p];
    }

    @Override
    public int size() {
        return id.length;
    }
}
