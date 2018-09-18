package 线性结构.链表;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/18 0018:6:15
 * 邮箱：1981462002@qq.com
 * 说明：
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class DelAllOfLinkEls {
    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val) {
            head = head.next;// head后移
        }
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next; // prev.next.next
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode res = new DelAllOfLinkEls().removeElements(head,6);
        System.out.println(res);
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    /**
     * 链表节点的构造函数
     * 使用arr作为参数，创建一个链表，当前的listNode为链表头结点。
     *
     * @param arr
     */
    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0){
            throw new IllegalArgumentException("Arr can not be empty");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    /**
     * 返回以当前节点为头结点的链表信息字符串
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("List :");
        ListNode cur = this;
        while (cur != null){
            res.append(cur.val +"->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}