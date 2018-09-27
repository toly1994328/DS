package 树结构.二分搜索树.平衡二叉树.红黑树;


/**
 * 作者：张风捷特烈
 * 时间：2018/9/23 0023:8:41
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class RedBlackTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private int size;


    public void add(K key, V value) {
        root = addNode(root, key, value);
        //根节点颜色置黑
        root.color = BLACK;
    }

    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = removeNode(root, key);
            return root.value;
        }
        return null;
    }

    public boolean contains(K key) {
        return getNode(root, key) != null;
    }


    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }


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
            return target;
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

        if (key.compareTo(target.key) < 0) {
            target.left = addNode(target.left, key, value);
        } else if (key.compareTo(target.key) > 0) {
            target.right = addNode(target.right, key, value);
        } else {
            target.value = value;
        }

        if (isRed(target.right) && !isRed(target.left)) {
            target = leftRotate(target);
        }

        if (isRed(target.left) && isRed(target.left.left)) {
            target = rightRotate(target);
        }
        if (isRed(target.left) && isRed(target.right)) {
            flipColors(target);
        }

        return target;
    }

    //    y                       x
    //  /   \     左旋转         /  \
    // T1   x   --------->    y    T3
    //     / \              /   \
    //    T2 T3            T1   T2

    /**
     * 红黑树左旋转
     * @param y
     * @return
     */
    private Node leftRotate(Node y) {
        Node x = y.right;
        //左旋转
        y.right = x.left;
        x.left = y;

        x.color = y.color;
        y.color = RED;
        return x;
    }

    //       y                    x
    //    /   \     右旋转       /  \
    //   x    T3   ------->   T1    y
    //  / \                       /  \
    // T1 T2                     T2  T3
    private Node rightRotate(Node y){

        Node x = y.left;

        // 右旋转
        y.left = x.right;
        x.right = y;

        x.color = y.color;
        y.color = RED;

        return x;
    }


    // 颜色翻转
    private void flipColors(Node node){

        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }


    // 判断节点node的颜色
    private boolean isRed(Node node){
        if(node == null)
            return BLACK;
        return node.color;
    }


    public int size() {
        return size;
    }


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
        public K key;
        public V value;
        /**
         * 左子
         */
        public Node left;
        /**
         * 右子
         */
        public Node right;

        /**
         * 节点颜色
         */
        public boolean color;

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
            color = RED;
        }

        public NodeType getType() {

            if (this.right == null) {
                if (this.left == null) {
                    return NodeType.LEAF;
                } else {
                    return NodeType.RIGHT_NULL;
                }
            }

            if (this.left == null) {
                return NodeType.LEFT_NULL;
            } else {
                return NodeType.FULL;
            }

        }
    }
}
