package 线性结构.队列;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/17 0017:15:57
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public interface Queue<E> {
    void enqueue(E e); // 入队
    E dequeue();       // 出队
    E getFront();      // 获取队首元素
    int getSize();      // 获取队列元素多少
    boolean isEmpty();  // 是否为空
}