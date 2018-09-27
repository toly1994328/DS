package 树结构.client;

import 树结构.二分搜索树.BST;

import java.util.Map;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/17 0017:14:50
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class ClientOfBST {
    public static void main(String[] args) {
//        BST<Integer> bst = new BST<>();
//
//        int[] nums = {10, 8, 6, 16, 9, 12, 22, 15, 72, 19};
//        for (int num : nums)
//            bst.add(num);

  /*
            10
        /       \
       8        16
     /  \      /  \
    6    9   12   22
             \    / \
             15 19  72
                        */

//        removeTest(bst);

//        BST<Integer> bst1 = new BST<>(false);
        BST<Integer> bst2 = new BST<>(true);

        int[] nums2 = {10, 6, 5, 6, 9, 9, 12, 12, 12};
        for (int num : nums2) {
//            bst1.add(num);
            bst2.add(num);
        }

//不可重复二叉树
/*
            10
        /       \
       6        12
     /  \
    5    9
                        */

  /*
            10
        /       \
       6        12
     /  \      /
    5    9   12
    \    /  /
     6  9  12
                        */

        //10 8 16 6 9 12 22 15 19 72

//        bst1.orderLevel();
        bst2.orderLevel();
        Map<Integer, Integer> map = bst2.getNodeCountMap();
        System.out.println("");
        System.out.println(map);


    }

    private static void removeTest(BST<Integer> bst) {
    /*
            10
        /       \
       8        16
     /  \      /  \
    6    9   12   22
             \    / \
             15 19  72
                  */

//右驱后继删除
/*
       10
    /      \
   8        19
 /  \      /  \
6    9   12   22
          \     \
          15    72
              */

//左驱后继删除
/*
       10
    /      \
   8        15
 /  \      /  \
6    9   12   22
             / \
           19  72
              */

//        baseTest();
        bst.orderLevel();
        bst.remove(16);
        System.out.println("");
        bst.orderLevel();
        System.out.println(bst);
    }

    private static void baseTest() {

  /*
          10
        /   \
       8    12
     /  \    \
    6    9   22
             / \
           16  72
                  */


        BST<Integer> bst = new BST<>();
        int[] nums = {10, 8, 6, 12, 9, 22, 16, 72};
        for (int num : nums)
            bst.add(num);


//        System.out.println("递归前序遍历");
//        bst.orderPer();//前序遍历:父->左子->右子
//        System.out.println();
//        //10 8 6 9 12 22 16 72
//
//        System.out.println("非递归前序遍历");
//        bst.orderPerNR();//非递归遍历
//        System.out.println();
//
//        System.out.println("递归中序遍历");
//        bst.orderIn();//中序遍历:左子->父->右子----排序
//        System.out.println("");
//
//        System.out.println("非递归中序遍历");
//        bst.orderInNR();//非递归遍历
//        System.out.println();
//        //6 8 9 10 12 16 22 72
//
//
//        System.out.println("递归后序遍历");
//        bst.orderPost();//后序遍历:左子->右子->父----内存释放
//        System.out.println();
//        // 先处理左子树，再处理右子树，最后处理根
//        // 10的左子树8,右子树12,先处理8
//        // 8的左子树6,6无左子树,所以处理6,然后处理8的右子树9,然后处理8
//        // 8处理完要处理12,之前要处理22,22之前要处理16和72,12处理完就处理10，over
//        //6 9 8 16 72 22 12 10
//
//        System.out.println("递归后序遍历");
//        bst.orderPostNR();
//        System.out.println("");
//        //6 9 8 16 72 22 12 10
//
//        System.out.println("层序遍历");
//        bst.orderLevel();
//        System.out.println("");
//        //10 8 12 6 9 22 16 72
//
//        System.out.println(bst.getMin());//6
//        System.out.println(bst.getMax());//72
//
//        bst.removeMax();
//        bst.orderIn();//中序遍历:左子->父->右子----排序
//        //6 8 9 10 12 16 22
//        System.out.println("");
//        bst.removeMin();
//        bst.orderIn();//中序遍历:左子->父->右子----排序
        //8 9 10 12 16 22
    }
/////////////////////////////性能测试S//////////////////////////


/////////////////////////////性能测试E//////////////////////////


}
