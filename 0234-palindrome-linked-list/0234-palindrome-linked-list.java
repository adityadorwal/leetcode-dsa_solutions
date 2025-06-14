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
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode prev=null;
        while (slow != null)
        {
            ListNode nextTemp = slow.next; 
            slow.next = prev;              
            prev = slow;                   
            slow = nextTemp;               
        }
        slow=prev;
        while(slow!=null)
        {
            if(slow.val!=head.val)
            return false;
            head=head.next;
            slow=slow.next;
        }
        return true;
    }
}