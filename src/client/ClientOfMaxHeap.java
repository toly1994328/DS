package client;

import Jutils.TimeTest;
import 树结构.二叉堆.MaxHeap;

import java.util.Random;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/23 0023:13:17
 * 邮箱：1981462002@qq.com
 * 说明：
 * 100W数据：方法耗时:0.160604525秒
 * 1000W数据：方法耗时:2.444076222秒
 */
public class ClientOfMaxHeap {
    public static void main(String[] args) {
//        testMaxHeap();
        int n = 10000000;
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for(int i = 0 ; i < n ; i ++)
            testData[i] = random.nextInt(Integer.MAX_VALUE);

        double time1 = testHeap(testData, false);
        System.out.println("Without heapify: " + time1 + " s");

        double time2 = testHeap(testData, true);
        System.out.println("With heapify: " + time2 + " s");

    }

    private static double testHeap(Integer[] testData, boolean isHeapify){

        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if(isHeapify)
            maxHeap = new MaxHeap<>(testData);
        else{
            maxHeap = new MaxHeap<>();
            for(int num: testData)
                maxHeap.add(num);
        }

        int[] arr = new int[testData.length];
        for(int i = 0 ; i < testData.length ; i ++)
            arr[i] = maxHeap.extractMax();

        for(int i = 1 ; i < testData.length ; i ++)
            if(arr[i-1] < arr[i])
                throw new IllegalArgumentException("Error");
        System.out.println("Test MaxHeap completed.");

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1e9;
    }

    private static void testMaxHeap() {
        int n = 1000000;

        new TimeTest() {

            @Override
            protected void run() {
                MaxHeap<Integer> heap = new MaxHeap<>();
                Random random = new Random();
                for (int i = 0; i < n; i++) {
                    heap.add(random.nextInt(Integer.MAX_VALUE));
                }
            }
        };
    }
}
