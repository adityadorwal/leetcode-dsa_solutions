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
    public void reorderList(ListNode head) {
        ListNode slow=head,fast=head;
        Stack<ListNode> stk = new Stack<>();
        stk.push(slow);

        while(fast.next != null && fast.next.next != null)
        {
            slow=slow.next;
            stk.push(slow);
            fast = fast.next.next;
        }
        slow = slow.next;
        ListNode last=null;

        if(fast.next != null)
        {
            last = slow;;
            slow=slow.next;
            last.next = null;
        }
        while(slow!=null)
        {
            ListNode prev = stk.pop();
            prev.next = last;
            last = slow;
            slow = slow.next;
            last.next = prev;
        }
        head.next = last;
    }    
}