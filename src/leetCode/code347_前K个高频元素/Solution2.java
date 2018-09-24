package leetCode.code347_前K个高频元素;


import java.util.*;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/19 0019:15:45
 * 邮箱：1981462002@qq.com
 * 说明：
 * <p>
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
class Solution2 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(new Freq(key, map.get(key)));
            } else if (map.get(key) > pq.peek().freq) {
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove().el);
        }
        return res;

    }

   private class Freq implements Comparable<Freq>{
        public int el, freq;

        public Freq(int el, int freq) {
            this.el = el;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq o) {
            return Integer.compare(this.freq, o.freq);

//            return Integer.compare(o.freq, this.freq);

        }
    }

    private class FreqComparator implements Comparator<Freq> {


        @Override
        public int compare(Freq o1, Freq o2) {
            return o1.freq - o2.freq;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3,4,5,5,5,5,5,5,5,5};
        Solution2 solution = new Solution2();
        List<Integer> list = solution.topKFrequent(nums, 2);
        System.out.println(list);

    }


}