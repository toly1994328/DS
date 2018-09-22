package base;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/19 0019:11:24
 * 邮箱：1981462002@qq.com
 * 说明：集合接口
 */
public interface ISet<T> {
    /**
     * 添加操作
     *
     * @param el 数据元素
     */
    void add(T el);

    /**
     * 移除
     *
     * @param el 数据元素
     */
    void remove(T el);

    /**
     * 是否包含
     *
     * @param el 数据元素
     * @return 是否包含
     */
    boolean contains(T el);

    /**
     * 元素个数
     *
     * @return 元素个数
     */
    int size();

    /**
     * 集合是否为空
     *
     * @return 是否为空
     */
    boolean isEmpty();
}
