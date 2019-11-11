import java.util.*;

/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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
    public boolean isPalindrome(ListNode head) {
        return Solution234.isPalindrome(head);
    }
}
class Solution234 {
    public static boolean isPalindrome(ListNode head) {
        int count = 0;
        ListNode tmp = head;
        while(tmp!=null) {
            count++;
            tmp = tmp.next;
        }
        if(count<=1) return true;
        Stack<Integer> stack = new Stack<>();
        tmp = head;
        for(int i = 0;i<count/2;i++) {
            stack.push(tmp.val);
            tmp = tmp.next;
        }
        if(count%2 == 1) tmp = tmp.next;

        while(tmp!= null) {
            if(stack.pop() != tmp.val) return false;
            tmp = tmp.next;
        }
        return true;
    }
}
// @lc code=end

