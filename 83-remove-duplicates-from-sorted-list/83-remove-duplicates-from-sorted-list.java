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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while(curr != null){
            int currVal = curr.val;
            ListNode nextNode = curr;
            while(nextNode != null && nextNode.val == currVal){
                nextNode = nextNode.next;
            }
            curr.next = nextNode;
            curr = nextNode;
        }
        return head;
    }
}