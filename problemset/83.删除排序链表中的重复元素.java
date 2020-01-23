/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode index = head;
        while(index != null) {
            if(index.next == null) break;
            if(index.val == index.next.val) {
                index.next = index.next.next;
            }else {
                index = index.next;
            }
        }
        return head;
    }
}
// @lc code=end

