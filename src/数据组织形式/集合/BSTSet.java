package 数据组织形式.集合;

import base.ISet;
import 树结构.二分搜索树.BST;

import java.util.Map;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/21 0021:13:23
 * 邮箱：1981462002@qq.com
 * 说明：二分搜索树实现集合
 */
public class BSTSet<T extends Comparable<T>> implements ISet<T> {
    private BST<T> mBST;

    public BSTSet() {
        this(false);
    }

    public BSTSet(boolean canSame) {
        mBST = new BST<>(canSame);

    }

    @Override
    public void add(T el) {//O（h）
        mBST.add(el);
    }

    @Override
    public void remove(T el) {//O（h）
        mBST.remove(el);
    }

    @Override
    public boolean contains(T el) {
        mBST.contains(el);
        return false;
    }

    @Override
    public int size() {
        return mBST.size();
    }

    @Override
    public boolean isEmpty() {
        return mBST.isEmpty();
    }

    public Map<T, Integer> getNodeCountMap() {
        return mBST.getNodeCountMap();
    }

}
