package leetCode.code350_两个数组的交集II;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/19 0019:15:45
 * 邮箱：1981462002@qq.com
 * 说明：
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i : nums1) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i : nums2) {
            if (map.containsKey(i)) {
                list.add(i);
                map.put(i, map.get(i) - 1);
                if (map.get(i) == 0) {
                    map.remove(i);
                }
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
        int[] nums1 = {4, 9, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        int[] ints = solution.intersection(nums1, nums2);

        System.out.println(ints);
    }
}