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
        if(head == null || head.next == null || k==0){
            return head;
        }
        
        int length = 1;
        ListNode tail = head;
        
        while(tail.next != null){
            length++;
            tail = tail.next;
        }
        
        k = k % length;
        
        if(k != 0){
            ListNode current = head;        
            int count = 1;
                while(count < length - k){
                    current = current.next;
                    count++;
                }
            
            ListNode nextNode = current.next;
            current.next = null;
            tail.next = head;
            head = nextNode;
        }
        return head;
    }   
}