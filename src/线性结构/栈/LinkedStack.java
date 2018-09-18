package 线性结构.栈;


import 线性结构.链表.Linked;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/17 0017:22:40
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class LinkedStack<E> implements Stack<E> {


    private Linked<E> link;

    public LinkedStack() {
        link = new Linked<>();
    }


    @Override
    public int getSize() {
        return link.getSize();
    }

    @Override
    public int getCapacity() {
        return link.getSize();
    }

    @Override
    public boolean isEmpty() {
        return link.isEmpty();
    }

    @Override
    public void push(E e) {
        link.addFirst(e);
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
