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
    public boolean isPalindrome(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        ListNode dummyHead = dummyNode;
        
        ListNode curr = head;
        while(curr != null){
            dummyNode.next = new ListNode(curr.val);
            dummyNode = dummyNode.next;
            curr = curr.next;
        }
        
        ListNode copyHead = reverseList(dummyHead.next);
        
        while(head!= null && copyHead != null){
            if(head.val != copyHead.val){
                return false;
            }
            head = head.next;
            copyHead = copyHead.next;
        }
        
        if(copyHead == null && head == null){
            return true;
        }
        return false;
        
    }
    
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
    
}