package leetCode.code349_两个数组的交集;

import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/19 0019:15:45
 * 邮箱：1981462002@qq.com
 * 说明：
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i : nums1) {
            treeSet.add(i);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (treeSet.contains(i)) {
                list.add(i);
                treeSet.remove(i);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9,4,9,8,4};

        int[] ints = solution.intersection(nums1, nums2);

        System.out.println(ints);
    }
}