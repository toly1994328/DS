package 线性结构.栈;


import base.IStack;
import 线性结构.链表.Linked;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/17 0017:22:40
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class LinkedStack<E> implements IStack<E> {


    private Linked<E> link;

    public LinkedStack() {
        link = new Linked<>();
    }


    @Override
    public int size() {
        return link.getSize();
    }

    @Override
    public int capacity() {
        return link.getSize();
    }

    @Override
    public boolean isEmpty() {
        return link.isEmpty();
    }

    @Override
    public void push(E el) {
        link.addFirst(el);
    }

    @Override
    public E pop() {
        return link.removeFirst();
    }

    @Override
    public E peek() {
        return link.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedList Stack ：");
        res.append(link);
        return  res.toString();
    }

}
