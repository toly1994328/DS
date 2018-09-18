package 树结构.集合;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/19 0019:11:24
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
