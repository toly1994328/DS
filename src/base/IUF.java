package base;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/25 0025:11:09
 * 邮箱：1981462002@qq.com
 * 说明：并查集接口
 */
public interface IUF {
    /**
     * 查看p,q元素是否属于同一集合
     *
     * @param p p元素
     * @param q q元素
     * @return 是否属于同一集合
     */
    boolean isConnected(int p,int q);

    /**
     * 联合p，q所在集合
     * @param p p元素
     * @param q q元素
     */
    void unionEl(int p, int q);

    /**
     * 元素个数
     * @return 元素个数
     */
    int size();
}
