package 线性结构.client;

import Jutils.TimeTest;
import 线性结构.数组.ArrayChart;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/19 0019:8:59
 * 邮箱：1981462002@qq.com
 * 说明：数组测试
 */
public class ClientOfArrayChart {

    public static void main(String[] args) {
        testAdd();


//        otherTest(arrayGroup);

        int testCount = 10000000;


//        addLastTest(testCount);
//        addFirstTest(testCount);
//        removeLastTest(testCount);
//        removeFirstTest(testCount);

    }

    /////////////////////////////性能测试S//////////////////////////
    private static void addFirstTest(int testCount) {
        ArrayChart<String> arrayGroup = new ArrayChart<>();
        new TimeTest("addFirst:", testCount) {
            @Override
            protected void run() {
                arrayGroup.addFirst("A");
            }
        };
    }

    private static void addLastTest(int testCount) {
        ArrayChart<String> arrayGroup = new ArrayChart<>();
        new TimeTest("addLast:", testCount) {
            @Override
            protected void run() {
                arrayGroup.addLast("A");
            }
        };
    }

    private static void removeLastTest(int testCount) {
        ArrayChart<String> arrayGroup = new ArrayChart<>();
        for (int i = 0; i < testCount; i++) {
            arrayGroup.addLast("A");
        }

        new TimeTest("removeLast:", testCount) {
            @Override
            protected void run() {
                arrayGroup.removeLast();
            }
        };
    }

    private static void removeFirstTest(int testCount) {
        ArrayChart<String> arrayGroup = new ArrayChart<>();
        for (int i = 0; i < testCount; i++) {
            arrayGroup.addLast("A");
        }

        new TimeTest("removeFirst:", testCount) {
            @Override
            protected void run() {
                arrayGroup.removeFirst();
            }
        };
    }

    /////////////////////////////性能测试E//////////////////////////
    private static void otherTest(ArrayChart<String> arrayGroup) {
        arrayGroup.addLast("a");
        arrayGroup.addLast("a");
        arrayGroup.addLast("b");
        arrayGroup.addLast("c");
        arrayGroup.addLast("f");
        arrayGroup.addLast("a");
        arrayGroup.addLast("el");
        arrayGroup.addLast("d");

        System.out.println(arrayGroup);
        //ArrayChart:size =8,capacity=10
        //[a, a, b, c, f, a, el, d]

        //定点删除操作
        String remove = arrayGroup.remove(3);
        System.out.println(remove);//c
        System.out.println(arrayGroup);
        //ArrayChart:size =7,capacity=10
        //[a, a, b, f, a, el, d]

        //定元素删除
        int a = arrayGroup.removeEl("a");
        System.out.println(a);//0
        System.out.println(arrayGroup);
        //ArrayChart:size =6,capacity=10
        //[a, b, f, a, el, d]

        //定元素全删除
        boolean ok = arrayGroup.removeEls("a");
        System.out.println(ok);//true
        System.out.println(arrayGroup);
        //ArrayChart:size =4,capacity=10
        //[b, f, el, d]

        //定点修改
        String toly = arrayGroup.set(3, "toly");
        System.out.println(toly);//d
        System.out.println(arrayGroup);
        //ArrayChart:size =4,capacity=10
        //[b, f, el, toly]

        //是否存在元素
        boolean contains = arrayGroup.contains("b");
        System.out.println(contains);//true

        //定点插入集合
        ArrayChart<String> arrayGroup2 = new ArrayChart<>();
        arrayGroup2.addLast("1");
        arrayGroup2.addLast("2");
        arrayGroup.contact(2, arrayGroup2);
        System.out.println(arrayGroup);
        //ArrayChart:size =6,capacity=10
        //[b, f, el, 1, 2, toly]

        //末尾插入集合
        arrayGroup.contact(arrayGroup2);
        System.out.println(arrayGroup);
        //ArrayChart:size =8,capacity=10
        //[b, f, el, 1, 2, toly, 1, 2]

        arrayGroup.clear();
        System.out.println(arrayGroup);
        //ArrayChart:size =0,capacity=10
        //[]
    }

    private static void testAdd() {
        ArrayChart<String> arrayGroup = new ArrayChart<>();
        arrayGroup.addLast("风");
        arrayGroup.addLast("特");
        arrayGroup.addLast("烈");
        arrayGroup.add(1, "捷");
        arrayGroup.addFirst("张");

        System.out.println(arrayGroup);
        //ArrayChart:size =5,capacity=10
        //[张, 风, 捷, 特, 烈]
    }
}
