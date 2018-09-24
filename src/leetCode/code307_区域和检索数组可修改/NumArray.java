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
public class NumArray {
    private int[] sum;
    private int[] data;


    public NumArray(int[] nums) {
        data = new int[nums.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = nums[i];
        }

        sum = new int[nums.length + 1];
        sum[0] = 0;

        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public void update(int i, int val) {
        data[i] = val;
        for (int j = i + 1; j < sum.length; j++) {
            sum[i] = sum[i - 1] + data[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
