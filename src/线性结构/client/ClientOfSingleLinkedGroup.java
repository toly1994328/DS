package 线性结构.client;

import Jutils.TimeTest;
import 线性结构.链表.SingleLinkedChart;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/18 0018:23:46
 * 邮箱：1981462002@qq.com
 * 说明：双链表测试
 */
public class ClientOfSingleLinkedGroup {
    public static void main(String[] args) {
//        baseTest();
        otherTest();

        int opCount = 10000000;

//        addLastTest(opCount);
//        addFirstTest(opCount);
//        removeLastTest(opCount);
//        removeFirstTest(opCount);
    }

    /////////////////////////////性能测试S//////////////////////////
    private static void addFirstTest(int testCount) {
        SingleLinkedChart<String> linkedGroup = new SingleLinkedChart<>();
        new TimeTest("addFirst:", testCount) {
            @Override
            protected void run() {
                linkedGroup.addFirst("A");
            }
        };
    }

    private static void addLastTest(int testCount) {
        SingleLinkedChart<String> singleLinkedGroup = new SingleLinkedChart<>();
        new TimeTest("addLast:", testCount) {
            @Override
            protected void run() {
                singleLinkedGroup.addLast("A");
            }
        };
    }

    private static void removeLastTest(int testCount) {
        SingleLinkedChart<String> SingleLinkedGroup = new SingleLinkedChart<>();
        for (int i = 0; i < testCount; i++) {
            SingleLinkedGroup.addFirst("A");
        }

        new TimeTest("removeLast:", testCount) {
            @Override
            protected void run() {
                SingleLinkedGroup.removeLast();
            }
        };
    }

    private static void removeFirstTest(int testCount) {
        SingleLinkedChart<String> SingleLinkedGroup = new SingleLinkedChart<>();
        for (int i = 0; i < testCount; i++) {
            SingleLinkedGroup.addFirst("A");
        }

        new TimeTest("removeFirst:", testCount) {
            @Override
            protected void run() {
                SingleLinkedGroup.removeFirst();
            }
        };
    }
/////////////////////////////性能测试E//////////////////////////

    /**
     * 其他方法测试
     */
    private static void otherTest() {
        SingleLinkedChart<String> linkedGroup = new SingleLinkedChart<>();
        linkedGroup.addLast("a");
        linkedGroup.addLast("b");
        linkedGroup.addLast("a");
        linkedGroup.addLast("c");
        linkedGroup.addLast("a");

        System.out.println(linkedGroup);
        //head: a->b->a->c->a->NULL

        //获取a元素的所有索引位置
        int[] as = linkedGroup.getIndex("a");
        for (int a : as) {
            System.out.print(a + " ");//0 2 4
        }

        //删除a元素第一次出现的地方---
        linkedGroup.removeEl("a");
        System.out.println(linkedGroup);
        //head: b->a->c->a->NULL

        //查看a元素是否存在
        boolean b = linkedGroup.contains("a");
        System.out.println(b);//true

        //删除所有a元素出现的地方---
        linkedGroup.removeEls("a");
        System.out.println(linkedGroup);
        //head: b->c->NULL

        SingleLinkedChart<String> linkedGroup2 = new SingleLinkedChart<>();

        linkedGroup2.addLast("1");
        linkedGroup2.addLast("3");
        linkedGroup2.addLast("2");

        linkedGroup.contact(0, linkedGroup2);
        System.out.println(linkedGroup);
        //head: b->c->1->3->2->NULL

    }

    /**
     * 增删改查测试
     */
    private static void baseTest() {
        SingleLinkedChart<String> list = new SingleLinkedChart<>();
        list.addFirst("特");
        list.addLast("烈");
        list.addFirst("风");
        list.addFirst("张");
        list.add(2, "杰");

        list.set(2, "捷");
        System.out.println(list);
        //head: 张->风->捷->特->烈->NULL

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));//张风捷特烈
        }
        list.remove(2);
        //head: 张->风->特->烈->NULL
        System.out.println(list);

        list.clear();
        System.out.println(list);//head: NULL
    }
}
