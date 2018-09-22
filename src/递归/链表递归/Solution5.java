package 递归.链表递归;

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

    public ListNode removeElements(ListNode head, int val, int depth) {

        String depthString = generateDepthString(depth);
        System.out.println(depthString);
        System.out.println("Call:removeElements " + val + " in " + head);

        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return " + head);
            return null;
        }

        ListNode res = removeElements(head.next, val, depth + 1);

        System.out.print(depthString);
        System.out.println("After remove " + val + ": " + res);

        head.next = res;

        ListNode ret;
        if (head.val == val)
            ret = res;
        else {
            head.next = res;
            ret = head;
        }

        System.out.print(depthString);
        System.out.println("Return: " + ret);

        return ret;
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("-->"); // 深度越深，字符串中--数量越多。
        }
        return res.toString();
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{6, 7, 8});

        Solution5 s = new Solution5();
        ListNode listNode = s.removeElements(head, 6, 0);
        System.out.println(listNode);
    }
}