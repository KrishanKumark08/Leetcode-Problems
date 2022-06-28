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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        else if(list2 == null){
            return list1;
        }
        
        ListNode dummyNode = new ListNode(-101);
        ListNode head = dummyNode;
        while(list1 != null && list2!= null){
            if(list1.val <= list2.val){
                ListNode newNode = new ListNode(list1.val);
                list1 = list1.next;
                dummyNode.next = newNode;
                dummyNode = dummyNode.next;
            }
            else{
                ListNode newNode = new ListNode(list2.val);
                list2 = list2.next;
                dummyNode.next = newNode;
                dummyNode = dummyNode.next;
            }
        }
        
        while(list1 != null){
            ListNode newNode = new ListNode(list1.val);
            list1 = list1.next;
            dummyNode.next = newNode;
            dummyNode = dummyNode.next;
        }
        
        while(list2 != null){
            ListNode newNode = new ListNode(list2.val);
            list2 = list2.next;
            dummyNode.next = newNode;
            dummyNode = dummyNode.next;
        }
    
        return head.next;
    
    }
}