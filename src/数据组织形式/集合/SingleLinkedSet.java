package 数据组织形式.集合;

import base.ISet;
import 树结构.二分搜索树.BST;
import 线性结构.链表.SingleLinkedGroup;

import java.util.Map;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/21 0021:13:23
 * 邮箱：1981462002@qq.com
 * 说明：二分搜索树实现集合
 */
public class SingleLinkedSet<T extends Comparable<T>> implements ISet<T> {
    private SingleLinkedGroup<T> list;

    public SingleLinkedSet() {
        this(false);
    }

    public SingleLinkedSet(boolean canSame) {
        list = new SingleLinkedGroup<>();

    }

    @Override
    public void add(T el) { //O(n)
        if (!list.contains(el)) {
            list.addFirst(el);
        }
    }

    @Override
    public void remove(T el) {//O(n)
        list.removeEl(el);
    }

    @Override
    public boolean contains(T el) {
        list.contains(el);
        return false;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

}
