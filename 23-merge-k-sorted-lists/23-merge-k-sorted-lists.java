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
class Pair implements Comparable<Pair>{
    ListNode node;
    int val;
    Pair(ListNode node, int val){
        this.node = node;
        this.val = val;
    }
    
    public int compareTo(Pair o){
        return this.val - o.val;
    }
    
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(ListNode list:lists){
            while(list != null){
                pq.add(new Pair(list, list.val));
                list = list.next;
            }
        }
        
        ListNode dummyNode = new ListNode(-100000);
        ListNode newHead = dummyNode;
        while(!pq.isEmpty()){
            Pair l = pq.remove();
            ListNode newNode = new ListNode(l.val);
            dummyNode.next = newNode;
            dummyNode = newNode;
        }
        return newHead.next;
    }
}