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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head,temp;
        int i=1;
        temp=curr;
        while(curr!=null)
        {
            if(i==k)
            {
                ListNode nextnode,prev=reverseKGroup(curr.next,k);
                while(i-- != 0)
                {
                    nextnode = temp.next;
                    temp.next = prev;
                    prev = temp;
                    temp = nextnode;
                }
                return prev;
            }
            i++;
            curr = curr.next;
        }
        return head;
    }
}