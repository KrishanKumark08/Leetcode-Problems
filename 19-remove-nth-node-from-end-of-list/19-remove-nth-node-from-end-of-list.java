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
        if(head==null)return head;
        ListNode h = reverseList(head);
        ListNode j=h;
        while(n>2&&j.next!=null)
        {
            n--;
           j= j.next;
        }
        if(n==2&&j.next!=null)
        {
            ListNode d=j.next;
            j.next=j.next.next;
            d.next=null;
        }
        System.out.println(j.val);
        if(n==1)
        {
           ListNode d=h;
            h=h.next;
            d.next=null; 
        }
        head = reverseList(h);
        
        return head;
        
    }
     public ListNode reverseList(ListNode head) {
        if(head==null)
            return head;
        ListNode p=null;
        ListNode q=null;
        while(head.next!=null)
        {
            q=head.next;
            head.next=p;
            p=head;
            head=q;
        }
        head.next=p;
        return head;
    }
}