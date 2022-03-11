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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null)
            return head;
        ListNode q=head;
        int index=1;
        while(q.next!=null)
        {
            index++;
            q=q.next;
        }
       // System.out.println(index);
        k=k%index;
        for(int i=0;i<k;i++)
        {
            q=rotate(head,q);
            head=q;
        }
        //head=q;
        return head;
    }
    public ListNode rotate(ListNode head,ListNode q)
    {
        ListNode p=head;
        while(p.next.next!=null)
        {
            p=p.next;
        }
        q=p.next;
        p.next=null;
        q.next=head;
        return q;
    }
}