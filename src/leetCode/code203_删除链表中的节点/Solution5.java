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

class Solution5 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{6, 7, 8});

        Solution5 s = new Solution5();
        ListNode listNode = s.removeElements(head, 6);
        System.out.println(listNode);
    }
}