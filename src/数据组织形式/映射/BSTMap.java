package 数据组织形式.映射;

import base.IMap;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/23 0023:8:41
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class BSTMap<K extends Comparable<K>, V> implements IMap<K, V> {
    private Node root;
    private int size;


    @Override
    public void put(K key, V value) {
        root = addNode(root, key, value);
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = removeNode(root, key);
            return root.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist");
        }
        node.value = value;
    }

    /**
     * 删除掉以target为根的二分搜索树中值为e的节点, 递归算法 返回删除节点后新的二分搜索树的根
     *
     * @param target
     * @param key
     * @return
     */
    private Node removeNode(Node target, K key) {
        if (target == null) {
            return null;
        }

        if (key.compareTo(target.key) < 0) {
            target.left = removeNode(target.left, key);
        } else if (key.compareTo(target.key) > 0) {
            target.right = removeNode(target.right, key);
            return target;
        } else {//相等时
            switch (target.getType()) {
                case LEFT_NULL://左残--
                case LEAF:
                    Node rightNode = target.right;
                    target.right = null;
                    size--;
                    return rightNode;
                case RIGHT_NULL:
                    Node leftNode = target.left;
                    target.left = null;
                    size--;
                    return leftNode;
                case FULL:
                    //找后继节点
                    Node successor = getMinNode(target.right);
                    successor.right = removeMinNode(target.right);
                    successor.left = target.left;
                    target.left = target.right = null;

//                    Node successor = getMaxNode(target.left);
//                    successor.left = removeMaxNode(target.left);
//                    successor.right = target.right;
//                    target.left = target.right = null;
                    return successor;
            }
        }
        return target;
    }

    /**
     * 返回最大值节点
     *
     * @param target 目标根节点
     * @return 最大值节点
     */
    private Node getMinNode(Node target) {
        //右子不为空就一直拿右子
        return target.left == null ? target : getMinNode(target.left);
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMinNode(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMinNode(node.left);
        return node;
    }

    /**
     * 获取节点
     *
     * @param node 节点
     * @param key  键
     * @return
     */
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        } else {
            return getNode(node.left, key);
        }

    }


    /**
     * 返回插入新节点后的二分搜索树的根
     *
     * @param target 目标节点
     * @param key    插入元素
     * @param value  插入元素
     * @return 插入新节点后的二分搜索树的根
     */
    private Node addNode(Node target, K key, V value) {


        if (target == null) {
            size++;
            return new Node(null, null, key, value);
        }

//        countRepeatNode(target, el);

        //节点相同，并且不允许重复时
//        if (el.equals(target.el) && !canSame) {
//            return target;//传入值与父节点值相同,并且不允许相同时
//        }

        if (key.compareTo(target.key) < 0) {
            target.left = addNode(target.left, key, value);
        } else if (key.compareTo(target.key) > 0) {
            target.right = addNode(target.right, key, value);
        } else {
            target.value = value;
        }
        return target;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    enum NodeType {
        FULL,
        LEAF,
        RIGHT_NULL,
        LEFT_NULL;
    }

    /**
     * 节点类
     */
    private class Node {

        /**
         * 储存的数据元素
         */
        private K key;
        private V value;
        /**
         * 左子
         */
        private Node left;
        /**
         * 右子
         */
        private Node right;

        private NodeType mNodeType;

        /**
         * 构造函数
         *
         * @param left  左子
         * @param right 右子
         * @param key   储存的数据元素
         * @param value 储存的数据元素
         */
        public Node(Node left, Node right, K key, V value) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public NodeType getType() {

            if (this.right == null) {
                if (this.left == null) {
                    mNodeType = NodeType.LEAF;
                    return NodeType.LEAF;
                } else {
                    mNodeType = NodeType.RIGHT_NULL;
                    return NodeType.RIGHT_NULL;
                }
            }

            if (this.left == null) {
                mNodeType = NodeType.LEFT_NULL;
                return NodeType.LEFT_NULL;
            } else {
                mNodeType = NodeType.FULL;
                return NodeType.FULL;
            }

        }
    }
}
