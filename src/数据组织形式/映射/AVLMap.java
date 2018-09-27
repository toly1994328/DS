package 数据组织形式.映射;

import base.IMap;
import 树结构.二分搜索树.平衡二叉树.avl.AVL;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/23 0023:8:41
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class AVLMap<K extends Comparable<K>, V> implements IMap<K, V> {

    private AVL<K, V> mAVL;

    public AVLMap() {
        mAVL = new AVL<>();
    }

    @Override
    public void put(K key, V value) {
        mAVL.add(key, value);
    }

    @Override
    public V remove(K key) {
        return mAVL.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return mAVL.contains(key);
    }

    @Override
    public V get(K key) {
        return mAVL.get(key);
    }

    @Override
    public void set(K key, V value) {
        mAVL.set(key, value);
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
