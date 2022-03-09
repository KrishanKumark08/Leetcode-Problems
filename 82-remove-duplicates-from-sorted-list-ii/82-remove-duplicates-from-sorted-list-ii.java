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
        TreeMap<Integer, Integer> memo = new TreeMap<>();
        
        while(head != null){
            memo.put(head.val, memo.getOrDefault(head.val, 0) + 1);
            head = head.next;
        }
        
        ListNode dummyNode = new ListNode(-101);
        ListNode newHead = dummyNode;
        
        for(int node:memo.keySet()){
            //System.out.println("Key : "+node+" value = "+memo.get(node));
            if(memo.get(node) == 1){
                newHead.next = new ListNode(node);
                newHead = newHead.next;
            }
        }
        return dummyNode.next;
    }
}