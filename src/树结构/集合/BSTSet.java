package 树结构.集合;


import 树结构.BST;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/19 0019:11:23
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class BSTSet <E extends Comparable<E>> implements Set<E> {
    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>(false);
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
