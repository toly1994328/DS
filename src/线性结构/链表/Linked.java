package 线性结构.链表;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/17 0017:16:32
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class Linked<E> {
    private Node root;//根节点
    private int size;//链长


    public Linked() {
        this(null, 0);
    }

    public Linked(E e) {
        this(e, 1);
    }

    /**
     * 两参构造
     *
     * @param e    //根节元素
     * @param size //链长
     */
    public Linked(E e, int size) {
        this.root = new Node(e);
        this.size = size;
    }

    /**
     * 从数组创建链表的方法，待完善。
     *
     * @param es
     */
    public Linked(E[] es) {
        this.root = new Node(es[0]);
        this.size = es.length;
    }

    /**
     * 获取链表中元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 在首位添加
     *
     * @param e
     */
    public void addFirst(E e) {
        root = new Node(e, root);
        size++;
    }

    /**
     * 在链表的index位置添加新的元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        // index可以取到size，在链表末尾空位置添加元素。
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index");
        }

        Node prevNode = root;

        for (int i = 0; i < index - 1; i++) {
            prevNode = prevNode.next;//寻找index个节点前的元素
        }
        prevNode.next = new Node(e, prevNode.next);//寻找index个节点后的元素，与传参e组成Node挂在前节点的next

        size++;
    }

    public Node getRoot() {
        return root;
    }

    /**
     * 在链表末尾添加新的元素e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 返回链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获得链表的第index(0-based)位置元素
     * 链表中不是常用操作，练习用
     *
     * @param index
     * @return
     */
    public E get(int index) {
        // index不可以取到size，索引从0开始，最多取到size-1
        if (index < 0 || index >= size) {

            throw new IllegalArgumentException("Add failed. Illegal index");
        }
        Node cur = root.next; // 从索引为0元素开始
        // 下面与找index-1个节点保持一致。上面执行了一次。所以从index-1个元素变成了找index个元素。
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        return index == 0 ? root.e : cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表的第index(0-based)个位置的元素为e
     * 在链表中不是一个常用的操作，练习用
     */
    public void set(int index,E e){
        // index不可以取到size，索引从0开始，最多取到size-1
        if (index < 0 || index >=size){
            throw new IllegalArgumentException("Set failed. Illegal index");
        }
        Node cur = index==0?root:root.next; // 从索引为0元素开始
        // 下面与找index-1个节点保持一致。上面执行了一次。所以从index-1个元素变成了找index个元素。
        for (int i = 0; i < index-1; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }


    /**
     * 查找链表中是否有元素e
     */
    public boolean contains(E e) {
        Node cur = root.next;
        while (cur != null) {
            if (e.equals(cur.e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("root:" + root.e + "->");
        for (Node cur = root.next; cur != null; cur = cur.next) {
            res.append(cur.e + "->");
        }
        return res.toString();
    }


    /**
     * 删除链表中指定index位置的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index==0) {
            size--;
            E e = root.e;
            root = root.next;
            return e;
        }

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Illegal index");
        }
        Node prev = root;
        for (int i = 0; i < index-1; i++) {
            prev = prev.next;
        }

        Node targetNode = prev.next;
        prev.next = targetNode.next;
        targetNode.next = null;

        size--;

        return targetNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
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
        public String toString() {
            return "BST[" +
                    "e=" + e +
                    ", next=" + next +
                    ']';
        }
    }

}
