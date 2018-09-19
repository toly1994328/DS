package 线性结构.链表;

import base.Group;

import java.util.List;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/19 0019:8:34
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class DoubleLinkedGroup<T> extends Group<T> {

    /**
     * 虚拟头结点
     */
    private Node headNode;
    /**
     * 虚拟尾节点
     */
    private Node tailNode;

    public DoubleLinkedGroup() {
        clear();
    }

    @Override
    public void add(int index, T el) {
        addNodeBefore(getNode(index), el);
    }

    @Override
    public T remove(int index) {
        return removeNode(getNode(index));
    }


    @Override
    public void clear() {
        clearNode();
    }

    @Override
    public T set(int index, T el) {
        Node<T> node = getNode(index);
        T oldData = node.data;
        node.data = el;
        return oldData;
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    @Override
    public int[] getIndex(T el) {
        return null;
    }

    @Override
    public Group<T> contact(int index, Group<T> group) {
        return null;
    }

    /////////////////////////////节点操作//////////////////////////

    /**
     * 根据目标节点插入新节点
     *
     * @param target 目标节点
     * @param data   新节点数据
     */
    private void addNodeBefore(Node<T> target, T data) {
        //新建一个node,将前、后指向分别指向目标前节点和目标节点
        Node<T> newNode = new Node<>(target.prev, target, data);
        //目标前节点next指向新节点
        target.prev.next = newNode;
        //目标节点prev指向新节点
        target.prev = newNode;
        //链表长度+1
        size++;
    }

    /**
     * 移除目标节点
     *
     * @param target 目标节点
     * @return 目标节点数据
     */
    private T removeNode(Node<T> target) {
        //目标前节点的next指向目标节点后节点
        target.prev.next = target.next;
        //目标后节点的prev指向目标节点前节点
        target.next.prev = target.prev;
        //链表长度-1
        size--;
        return target.data;
    }


    /**
     * 清空所有节点
     */
    private void clearNode() {
        //实例化头结点
        headNode = new Node<T>(null, null, null);
        //实例化尾节点，并将prev指向头
        tailNode = new Node<T>(headNode, null, null);
        headNode.next = tailNode;
        //链表长度置零
        size = 0;
    }

    /**
     * 根据索引获取节点
     *
     * @param index 索引
     * @return 索引处节点
     */
    private Node<T> getNode(int index) {
        //声明目标节点
        Node<T> targetNode;
        //索引越界处理
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        //如果索引在前半,前序查找
        if (index < size / 2) {
            targetNode = headNode.next;
            for (int i = 0; i < index; i++) {
                targetNode = targetNode.next;
            }
        } else {  //如果索引在后半,反序查找
            targetNode = tailNode;
            for (int i = size; i > index; i--) {
                targetNode = targetNode.prev;
            }
        }
        return targetNode;
    }

    /**
     * 节点类
     *
     * @param <T>
     */
    private static class Node<T> {
        /**
         * 数据
         */
        public T data;
        /**
         * 前节点
         */
        public Node prev;
        /**
         * 后节点
         */
        public Node next;

        public Node(Node prev, Node next, T data) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}
