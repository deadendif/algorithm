package leetcode.L092_ReverseLinkedListII;

/**
 * @author: deadend
 * @date: 2:40 PM 12/2/16
 * @version: 1.0
 * @description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr = dummy, prev = null;;

        for (int i = 0; i < m; i++) {
            prev = curr;
            curr = curr.next;
        }

        for (int i = 0; i < n - m; i++) {
            ListNode tmp = curr.next.next;
            curr.next.next = prev.next;
            prev.next = curr.next;
            curr.next = tmp;
        }
        return dummy.next;
    }
}
