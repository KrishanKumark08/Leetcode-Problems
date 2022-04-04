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
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null||head.next==null)
            return head;
        ListNode p=null;
        ListNode q=head;
        ListNode r=head;
        while(k>0&&q!=null)
        {
            k--;
            p=q;
            q=q.next;
        }
        ListNode n=p;
        int l=p.val;
         while(q!=null)
         {
             r=r.next;
             q=q.next;
         }
        int j=r.val;
        r.val=l;
        n.val=j;
        return head;
    }
}