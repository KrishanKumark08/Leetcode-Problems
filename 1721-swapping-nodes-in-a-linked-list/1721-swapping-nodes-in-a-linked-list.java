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
        if(head.next==null || head.next == null)
            return head;
        
        ListNode runner = head;
        ListNode follower = head;
        ListNode prev = null;
        
        for(int i=0; i<k; i++){
            prev = runner;
            runner = runner.next;
        }
        
        while(runner != null){
            runner = runner.next;
            follower = follower.next;
        }
        
        int temp = prev.val;
        prev.val = follower.val;
        follower.val = temp;
    
        return head;
    }
}