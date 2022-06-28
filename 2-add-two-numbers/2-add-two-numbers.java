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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyNode = new ListNode(-101);
        ListNode head = dummyNode;
        
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            if(sum > 9){
                sum = sum % 10;
                carry = 1;
            }
            else{
                carry = 0;
            }
            ListNode newNode = new ListNode(sum);
            dummyNode.next = newNode;
            dummyNode = dummyNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null){
            
            int sum = l1.val + carry;
            if(sum > 9){
                sum = sum % 10;
                carry = 1;
            }
            else{
                carry = 0;
            }
            ListNode newNode = new ListNode(sum);
            dummyNode.next = newNode;
            dummyNode = dummyNode.next;
            l1 = l1.next;
        }
        
        while(l2 != null){
            
            int sum = l2.val + carry;
            if(sum > 9){
                sum = sum % 10;
                carry = 1;
            }
            else{
                carry = 0;
            }
            ListNode newNode = new ListNode(sum);
            dummyNode.next = newNode;
            dummyNode = dummyNode.next;
            l2 = l2.next;
        }
        
        if(carry == 1){
            ListNode newNode = new ListNode(1);
            dummyNode.next = newNode;
            dummyNode = dummyNode.next;
        }
        
        return head.next;
    }
}