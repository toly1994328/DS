package 线性结构.队列;

import base.IQueue;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/17 0017:22:50
 * 邮箱：1981462002@qq.com
 * 说明：单链表实现队列
 */
public class SingleLinkedQueue<T> implements IQueue<T> {

    /**
     * 头节点
     */
    private Node head;
    /**
     * 尾节点
     */
    private Node tail;

    /**
     * 元素个数
     */
    private int size;

    public SingleLinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(T el) {
        // 如果队尾为空，说明队列是空的。因为tail一直指向最后一个非空节点。
        if (tail == null) {
            tail = new Node(null, el);
            head = tail;
        } else {
            // 使用tail.next把新Node挂载上来。
            tail.next = new Node(null, el);
            // tail后挪
            tail = tail.next;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        Node targetNode = head;
        head = head.next; // head后移
        targetNode.next = null; // 元素置空
        if (head == null) {// 如果头结点为空
            tail = null;
        }

        size--;
        return targetNode.el;
    }

    @Override
    public T getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("IQueue is empty.");
        return head.el;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("IQueue: front ");

        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }


    private class Node {
        public T el;//改节点上的元素
        public Node next; //下一节点


        /**
         * 两参构造
         *
         * @param next //下一节点
         * @param el    生成节点的元素值
         */
        public Node(Node next, T el) {
            this.el = el;
            this.next = next;
        }

        @Override
        public String toString() {
            return el.toString();
        }
    }
}
