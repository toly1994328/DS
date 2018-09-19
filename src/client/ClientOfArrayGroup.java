package client;

import Jutils.TimeTest;
import 线性结构.数组.ArrayGroup;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/19 0019:8:59
 * 邮箱：1981462002@qq.com
 * 说明：数组测试
 */
public class ClientOfArrayGroup {

    public static void main(String[] args) {
        ArrayGroup<String> arrayGroup = new ArrayGroup<>();

//        testAdd(arrayGroup);

//        otherTest(arrayGroup);

        int testCount = 100000000;

        for (int i = 0; i < testCount; i++) {
            arrayGroup.addLast("a");
        }


//        new TimeTest("clear:") {
//            @Override
//            protected void run() {
//                arrayGroup.clear();
//            }
//        };

        new TimeTest("addLast:") {
            @Override
            protected void run() {
                arrayGroup.clear();
            }
        };


    }

    private static void otherTest(ArrayGroup<String> arrayGroup) {
        arrayGroup.addLast("a");
        arrayGroup.addLast("a");
        arrayGroup.addLast("b");
        arrayGroup.addLast("c");
        arrayGroup.addLast("f");
        arrayGroup.addLast("a");
        arrayGroup.addLast("e");
        arrayGroup.addLast("d");

        System.out.println(arrayGroup);
        //ArrayGroup:size =8,capacity=10
        //[a, a, b, c, f, a, e, d]

        //定点删除操作
        String remove = arrayGroup.remove(3);
        System.out.println(remove);//c
        System.out.println(arrayGroup);
        //ArrayGroup:size =7,capacity=10
        //[a, a, b, f, a, e, d]

        //定元素删除
        int a = arrayGroup.removeEl("a");
        System.out.println(a);//0
        System.out.println(arrayGroup);
        //ArrayGroup:size =6,capacity=10
        //[a, b, f, a, e, d]

        //定元素全删除
        boolean ok = arrayGroup.removeEls("a");
        System.out.println(ok);//true
        System.out.println(arrayGroup);
        //ArrayGroup:size =4,capacity=10
        //[b, f, e, d]

        //定点修改
        String toly = arrayGroup.set(3, "toly");
        System.out.println(toly);//d
        System.out.println(arrayGroup);
        //ArrayGroup:size =4,capacity=10
        //[b, f, e, toly]

        //是否存在元素
        boolean contains = arrayGroup.contains("b");
        System.out.println(contains);//true

        //定点插入集合
        ArrayGroup<String> arrayGroup2 = new ArrayGroup<>();
        arrayGroup2.addLast("1");
        arrayGroup2.addLast("2");
        arrayGroup.contact(2, arrayGroup2);
        System.out.println(arrayGroup);
        //ArrayGroup:size =6,capacity=10
        //[b, f, e, 1, 2, toly]

        //末尾插入集合
        arrayGroup.contact(arrayGroup2);
        System.out.println(arrayGroup);
        //ArrayGroup:size =8,capacity=10
        //[b, f, e, 1, 2, toly, 1, 2]

        arrayGroup.clear();
        System.out.println(arrayGroup);
        //ArrayGroup:size =0,capacity=10
        //[]
    }

    private static void testAdd(ArrayGroup<String> arrayGroup) {
        arrayGroup.addLast("风");
        arrayGroup.addLast("特");
        arrayGroup.addLast("烈");
        arrayGroup.add(1, "捷");
        arrayGroup.addFirst("张");

        System.out.println(arrayGroup);
        //ArrayGroup:size =5,capacity=10
        //[张, 风, 捷, 特, 烈]
    }
}
