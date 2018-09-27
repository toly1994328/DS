package 数据组织形式.映射.test;

import Jutils.PInt;
import Jutils.TimeTest;
import 数据组织形式.映射.AVLMap;
import 数据组织形式.映射.BSTMap;
import 数据组织形式.映射.RBMap;
import 数据组织形式.映射.SingleLinkedMap;
import 数据组织形式.表.HashChart;
import 数据组织形式.集合.test.FileOperation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/19 0019:11:38
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class CountWordOfMap {
    public static void main(String[] args) {

//        ArrayList<Integer> fromA2B = PInt.getPrimeFromA2B(231446, 231446 + 20);
//        System.out.println(fromA2B);

        System.out.println("《吸血鬼日记》原著英文.txt");
        new TimeTest(1) {
            @Override
            protected void run() {
//                countByBST();
//                countBySingleLinked();
//                countByHashMap();
//                countByDoubleLinked();

//                countByBSTWithSort();
//                countByAVLWithSort();
//                countByRBWithSort();
                countByHashChartWithSort();
            }
        };


    }

    /**
     * 普通二分搜索树实现Map测试
     */
    private static void countByBST() {
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("I:\\Java\\DS\\src\\数据组织形式\\集合\\test\\《吸血鬼日记》原著英文.txt", words)) {
            System.out.println("Total words: " + words.size());
            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
            System.out.println("Total different words: " + map.size());
            System.out.println("Total different words: " + map.get("hello"));
            //Total words: 231446
            //Total different words: 9574
            //Total different words: 16
            //方法耗时:0.434729002秒
        }
    }

    /**
     * 单链表实现Map测试
     */
    private static void countBySingleLinked() {
        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("I:\\Java\\DS\\src\\数据组织形式\\集合\\test\\《吸血鬼日记》原著英文.txt", words1)) {
            System.out.println("Total words: " + words1.size());
            SingleLinkedMap<String, Integer> map = new SingleLinkedMap<>();
            for (String word : words1) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
            System.out.println("Total different words: " + map.size());
            System.out.println("Total different words: " + map.get("hello"));
            //Total words: 231446
            //Total different words: 9574
            //Total different words: 16
            //方法耗时:53.993837562秒
        }
    }

    /**
     * HashMap测试
     */
    private static void countByHashMap() {
        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("I:\\Java\\DS\\src\\数据组织形式\\集合\\test\\《吸血鬼日记》原著英文.txt", words1)) {
            System.out.println("Total words: " + words1.size());
            HashMap<String, Integer> map = new HashMap<>();
            for (String word : words1) {
                if (map.containsKey(word)) {
                    map.replace(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
            System.out.println("Total different words: " + map.size());
            System.out.println("Total different words: " + map.get("hello"));
            //Total words: 231446
            //Total different words: 9574
            //Total different words: 16
            //方法耗时:0.329440408秒
        }
    }

    /**
     * 普通二分搜索树实现Map测试----加顺序：将退化成链表
     * //明显链表要慢很多很多：
     * //罪魁祸首是谁？-----list.contains(el) 添加时判断是否重复O(n)
     */
    private static void countByBSTWithSort() {
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("I:\\Java\\DS\\src\\数据组织形式\\集合\\test\\《吸血鬼日记》原著英文.txt", words)) {
            System.out.println("Total words: " + words.size());
            Collections.sort(words);
            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
            System.out.println("Total different words: " + map.size());
            System.out.println("Total different words: " + map.get("hello"));
            //Total words: 231446
            //Total different words: 9574
            //Total different words: 16
            //方法耗时:75.722882709秒
        }
    }

    /**
     * AVL树实现Map测试----加顺序
     */
    private static void countByAVLWithSort() {
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("I:\\Java\\DS\\src\\数据组织形式\\集合\\test\\《吸血鬼日记》原著英文.txt", words)) {

            System.out.println("Total words: " + words.size());
            Collections.sort(words);
            AVLMap<String, Integer> map = new AVLMap<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
            System.out.println("Total different words: " + map.size());
            System.out.println("Total different words: " + map.get("hello"));
//            System.out.println("is BST:" + map.isBST());
//            System.out.println("is balanced:" + map.isBalanced());
            //Total words: 231446
            //Total different words: 9574
            //Total different words: 16
            //方法耗时:0.666754835秒
        }
    }

    /**
     * 红黑树实现Map测试----加顺序
     */
    private static void countByRBWithSort() {
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("I:\\Java\\DS\\src\\数据组织形式\\集合\\test\\《吸血鬼日记》原著英文.txt", words)) {

            System.out.println("Total words: " + words.size());
            Collections.sort(words);
            RBMap<String, Integer> map = new RBMap<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
            System.out.println("Total different words: " + map.size());
            System.out.println("Total different words: " + map.get("hello"));

//            System.out.println("is BST:" + map.isBST());
//            System.out.println("is balanced:" + map.isBalanced());
            //Total words: 231446
            //Total different words: 16
            //Total different words: 9574
            //方法耗时:0.625548081秒
        }
    }

    /**
     * 红黑树实现Map测试----加顺序
     */
    private static void countByHashChartWithSort() {
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("I:\\Java\\DS\\src\\数据组织形式\\集合\\test\\《吸血鬼日记》原著英文.txt", words)) {

            System.out.println("Total words: " + words.size());
            Collections.sort(words);
            HashChart<String, Integer> map = new HashChart<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println("Total different words: " + map.size());
            System.out.println("Total different words: " + map.get("hello"));

//            System.out.println("is BST:" + map.isBST());
//            System.out.println("is balanced:" + map.isBalanced());
            //Total words: 231446
            //Total different words: 16
            //Total different words: 9574
            //方法耗时:0.632550745秒
        }
    }


}
