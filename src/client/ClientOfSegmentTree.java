package client;

import 树结构.线段树.Merger;
import 树结构.线段树.SegmentTree;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/24 0024:9:21
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class ClientOfSegmentTree {
    public static void main(String[] args) {
        Integer[] nums = {-2, 9, 5, 4, 6, 8};

        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);
        System.out.println(segmentTree);

        Integer query = segmentTree.query(0, 2);
        System.out.println(query);

    }
}
