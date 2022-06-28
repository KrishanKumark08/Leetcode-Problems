/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode currNode = node;
        ListNode prevNode = node;
        while(currNode.next != null){
            int currVal = currNode.val;
            int nextVal = currNode.next.val;
            currNode.val = nextVal;
            currNode.next.val = currVal;
            prevNode = currNode;
            currNode = currNode.next;
        }
        
        prevNode.next = null;
        
    }
}