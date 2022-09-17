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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((o1,o2) -> o1.val - o2.val);
        // loop through head node of lists
        for(int i = 0; i< lists.length; i++){
            if(lists[i]!=null){
                minHeap.add(lists[i]);
            }
        }

        
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(minHeap.size() != 0){
            ListNode node = minHeap.remove();
            cur.next = node;
            cur = cur.next;
            if(node.next != null) minHeap.add(node.next);
        }
        return dummy.next;
    }
}

// Time Complexity: O(NlogK)
// Space Complexity: O(N)