package 树结构;

import java.util.Random;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/18 0018:15:45
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class Client {
    public static void main(String[] args) {
        baseTest();
//        System.out.println(timeTest(10000000));
    }

    private static void baseTest() {
        BST<Integer> bst = new BST<>();
        bst.add(10);
        bst.add(11);
        bst.add(6);
        bst.add(12);
        bst.add(8);
        bst.add(4);
        bst.add(6);
        bst.add(9);
        bst.add(5);
        bst.add(13);
        bst.add(13);
//        System.out.println(bst);
//        System.out.println(bst.contains(6));
//        bst.preOrder();
//        System.out.println("------------------");
//        bst.inOrder();
//        System.out.println("------------------");
//        bst.postOrder();
//        System.out.println("------------------");
//        bst.levelOrder();
//        System.out.println("------------------");
//
//        System.out.println(bst.min());
//        System.out.println(bst.max());
//        System.out.println(bst.removeMin());
//        System.out.println(bst);
        bst.remove(13);
        bst.remove(13);
        System.out.println(bst);
        bst.levelOrder();

    }


    private static double timeTest(int opCount) {
        BST2<Integer> bst = new BST2<>();
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            bst.add(random.nextInt(Integer.MAX_VALUE)); // 生成从0到int最大值
        }
        long endTime = System.nanoTime(); // 纳秒
        return (endTime - startTime) / 1e9;
    }
}
