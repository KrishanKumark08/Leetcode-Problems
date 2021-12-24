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
    public int[] nextLargerNodes(ListNode head) {
        int length = 0;
        ListNode current = head;
        while(current != null){
            current = current.next;
            length++;
        }
        
        int arr[] = new int[length];
        
        current = head;
        
        for(int i = 0; i < arr.length - 1; i++){
            ListNode present = current;
            while(present != null){
                if(current.val < present.val){
                    break;
                }
                present = present.next;
            }
            if(present == null){
                arr[i] = 0;
            }
            else{
            arr[i] = present.val;
            }
            current = current.next;
                
        }
        return arr;
    }
}
