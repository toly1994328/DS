package 线性结构.数组;

import base.Group;

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
            throw new IllegalArgumentException("Set failed! Make sure index < 0 || index > size");
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("ArrayGroup:size =%d,capacity=%d\n", size, datas.length));
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
