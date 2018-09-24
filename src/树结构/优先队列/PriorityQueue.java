package 树结构.优先队列;

import base.IQueue;
import 树结构.二叉堆.MaxHeap;

import java.util.Queue;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/23 0023:18:51
 * 邮箱：1981462002@qq.com
 * 说明：基于堆实现优先队列
 */
public class PriorityQueue<T extends Comparable<T>> implements IQueue<T> {
    private MaxHeap<T> mMaxHeap;

    public PriorityQueue() {
        mMaxHeap = new MaxHeap<>();
    }

    @Override
    public void enqueue(T el) {
        mMaxHeap.add(el);
    }

    @Override
    public T dequeue() {

        return mMaxHeap.extractMax();
    }

    @Override
    public T getFront() {
        return mMaxHeap.findMax();
    }

    @Override
    public int getSize() {
        return mMaxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return mMaxHeap.isEmpty();
    }
}
