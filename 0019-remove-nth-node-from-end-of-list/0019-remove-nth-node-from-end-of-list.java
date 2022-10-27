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
        
        // if(head.next == null){
        //     return null;
        // }
        
        ListNode curr = head;
        
        for(int i = 0; i < n; i++){
            curr = curr.next;
        }
        
        if(curr == null){
            return head.next;
        }
        
        ListNode follow = head;
        
        while(curr.next != null){
            curr = curr.next;
            follow = follow.next;
        }
        
        follow.next = follow.next.next;
        
        return head;
        
        
    }
}