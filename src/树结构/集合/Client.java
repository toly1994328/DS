package 树结构.集合;

import java.util.ArrayList;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/19 0019:11:38
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("《吸血鬼日记》原著英文.txt");

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("E:/Files/《吸血鬼日记》原著英文.txt", words1)) {


            System.out.println("Total words: " + words1.size());

            BSTSet<String> set1 = new BSTSet<>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
        }
    }

}
