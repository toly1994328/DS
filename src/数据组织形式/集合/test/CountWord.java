package 数据组织形式.集合.test;

import Jutils.TimeTest;
import 数据组织形式.集合.*;

import java.util.ArrayList;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/19 0019:11:38
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class CountWord {
    public static void main(String[] args) {
        System.out.println("《吸血鬼日记》原著英文.txt");

//        new TimeTest("Tire",1) {
//
//            @Override
//            protected void run() {
////                countByBST();
////                countBySingleLinked();
////                countByDoubleLinked();
//                countByTire();
//            }
//        };

//        new TimeTest("BST",1) {
//
//            @Override
//            protected void run() {
//                countByBST();
//            }
//        };

        new TimeTest("AVL",1) {

            @Override
            protected void run() {
                countByAVL();
            }
        };

    }

    private static void countByBST() {
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("I:\\Java\\DS\\src\\数据组织形式\\集合\\test\\《吸血鬼日记》原著英文.txt", words)) {

            System.out.println("Total words: " + words.size());

            BSTSet<String> set1 = new BSTSet<>();
            for (String word : words)
                set1.add(word);

            for(String word: words)
                set1.contains(word);

            System.out.println("Total different words: " + set1.size());

            //Total words: 231446
            //Total different words: 9574
            //方法耗时:0.388587346秒
            //添加查询后：BST方法耗时:0.468755831秒
        }
    }

    private static void countBySingleLinked() {
        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("I:\\Java\\DS\\src\\数据组织形式\\集合\\test\\《吸血鬼日记》原著英文.txt", words1)) {

            System.out.println("Total words: " + words1.size());
            SingleLinkedSet<String> set = new SingleLinkedSet<>();
            for (String word : words1)
                set.add(word);
            System.out.println("Total different words: " + set.size());
            //Total words: 231446
            //Total different words: 9574
            //方法耗时:16.662198178秒
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
            //Total words: 231446
            //Total different words: 9574
            //方法耗时:16.060901669秒
        }
    }

    private static void countByTire() {
        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("I:\\Java\\DS\\src\\数据组织形式\\集合\\test\\《吸血鬼日记》原著英文.txt", words1)) {

            System.out.println("Total words: " + words1.size());
            TireSet set = new TireSet();
            for (String word : words1)
                set.add(word);

            for(String word: words1)
                set.contains(word);

            System.out.println("Total different words: " + set.size());
            //Total words: 231446
            //Total different words: 9574
            //Tire方法耗时:0.43592557秒
        }
    }

    private static void countByAVL() {
        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("I:\\Java\\DS\\src\\数据组织形式\\集合\\test\\《吸血鬼日记》原著英文.txt", words1)) {

            System.out.println("Total words: " + words1.size());
            AVLSet<String> set = new AVLSet<>();
            for (String word : words1)
                set.add(word);


            System.out.println("Total different words: " + set.size());
            //Total words: 231446
            //Total different words: 9574
            //AVL方法耗时:0.542959279秒
        }
    }

    //明显链表要慢很多很多：
    //罪魁祸首是谁？-----list.contains(el) 添加时判断是否重复O(n)


}
