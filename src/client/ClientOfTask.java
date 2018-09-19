package client;

import base.IStack;
import 线性结构.栈.ArrayGroupStack;
import 线性结构.栈.LinkedStack;

import java.util.Random;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/17 0017:14:50
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class ClientOfTask {
    public static void main(String[] args) {
        arrayStackTest();
//        linkStackTest();

//        timeTest();

    }

    private static void timeTest() {
        int opCount = 10000000;

        ArrayGroupStack<Integer> arrayGroupStack = new ArrayGroupStack<>();
        double time1 = testStack(arrayGroupStack, opCount);
        System.out.println("ArrayGroupStack, time: " + time1 + " s");

        LinkedStack<Integer> linkedListStack = new LinkedStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("LinkedStack, time: " + time2 + " s");
    }

    private static void linkStackTest() {
        LinkedStack<Integer> arrayStack = new LinkedStack<>();
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }
        arrayStack.pop();
        arrayStack.pop();
        Integer peek = arrayStack.peek();
        System.out.println(peek);
    }

    private static void arrayStackTest() {
        ArrayGroupStack<Integer> arrayGroupStack = new ArrayGroupStack<>();
        for (int i = 0; i < 5; i++) {
            arrayGroupStack.push(i);
            System.out.println(arrayGroupStack);
        }
        arrayGroupStack.pop();
        arrayGroupStack.pop();
        Integer peek = arrayGroupStack.peek();
        System.out.println(peek);
        //Stack ：[ 0] <--top
        //Stack ：[ 0, 1] <--top
        //Stack ：[ 0, 1, 2] <--top
        //Stack ：[ 0, 1, 2, 3] <--top
        //Stack ：[ 0, 1, 2, 3, 4] <--top
        //2
    }


    // 测试使用stack运行opCount个push和pop操作所需要的时间，单位：秒
    private static double testStack(IStack<Integer> stack, int opCount){

        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++)
            stack.push(random.nextInt(Integer.MAX_VALUE));
        for(int i = 0 ; i < opCount ; i ++)
            stack.pop();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1e9;
    }

}
