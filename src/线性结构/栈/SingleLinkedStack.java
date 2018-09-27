package 线性结构.栈;


import base.IStack;
import 线性结构.链表.SingleLinkedChart;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/17 0017:22:40
 * 邮箱：1981462002@qq.com
 * 说明：栈的链表式集合实现
 */
public class SingleLinkedStack<E> implements IStack<E> {

    private SingleLinkedChart<E> mLinkedGroup;

    public SingleLinkedStack() {
        mLinkedGroup = new SingleLinkedChart<>();
    }


    @Override
    public int size() {
        return mLinkedGroup.size();
    }

    @Override
    public int capacity() {
        return mLinkedGroup.size();
    }

    @Override
    public boolean isEmpty() {
        return mLinkedGroup.isEmpty();
    }

    @Override
    public void push(E el) {
        mLinkedGroup.addFirst(el);
    }

    @Override
    public E pop() {
        return mLinkedGroup.removeFirst();
    }

    @Override
    public E peek() {
        return mLinkedGroup.get(0);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("SingleLinkedStack Stack ：");
        res.append(mLinkedGroup);
        return res.toString();
    }
}
