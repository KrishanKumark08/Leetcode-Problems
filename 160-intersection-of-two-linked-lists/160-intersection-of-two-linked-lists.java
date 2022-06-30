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
        
        int countA = 0;
        int countB = 0;
        
        ListNode currA = headA;
        while(currA != null){
            countA++;
            currA = currA.next;
        }
        
        ListNode currB = headB;
        while(currB != null){
            countB++;
            currB = currB.next;
        }
        
        currA = headA;
        currB = headB;
        
        if(countA > countB){
            while(countA > countB){
                currA = currA.next;
                countA--;
            }
        }
        else if(countB > countA){
            while(countB > countA){
                currB = currB.next;
                countB--;
            }
        }
        
        while(currA != null && currB != null){
            if(currA == currB){
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }
}