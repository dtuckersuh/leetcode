/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionTwoLists{
    /**
     * Two Pointers Approach:
     * Maintain two pointers intialized at head, traverse through list.
     * If pointer reaches end of list, start traverse through other list starting at head
     * If there is an intersection, the two pointers will meet
     * Time Complexity: O(m + n) because we traverse through list A and list B
     * Space Complexity: O(1) because we only use two pointers a and b
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}