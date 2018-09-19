package client;

import base.IQueue;
import 线性结构.队列.ArrayGroupQueue;
import 线性结构.队列.ArrayLoopQueue;
import 线性结构.队列.LinkedIQueue;

import java.util.Random;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/17 0017:16:01
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class ClientOfQueue {
    public static void main(String[] args) {
        arrayQueueTest();
//        LoopQueueTest();
//        linkedQueueTest();
//        abilityTest();


    }

    private static void abilityTest() {
        int opCount = 150000;
        ArrayGroupQueue<Integer> arrayQueue = new ArrayGroupQueue<>();
//        double time1 = testQueue(arrayQueue, opCount);
//        System.out.println("ArrayQueue出队入队"+opCount+"次的时间: "+time1+"秒");
        ArrayLoopQueue<Integer> loopQueue = new ArrayLoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("loopQueue出队入队"+opCount+"次的时间: "+time2+"秒");

        LinkedIQueue<Integer> linkedQueue = new LinkedIQueue<>();
        double time3 = testQueue(linkedQueue, opCount);
        System.out.println("linkedQueue出队入队" +opCount+"次的时间: "+ time3 + " 秒");

    }

    private static void linkedQueueTest() {
        LinkedIQueue<Integer> queue = new LinkedIQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
//            System.out.println(queue);
//            if(i %3 == 2){
//                queue.dequeue();
//                System.out.println(queue);
//            }
        }
//        queue.dequeue();
//        queue.dequeue();
        System.out.println(queue);
    }

    private static void LoopQueueTest() {
        ArrayLoopQueue<Integer> queue = new ArrayLoopQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if(i %3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

    /**
     * 数组队列测试
     */
    private static void arrayQueueTest() {
        ArrayGroupQueue<Integer> queue = new ArrayGroupQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }
        queue.dequeue();
        System.out.println(queue);
        //IQueue ：front [ 0] tail
        //IQueue ：front [ 0, 1] tail
        //IQueue ：front [ 0, 1, 2] tail
        //IQueue ：front [ 0, 1, 2, 3] tail
        //IQueue ：front [ 0, 1, 2, 3, 4] tail
        //IQueue ：front [ 1, 2, 3, 4] tail
    }

    private static double testQueue(IQueue<Integer> q, int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();

        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE)); // 生成从0到int最大值
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime(); // 纳秒
        return (endTime - startTime)/ 1e9;
    }


}


