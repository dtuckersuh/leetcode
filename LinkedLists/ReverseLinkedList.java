/**
 * https://leetcode.com/problems/reverse-linked-list/
 * Time Complexity: O(n)
 * Space Complexity: O(1) Iterative; O(n) Recursive
 */
public class ReverseLinkedList{
    // Iterative Solution
    public ListNode reverseListIter(ListNode head){
        ListNode prev = null;
        while (head != null){
            // Save next
            ListNode next = head.next;
            head.next = prev;
            // Advance pointers
            prev = head;
            head = next;
        }
        return prev;
    }

    // Recursive Solution
    public ListNode reverseList(ListNode head){
        return reverseListRecurse(head, null);
    }
    public ListNode reverseListRecurse(ListNode head, ListNode prev){
        // Base case
        if (head == null){
            return prev;
        }
        ListNode next = head.next;
        head.next = prev;
        // Gimme reverse with next as head and prev as head
        return reverseListRecurse(next, head);
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }
}