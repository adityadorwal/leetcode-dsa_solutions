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
    public int pairSum(ListNode head) {
        ListNode slow = head , fast = head;
        ListNode prev = null,next_node=null;
        int max_sum=0;
        while(fast!=null)
        {
            fast = fast.next.next;
            next_node = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next_node;
        }
        while(prev!= null)
        {
            int sum = prev.val+slow.val;
            prev = prev.next;
            slow = slow.next;
            if(sum>max_sum)max_sum=sum;
        }
        return max_sum;
    }
}