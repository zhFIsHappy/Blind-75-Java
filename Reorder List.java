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
    public void reorderList(ListNode head) {
        if(head == null ) return;
        ListNode mid = findMid(head);
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverse(l2);
        ListNode l1 = head;
        while(l1!=null && l2 !=null){
            ListNode next = l1.next;
            l1.next =l2;
            l2 = l2.next;
            l1.next.next = next;
            l1 = next;
        }
    }
    
    public ListNode findMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public ListNode reverse(ListNode head){
        if(head == null) return head;
        ListNode newHead = null;
        while(head!= null){
            ListNode next =head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
    

}

// Time Complexity : O(N)
// Space Complexity : O(1)