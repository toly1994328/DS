package 树结构;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/18 0018:15:39
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class BST<E extends Comparable<E>> {
    private boolean canSame = true;
    private Node root;  // 根节点
    private int size;   // 树中元素的个数

    public BST() {
        this(true);
    }

    /**
     * 默认的二分搜索树构造函数
     */
    public BST(boolean canSame) {
        this.canSame = canSame;
        root = null;
        size = 0;
    }

    /**
     * 获取搜索树中节点元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 向二分搜索树中添加新的元素e(面向用户使用的)
     *
     * @param e
     */
    public void add(E e) {

        if (root == null) {
            root = new Node(e);
            size++;
        } else
            add(root, e);
    }

    /**
     * 语义: 向以node为根的二分搜索树中插入元素e，递归算法
     *
     * @param node
     * @param e
     */
    private void add(Node node, E e) {
        boolean smallThan = e.compareTo(node.e) <= 0;

        if (e.equals(node.e) && !canSame) {
            return;//传入值与父节点值相同,并且不允许相同时
        }
        //小于e的值，并且该节点的左子树为空。
        if (smallThan && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        }

        // 如果大于e的值，并且该节点的右子树为空。
        if (!smallThan && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        add(smallThan ? node.left : node.right, e);

    }

    /**
     * 看二分搜索树中是否包含元素e（面向用户的）
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 看以node为根的二分搜索树中是否包含元素e(递归算法语义)
     *
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {

        if (node == null) {
            return false;
        }

        int i = e.compareTo(node.e);
        if (i == 0) {
            return true;
        }

        return i < 0 ? contains(node.left, e) : contains(node.right, e);

    }

    /**
     * 二分搜索树的前序遍历（用户使用）
     */
    public void preOrder() {
        preOrder(root);
    }


    /**
     * 前序遍历以node为根的二分搜索树, 递归算法
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.e + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 二分搜索树的中序遍历（用户使用）
     */
    public void inOrder() {
        inOrder(root);
    }


    /**
     * 中序遍历以node为根的二分搜索树, 递归算法
     *
     * @param node
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.e + " ");
        inOrder(node.right);
    }

    /**
     * 二分搜索树的后序遍历（用户使用）
     */
    public void postOrder() {
        postOrder(root);
    }


    /**
     * 后序遍历以node为根的二分搜索树, 递归算法
     *
     * @param node
     */
    private void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.e + " ");
    }


    /**
     * 二分搜索树的层序遍历，使用队列实现
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.printf(cur.e + " ");

            if (cur.left != null) {
                queue.add(cur.left);
            }

            if (cur.right != null) {
                queue.add(cur.right);
            }

        }

    }

    /**
     * 寻找二分搜索树的最小元素(面向用户)
     *
     * @return
     */
    public E min() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        Node minNode = min(root);
        return minNode.e;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     *
     * @param node
     * @return
     */
    private Node min(Node node) {
        return node.left == null ? node : min(node.left);
    }

    /**
     * 寻找二分搜索树的最大元素（面向用户）
     *
     * @return
     */
    public E max() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        return max(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最大值所在的节点
     *
     * @param node
     * @return
     */
    private Node max(Node node) {

        return node.right == null ? node : max(node.right);

    }


    /**
     * 从二分搜索树中删除最小值所在节点, 返回最小值
     *
     * @return
     */
    public E removeMin() {
        E ret = min();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从二分搜索树中删除最大值所在节点
     *
     * @return
     */
    public E removeMax() {
        E ret = max();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最大节点 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMax(Node node) {

        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 从二分搜索树中删除元素为e的节点
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除掉以node为根的二分搜索树中值为e的节点, 递归算法 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node, E e) {

        if (node == null)
            return null;

        boolean smallThan = e.compareTo(node.e) < 0;
        boolean bigThan = e.compareTo(node.e) > 0;

        if (smallThan) {
            node.left = remove(node.left, e);
            return node;
        } else if (bigThan) {
            node.right = remove(node.right, e);
            return node;
        } else {
            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = min(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }



    /**
     * 打印二分搜索树的信息
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }


    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     *
     * @param node
     * @param depth
     * @param res
     */
    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");

        generateBSTString(node.left, depth + 1, res.append("左"));
        generateBSTString(node.right, depth + 1, res.append("右"));
    }

    /**
     * 生成树深度的标识。
     *
     * @param depth
     * @return
     */
    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("-");
        return res.toString();
    }


    /**
     * 二分搜索树是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 节点类对用户屏蔽
     */
    private class Node {
        public E e; // 节点元素值
        public Node left, right; // 左子树，右子树引用


        /**
         * 默认的节点构造函数
         *
         * @param e
         */
        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }
}
