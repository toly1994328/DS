package 线性结构.队列;

import base.IQueue;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/17 0017:16:03
 * 邮箱：1981462002@qq.com
 * 说明：数组实现循环队列
 */
public class ArrayLoopQueue<T> implements IQueue<T> {
    /**
     * 队列数据
     */
    private T[] data;
    /**
     * 队首标示
     */
    private int front;
    /**
     * 队尾标示
     */
    private int tail;

    /**
     * 元素个数
     */
    private int size;

    /**
     * 无参构造：默认10个容量
     */
    public ArrayLoopQueue() {
        this(11);
    }

    /**
     * 一参构造
     *
     * @param capacity 队列容量
     */
    public ArrayLoopQueue(int capacity) {
        // 因为会有一个浪费，所以+1
        data = (T[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    @Override
    public void enqueue(T el) {
        if (isFull()) {
            grow(getCapacity() * 2);
        }
        data[tail] = el;
        //插入数据时对尾标示进行操作
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        T ret = data[front];
        data[front] = null;
        //插入数据时对首标示进行操作
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            grow(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        return data[front];
    }

    /**
     * 重新确定容量
     * @param newCapacity 新的容量
     */
    private void grow(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            // 此时在newData中队首对齐回来，data中就得有一个front的偏移量
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    /**
     * 获取容量
     * @return 容量
     */
    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * 队列元素个数
     * @return 元素个数
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 是否为空
     * @return 是否为空
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 队列是否满了
     * @return 队列是否满了
     */
    public boolean isFull() {
        // tail的下一个位置等于front时
        return (tail + 1) % data.length == front;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("ArrayLoopQueue: size = %d, capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) // 最后一个元素不要加，
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
