/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        if(a==null||b==null)return null;
        if(a==b)return a;
        if(a.next==null&&b.next==null)return null;
        if(a.next==b.next)return a.next;
        ListNode headA=a;
        ListNode c=null;
        int flag=0;
        while(headA!=null)
        {
            ListNode headB=b;
            while(headB!=null)
            {
                if(headA==headB)
            {
                c=headA;
                    flag=1;
                break;
            }
            headB=headB.next;
            }
            headA=headA.next;
            if(flag==1)break;
        }
        if(c==null)
            return null;
        return c;
    }
}