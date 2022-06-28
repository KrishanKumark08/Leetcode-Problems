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
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenPart = even;
        
        //odd != null && odd.next != null &&
        
        while(even != null && even.next != null){
            ListNode nextOdd = odd.next.next;
            ListNode nextEven = even.next.next;
            odd.next = nextOdd;
            even.next = nextEven;
            odd = nextOdd;
            even = nextEven;
        }
        
        odd.next = evenPart;
        return head;
        
    }
}