package leetCode.code677_键值映射;

import java.util.TreeMap;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/25 0025:10:20
 * 邮箱：1981462002@qq.com
 * 说明：
 * <p>
 * 实现一个 MapSum 类里的两个方法，insert 和 sum。
 * <p>
 * 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
 * <p>
 * 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: insert("apple", 3), 输出: Null
 * 输入: sum("ap"), 输出: 3
 * 输入: insert("app", 2), 输出: Null
 * 输入: sum("ap"), 输出: 5
 */
class MapSum {

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new Node(0);
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            //当前节点的下一节点不是该字符，则添加
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node(0));
            }
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
    }

    private int sum(Node node) {

//        if (node.next.size() == 0) {
//            return node.value;
//        }

        int res = node.value;
        for (Character c : node.next.keySet()) {
            res += sum(node.next.get(c));
        }
        return res;

    }

    private class Node {
        /**
         * 该节点是否是单词结尾
         */

        public int value;
        /**
         * 下一个节点
         */
        public TreeMap<Character, Node> next;

        public Node(int value) {
            this.value = value;
            next = new TreeMap<>();
        }
    }
}
