package 线性结构.client;

import Jutils.TimeTest;
import 线性结构.栈.ArrayChartStack;
import 线性结构.栈.SingleLinkedStack;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/17 0017:14:50
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class ClientOfTask {
    public static void main(String[] args) {
//        arrayStackTest();
//        linkStackTest();


        int opCount = 10000000;
//        数组栈添加(opCount);
//        链表栈添加(opCount);
        数组栈出栈(opCount);
        链表栈出栈(opCount);
    }
/////////////////////////////性能测试S//////////////////////////

    private static void 链表栈添加(int opCount) {
        SingleLinkedStack<Integer> linkedStack = new SingleLinkedStack<>();
        new TimeTest("链表栈添加", opCount) {
            @Override
            protected void run() {
                linkedStack.push(1);
            }
        };
    }

    private static void 链表栈出栈(int opCount) {
        SingleLinkedStack<Integer> linkedStack = new SingleLinkedStack<>();
        for (int i = 0; i < opCount; i++) {
            linkedStack.push(1);
        }

        new TimeTest("链表栈出栈", opCount) {
            @Override
            protected void run() {
                linkedStack.pop();
            }
        };
    }

    private static void 数组栈添加(int opCount) {

        ArrayChartStack<Integer> arrayChartStack = new ArrayChartStack<>();
        new TimeTest("数组栈添加", opCount) {
            @Override
            protected void run() {
                arrayChartStack.push(1);
            }
        };
    }

    private static void 数组栈出栈(int opCount) {
        ArrayChartStack<Integer> arrayChartStack = new ArrayChartStack<>();
        for (int i = 0; i < opCount; i++) {
            arrayChartStack.push(1);
        }
        new TimeTest("数组栈添加", opCount) {
            @Override
            protected void run() {
                arrayChartStack.pop();
            }
        };
    }

/////////////////////////////性能测试E//////////////////////////

    /**
     * 链表式集合实现的栈测试方法
     */
    private static void linkStackTest() {
        SingleLinkedStack<Integer> linkedStack = new SingleLinkedStack<>();
        for (int i = 0; i < 5; i++) {
            linkedStack.push(i);
            System.out.println(linkedStack);
        }
        linkedStack.pop();
        linkedStack.pop();
        Integer peek = linkedStack.peek();
        System.out.println(peek);
        //SingleLinkedStack Stack ：head: 0->NULL
        //SingleLinkedStack Stack ：head: 1->0->NULL
        //SingleLinkedStack Stack ：head: 2->1->0->NULL
        //SingleLinkedStack Stack ：head: 3->2->1->0->NULL
        //SingleLinkedStack Stack ：head: 4->3->2->1->0->NULL
        //2
    }

    /**
     * 数组式集合实现的栈测试方法
     */
    private static void arrayStackTest() {
        ArrayChartStack<Integer> arrayChartStack = new ArrayChartStack<>();
        for (int i = 0; i < 5; i++) {
            arrayChartStack.push(i);
            System.out.println(arrayChartStack);
        }
        arrayChartStack.pop();
        arrayChartStack.pop();
        Integer peek = arrayChartStack.peek();
        System.out.println(peek);
        //Stack ：[ 0] <--top
        //Stack ：[ 0, 1] <--top
        //Stack ：[ 0, 1, 2] <--top
        //Stack ：[ 0, 1, 2, 3] <--top
        //Stack ：[ 0, 1, 2, 3, 4] <--top
        //2
    }

}
