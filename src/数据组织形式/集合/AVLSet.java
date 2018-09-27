package 数据组织形式.集合;

import base.ISet;
import 树结构.二分搜索树.平衡二叉树.avl.AVL;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/26 0026:15:27
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class AVLSet<T extends Comparable<T>> implements ISet<T> {

    private AVL<T, Object> mAVL;

    public AVLSet() {
        mAVL = new AVL<>();
    }

    @Override

    public void add(T el) {
        mAVL.add(el, null);
    }

    @Override
    public void remove(T el) {
        mAVL.remove(el);
    }

    @Override
    public boolean contains(T el) {
        return mAVL.contains(el);
    }

    @Override
    public int size() {
        return mAVL.size();
    }

    @Override
    public boolean isEmpty() {
        return mAVL.isEmpty();
    }
}
