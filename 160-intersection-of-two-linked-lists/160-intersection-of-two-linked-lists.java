/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        LinkedHashSet<ListNode> setA = new LinkedHashSet<>();
        
        ListNode ptr = headA;
        while(ptr != null){
            setA.add(ptr);
            ptr = ptr.next;
        }
        
        ptr = headB;
        while(ptr != null){
            if(setA.contains(ptr)){
                return ptr;
            }
            ptr = ptr.next;
        }
        return null;
    }
}