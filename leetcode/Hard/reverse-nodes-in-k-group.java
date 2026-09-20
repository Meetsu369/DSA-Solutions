// Problem: Reverse Nodes in k-Group
// Platform: leetcode
// Rating/Difficulty: Hard
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/reverse-nodes-in-k-group/
// Solved on: 2026-09-20T16:29:49.275Z

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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {

            ListNode kth = groupPrev;

            for (int i = 0; i < k; i++) {

                kth = kth.next;

                if (kth == null) {
                    return dummy.next;
                }
            }

            ListNode groupNext = kth.next;

            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {

                ListNode next = curr.next;

                curr.next = prev;
                prev = curr;
                curr = next;
            }

            ListNode oldGroupStart = groupPrev.next;
            groupPrev.next = kth;

            groupPrev = oldGroupStart;
        }
    }
}