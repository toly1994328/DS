package 线性结构.栈;


import 线性结构.数组.Array;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/17 0017:12:56
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    /**
     * 获取栈中元素个数
     *
     * @return
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 获取栈总容量
     *
     * @return
     */
    @Override
    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 出栈
     *
     * @return
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 入栈
     *
     * @param e
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * 查看栈顶元素
     *
     * @return
     */
    @Override
    public E peek() {
        return array.get(getSize() - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack ：");
        res.append("[ ");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize()-1){
                res.append(", ");
            }
        }
        res.append("] top");
        return  res.toString();
    }

}
