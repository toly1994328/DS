package 树结构.线段树;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/24 0024:9:18
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public interface Merger<T> {
    T merge(T a, T b);
}
