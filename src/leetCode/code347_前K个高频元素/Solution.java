package leetCode.code347_前K个高频元素;


import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/19 0019:15:45
 * 邮箱：1981462002@qq.com
 * 说明：
 * <p>
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for (int key : map.keySet()) {
            if (pq.getSize() < k) {
                pq.enqueue(new Freq(key, map.get(key)));
            } else if (map.get(key) > pq.getFront().freq) {
                pq.dequeue();
                pq.enqueue(new Freq(key, map.get(key)));
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.dequeue().el);
        }
        return res;

    }

   private class Freq implements Comparable<Freq>{
        public int el, freq;

        public Freq(int el, int freq) {
            this.el = el;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq o) {
//            if (this.freq < o.freq) {
//                return 1;
//            }else if (this.freq > o.freq) {
//                return -1;
//            }else {
//                return 0;
//            }

            return Integer.compare(o.freq, this.freq);

        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3,4,5,5,5,5,5,5,5,5};
        Solution solution = new Solution();
        List<Integer> list = solution.topKFrequent(nums, 2);
        System.out.println(list);

    }

    /**
     * 作者：张风捷特烈
     * 时间：2018/9/19 0019:9:00
     * 邮箱：1981462002@qq.com
     * 说明：数组集合
     */
    public class ArrayGroup<T> extends Group<T> {
        /**
         * 成员数组
         */
        private T[] datas;

        /**
         * 增长率
         */
        private static final float GROW_RATE = 1.5f;


        /**
         * 无参构造--默认容量10
         */
        public ArrayGroup() {
            this(10);
        }

        /**
         * 一参构造
         *
         * @param capacity 集合容量
         */
        public ArrayGroup(int capacity) {
            //实例化数组
            datas = (T[]) new Object[capacity];
        }

        /**
         * 静态数组入参构造函数
         *
         * @param datas 传入静态数组
         */
        public ArrayGroup(T[] datas) {
            this.datas = datas;
            this.size = datas.length;

        }

        @Override
        public void addLast(T el) {
            add(size, el);
        }

        @Override
        public void add(int index, T el) {
            if (size == datas.length) {
                grow((int) (GROW_RATE * datas.length));
            }
            if (index < 0 || index > size) {
                throw new IllegalArgumentException("Add failed! Make sure index < 0 || index > size");
            }
            //从最后一个元素开始,到定点位置元素,后移一位
            for (int i = size - 1; i >= index; i--) {
                datas[i + 1] = datas[i];
            }
            datas[index] = el;
            size++;
        }

        @Override
        public T remove(int index) {
            if (index < 0 || index >= size) {
                throw new IllegalArgumentException("Remove failed! Make sure index < 0 || index > size");
            }
            T temp = get(index);
            //从删除元素索引的下一位开始到结尾，依次左移
            for (int i = index + 1; i < size; i++) {
                datas[i - 1] = datas[i];
            }
            size--;
            //置空--游荡的对象
            datas[size] = null;

            //缩容
            if (size == datas.length / 4 && datas.length / 2 != 0) {
                grow(datas.length / 2);
            }

            return temp;
        }


        @Override
        public void clear() {
            //注意正向清空会非常耗时
//        for (int i = 0; i < size-1; i++) {
//            remove(i);
//        }

            for (int i = size - 1; i <= 0; i--) {
                remove(i);
            }
            size = 0;
            datas = null;
        }

        @Override
        public T set(int index, T el) {
            if (index < 0 || index >= size) {
                throw new IllegalArgumentException("ISet failed! Make sure index < 0 || index > size");
            }
            T oldEl = get(index);
            datas[index] = el;
            return oldEl;
        }

        @Override
        public T get(int index) {
            if (index < 0 || index >= size) {
                throw new IllegalArgumentException("Get failed! Make sure index < 0 || index > size");
            }
            return datas[index];
        }

        @Override
        public int[] getIndex(T el) {
            //临时数组
            int[] tempArray = new int[size];
            //重复个数
            int count = 0;
            //遍历集合,获取该元素重复个数，及位置数组
            for (int i = 0; i < size; i++) {
                if (datas[i].equals(el)) {
                    tempArray[count] = i;
                    count++;
                }
            }
            //将临时数组压缩
            int[] indexArray = new int[count];
            for (int i = 0; i < count; i++) {
                indexArray[i] = tempArray[i];
            }
            return indexArray;
        }

        @Override
        public Group<T> contact(int index, Group<T> group) {
            //从index处遍历本数组，将待插入数据一个一个插入
            for (int i = index; i < index + group.size(); i++) {
                add(i + 1, group.get(i - index));
            }
            return this;
        }

        public int getCapacity() {
            if (datas != null) {
                return datas.length;
            } else {
                return 0;
            }

        }


        /**
         * 扩容
         *
         * @param newCapacity 新容量
         */
        private void grow(int newCapacity) {
            T[] newData = (T[]) new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newData[i] = datas[i];
            }
            datas = newData;
        }

        /**
         * 交换i和j的位置
         * @param i i
         * @param j j
         */
        public void swap(int i, int j) {
            if (i < 0 || i >= size || j < 0 || j >= size) {
                throw new IllegalArgumentException("ISet failed! Make sure index < 0 || index > size");
            }
            T t = datas[i];
            datas[i] = datas[j];
            datas[j] = t;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("ArrayChart:size =%d,capacity=%d\n", size, datas.length));
            sb.append("[");
            for (int i = 0; i < size; i++) {
                sb.append(datas[i].toString());
                if (i != size - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");

            return sb.toString();
        }
    }
    /**
     * 作者：张风捷特烈
     * 时间：2018/9/19 0019:7:42
     * 邮箱：1981462002@qq.com
     * 说明：集合的基类
     */
    public abstract class Group<T> {
        protected int size;

        /**
         * 定点添加
         *
         * @param index 索引
         * @param el    数据元素
         */
        public abstract void add(int index, T el);

        /**
         * 首添加
         *
         * @param el 数据元素
         */
        public void addFirst(T el) {
            add(0, el);
        }

        /**
         * 尾添加
         *
         * @param el 数据元素
         */
        public void addLast(T el) {
            add(size - 1, el);
        }

        /**
         * 定位删除
         *
         * @param index 索引
         * @return 删除的元素
         */
        public abstract T remove(int index);

        /**
         * 删除首位
         *
         * @return 删除的元素
         */
        public T removeFirst() {
            return remove(0);
        }

        /**
         * 删除尾位
         *
         * @return 删除的元素
         */
        public T removeLast() {
            return remove(size - 1);
        }

        /**
         * 删除指定元素的第一次出现时
         *
         * @param el 数据元素
         * @return 元素位置
         */
        public int removeEl(T el) {
            int[] indexes = getIndex(el);
            int index = -1;
            if (indexes.length > 0) {
                index = indexes[0];
                remove(indexes[0]);
            }
            return index;
        }

        /**
         * 删除所有指定元素
         *
         * @param el 数据元素
         */
        public boolean removeEls(T el) {

            int[] indexArray = getIndex(el);
            if (indexArray.length != 0) {
                for (int i = 0; i < indexArray.length; i++) {
                    remove(indexArray[i] - i); // 注意-i
                }
                return true;
            }
            return false;
        }

        /**
         * 清空集合
         */
        public abstract void clear();

        /**
         * 设置某位置的元素新值
         *
         * @param index 索引
         * @param el    新值
         * @return 旧值
         */
        public abstract T set(int index, T el);

        /**
         * 根据指定位置获取元素
         *
         * @param index 索引
         * @return 数据元素
         */
        public abstract T get(int index);

        /**
         * 根据指定元素获取匹配索引
         *
         * @param el 数据元素
         * @return 索引集
         */
        public abstract int[] getIndex(T el);

        /**
         * 集合是否包含某元素
         *
         * @param el 数据元素
         * @return 是否包含
         */
        public boolean contains(T el) {
            return getIndex(el).length != 0;
        }

        /**
         * 连接两个集合
         *
         * @param group 插入集合
         * @return 合并后的集合
         */
        public Group<T> contact(Group<T> group) {
            return contact(size-1, group);
        }

        /**
         * 定点连接两个集合
         *
         * @param index 索引
         * @param group 插入集合
         * @return 合并后的集合
         */
        public abstract Group<T> contact(int index, Group<T> group);

        /**
         * 是否为空
         *
         * @return 是否为空
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * 返回集合大小
         *
         * @return 大小
         */
        public int size() {
            return size;
        }
    }

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
    public interface IQueue<T> {
        /**
         * 入队
         * @param el 元素
         */
        void enqueue(T el);

        /**
         * 出队
         * @return 元素
         */
        T dequeue();

        /**
         * 获取队首元素
         * @return 队首元素
         */
        T getFront();

        /**
         * 获取队列元素个数
         * @return 元素个数
         */
        int getSize();

        /**
         * 是否为空
         * @return 是否为空
         */
        boolean isEmpty();
    }
    public class MaxHeap<T extends Comparable<T>> {

        private ArrayGroup<T> data;


        public MaxHeap() {
            data = new ArrayGroup<>();
        }

        public MaxHeap(int capacity) {
            data = new ArrayGroup<>(capacity);
        }

        /**
         * 将任意数组整理成堆的形状
         *
         * @param arr 数组
         */
        public MaxHeap(T[] arr) {
            data = new ArrayGroup<>(arr);
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

}