package 线性结构.栈;

import java.util.Random;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/17 0017:14:50
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class Client {
    public static void main(String[] args) {
//        arrayStackTest();
//        linkStackTest();

        int opCount = 10000000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack, time: " + time1 + " s");

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
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }
        arrayStack.pop();
        arrayStack.pop();
        Integer peek = arrayStack.peek();
        System.out.println(peek);
    }


    // 测试使用stack运行opCount个push和pop操作所需要的时间，单位：秒
    private static double testStack(Stack<Integer> stack, int opCount){

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
