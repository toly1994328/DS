package 数据组织形式.映射.test;

import 数据组织形式.映射.AVLMap;
import 数据组织形式.映射.test.FileOperation;

import java.util.ArrayList;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/26 0026:15:03
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class ClientOfAVL {
    public static void main(String[] args) {
        countByAVL();

    }

    private static void countByAVL() {
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("I:\\Java\\DS\\src\\数据组织形式\\集合\\test\\avl.txt", words)) {

            System.out.println("Total words: " + words.size());
            AVLMap<String, Integer> map = new AVLMap<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
            System.out.println("Total different words: " + map.size());
            System.out.println("count of are: " + map.get("are"));
            System.out.println("------------------");
            map.remove("are");
            System.out.println("Total different words: " + map.size());
            System.out.println("Total different words: " + map.size());
            System.out.println("count of are: " + map.get("are"));

//            System.out.println("is BST:" + map.isBST());
//            System.out.println("is balanced:" + map.isBalanced());
            //Total words: 231446
            //Total different words: 9574
            //Total different words: 16
            //方法耗时:0.666754835秒
        }
    }
}
