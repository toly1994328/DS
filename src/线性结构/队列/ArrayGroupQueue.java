package 线性结构.队列;


import base.IQueue;
import 线性结构.数组.ArrayGroup;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/17 0017:15:57
 * 邮箱：1981462002@qq.com
 * 说明：队列的数组实现
 */
public class ArrayGroupQueue<E> implements IQueue<E> {

    /**
     * 成员变量
     */
    private ArrayGroup<E> array;

    public ArrayGroupQueue(int capacity) {
        this.array = new ArrayGroup<>(capacity);
    }

    public ArrayGroupQueue() {
        this.array = new ArrayGroup<>();
    }

    @Override
    public void enqueue(E el) {
        array.addLast(el);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.get(0);
    }

    @Override
    public int getSize() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("IQueue ：");
        res.append("front [ ");
        for (int i = 0; i < array.size(); i++) {
            res.append(array.get(i));
            if (i != array.size() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

}
