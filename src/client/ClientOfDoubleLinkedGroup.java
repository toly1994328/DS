package client;

import 线性结构.链表.DoubleLinkedGroup;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/18 0018:23:46
 * 邮箱：1981462002@qq.com
 * 说明：双链表测试
 */
public class ClientOfDoubleLinkedGroup {
    public static void main(String[] args) {
        baseTest();

        otherTest();

    }

    /**
     * 其他方法测试
     */
    private static void otherTest() {
        DoubleLinkedGroup<String> linkedGroup = new DoubleLinkedGroup<>();
        linkedGroup.addLast("a");
        linkedGroup.addLast("b");
        linkedGroup.addLast("a");
        linkedGroup.addLast("c");
        linkedGroup.addLast("a");

        System.out.println(linkedGroup);
        //head: a->b->a->c->a->null->

        //获取a元素的所有索引位置
        int[] as = linkedGroup.getIndex("a");
        for (int a : as) {
            System.out.print(a + " ");//0 2 4
        }

        //删除a元素第一次出现的地方---
        linkedGroup.removeEl("a");
        System.out.println(linkedGroup);
        //head: b->a->c->a->null->

        //查看a元素是否存在
        boolean b = linkedGroup.contains("a");
        System.out.println(b);//true

        //删除所有a元素出现的地方---
        linkedGroup.removeEls("a");
        System.out.println(linkedGroup);
        //head: b->c->NULL

        //双链表合并测试
        DoubleLinkedGroup<String> linkedGroup2 = new DoubleLinkedGroup<>();

        linkedGroup2.addLast("1");
        linkedGroup2.addLast("3");
        linkedGroup2.addLast("2");

        linkedGroup.contact(0, linkedGroup2);
        System.out.println(linkedGroup);
        //head: b->1->3->2->c->null->

    }

    private static void baseTest() {
        DoubleLinkedGroup<String> list = new DoubleLinkedGroup<>();
        //添加测试
        list.addFirst("特");
        list.addFirst("张");
        list.add(1,"风");
        list.add(2,"捷");
        list.addLast("烈");

        //输出测试
        System.out.println(list);
        //head: 张->风->捷->特->烈->null->

        //移除测试
        list.remove(3);
        System.out.println(list);
        //head: 张->风->捷->烈->null->

        //修改测试
        list.set(2,"神");
        System.out.println(list);
        //head: 张->风->神->烈->null->

        //获取测试
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));//张风神烈
        }

        //大小测试
        System.out.println(list.size());//4
        //是否为空测试
        System.out.println(list.isEmpty());//false

        //清空测试
        list.clear();
        System.out.println(list.isEmpty());//true
    }
}
