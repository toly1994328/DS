package 数据组织形式.映射;

import base.IMap;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/22 0022:17:17
 * 邮箱：1981462002@qq.com
 * 说明：单链表实现映射
 */
public class SingleLinkedMap<K, V> implements IMap<K, V> {
    private Node headNode;
    private int size;

    public SingleLinkedMap() {
        this.headNode = new Node<K, V>(null, null, null);
        this.size = size;
    }

    @Override
    public void put(K key, V value) {
        Node<K, V> node = getNode(key);
        if (node == null) {
            headNode.next = new Node<K, V>(headNode.next, key, value);
            size++;
        } else {
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node<K, V> pre = headNode;
        while (pre.next != null) {
            if (pre.next.key.equals(key)) {
                break;
            }
            pre = pre.next;

            if (pre.next != null) {
                Node<K, V> delNode = pre.next;
                pre.next=delNode.next;
                delNode.next = null;
                size--;
                return delNode.value;
            }
        }

        return null;
    }

    @Override
    public boolean contains(K key) {//O(n)
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        return getNode(key) == null ? null : getNode(key).value;
    }

    @Override
    public void set(K key, V value) {
        Node<K, V> node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist");
        }
        node.value = value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 根据key获取节点
     *
     * @param key 键
     * @return 获取节点
     */
    private Node<K, V> getNode(K key) {
        Node cur = headNode.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * 内部私有节点类
     *
     * @param <K,V>
     */
    private class Node<K, V> {
        /**
         * 节点数据元素
         */
        public K key;
        public V value;


        /**
         * 下一节点的引用
         */
        public Node next;

        public Node(Node next, K key, V value) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
