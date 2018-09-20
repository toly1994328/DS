package 树结构;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/18 0018:15:39
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class BST2<E extends Comparable<E>> {
    private boolean canSame = true;
    private Node root;  // 根节点
    private int size;   // 树中元素的个数

    public BST2() {
        this(true);
    }

    /**
     * 默认的二分搜索树构造函数
     */
    public BST2(boolean canSame) {
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


        root = add(root, e);
    }

    /**
     * 语义: 向以node为根的二分搜索树中插入元素e，递归算法
     *
     * @param node
     * @param el
     */
    /**
     * 返回插入新节点后二分搜索树的根
     *
     * @param node
     * @param e
     * @return
     */
    private Node add(Node node, E e) {//虽然简便，但对于1来说1000W次插入时间较长
        if (node == null) {
            size++;
            return new Node(e);
        }
        // 上面条件不满足，说明还得继续往下找左右子树为null可以挂载上的节点
        if (e.compareTo(node.e) <= 0)
            // 如果小于，那么继续往它的左子树添加该节点,这里插入结果可能根发生了变化。
            node.left = add(node.left, e); // 新节点赋值给node.left,改变了二叉树
        else if (e.compareTo(node.e) > 0)
            // 大于，往右子树添加。
            node.right = add(node.right, e);
        return node;
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
