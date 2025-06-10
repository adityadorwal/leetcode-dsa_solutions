/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left=head;
        ListNode right=head;
        if(n==1 && head.next==null)return head.next;
        while(n>0)
        {
            n--;
            right=right.next;
        }
        if(right==null)return(left.next);
        while(right.next!=null)
        {
            right=right.next;
            left=left.next;
        }
        left.next=left.next.next;
        return head;
    }
}