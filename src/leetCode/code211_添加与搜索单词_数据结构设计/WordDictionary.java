package leetCode.code211_添加与搜索单词_数据结构设计;

import java.util.TreeMap;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/25 0025:10:06
 * 邮箱：1981462002@qq.com
 * 说明：
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addWord(word)
 * bool search(word)
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 * <p>
 * 示例:
 * <p>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 说明:
 * <p>
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 */
class WordDictionary {
    private Node root;


    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new Node(false);
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
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
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int index) {
        if (index == word.length()) {
            return node.isWord;
        }

        char c = word.charAt(index);
        if (c != '.') {
            if (node.next.get(c) == null) {
                return false;
            } else {
                return match(node.next.get(c), word, index + 1);
            }
        } else {
            for (Character nextChar : node.next.keySet()) {
                if (match(node.next.get(nextChar), word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
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

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */