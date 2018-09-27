package 线性结构.栈;


import base.IStack;
import 线性结构.数组.ArrayChart;


/**
 * 作者：张风捷特烈
 * 时间：2018/8/17 0017:12:56
 * 邮箱：1981462002@qq.com
 * 说明：栈的数组实现
 */
public class ArrayChartStack<T> implements IStack<T> {
    /**
     * 成员变量
     */
    private ArrayChart<T> array;

    public ArrayChartStack(int capacity) {
        array = new ArrayChart<>(capacity);
    }

    public ArrayChartStack() {
        array = new ArrayChart<>();
    }


    @Override
    public int size() {
        return array.size();
    }

    @Override
    public int capacity() {
        return array.getCapacity();
    }


    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }


    @Override
    public T pop() {
        return array.removeLast();
    }


    @Override
    public void push(T el) {
        array.addLast(el);
    }


    @Override
    public T peek() {
        return array.get(size() - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack ：");
        res.append("[ ");
        for (int i = 0; i < array.size(); i++) {
            res.append(array.get(i));
            if (i != array.size() - 1) {
                res.append(", ");
            }
        }
        res.append("] <--top");
        return res.toString();
    }

}
