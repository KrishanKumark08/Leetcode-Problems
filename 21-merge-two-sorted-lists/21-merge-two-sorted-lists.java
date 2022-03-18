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
        ListNode dummynode=new ListNode(-1);
         ListNode h=dummynode;
        while(list1!=null&&list2!=null)
        {
            if(list1.val>=list2.val)
            {
                ListNode n=new ListNode(list2.val);
                dummynode.next=n;
                dummynode=dummynode.next;
                list2=list2.next;
            }
            else
            {
               ListNode n=new ListNode(list1.val);
                dummynode.next=n;
                dummynode=dummynode.next;
                list1=list1.next; 
            }
        }
        while(list1!=null)
        {
          ListNode n=new ListNode(list1.val);
                dummynode.next=n;
                dummynode=dummynode.next;
                list1=list1.next;  
        }
        while(list2!=null)
        {
            ListNode n=new ListNode(list2.val);
                dummynode.next=n;
                dummynode=dummynode.next;
                list2=list2.next; 
        }
        return h.next;
    }
}