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
    public ListNode mergeKLists(ListNode[] lists) {
        Map <Integer,ListNode> map = new TreeMap<>();
        ListNode temp,temp1,del;
        for(ListNode n : lists)
        {
            if (n != null)
            {
                temp = n;
                while(temp!=null)
                {
                    if (!map.containsKey(temp.val))
                    map.put(temp.val,temp);
                    else
                    {
                        temp1 = map.get(temp.val);
                        while(temp1.next!=null)temp1=temp1.next;
                        temp1.next = temp;
                    }
                    del = temp.next;
                    temp.next = null;
                    temp=del;
                }
            }
        }
        del = new ListNode();
        ListNode result = del;
        for (int key : map.keySet())
        {
            temp = map.get(key);
            while(temp!=null)
            {
                del.next = temp;
                System.out.print(key);
                temp=temp.next;
                del=del.next;
            }
        }
        return (result.next);
    }
}