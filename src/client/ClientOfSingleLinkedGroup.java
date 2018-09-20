package client;

import Jutils.TimeTest;
import 线性结构.链表.SingleLinkedGroup;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/18 0018:23:46
 * 邮箱：1981462002@qq.com
 * 说明：双链表测试
 */
public class ClientOfSingleLinkedGroup {
    public static void main(String[] args) {
//        baseTest();
//        otherTest();

        int opCount = 10000000;

//        addLastTest(opCount);
        addFirstTest(opCount);
//        removeLastTest(opCount);
        removeFirstTest(opCount);
    }


    private static void addFirstTest(int testCount) {
        SingleLinkedGroup<String> linkedGroup = new SingleLinkedGroup<>();
        new TimeTest("addFirst:", testCount) {
            @Override
            protected void run() {
                linkedGroup.addFirst("A");
            }
        };
    }

    private static void addLastTest(int testCount) {
        SingleLinkedGroup<String> singleLinkedGroup = new SingleLinkedGroup<>();
        new TimeTest("addLast:", testCount) {
            @Override
            protected void run() {
                singleLinkedGroup.addLast("A");
            }
        };
    }

    private static void removeLastTest(int testCount) {
        SingleLinkedGroup<String> SingleLinkedGroup = new SingleLinkedGroup<>();
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
        SingleLinkedGroup<String> SingleLinkedGroup = new SingleLinkedGroup<>();
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


    private static void otherTest() {
        SingleLinkedGroup<String> linkedGroup = new SingleLinkedGroup<>();
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

        SingleLinkedGroup<String> linkedGroup2 = new SingleLinkedGroup<>();

        linkedGroup2.addLast("1");
        linkedGroup2.addLast("3");
        linkedGroup2.addLast("2");

        linkedGroup.contact(1, linkedGroup2);
        System.out.println(linkedGroup);
        //head: b->c->1->3->2->NULL

    }

    private static void baseTest() {
        SingleLinkedGroup<String> list = new SingleLinkedGroup<>();
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
