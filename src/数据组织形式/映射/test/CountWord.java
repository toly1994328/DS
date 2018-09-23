package 数据组织形式.映射.test;

import Jutils.TimeTest;
import 数据组织形式.映射.BSTMap;
import 数据组织形式.映射.SingleLinkedMap;
import 数据组织形式.集合.DoubleLinkedSet;
import 数据组织形式.集合.test.FileOperation;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/19 0019:11:38
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class CountWord {
    public static void main(String[] args) {
        System.out.println("《吸血鬼日记》原著英文.txt");
        new TimeTest(1) {
            @Override
            protected void run() {
                countByBST();
//                countBySingleLinked();
//                countByHashMap();
//                countByDoubleLinked();
            }
        };


    }

    private static void countByBST() {
        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("I:\\Java\\DS\\src\\数据组织形式\\集合\\test\\《吸血鬼日记》原著英文.txt", words1)) {

            System.out.println("Total words: " + words1.size());

            BSTMap<String, Integer> map = new BSTMap<>();
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
            //方法耗时:0.434729002秒
        }
    }

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

    private static void countByDoubleLinked() {
        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("I:\\Java\\DS\\src\\数据组织形式\\集合\\test\\《吸血鬼日记》原著英文.txt", words1)) {

            System.out.println("Total words: " + words1.size());
            DoubleLinkedSet<String> set = new DoubleLinkedSet<>();
            for (String word : words1)
                set.add(word);
            System.out.println("Total different words: " + set.size());

        }
    }

    //明显链表要慢很多很多：
    //罪魁祸首是谁？-----list.contains(el) 添加时判断是否重复O(n)


}
