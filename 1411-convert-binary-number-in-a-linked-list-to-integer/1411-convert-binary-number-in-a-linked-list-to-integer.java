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
    public int getDecimalValue(ListNode head) {
        int n=0,c=0;
        while(head != null)
        {
            if(head.val == 0)c++;
            else
            {
                n = (n << c) + 1;
                c=1;
            }
            System.out.println(n);

            head = head .next;
        }
        if(c>1)n = (n << c-1);
        System.out.println(n);
        return n;
    }
}