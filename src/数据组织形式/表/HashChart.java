package 数据组织形式.表;

import java.util.TreeMap;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/27 0027:13:04
 * 邮箱：1981462002@qq.com
 * 说明：哈希表
 * <p>
 * 每个地址是链表：O(N/M)
 * 每个地址是平衡树:(O(log(N/M)))
 */
public class HashChart<K, V> {

    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static final int initCapacity = 7;

    /**
     * 红黑树的数组
     */
    private TreeMap<K, V>[] hashChart;
    /**
     * 数组的长度
     */
    private int M;
    /**
     * 元素个数
     */
    private int size;

    public HashChart(int m) {
        M = m;
        size = 0;
        hashChart = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashChart[i] = new TreeMap<>();
        }
    }

    public HashChart() {
        this(initCapacity);
    }

    /**
     * hash值转索引
     *
     * @param key
     * @return
     */
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    /**
     * 添加
     *
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        TreeMap<K, V> tempMap = hashChart[hash(key)];
        if (tempMap.containsKey(key)) {
            tempMap.put(key, value);
        } else {
            tempMap.put(key, value);
            size++;
            //扩容
            if (size >= upperTol * M) {
                resize(2 * M);
            }
        }


    }

    /**
     * 删除
     *
     * @param key
     * @return
     */
    public V remove(K key) {
        TreeMap<K, V> tempMap = hashChart[hash(key)];
        V ret = null;
        if (tempMap.containsKey(key)) {
            ret = tempMap.remove(key);
            size--;
            //缩容
            if (size <= lowerTol * M && M > initCapacity)
                resize(M / 2);
        }
        return ret;

    }

    /**
     * 修改
     *
     * @param key
     * @param value
     */
    public void set(K key, V value) {
        TreeMap<K, V> tempMap = hashChart[hash(key)];
        if (!tempMap.containsKey(key)) {
            throw new IllegalArgumentException(key + " doesn't exist");
        }

        tempMap.put(key, value);
    }

    private void resize(int newM) {
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++)
            newHashTable[i] = new TreeMap<>();

        for (int i = 0; i < M; i++)
            for (K key : hashChart[i].keySet())
                newHashTable[hash(key)].put(key, hashChart[i].get(key));

        this.M = newM;
        this.hashChart = newHashTable;
    }

    /**
     * 查询
     *
     * @param key
     */
    public V get(K key) {
        return hashChart[hash(key)].get(key);
    }


    public boolean contains(K key) {
        return hashChart[hash(key)].containsKey(key);
    }


    public int size() {
        return size;
    }
}
