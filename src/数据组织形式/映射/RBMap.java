package 数据组织形式.映射;

import base.IMap;
import 树结构.二分搜索树.平衡二叉树.红黑树.RedBlackTree;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/27 0027:9:39
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class RBMap<K extends Comparable<K>, V> implements IMap<K, V> {
    private RedBlackTree<K, V> mRedBlackTree;

    public RBMap() {
        mRedBlackTree = new RedBlackTree<>();
    }

    @Override
    public void put(K key, V value) {
        mRedBlackTree.add(key, value);
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        return mRedBlackTree.contains(key);
    }

    @Override
    public V get(K key) {
        return mRedBlackTree.get(key);
    }

    @Override
    public void set(K key, V value) {
        mRedBlackTree.set(key, value);
    }

    @Override
    public int size() {
        return mRedBlackTree.size();
    }

    @Override
    public boolean isEmpty() {
        return mRedBlackTree.isEmpty();
    }
}
