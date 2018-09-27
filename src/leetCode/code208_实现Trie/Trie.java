package leetCode.code208_实现Trie;

import java.util.TreeMap;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/25 0025:10:00
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class Trie {
    private Node root;
    private int size;

    public Trie() {
        root = new Node(false);
    }

    /**
     * 添加一个新的单词
     *
     * @param word 单词
     */
    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            //当前节点的下一节点不是该字符，则添加
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node(false));
            }
            cur = cur.next.get(c);
        }

        //结尾节点isWord= true
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 是否存在单词
     * @param word 单词
     * @return 是否存在单词
     */
    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    /**
     * 返回存储的单词数量
     *
     * @return 单词数量
     */
    public int size() {
        return size;
    }
    /**
     * 返回存储的单词数量
     *
     * @return 单词数量
     */
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {


        /**
         * 该节点是否是单词结尾
         */
        public boolean isWord;
        /**
         * 下一个节点
         */
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }
    }
}
