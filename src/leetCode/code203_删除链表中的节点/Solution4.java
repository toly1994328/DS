package leetCode.code203_删除链表中的节点;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/19 0019:15:45
 * 邮箱：1981462002@qq.com
 * 说明：
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
//场景：一辆火车，若干节损坏，要去除损坏的节点

class Solution4 {

    public ListNode removeElements(ListNode head, int val) {
        //递归基
        if (head == null) {//检测完毕
            return null;
        }
        //头节点之后的所有节点删除val后的链表----即所有火车厢
        ListNode res = removeElements(head.next, val);
        if (head.val == val) {//头节点满足删除条件----火车头损坏
            return res;//返回所有火车厢
        } else {//火车头未损坏
            head.next = res;
            return head;
        }

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 6, 3,4, 5, 6});

        Solution4 s = new Solution4();
        ListNode listNode = s.removeElements(head, 6);
        System.out.println(listNode);
    }
}