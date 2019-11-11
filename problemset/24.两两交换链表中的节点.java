import java.util.Stack;

/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (62.51%)
 * Likes:    310
 * Dislikes: 0
 * Total Accepted:    46.4K
 * Total Submissions: 74.2K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 
 * 
 * 示例:
 * 
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 
 * 
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
    public ListNode swapPairs(ListNode head) {
        return SwapPairs.swapPairs(head, 2);
    }
}
class SwapPairs{
    public static ListNode swapPairs(ListNode head, int pairs) {
        if(pairs <= 1) {
            return head;
        }

        ListNode index = new ListNode(0); // fack node
        ListNode res = index;
        index.next = head;
        ListNode[] arrays = new ListNode[pairs+1];
        while(hasNextN(index, pairs)) {
            index = swap(index, pairs, arrays);
        }
        // 不该输出这个的。
        return res.next;
    }
    // 看了下标准答案，就是把这个代码进行了个整合。不过我还是喜欢我的这个思路，虽然hasNextN的，多遍历了链表了一次
    public static boolean hasNextN(ListNode node, int pairs) {
        // 第一个node不进行计数
        ListNode tmp = node;
        int count = 0;
        while(tmp != null) {
            if(count++ >= pairs) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    public static ListNode swap(ListNode node ,int pairs, ListNode[] arrays) {
        ListNode index = node;
        for(int i = 0; i<=pairs; i++) {
            arrays[i] = index;
            index = index.next;
        }
        arrays[1].next = arrays[pairs].next;
        for(int i = pairs; i>1;i--){
            arrays[i].next = arrays[i-1];
        }
        arrays[0].next = arrays[pairs];
        return arrays[1]; // 不会数组越界，因为pairs大于1的。
    }
}

// @lc code=end

