package client;

import 数据组织形式.集合.BSTSet;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/17 0017:14:50
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class ClientOfBSTSet {
    public static void main(String[] args) {
        BSTSet<Integer> bstSet1 = new BSTSet<>();
        BSTSet<Integer> bstSet2 = new BSTSet<>(true);


        int[] nums2 = {10, 6, 5, 6, 9, 9, 12, 12, 12};
        for (int num : nums2) {
            bstSet1.add(num);
            bstSet2.add(num);
        }

        System.out.println(bstSet1.size());//5
        System.out.println(bstSet1.getNodeCountMap());//null

        //可重复
        System.out.println(bstSet2.size());//9
        System.out.println(bstSet2.getNodeCountMap());
        //{5=1, 6=2, 9=2, 10=1, 12=3}

    }
/////////////////////////////性能测试S//////////////////////////


/////////////////////////////性能测试E//////////////////////////


}
