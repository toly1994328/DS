package 线性结构.队列;

import base.IQueue;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/17 0017:22:50
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class LinkedIQueue<E> implements IQueue<E> {

    private Node head, tail;
    private int size;

    public LinkedIQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E el) {
        // 如果队尾为空，说明队列是空的。因为tail一直指向最后一个非空节点。
        if(tail == null){
            tail = new Node(el);
            head = tail;
        }
        else{
            // 使用tail.next把新Node挂载上来。
            tail.next = new Node(el);
            // tail后挪
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        Node targetNode = head;
        head = head.next; // head后移
        targetNode.next = null; // 元素置空
        if(head == null) // 如果头结点都没得删了
            tail = null;
        size --;
        return targetNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("IQueue is empty.");
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("IQueue: front ");

        Node cur = head;
        while(cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }



    private class Node {
        public E e;//改节点上的元素
        public Node next; //下一节点

        /**
         * 无参构造
         */
        public Node() {
            this(null, null);
        }

        /**
         * 一参构造
         *
         * @param e 生成节点的元素值
         */
        public Node(E e) {
            this(e, null);
        }

        /**
         * 两参构造
         *
         * @param e    生成节点的元素值
         * @param next //下一节点
         */
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }
}
