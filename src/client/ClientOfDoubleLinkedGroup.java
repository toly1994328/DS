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
        DoubleLinkedGroup<String> list = new DoubleLinkedGroup<>();
        list.addFirst("张");
        list.addFirst("捷");

        list.add(1,"风");//添加
        list.add(2,"特");
        list.remove(3);//移除
        list.set(2,"火");//修改
        System.out.println(list.size());//大小----3
        System.out.println(list.isEmpty());//是否为空----false
        list.clear();//清空
        System.out.println(list.isEmpty());//true

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));//获取
        }
    }
}
