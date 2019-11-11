/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k==0) return head;
        int count = 1;
        ListNode tail = head;
        while(tail.next != null) {
            count++;
            tail = tail.next;
        }

        k = k%count;
        if(k == 0) return head;
        ListNode tmp = head;
        while(--count>k) {
            tmp = tmp.next;
        }
        ListNode newHead = tmp.next;
        tail.next = head;
        tmp.next = null;
        return newHead;
    }
}
// @lc code=end

