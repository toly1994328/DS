package leetCode.code203_删除链表中的节点;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/19 0019:15:45
 * 邮箱：1981462002@qq.com
 * 说明：
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
class Solution1 {

    public ListNode removeElements(ListNode head, int val) {
        //头部是val
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        if (head == null) {
            return null;
        }

        //中间的元素是val
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                //要删除的元素
                ListNode delNode = prev.next;
                //要删除的元素的前一元素的next指向要删除的元素的下一元素
                //即：孤立删除元素
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                //如果不是，继续往下找
                prev = prev.next;
            }
        }

        return head;
    }
}