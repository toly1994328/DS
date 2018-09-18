package 线性结构.栈;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/17 0017:12:49
 * 邮箱：1981462002@qq.com
 * 说明：
 */
interface Stack<E>  {

    int getSize();
    int getCapacity();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
