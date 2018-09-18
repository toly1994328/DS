package 线性结构.队列;

import java.util.Random;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/17 0017:16:01
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class Client {
    public static void main(String[] args) {
//        baseQueueTest();
//        LoopQueueTest();
//        linkedQueueTest();
        abilityTest();


    }

    private static void abilityTest() {
        int opCount = 150000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
//        double time1 = testQueue(arrayQueue, opCount);
//        System.out.println("ArrayQueue出队入队"+opCount+"次的时间: "+time1+"秒");
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("loopQueue出队入队"+opCount+"次的时间: "+time2+"秒");

        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        double time3 = testQueue(linkedQueue, opCount);
        System.out.println("linkedQueue出队入队" +opCount+"次的时间: "+ time3 + " 秒");

    }

    private static void linkedQueueTest() {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
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
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if(i %3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

    private static void baseQueueTest() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }
        queue.dequeue();
        System.out.println(queue);
    }

    private static double testQueue(Queue<Integer> q,int opCount){
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


