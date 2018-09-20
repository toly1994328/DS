package client;

import Jutils.TimeTest;
import 线性结构.队列.ArrayGroupQueue;
import 线性结构.队列.ArrayLoopQueue;
import 线性结构.队列.SingleLinkedQueue;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/17 0017:16:01
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class ClientOfQueue {
    public static void main(String[] args) {
//        arrayQueueTest();
//        LoopQueueTest();
//        linkedQueueTest();
        int opCount = 10000000;

//        数组普通队列入队测试(opCount);
//        数组循环队列入队测试(opCount);
        链表队列入队测试(opCount);

//        数组循环队列出队测试(opCount);
//        数组普通队列出队测试(opCount);
        链表队列出队测试(opCount);


    }

    private static void 数组普通队列出队测试(int opCount) {
        ArrayGroupQueue<Integer> arrayGroupQueue = new ArrayGroupQueue<>();

        for (int i = 0; i < opCount; i++) {
            arrayGroupQueue.enqueue(1);
        }

        new TimeTest("arrayGroupQueue出队", opCount) {
            @Override
            protected void run() {
                arrayGroupQueue.dequeue();
            }
        };
    }

    private static void 数组循环队列出队测试(int opCount) {
        ArrayLoopQueue<Integer> arrayLoopQueue = new ArrayLoopQueue<>();

        for (int i = 0; i < opCount; i++) {
            arrayLoopQueue.enqueue(1);
        }
        new TimeTest("arrayGroupQueue出队", opCount) {
            @Override
            protected void run() {
                arrayLoopQueue.dequeue();
            }
        };
    }

    private static void 链表队列出队测试(int opCount) {
        SingleLinkedQueue<Integer> linkedQueue = new SingleLinkedQueue<>();

        for (int i = 0; i < opCount; i++) {
            linkedQueue.enqueue(1);
        }
        new TimeTest("链表队列出队测试", opCount) {
            @Override
            protected void run() {
                linkedQueue.dequeue();
            }
        };
    }

    private static void 数组普通队列入队测试(int opCount) {
        ArrayGroupQueue<Integer> arrayGroupQueue = new ArrayGroupQueue<>();
        new TimeTest("arrayGroupQueue入队", opCount) {
            @Override
            protected void run() {
                arrayGroupQueue.enqueue(1);
            }
        };
    }

    private static void 数组循环队列入队测试(int opCount) {
        ArrayLoopQueue<Integer> loopQueue = new ArrayLoopQueue<>();
        new TimeTest("loopQueue入队", opCount) {
            @Override
            protected void run() {
                loopQueue.enqueue(1);
            }
        };
    }

    private static void 链表队列入队测试(int opCount) {
        SingleLinkedQueue<Integer> linkedQueue = new SingleLinkedQueue<>();
        new TimeTest("链表队列入队测试", opCount) {
            @Override
            protected void run() {
                linkedQueue.enqueue(1);
            }
        };
    }

    /**
     * 链表队列测试
     */
    private static void linkedQueueTest() {
        SingleLinkedQueue<Integer> queue = new SingleLinkedQueue<>();
        for (int i = 0; i < 8; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        //IQueue: front 0->1->2->3->4->5->6->7->NULL tail
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(10);
        System.out.println(queue.getFront());//4
        System.out.println(queue);
        //IQueue: front 4->5->6->7->10->NULL tail
    }

    /**
     * 循环队列测试
     */
    private static void LoopQueueTest() {
        ArrayLoopQueue<Integer> queue = new ArrayLoopQueue<>(8);
        for (int i = 0; i < 8; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        //ArrayLoopQueue: size = 8, capacity = 8
        //front [0, 1, 2, 3, 4, 5, 6, 7] tail
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(10);
        System.out.println(queue.getFront());//4
        System.out.println(queue);
        //ArrayLoopQueue: size = 5, capacity = 8
        //front [4, 5, 6, 7, 10] tail
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
}


