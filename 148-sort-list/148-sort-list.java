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
    public ListNode sortList(ListNode head) {
        return dosort(head);
    }
    public ListNode dosort(ListNode head)
    {
        if(head==null||head.next==null)
            return head;
        ListNode fast=head,slow=head;
        while(fast.next!=null&&fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode list2=slow.next;
        slow.next=null;
        ListNode list1=head;
        ListNode Left=dosort(list1);
        ListNode right=dosort(list2);
        return merge(Left,right);
    }
     public ListNode merge(ListNode list1,ListNode list2)
     {
         if(list1==null)return list2;
         if(list2==null)return list1;
         
         ListNode p=list1,q=list2;
         ListNode list=new ListNode(-1);
         ListNode current=list;
         while(p!=null&&q!=null)
         {
             if(p.val>=q.val)
             {
                 ListNode d=new ListNode(q.val);
                 current.next=d;
                 q=q.next;
             }
             else
             {
                ListNode d=new ListNode(p.val);
                 current.next=d; 
                 p=p.next;
             }
             current=current.next;
         }
          while(p!=null)
         {
                ListNode d=new ListNode(p.val);
                 current.next=d; 
             current=current.next;
              p=p.next;
         }
         while(q!=null)
         {
                ListNode d=new ListNode(q.val);
                 current.next=d; 
             current=current.next;
              q=q.next;
         }
         ListNode l=list;
         while(l!=null)
         {
             System.out.print(l.val+" ");
             l=l.next;
         }
         System.out.println();
         return list.next;
     }
}