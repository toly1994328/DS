package leetCode.code307_区域和检索数组可修改;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/24 0024:9:51
 * 邮箱：1981462002@qq.com
 * 说明：
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * <p>
 * 示例：
 * <p>
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 * <p>
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 */
public class NumArray2 {
    private SegmentTree<Integer> mSegmentTree;


    public NumArray2(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            mSegmentTree = new SegmentTree<>(data, (a, b) -> a + b);
        }
    }

    public void update(int i, int val) {
        if (mSegmentTree == null) {
            throw new IllegalArgumentException("SegmentTree is null");
        }
        mSegmentTree.set(i,val);

    }

    public int sumRange(int i, int j) {
        if (mSegmentTree == null) {
            throw new IllegalArgumentException("SegmentTree is null");
        }
        return mSegmentTree.query(i, j);
    }
//region -------------------------

    public interface Merger<T> {
        T merge(T a, T b);
    }

    public class SegmentTree<T> {
        private T[] data;
        private T[] tree;
        private Merger<T> mMerger;

        public SegmentTree(T[] arr, Merger<T> merger) {
            data = (T[]) new Object[arr.length];
            tree = (T[]) new Object[4 * arr.length];
            mMerger = merger;
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }

            buildSegmentTree(0, 0, data.length - 1);
        }

        /**
         * 返回区间[queryL,queryR] 的值
         *
         * @param queryL 左界
         * @param queryR 右界
         * @return [queryL, queryR] 的值
         */
        public T query(int queryL, int queryR) {
            if (queryL < 0 || queryL >= data.length ||
                    queryR < 0 || queryR >= data.length) {
                throw new IllegalArgumentException("index should:index < 0 || index >= data.length ");
            }

            return query(0, 0, data.length - 1, queryL, queryR);
        }

        /**
         * 在以treeIndex为根的线段树[l,r]间，搜索区间是[queryL,queryR]的值
         *
         * @param treeIndex 树节点位置
         * @param l         左子索引
         * @param r         右子索引
         * @param queryL    左界
         * @param queryR    右界
         * @return 搜索区间是[queryL, queryR]的值
         */
        private T query(int treeIndex, int l, int r, int queryL, int queryR) {
            if (l == queryR && r == queryR) {
                return tree[treeIndex];
            }
            int mid = l + (r - l) / 2;
            int leftTreeIndex = leftChildIndex(treeIndex);
            int rightTreeIndex = rightChildIndex(treeIndex);
            if (queryL >= mid + 1) {
                return query(rightTreeIndex, mid + 1, r, queryL, queryR);
            } else if (queryR <= mid) {
                return query(leftTreeIndex, l, mid, queryL, queryR);
            }

            T leftRes = query(leftTreeIndex, l, mid, queryL, mid);
            T rightRes = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);

            return mMerger.merge(leftRes, rightRes);

        }

        public void set(int index, T el) {
            if (index < 0 || index >= data.length) {
                throw new IllegalArgumentException("index should:index < 0 || index >= data.length ");
            }
            set(0, 0, data.length - 1, index, el);
        }

        /**
         * 在以treeIndex为根的线段树中更新index的值为e
         *
         * @param treeIndex 根
         * @param l
         * @param r
         * @param index 叶
         * @param el
         */
        private void set(int treeIndex, int l, int r, int index, T el) {
            if (l == r) {
                tree[treeIndex] = el;
                return;
            }
            // 找index对应的叶子
            int mid = l + (r - l) / 2;
            // treeIndex的节点分为[l...mid]和[mid+1...r]两部分

            int leftTreeIndex = leftChildIndex(treeIndex);
            int rightTreeIndex = rightChildIndex(treeIndex);
            if (index >= mid + 1) {
                set(rightTreeIndex, mid + 1, r, index, el);
            } else { // index <= mid
                set(leftTreeIndex, l, mid, index, el);
            }

            tree[treeIndex] = mMerger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);

        }

        /**
         * 在treeIndex的位置创建区间[l,r]的线段树
         *
         * @param treeIndex 树节点位置
         * @param l         左子索引
         * @param r         右子索引
         */
        private void buildSegmentTree(int treeIndex, int l, int r) {
            if (l == r) {
                tree[treeIndex] = data[l];
                return;
            }
            int leftTreeIndex = leftChildIndex(treeIndex);
            int rightTreeIndex = rightChildIndex(treeIndex);
            int mid = l + (r - l) / 2;
            buildSegmentTree(leftTreeIndex, l, mid);
            buildSegmentTree(rightTreeIndex, mid + 1, r);

            tree[treeIndex] = mMerger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
        }

        public T get(int index) {
            if (index < 0 || index >= data.length) {
                throw new IllegalArgumentException("index should:index < 0 || index >= data.length ");
            }
            return data[index];
        }

        public int size() {
            return data.length;
        }


        /**
         * 获取左子节点的索引
         *
         * @param index
         * @return
         */
        private int leftChildIndex(int index) {
            return 2 * index + 1;
        }

        /**
         * 获取右子节点的索引
         *
         * @param index
         * @return
         */
        private int rightChildIndex(int index) {
            return 2 * index + 2;
        }

        /**
         * 遍历打印树中节点中值信息。
         *
         * @return
         */
        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            res.append('[');
            for (int i = 0; i < tree.length; i++) {
                if (tree[i] != null)
                    res.append(tree[i]);
                else
                    res.append("null");

                if (i != tree.length - 1)
                    res.append(", ");
            }
            res.append(']');
            return res.toString();
        }
    }

//endregion

}
