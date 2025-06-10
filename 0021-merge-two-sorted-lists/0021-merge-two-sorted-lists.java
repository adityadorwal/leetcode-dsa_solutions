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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result,temp;
        if(list1==null && list2==null)
        return(list1);
        else if(list1==null)
        return(list2);
        else if(list2==null)
        return(list1);
        if(list1.val<list2.val)
        {
            temp=list1;
            list1=list1.next;
        }
        else
        {
            temp=list2;
            list2=list2.next;
        }
        result=temp;
        while(list1!=null && list2!=null)
        {
            if(list1.val<list2.val)
            {
                temp.next=list1;
                list1=list1.next;
            }
            else
            {
                temp.next=list2;
                list2=list2.next;
            }
            temp=temp.next;
        }
        temp.next=(list1!=null)?list1:list2;
        return(result);
    }
}