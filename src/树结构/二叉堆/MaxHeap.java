package 树结构.二叉堆;

import 线性结构.数组.ArrayChart;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/23 0023:11:17
 * 邮箱：1981462002@qq.com
 * 说明：数组容器实现二叉堆
 */
public class MaxHeap<T extends Comparable<T>> {

    private ArrayChart<T> data;


    public MaxHeap() {
        data = new ArrayChart<>();
    }

    public MaxHeap(int capacity) {
        data = new ArrayChart<>(capacity);
    }

    /**
     * 将任意数组整理成堆的形状
     *
     * @param arr 数组
     */
    public MaxHeap(T[] arr) {
        data = new ArrayChart<>(arr);
        for (int i = fatherIndex(arr.length - 1); i >= 0; i--)
            siftDown(i);
    }


    /**
     * 添加元素
     * @param el 元素
     */
    public void add(T el) {
        data.addLast(el);
        siftUp(data.size() - 1);
    }

    /**
     * 移除最大值
     * @return 最大值
     */
    public T extractMax() {
        T maxEl = findMax();
        data.swap(0, data.size() - 1);
        data.removeLast();
        siftDown(0);
        return maxEl;
    }

    /**
     * 找寻最大值
     * @return 数组容器中的第一个元素
     */
    public T findMax() {
        if (data.size() == 0) {
            throw new ArrayIndexOutOfBoundsException("Can't findMax when heap is empty");
        }
        return data.get(0);
    }

    /**
     * 取出堆中的最大元素，并且替换成元素el
     *
     * @param el 待替换元素
     * @return 被替换元素
     */
    public T replace(T el) {

        T ret = findMax();
        data.set(0, el);
        siftDown(0);
        return ret;
    }


    /**
     * 下沉元素
     *
     * @param i 索引位
     */
    private void siftDown(int i) {
        while (leftChildIndex(i) < data.size()) {
            int j = leftChildIndex(i);

            if (j + 1 < data.size() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChildIndex(i);
                //data[j]是左右子的最大值
            }

            if (data.get(i).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(i, j);
            i = j;
        }
    }

    /**
     * 上浮添加的元素
     *
     * @param i 待上浮元素的索引
     */
    private void siftUp(int i) {
        //父元素小于当前元素
        while (i > 0 && data.get(i).compareTo(data.get(fatherIndex(i))) > 0) {
            // 数组Array中添加方法swap
            data.swap(i, fatherIndex(i));
            i = fatherIndex(i); // 这句话让i来到新的位置，使得循环可以查看新的位置是否还要大。
        }

    }

    /**
     * 获取父节点的索引
     *
     * @param index
     * @return
     */
    private int fatherIndex(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index of 0 doesn't have father");
        }
        return (index - 1) / 2;
    }

    /**
     * 获取左子节点的索引
     *
     * @param index
     * @return
     */
    private int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    /**
     * 获取右子节点的索引
     *
     * @param index
     * @return
     */
    private int rightChildIndex(int index) {
        return 2 * index + 2;
    }


    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

}
