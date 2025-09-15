class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            head = head.next;
            fast = fast.next.next;
            if(head == fast) return true;
        }
        return false;
    }
}