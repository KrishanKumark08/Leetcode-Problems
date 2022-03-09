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
        ListNode dummyNode = new ListNode(-100);
        ListNode newHead = dummyNode;
        
        ListNode prev = head;
        if(head == null){
            return head;
        }
        ListNode curr = head.next;
        
        int last = 0;
        
        while(curr != null){
            if(prev.val == curr.val){
                while(curr != null && prev.val == curr.val){
                    //System.out.println("prev = "+prev.val+" curr = "+curr.val+" dupli");
                    last = prev.val;
                    prev = curr;
                    curr = curr.next;
                }
                if(curr != null){
                    //System.out.println("prev = "+prev.val+" curr = "+curr.val+" dupli");
                    last = prev.val;
                    prev = curr;
                    curr = curr.next;
                }   
            }
            else{
                //System.out.println("prev = "+prev.val+" curr = "+curr.val);
                newHead.next = new ListNode(prev.val);
                newHead = newHead.next;
                prev = curr;
                curr = curr.next;
            }
        }
        
        if(prev.val != last){
            newHead.next = prev;
        }
        
        return dummyNode.next;
        
    }
}