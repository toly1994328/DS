
import bean.Person;
import 线性结构.数组.Array;
import 线性结构.数组.IntArray;

import java.util.Objects;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/17 0017:13:03
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class Client {
    public static void main(String[] args) {
//        intArrayTest();
//        arrayTest();
//        arrayPersonTest();
        growArray();
    }

    private static void growArray() {

        Array<String> array = new Array();
        for (int i = 0; i < 10; i++) {
            array.addLast("第" + i + "个数");
        }
        array.addLast("第10个数");
        array.addLast("第11个数");
        array.addLast("第12个数");
        array.addLast("第13个数");

        System.out.println(array);

    }

    private static void arrayPersonTest() {
        Array<Person> array = new Array();
        Person toly = new Person("toly", 24);
        Person wy = new Person("wy", 23);
        Person ls = new Person("ls", 24);
        Person sf = new Person("sf", 21);
        array.add(0, toly);
        array.add(1, wy);
        array.addFirst(ls);
        array.addLast(sf);
        array.addLast(toly);
        System.out.println(array);
        System.out.println(array.get(1));
        System.out.println(array.findIndexOf(toly));
        System.out.println(array.findIndexesOf(toly).length);
        System.out.println(array.removeElement(toly));
        System.out.println(array);
        System.out.println(array.contains(toly));
//        System.out.println(array.contains("ls"));
//        array.clear();
//        System.out.println(array);
    }


    private static void arrayTest() {
        Array<String> array = new Array();
        array.add(0, "toly");
        array.add(1, "wy");
        array.addFirst("ls");
        array.addLast("sf");
        array.addLast("toly");
        System.out.println(array);
        System.out.println(array.get(1));
        System.out.println(array.findIndexOf("toly"));
        System.out.println(array.findIndexesOf("toly").length);
        System.out.println(array.removeElements("toly"));
        System.out.println(array);
        System.out.println(array.contains("toly"));
        System.out.println(array.contains("ls"));
        array.clear();
        System.out.println(array);
    }


    private static void intArrayTest() {
        IntArray array = new IntArray();
        array.add(0, 1);
        array.addLast(10);
        array.addFirst(-4);
        array.addLast(13);
        array.addLast(1);
        array.set(4, -13);
        array.add(4, 13);
        System.out.println(array);
        System.out.println(array.get(1));
        System.out.println(array.findIndexOf(1));
        System.out.println(array.findIndexesOf(1).length);
        System.out.println(array.remove(0));
        System.out.println(array);
        System.out.println(array.removeElement(1));
        System.out.println(array);
        System.out.println(array.removeElements(13));
        System.out.println(array);

        array.clear();
        System.out.println("..." + array);
    }
}


