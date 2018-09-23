package base;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/22 0022:17:11
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public interface IMap<K, V> {
    /**
     * 增加元素
     *
     * @param key   键
     * @param value 值
     */
    void put(K key, V value);

    /**
     * 删除元素
     *
     * @param key 键
     * @return 删除的value
     */
    V remove(K key);

    /**
     * 是否包含某元素
     *
     * @param key 键
     * @return 是否存在
     */
    boolean contains(K key);

    /**
     * 获取元素
     *
     * @param key 键
     * @return 值
     */
    V get(K key);

    /**
     * 修改
     *
     * @param key   键
     * @param value 新值
     */
    void set(K key, V value);

    /**
     * 元素个数
     *
     * @return 元素个数
     */
    int size();

    /**
     * 是否为空
     *
     * @return 是否为空
     */
    boolean isEmpty();


}
